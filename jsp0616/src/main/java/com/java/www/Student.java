package com.java.www;
//int형 확실히 구분하기!

public class Student {

    private int stuNo;
    private String name;
    private int kor; // kor 프로퍼티 추가
    private int eng; // kor 프로퍼티 추가
    private int math; // kor 프로퍼티 추가

    public int getStuNo() {
        return this.stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return this.kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return this.eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return this.math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public Student() {

    }

    // getter와 setter 메소드 생략

}
