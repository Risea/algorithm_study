package cn.seands.algorithm.queue;

import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        //ArrayQueue<Integer> aq = new ArrayQueue<>(3);
        CircularQueue<Integer> aq = new CircularQueue<>(3);
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag){
            System.out.println("操作: a 元素入列, p 查看元素, o 元素出列, l 查看所有, e 结束程序");
            String opt = sc.next();
            switch (opt){
                case "a":
                    System.out.print("请输入元素: ");
                    int data = sc.nextInt();
                    try {
                        aq.add(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "p":
                    try {
                        System.out.printf("当前对列头部元素: %d\n", aq.peek());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "o":
                    try {
                        System.out.printf("出列元素: %d\n", aq.remove());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "l":
                    aq.list();
                    break;
                case "e":
                    flag = false;
                    break;
                default:
                    System.out.println("不能识别的操作... 请输入(a, p, o, e)");
            }
        }
    }
}
