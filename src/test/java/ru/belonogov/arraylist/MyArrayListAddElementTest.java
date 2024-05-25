package ru.belonogov.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class MyArrayListAddElementTest {

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
    void addByIndexPositive() {
        for(int i = 0; i < 1_000; i++) {
            myArrayList.add(4, 700);
        }
        int size = myArrayList.size();
        System.out.println();
        assertThat(size).isEqualTo(1_010);
    }

    @Test
    void addByIndexNegative() {
        assertThatThrownBy(() -> myArrayList.add(20, 700)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void add() {
        Random random = new Random();
        for(int i = 0; i < 1_000; i++) {
            myArrayList.add(random.nextInt(500));
        }
        int size = myArrayList.size();
        System.out.println();
        assertThat(size).isEqualTo(1_010);
    }
}