package ru.belonogov.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MyArrayListIndexOfTest {

    List<Integer> myArrayList;

    @BeforeEach
    public void init() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(600);
        myArrayList.add(600);
        myArrayList.add(10);
        myArrayList.add(7);
        myArrayList.add(4);
        myArrayList.add(17);
        myArrayList.add(100);
        myArrayList.add(100);
    }

    @Test
    void indexOfPositive() {
        Integer number = 600;
        int result = myArrayList.indexOf(number);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void indexOfNegative() {
        Integer number = 700;
        int result = myArrayList.indexOf(number);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void lastIndexOfPositive() {
        Integer number = 100;
        int result = myArrayList.lastIndexOf(number);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void lastIndexOfNegative() {
        Integer number = 200;
        int result = myArrayList.lastIndexOf(number);
        assertThat(result).isEqualTo(-1);
    }
}