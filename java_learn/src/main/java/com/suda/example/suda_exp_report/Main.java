package com.suda.example.suda_exp_report;

/**
 * @author alien
 * @program myrepo
 * @description 每年的实验报告归档
 * 采用 多生产者 - 多消费者 模型
 * 生产者负责从表格数据中读取 x课程-x实验 的所有实验报告的信息，发送到阻塞队列中
 * 一级消费者通过id 散列到下一级真正负责拷贝的消费者
 * 二级消费者负责从阻塞队列中获取消息，然后拷贝实验报告到指定文件夹中(如果不存在就创建)
 * 如果还想要优化：建议参考Kafka的设计架构，采用pageCache，顺序读写，批量压缩技术来提升IO性能
 * @date 2024/12/30$
 */
public class Main {
    public static void main(String[] args) {

    }
}
