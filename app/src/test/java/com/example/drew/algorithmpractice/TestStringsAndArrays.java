package com.example.drew.algorithmpractice;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestStringsAndArrays {

    @Test
    public void hasAllUniqueChars() {
        assertEquals(StringsAndArrays.hasAllUniqueChars("abcde"), true);
        assertEquals(StringsAndArrays.hasAllUniqueChars("abcdee"), false);
        assertEquals(StringsAndArrays.hasAllUniqueChars(""), true);
    }

    @Test
    public void arePermutations() {
        assertEquals(StringsAndArrays.arePermutations("coke", "soda"), false);
        assertEquals(StringsAndArrays.arePermutations("tokyo", "kyoto"), true);
        assertEquals(StringsAndArrays.arePermutations("", ""), true);
    }
}