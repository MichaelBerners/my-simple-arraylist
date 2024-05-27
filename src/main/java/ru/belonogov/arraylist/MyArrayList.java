package ru.belonogov.arraylist;

import java.util.*;

/**
 * Класс пердоставляющий реализацию списка на основе массива
 * @param <T> - тип хранимого объекта
 */
public class MyArrayList<T> implements List<T> {

    /**
     * массив хранимых объектов
     */
    private Object[] elementData;
    /**
     * размер списка
     */
    private int size;
    /**
     * фактический размер массива
     */
    private int capacity;


    /**
     * Конструктор по умолчанию, задающий размер внутренниго масива 10 (default)
     */
    public MyArrayList() {
        capacity = 10;
        elementData = new Object[capacity];
    }

    /**
     * Конструктор позволяющий задать размер внутренниго масива
     * @param capacity - размер внутренниго масива
     */
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elementData = new Object[capacity];
        } else throw new IllegalArgumentException();
    }

    /**
     * Метод добавления элемента по указанному индексу индексу.
     * Сдвигает элемент, находящийся в данный момент в этой позиции (если таковой имеется),
     * и все последующие элементы вправо (добавляет единицу к их индексам).
     * В случае если внутренний массив заполнен, происходит его увеличение в 1,5 раза (size = capacity)
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException – если индекс находится вне диапазона
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (size == capacity) {
            increasingCapacity();
        }
        shiftToRight(index);
        elementData[index] = element;
    }

    /**
     * Метод сдвигающий элементы массива вправо (добавляет единицу к их индексам)
     * и увеличивает размер списка на 1 (size = size + 1)
     * @param index - индекс элемента по каторый требуется произвести сдвиг (включительно)
     */
    private void shiftToRight(int index) {
        size++;
        for (int i = size - 2; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
    }

    /**
     * Метод добавления нового элемента в конец списка
     * В случае если внутренний массив заполнен, происходит его увеличение в 1,5 раза (size = capacity)
     * @param t объект, который требуется добавить
     * @return true
     */
    @Override
    public boolean add(T t) {
        if (size == capacity) {
            increasingCapacity();
        }
        elementData[size++] = t;
        return true;
    }

    /**
     * Метод увеличивающий внутренний массив 1,5 раза в случае если масив был переполнен (size = capacity)
     * @return Массив с данными увеличенный в 1,5 раза
     */
    private Object[] increasingCapacity() {
        capacity = capacity + (capacity >> 1);
        Object[] newElements = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elementData[i];
        }
        elementData = newElements;

        return elementData;
    }

    /**
     * Метод получения объекта из списка по индексу
     * @param index индекс объекта, который требуется получить
     * @return объект соответствующий указаному индексу
     * @throws IndexOutOfBoundsException – если индекс находится вне диапазона
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        Object element = elementData[index];

        return (T) element;
    }

    /**
     * Метод удаления объекта из списка. Проверяет, есть ли указанный объект в списке и удаляет его
     * (первый соответствующий объект).
     * Каждый элемент внутреннего массива сдвигаеся влево к месту удаленного элемента (i = i + 1)
     * @param o объект который требуется удалить
     * @return true - если объект найден и успешно удален, false - если объет отсутствует в списке
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            elementData[index] = null;
            shiftToLeft(index);

            return true;
        }

        return false;
    }

    /**
     * Метод удаления объекта из списка по индексу. Удаляет объект из списка который соответствует требуемому индексу.
     * Каждый элемент внутреннего массива сдвигаеся влево к месту удаленного элемента (i = i + 1)
     * @param index индекс объекта, который требуется удаить
     * @return Удаленный объект
     * @throws IndexOutOfBoundsException – если индекс находится вне диапазона
     *
     */
    @Override
    public T remove(int index) {
        checkIndex(index);
        Object result = elementData[index];
        elementData[index] = null;
        shiftToLeft(index);

        return (T) result;
    }

    /**
     * Метод производящий смещение элементов влево к элементу с заданным индексом
     * Дубль последнего элемента в массиве (size - 1) удаляется
     * Если значения index = size - 1 (элемент относительно которого происходит смещение последний) - элемент просто удаляется
     * @param index индекс элемента на место которого происходит смещение
     */
    private void shiftToLeft(int index) {
        int indexToDelete = --size;
        if (index != size) {
            for (int i = index; i < size; i++) {
                elementData[i] = elementData[i + 1];
            }
            elementData[indexToDelete] = null;
        }
    }

    /**
     * Метод отчистки списка. Всем объектам сприска присваивается null.
     * Размер списка обнуляется.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Метод замены элемента в списке по указанному индексу.
     * @param index индекс элемента, который требуется заменить
     * @param element объект на который происходит замена
     * @return возвращает замененный элемент
     * @throws IndexOutOfBoundsException – если индекс находится вне диапазона
     */
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Object oldElement = elementData[index];
        elementData[index] = element;

        return (T) oldElement;
    }

    /**
     * Метод возвращающий размер списка
     * @return возвращает значение размера списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод проверяющий пуст список или нет.
     * @return true если список пустой (size = 0), false если в списке есть элементы (size != 0)
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Метод проверяет содержит ли список указанный в параметре объект
     * (требуется коррекно определить метод equals в классе, на основе которого строятся объекты)
     * @param o Объект, которому ищем соответствие в списке
     * @return индекс соответствующего переданному объекту. Или -1, если объект не найден
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Метод проверяет содержит ли список указанную в параметре коллекцию объектов
     * (требуется коррекно определить метод equals в классе, на основе которого строятся объекты)
     * @param c коллекция объектов, которой ищем соответствие в списке
     * @return true - если элементы нашегосписка соответствуют указанной колекции.
     * Или false если элементы коллекции либо полностью, либо частично не соответствуют списку
     */
    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object e : c) {
            if (!contains(e)) return false;
        }

        return true;
    }

    /**
     * Метод возвращающий объект итератора
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    /**
     * Метод, создающий массив объектов из нашего списка с размером равным size
     * @return массив объектов соответствующих нашему списку
     */
    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[size];
        for (int i = 0; i < size; i++) {
            newElements[i] = elementData[i];
        }

        return newElements;
    }


    /**
     * Метод проверяющий соответствие объекта списку.
     * Метод проверяет соответствует ли передаваемый объект объекту нашего списка.
     * Так же проверяется соответствие на null объект.
     * (ищет первое вхождение объекта в список)
     * @param o Элемент, которому требуется найти соответствие в списке
     * @return индекс соответствующего элемента списка, либо -1 если объект не найден
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Метод проверяющий соответствие объекта списку.
     * Метод проверяет соответствует ли передаваемый объект объекту нашего списка.
     * Так же проверяется соответствие на null объект.
     * (ищет последнее вхождение объекта в список)
     * @param o Элемент, которому требуется найти соответствие в списке
     * @return индекс соответствующего элемента списка, либо -1 если объект не найден
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Метод сортирующий список в зависимости от условия предусмотренного объектом класса реализующиго Comparator
     * @param c объект класса реализующего Comparator (условие сортировки)
     */
    @Override
    public void sort(Comparator<? super T> c) {
        quickSort(c, elementData, 0, size - 1);
    }

    /**
     * Рекурсивный метод быстрой сортировки. Массив разделяется на подмассивы и каждый из них
     * сортируется относительно опорного элемента (условие остановки рекурсии - в подмассиве
     * остается один элемен (нижняя граница сортировки равна верхней)
     * pi - опорный элемент относительно которого распологаются элементы (в зависимости от способа сортировки,
     * к примеру: слева - меньшие по значению, справа большие)
     * @param c объект класса реализующего Comparator (условие сортировки)
     * @param arr массив требующий сортировки
     * @param low нижняя граница сортируемого массива
     * @param high верхняя граница сортируемого массива
     */
    private void quickSort(Comparator<? super T> c, Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(c, arr, low, high);
            quickSort(c, arr, low, pi - 1);
            quickSort(c, arr, pi + 1, high);
        }
    }

    /**
     * Метод определения индекса опорного элемента. В методе происходит перестановка элементов
     * относительно опорного элемента (опорный элемент распологается посередине).
     * @param c объект класса реализующего Comparator (условие сортировки)
     * @param arr массив требующий сортировки
     * @param low нижняя граница сортируемого массива
     * @param high верхняя граница сортируемого массива
     * @return
     */
    private int partition(Comparator<? super T> c, Object[] arr, int low, int high) {
        T pivot = (T) arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (c.compare((T) arr[j], pivot) > 0) { //>0 ?
                i++;

                T temp = (T) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        T temp = (T) arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Метод проверки соответствия передоваемого индекса условию (index > size || index < 0).
     * @param index индекс требующий проверки на соответствие
     * @throws IndexOutOfBoundsException – если индекс находится вне заданного диапазона
     */
    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод возвращающий фактический размер внутреннего массива
     * @return фактический размер внутреннего массива
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Метод приводящий фактический размер внутреннего массива к размеру списка. (capacity = size)
     */
    public void trimToSize() {
        capacity = size;
        Object[] newElements = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elementData[i];
        }
        elementData = newElements;
    }

    /***
     * Метод позволяющий увеличить фактический размер внутреннего массива до заданной велечины (с сохранением элементов в нем)
     * если список пустой - просто увеличивает размер внутреннего массива.
     * @param newCapacity - емкость до которой требуется увеличить внутренний массив
     */
    public void ensureCapacity(int newCapacity) {
        capacity = newCapacity;
        Object[] newObjects = new Object[capacity];
        if (size == 0) {
            elementData = newObjects;
            return;
        }
        for (int i = 0; i < size; i++) {
            newObjects[i] = elementData[i];
        }
        elementData = newObjects;
    }

    /**
     * Внутренний класс реализующий интерфес Iterator
     */
    private class MyIterator implements Iterator<T> {

        /**
         * счетчик итератора
         */
        int count = 0;

        /**
         * Метод проверяет наличие элементов
         * @return true если элементы еще есть, false если дошли до конца
         */
        @Override
        public boolean hasNext() {
            return count != size;
        }

        /**
         * Метод переставляет счетчик на следующий элемент и возвращает текущий.
         * @return возвращает текущий объект.
         */
        @Override
        public T next() {
            return get(count++);
        }
    }

    // Остальные методы пока не реализованы
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

}
