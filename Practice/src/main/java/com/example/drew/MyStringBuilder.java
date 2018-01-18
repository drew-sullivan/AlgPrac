package com.example.drew;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyStringBuilder {
    private static final Logger LOGGER = Logger.getLogger(MyStringBuilder.class.getName());
    public static final int INITIAL_SIZE = 16;
    private char[] chars = new char[INITIAL_SIZE];
    private int numChars = 0;
    private double threshold = INITIAL_SIZE * 0.75;

    //Default constructor
    public MyStringBuilder() {}

    //Constructor for choosing initial capacity
    public MyStringBuilder(int capacity) {
        if (capacity < 0) {
            throw new NegativeArraySizeException();
        }
        chars = new char[capacity];
        threshold = capacity * 0.75;
    }

    public MyStringBuilder append(char c) {
        chars[numChars] = c;
        numChars++;
        if (numChars > threshold) {
            chars = Arrays.copyOf(chars, chars.length * 2);
            LOGGER.log(Level.FINE, "Size increased to: " + chars.length);
        }
        return this;
    }

    public void append(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            append(c);
        }
    }

    public String getName() { return "MyStringBuilder"; }

    public MyStringBuilder insert(int index ,char c) {
        if (index < 0) {
            throw new NegativeArraySizeException();
        }
        char[] temp = new char[numChars + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = chars[i];
        }
        temp[index] = c;
        for (int i = index + 1; i < numChars + 1; i++) {
            temp[i] = chars[i];
        }
        chars = Arrays.copyOf(temp, numChars + 1);
        numChars++;
        return this;
    }

    public char delete(int index) {
        if (index < 0) {
            throw new NegativeArraySizeException();
        }
        char deleted = chars[index];
        for (int i = index; i < chars.length - 1; i++) {
            chars[i] = chars[i + 1];
        }
        numChars--;
        return deleted;
    }

    public MyStringBuilder reverse() {
        for (int i = 0; i < chars[i]; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return this;
    }
//
//    public MyStringBuilder replace(int start, int end, String str) {
//        return new MyStringBuilder();
//    }
//
//    public MyStringBuilder setCharAt(int index, char c) {
//        return new MyStringBuilder();
//    }

    public int length() { return numChars; }

    public int capacity() { return chars.length; }

    @Override
    public String toString() {
        return new String(chars);
    }

    public static void main(String[] args) {
        MyStringBuilder msb = new MyStringBuilder();
        msb.append('a');
        msb.append('b');
        msb.append('c');
        msb.append('d');
        msb.append('e');
        msb.append("drew");
        msb.delete(2);
        msb.delete(7);
        System.out.println(msb.toString());
        msb.insert(2, 'H');
        System.out.println(msb.toString());
        msb.reverse();
        System.out.println(msb.toString());

    }
}
