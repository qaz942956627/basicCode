package com.lu;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 小卢
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Comparable<Student>{

    public int score;
    public int age;

    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }

}
