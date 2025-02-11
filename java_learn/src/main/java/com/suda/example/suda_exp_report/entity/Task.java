package com.suda.example.suda_exp_report.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/12/30$
 */
@Data
public class Task {
    Integer id;
    String courseName;
    String teacherId;
    Integer projectId;
}
