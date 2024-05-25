package ru.belonogov.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MyArrayListTest {

    List<Integer> myArrayList;

    @BeforeEach
    public void init() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(600);
        myArrayList.add(1);
        myArrayList.add(10);
        myArrayList.add(7);
        myArrayList.add(4);
        myArrayList.add(17);
        myArrayList.add(11);
        myArrayList.add(100);
    }


    @Test
    void size() {
        int result = myArrayList.size();
        assertThat(result).isEqualTo(8);
    }

    @Test
    void isEmptyFalse() {
        boolean result = myArrayList.isEmpty();
        assertThat(result).isFalse();
    }

    @Test
    void isEmptyTrue() {
        myArrayList = new MyArrayList<>();
        boolean result = myArrayList.isEmpty();
        assertThat(result).isTrue();
    }

    @Test
    void sort() {
        List<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(4);
        expected.add(7);
        expected.add(10);
        expected.add(11);
        expected.add(17);
        expected.add(100);
        expected.add(600);
        myArrayList.sort((a, b) -> b - a);
        for (int i = 0; i < expected.size(); i++) {
            assertThat(myArrayList.get(i)).isEqualTo(expected.get(i));
        }
    }

    @Test
    void toArray() {
        Object[] array = myArrayList.toArray();
        for(int i = 0; i < myArrayList.size(); i++) {
            assertThat(myArrayList.get(i)).isEqualTo(array[i]);
        }
    }

    @Test
    void clear() {
        myArrayList.clear();
        for(int i = 0; i < myArrayList.size(); i++) {
            assertThat(myArrayList.get(i)).isNull();
        }
    }

}