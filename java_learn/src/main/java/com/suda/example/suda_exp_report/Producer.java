package com.suda.example.suda_exp_report;

import com.suda.example.suda_exp_report.dto.Product;
import com.suda.example.suda_exp_report.entity.Experiment;
import com.suda.example.suda_exp_report.entity.Report;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/12/30$
 */
public class Producer implements Runnable{
    private BlockingQueue<Product> blockingQueue;

    @Override
    public void run() {
        try {
            FileInputStream fis1 = new FileInputStream(new File("ex_tasks.xls"));
            FileInputStream fis2 = new FileInputStream(new File("ex_report.xlsx"));
            FileInputStream fis3 = new FileInputStream(new File("ex_subject.xls"));
            HSSFWorkbook _tasksSheet = new HSSFWorkbook(fis1);
            HSSFWorkbook _subjectSheet = new HSSFWorkbook(fis3);
            XSSFWorkbook _reportSheet = new XSSFWorkbook(fis2);

            // 保证有效的表在第一个sheet
            HSSFSheet tasksSheet = _tasksSheet.getSheetAt(0);
            HSSFSheet subjectSheet = _subjectSheet.getSheetAt(0);
            XSSFSheet reportSheet = _reportSheet.getSheetAt(0);
            for (Row row : tasksSheet) {
                if (row.getRowNum() == 0) continue;
                Cell cellId = row.getCell(0);
                Cell cellName = row.getCell(3);
                Cell cellTeacher = row.getCell(4);
                long taskId = 0L;
                if (cellId != null && cellId.getCellType() == CellType.NUMERIC) {
                    taskId = (long) cellId.getNumericCellValue();
                }
                String courseName = cellName.getStringCellValue();
                String tearcherId = cellTeacher.getStringCellValue();
                Integer offset = 1;
                for (Row row2 : subjectSheet) {
                    if (row2.getRowNum() == 0) continue;
                    Cell taskCell = row2.getCell(4);
                    long _taskId = (long) taskCell.getNumericCellValue();
                    if (taskId == _taskId) {
                        Cell idCell = row2.getCell(0);
                        long expId = (long) idCell.getNumericCellValue();
                        Experiment experiment = new Experiment(expId, "实验" + offset);
                        offset ++;
                        ArrayList<Report> reports = new ArrayList<>();
                        for (Row row3 : reportSheet) {
                            if (row3.getRowNum() == 0) continue;
                            Cell idCell3 = row3.getCell(2);
                            long curExpId = (long) idCell3.getNumericCellValue();
                            if (curExpId == experiment.getId()) {
                                Cell c1 = row3.getCell(6);
                                Cell c2 = row3.getCell(7);
                                Cell c3 = row3.getCell(1);
                                String studentId = c3.getStringCellValue();
                                String path = c1.getStringCellValue() + c2.getStringCellValue();
                                Report report = new Report(studentId, path);
                                reports.add(report);
                            }
                        }

                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}