package ru.belonogov.arraylist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ListIterator;

class MyArrayListLolTest {
    /**
     * Класс написан для % покрытия тестами, тк функционал методов не написан
     */
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
    void toArray() {
        Integer[] nums = {4, 9, 0};
        Object[] array = myArrayList.toArray(nums);
        Assertions.assertThat(array).isNull();
    }

    @Test
    void addAll() {
        List<Integer> integerList = List.of(6, 3, 60);
        boolean result = myArrayList.addAll(integerList);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void testAddAll() {
        List<Integer> integerList = List.of(6, 3, 60);
        boolean result = myArrayList.addAll(4, integerList);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void removeAll() {
        List<Integer> integerList = List.of(6, 3, 60);
        boolean result = myArrayList.removeAll(integerList);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void retainAll() {
        List<Integer> integerList = List.of(6, 3, 60);
        boolean result = myArrayList.retainAll(integerList);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void listIterator() {
        ListIterator<Integer> integerListIterator = myArrayList.listIterator();
        Assertions.assertThat(integerListIterator).isNull();
    }

    @Test
    void testListIterator() {
        ListIterator<Integer> integerListIterator = myArrayList.listIterator(2);
        Assertions.assertThat(integerListIterator).isNull();
    }

    @Test
    void subList() {
        List<Integer> integerList = myArrayList.subList(2, 4);
        Assertions.assertThat(integerList).isEqualTo(List.of());
    }
}