package com.example.drew;

public class MyArrayList {
    private Object[] objs;
    private int size = 0;

    public MyArrayList() {
        objs = new Object[5];
    }

    public void add(Object obj) {
        objs[size] = obj;
        size++;
        if (size / objs.length >= 0.75) {
            Object[] temp = objs;
            objs = new Object[size * 2];
//            System.out.println("New length: " + objs.length);
            for (int i = 0; i < size; i++) {
                objs[i] = temp[i];
            }
        }
    }

    public Object get(int index) {
        if (index < objs.length && index >= 0) {
            return objs[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Out of bounds! Attempted index was: " + index);
        }
    }

    public void set(int index, Object obj) {
        if (index < size) {
            objs[index] = obj;
        } else {
            throw new ArrayIndexOutOfBoundsException("Out of bounds! Attempted index was: " + index);
        }
    }

    public Object remove(int index) {
        if (index < size) {
            Object store = objs[index];
            objs[index] = null;
            for (int i = index; i < size - 1; i++) {
                objs[i] = objs[i + 1];
            }
            objs[size - 1] = null;
            size--;
            return store;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() { return size; }

    public static void main(String[] stuff) {
        MyArrayList mal = new MyArrayList();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+mal.get(5));
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }

    }
}
