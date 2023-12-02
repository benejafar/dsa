package com.jafar.week3;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSortComparator {

    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(Object[] a, int j, int i) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparator c, Object a, Object b) {
        return c.compare(a, b) < 0;
    }

    static Comparator<Integer> compNumber = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);    
        }
        
    };

    static Comparator<Student> nameComp = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
        
    };

    static Comparator<Student> ageComp = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
           return o1.age.compareTo(o2.age);
        }
        
    };

    

    public static void main(String[] args) {
        Object[] arr = new Object[] {
            new Student(4, "anand"),
            new Student(5, "joseph"),
            new Student(1, "suneeth"),
            new Student(3, "anand"),
            new Student(2, "anand"),
            new Student(6, "suneeth")
            
        };
        sort(arr, nameComp);
        sort(arr,ageComp);
        System.out.println(Arrays.asList(arr));
    }

}

class Student{
    Integer age;
    String name;

    public Student(Integer age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    
}
