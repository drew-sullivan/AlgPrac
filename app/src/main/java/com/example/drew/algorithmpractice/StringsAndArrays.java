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

    //1.3 Replace spaces with '%20'. Given str (as char[]) and length of string w/o trailing spaces
    public static void urlify(char[] chars, int trueLength) {
        int numSpaces = 0;
        int index = 0;
        int i = 0;
        for (i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') numSpaces++;
        }
        index = trueLength + (numSpaces * 2);
        if (trueLength < chars.length) chars[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= 3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }
    }

    //1.4 is a permutation of a palindrome
    // Input: Tact Coa
    // Output: True ("taco cat", "atco cta")
    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequency(phrase);
        return checkMaxOneOdd(table);
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] buildCharFrequency(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) return val - a;
        return -1;
    }

    //Only use insert, remove, and replace. Given 2 strings, write a function to check
    //if they are one edit (or zero edits) away
    //pale, ple -> true
    //pale, bake -> false
    //pales, pale -> true
    public static boolean oneEditAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) return false;
        String short_string = a.length() < b.length() ? a : b;
        String long_string = a.length() < b.length() ? b : a;

        int ss_i = 0;
        int ls_i = 0;
        boolean foundDifference = false;
        while (ls_i < long_string.length() && ss_i < short_string.length()) {
            if (short_string.charAt(ss_i) != long_string.charAt(ls_i)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (short_string.length() == long_string.length()) ss_i++;
            } else {
                ss_i++;
            }
            ls_i++;
        }
        return true;
    }


    public static void main(String[] args) {
        //for debugging
    }
}
