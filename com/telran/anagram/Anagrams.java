package com.telran.anagram;

import java.util.*;

public class Anagrams {

    /**
     * BEFORE ALL - check length!!!!
     * 1.
     * String = char []
     * sort first param
     * sort second param
     * compare two arrays
     * <p>
     * <p>
     * 2.
     * Map<Character, Integer> initialWord, increment integer ->
     * {'l', 1}
     * {'l', 2}
     * {'p', 1}
     * {'p', 2}
     * ....
     * <p>
     * <p>
     * from anagram - get char array and iterate
     * <p>
     * 1. if map.get(anagramArray[i]) == null -> return false
     * 2. if map.computeIfPresent -> value--
     * <p>
     * check if there is a value <> 0
     * if all values = 0 -> true
     * if any value is not 0 -> return false
     */

//    public static boolean isFullAnagram(String word, String anagram) {
//
//        return fullAnagramSolution2(word, anagram);
//    }
//
//    public static boolean isPartAnagram(String word, String anagram) {
//        return partAnagramSolution1(word, anagram);
//    }

    public static boolean isAnagram(String word, String anagram) {
        //word = dog
        //anagram = earth
        if (anagram.length() > word.length()) {
            return false;
        }

        if (!word.isEmpty() && anagram.isEmpty()) {
            return false;
        }

        if (word.length() == anagram.length()) {
            return FullAnagram.isAnagram(word, anagram);
        }

        return PartAnagram.isAnagram(word, anagram);
    }





}
