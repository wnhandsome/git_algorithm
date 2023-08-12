package com.w6n.charpter1_linklist;

import com.w6n.charpter1_linklist.level1.BasicList;
import com.w6n.charpter1_linklist.level1.ListNode;

import java.util.LinkedList;
import java.util.Scanner;

public class Challenge{


    static Student head;

    public static void main(String[] args) {
        initStudent();



        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入加入学生信息：");
            System.out.print("姓名：");
            String name = scanner.next();
            System.out.print("语言：");
            String language = scanner.next();

            add(name, language);

            System.out.println("加入学生"+name+"后的信息：");
            printStudents();
        }

    }

    //加入学生
    public static void add(String name,String language){
        Student cur = head;
        Student pre = null;
        Student student = new Student(name, language);
        if ("java".equals(language)){
            while (!"CPP".equals(cur.language)){
                pre = cur;
                cur = cur.next;
            }
        }else if ("CPP".equals(language)){
            while (!"Python".equals(cur.language)){
                pre = cur;
                cur = cur.next;
            }
        }else if ("Python".equals(language)){
            while (cur != null){
                pre = cur;
                cur = cur.next;
            }
        }else {
            System.out.println("输入语言错误，请重新输入：");
            return;
        }
        pre.next = student;
        student.next = cur;
    }

    //构建初始链表结构
    public static void initStudent(){
        Student student6 = new Student("cb", "Python");
        Student student5 = new Student("ca","Python",student6);
        Student student4 = new Student("bb","CPP",student5);
        Student student3 = new Student("ba","CPP",student4);
        Student student2 = new Student("ab","java",student3);
        head = new Student("aa","java",student2);
        System.out.println("初始化学生信息如下：");
        printStudents();
    }

    //打印学生链表
    public static void printStudents(){
        Student cur = head;
        while (cur != null){
            System.out.print(cur+",");
            cur = cur.next;
        }
        System.out.println();
    }

    static class Student{
        String name;
        String language;
        Student next;

        public Student(String name, String language) {
            this.name = name;
            this.language = language;
        }

        public Student(String name, String language, Student next) {
            this.name = name;
            this.language = language;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{"+name+","+language+"}";
        }
    }
}
