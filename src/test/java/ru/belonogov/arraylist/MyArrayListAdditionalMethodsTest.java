package ru.belonogov.arraylist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayListAdditionalMethodsTest {
    MyArrayList<Integer> myArrayList;

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
    }

    @Test
    void trimToSize() {
        myArrayList.trimToSize();
        int result = myArrayList.getCapacity();
        Assertions.assertThat(result).isEqualTo(7);
    }

    @Test
    void ensureCapacity() {
        myArrayList.ensureCapacity(1_000);
        int result = myArrayList.getCapacity();
        Assertions.assertThat(result).isEqualTo(1_000);
    }
}