package com.suda.example.suda_exp_report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/12/30$
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Experiment {
    long id;
    String name;
}
