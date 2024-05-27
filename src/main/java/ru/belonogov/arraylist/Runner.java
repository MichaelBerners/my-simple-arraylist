package ru.belonogov.arraylist;

import java.util.List;
import java.util.Random;

/**
 * Класс инициализирующий список и запускающий его сортировку
 */
public class Runner {

    public static void main(String[] args) {
        List<Integer> myArrayList = initList(1_000);
        myArrayList.sort((a, b) -> a - b);
        myArrayList.stream().forEach(System.out::println);
    }

    public static List<Integer> initList(int value){
        List<Integer> myArrayList = new MyArrayList<>();
        Random random = new Random();
        for (int i = 0; i < value; i++) {
            myArrayList.add(random.nextInt(1_000));
        }

        return myArrayList;
    }
}
