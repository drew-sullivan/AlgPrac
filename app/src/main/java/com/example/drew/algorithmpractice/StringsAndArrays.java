package com.example.drew.algorithmpractice;

public class StringsAndArrays {

    public static boolean hasAllUniqueChars(String str) {
        if (str.length() > 128) return false;
        boolean[] letters = new boolean[128];
        for (char c : str.toCharArray()) {
            if (letters[c]) return false;
            letters[c] = true;
        }
        return true;
    }


    public static boolean arePermutations(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[128];
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        arePermutations("tokyo", "kyoto");

        char[] test = new char[128];
        for (int i = 0; i < test.length; i++) {
            test[i] = (char) i;
        }
        System.out.println("test[0]: " + test[0]);
        System.out.println("test['a']: " + test['a']);
    }
}
