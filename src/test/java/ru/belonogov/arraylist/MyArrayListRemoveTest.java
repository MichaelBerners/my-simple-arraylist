package ru.belonogov.arraylist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MyArrayListRemoveTest {

    List<Integer> myArrayList;

    @BeforeEach
    public void init() {
        myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            myArrayList.add(i);
        }
    }

    @Test
    void removeByIndexPositive() {
        for (int i = 3_000; i > 0; i--) {
            myArrayList.remove(i);
        }
        int size = myArrayList.size();
        System.out.println();
        assertThat(size).isEqualTo(7_000);
    }

    @Test
    void removeByIndexNegative() {

        assertThatThrownBy(() -> myArrayList.remove(20_000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void removeByObjectPositive() {
        Integer ob = 300;
        boolean remove = myArrayList.remove(ob);

        assertThat(remove).isTrue();
    }

    @Test
    void removeByObjectNegative() {
        Integer ob = 30_000;
        boolean remove = myArrayList.remove(ob);

        assertThat(remove).isFalse();
    }
}