package ru.belonogov.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MyArrayListGetTest {

    List<Integer> myArrayList;

    @BeforeEach
    public void init() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(600);
        myArrayList.add(1);
        myArrayList.add(10);
        myArrayList.add(7);

    }

    @Test
    void getPositive() {
        Integer result = myArrayList.get(2);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void getNegative() {
        assertThatThrownBy(() -> myArrayList.get(100)).isInstanceOf(IllegalArgumentException.class);
    }
}