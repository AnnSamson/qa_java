package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Feline feline;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;
        if ("�����".equals(sex)) {
            hasMane = true;
        } else if ("�����".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("����������� ���������� �������� ���� ��������� - ����� ��� �����");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("������");
    }
}
