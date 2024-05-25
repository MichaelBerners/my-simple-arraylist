package ru.belonogov.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MyArrayListContainsTest {

    List<Integer> myArrayList;

    @BeforeEach
    public void init() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(600);
        myArrayList.add(200);
        myArrayList.add(30);
    }

    @Test
    void containsPositive() {
        boolean result = myArrayList.contains(600);
        assertThat(result).isTrue();
    }

    @Test
    void containsNegative() {
        boolean result = myArrayList.contains(500);
        assertThat(result).isFalse();
    }

    @Test
    void containsAllPositive() {
        List<Integer> list = List.of(600, 200, 30);
        boolean result = myArrayList.containsAll(list);
        assertThat(result).isTrue();
    }

    @Test
    void containsAllNegative() {
        List<Integer> list = List.of(600, 300, 30);
        boolean result = myArrayList.containsAll(list);
        assertThat(result).isFalse();
    }


}