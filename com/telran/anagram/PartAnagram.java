package com.telran.anagram;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PartAnagram {

    public static boolean isAnagram(String word, String anagram) {
        return partAnagramSolution1(word, anagram);
    }


    private static boolean partAnagramSolution1(String word, String anagram) {
        Map<Character, Integer> wordMap = new HashMap<>();
        //anagram = city (c = 0, i = 0, t = 1, y = 0)
        //word = centricity

        //word = policy

        for (char letter : word.toCharArray()) {
            wordMap.compute(letter, (key, value) -> (value == null) ? 1 : ++value);
        }

        //{e = 2, l = 1, c = 2}

        //electricity
        //tell
        //collect
        for (char letter : anagram.toCharArray()) {
            //l
            //l
            if (wordMap.get(letter) == null) {
                return false;
            }

            wordMap.computeIfPresent(letter, (key, value) -> --value);
        }

        Collection<Integer> values = wordMap.values();
        values.removeIf(x -> x >= 0);

        return values.isEmpty();
    }

    //                                          		5				6
    private static boolean partAnagramSolution2(String word, String anagram) {
        if (word.length() > anagram.length()) {
            return false;
        }

        char[] wordArray = word.toCharArray();
        char[] anagramArray = anagram.toCharArray();


        Arrays.sort(wordArray);
        Arrays.sort(anagramArray);


        for (int i = 0; i < word.length(); i++) {
            /**
             * laptop -> aloppt
             * top -> opt
             *
             * Set<Integer> wordIndexes-> indexes of the letters, that were already compared
             * Set<Integer> anagramIndexes-> indexes of the letters, that were already compared
             * foreach "aloppt"
             * 		'o'
             *
             * 		foreach "opto" ->
             * 			//check, that current index was not already in use
             * 			if 'o' == 'o' -> exclude index of 'o' from "opt" and from "aloppt"
             *
             *
             */
        }
        return false;
    }
}
