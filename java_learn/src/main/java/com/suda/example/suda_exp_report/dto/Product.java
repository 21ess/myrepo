package com.suda.example.suda_exp_report.dto;

import com.suda.example.suda_exp_report.entity.Experiment;
import com.suda.example.suda_exp_report.entity.Report;
import com.suda.example.suda_exp_report.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author alien
 * @program myrepo
 * @description 发送到阻塞队列中的产物
 * 为了保证磁盘的顺序读写，我们以最小文件夹为单位
 * 组织形式为
 * id-courseName-teacherId
 *  |_id-实验x
 *      |_实验报告
 * @date 2024/12/30$
 */
@Data
@AllArgsConstructor
public class Product {
    Integer id;
    Task task;
    Experiment experiment;
    ArrayList<Report> reports;
}
