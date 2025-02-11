package com.suda.example.suda_exp_report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.util.SplittableRandom;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/12/30$
 */
@Data
@AllArgsConstructor
public class Report {
    String studentId;
    String savePath;
}
