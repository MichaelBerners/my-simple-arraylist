package ru.belonogov.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MyArrayListSetTest {

    List<Integer> myArrayList;

    @BeforeEach
    public void init() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(3);
        myArrayList.add(9);
        myArrayList.add(4);
        myArrayList.add(2);
        myArrayList.add(6);
        myArrayList.add(8);
        myArrayList.add(12);
        myArrayList.add(11);
        myArrayList.add(10);
        myArrayList.add(1);

    }

    @Test
    void setPositive() {
        Integer number = 60;
        Integer result = myArrayList.set(4, number);
        System.out.println();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void setNegative() {
        Integer number = 60;
        assertThatThrownBy(() -> myArrayList.set(20, number)).isInstanceOf(IllegalArgumentException.class);
    }
}