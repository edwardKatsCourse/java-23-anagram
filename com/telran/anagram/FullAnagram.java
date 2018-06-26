package com.telran.anagram;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FullAnagram {

    public static boolean isAnagram(String word, String anagram) {
        return fullAnagramSolution2(word, anagram);
    }

    private static boolean fullAnagramSolution1(String word, String anagram) {
        char[] wordArray = word.toCharArray();
        char[] anagramArray = anagram.toCharArray();

        Arrays.sort(wordArray);
        Arrays.sort(anagramArray);

        return Arrays.equals(wordArray, anagramArray);
    }

    private static boolean fullAnagramSolution2(String word, String anagram) {
        Map<Character, Integer> wordsMap = new HashMap<>();

        for (char c : word.toCharArray()) {

            wordsMap.compute(c, (key, value) -> (value == null) ? 1 : ++value);

//            if (wordsMap.get(c) == null) {
//                wordsMap.put(c, 1); //e - 1
//            } else {
//                wordsMap.computeIfPresent(c, (k, v) -> ++v); //e - 2
//            }
        }

        for (Character anagramCharacter : anagram.toCharArray()) {
            //anagramCharacter = 'e'

            wordsMap.computeIfPresent(anagramCharacter, (key, value) -> --value); //e - 1, e - 0
        }
        //word = letter 'k' occurrences 5
        //anagram = letter 'k' occurrences 4
        //k - 1

        Collection<Integer> values = wordsMap.values();

        values.removeIf(x -> x.equals(0));
        //all -1, 2 ...

        return values.isEmpty(); //values is empty, when all values were 0
    }
}
