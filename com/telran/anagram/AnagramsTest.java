package com.telran.anagram;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramsTest {
    private static final String PART_ANAGRAM_WORD = "";
    private static final String FULL_ANAGRAM_WORD = "";

//    private static final String [] words = {"electricity", "laptop"};


    private static final Map<String, List<String>> CORRECT_ANAGRAMS = new HashMap<>();
    private static final Map<String, List<String>> INCORRECT_ANAGRAMS = new HashMap<>();

    @BeforeClass
    public static void init() {
        CORRECT_ANAGRAMS.compute("electricity", (key, value) -> {
            List<String> anagrams = new ArrayList<>();
            anagrams.add("yticirtcele");
            anagrams.add("tycirictlee");
            anagrams.add("tic");
            anagrams.add("tele");
            anagrams.add("rely");
            anagrams.add("rele");
            anagrams.add("city");
            return anagrams;
        });

        CORRECT_ANAGRAMS.compute("miles", (key, value) -> {
            List<String> anagrams = new ArrayList<>();
            anagrams.add("limes");
            anagrams.add("slime");
            anagrams.add("smile");
            anagrams.add("semil");
            return anagrams;
        });

        CORRECT_ANAGRAMS.compute("result", (key, value) -> {
            List<String> anagrams = new ArrayList<>();
            anagrams.add("luster");
            anagrams.add("rustle");
            return anagrams;
        });

        INCORRECT_ANAGRAMS.compute("result", (key, value) -> {
            List<String> anagrams = new ArrayList<>();
            anagrams.add("lusterr");
            anagrams.add("rustlee");
            anagrams.add("raselt");
            return anagrams;
        });

        INCORRECT_ANAGRAMS.compute("miles", (key, value) -> {
            List<String> anagrams = new ArrayList<>();
            anagrams.add("milas");
            anagrams.add("niles");
            anagrams.add("milles");
            return anagrams;
        });

        INCORRECT_ANAGRAMS.compute("electricity", (key, value) -> {
            List<String> anagrams = new ArrayList<>();
            anagrams.add("tell");
            anagrams.add("select");
            anagrams.add("collect");
            anagrams.add("");
            anagrams.add("reter");
            return anagrams;
        });
    }
    
    @Test
    public void isCorrectAnagramTest() {
        runTest(CORRECT_ANAGRAMS, true);
    }

    @Test
    public void isIncorrectAnagramTest() {
        runTest(INCORRECT_ANAGRAMS, false);
    }

    private void runTest(Map<String, List<String>> inputWords, boolean isExpectedCorrect) {
        for (Map.Entry<String, List<String>> map : inputWords.entrySet()) {
            for (String wordToCheck : map.getValue()) {

                if (isExpectedCorrect) {

                    Assert.assertTrue(Anagrams.isAnagram(map.getKey(), wordToCheck));
                } else {
                    Assert.assertFalse(Anagrams.isAnagram(map.getKey(), wordToCheck));

                }
            }
        }
    }
}
