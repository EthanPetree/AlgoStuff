package edu.neumont.csc250.isomorph;

import edu.neumont.csc250.sorting.SortingLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class IsomorphGenerator {
    public static String create(List<String> words){
    return String.join(", ", words);
    }

    /**
     *  counter to track unique characters that come up in place
     *  split the string up into an array so we can iterate character by character
     *  make an empty array with the length of the string
     *  loop starting from 0 and going until the length of the string array
     *  map each character as we go, so we can know if we should increment the counter or not
     *  check if the character exists
     *  if exists track the index intially found
     *  if not, create a new key value pair with the new char and the index it was placed
     *
     *  update the previously empty array based on the counter
     *
     *  once the loop in finished we can loop through the last array and make a StringBuilder to return the pattern
     */
    public static String GetExactPattern(String word) {
        StringBuilder sb = new StringBuilder();
        int uniqueCharCounter = 0;
        HashMap<String, Integer> charTracker = new HashMap<>();
        String[] wordPieces = word.split("");

        for (int i = 0; i < wordPieces.length; i++) {
            if(charTracker.containsKey(wordPieces[i])){
                continue;
            } else {
                charTracker.put(wordPieces[i], uniqueCharCounter);
                uniqueCharCounter++;

            }
        }

        for (int i = 0; i < wordPieces.length; i++) {
            if(i + 2 > wordPieces.length){
                sb.append(charTracker.get(wordPieces[i]));
            } else {
                sb.append(charTracker.get(wordPieces[i]) + " ");
            }
        }

        return sb.toString();
    }

    /*
     * Split up the word into a string array
     * For each unique character we put it in a hashmap with a value of 1
     * if the character is not unique we increment the value of the character in the map

     * after the loop we loop through the values and populate an array to return
     * sort the array from least to greatest and return
     */
    public static String GetLoosePattern(String word) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> charTracker = new HashMap<>();
        String[] wordPieces = word.split("");

        for (int i = 0; i < wordPieces.length; i++) { //O(n)
            if(charTracker.containsKey(wordPieces[i])){
                charTracker.merge(wordPieces[i], 1, Integer::sum);
            } else {
                charTracker.put(wordPieces[i], 1);
            }

        }

        //populate thy array
        Integer[] result = new Integer[charTracker.size()];

        int counter = 0;
        for (String i : charTracker.keySet()) { //O(n)
            result[counter] = charTracker.get(i);
            counter++;
        }

        //sort
        SortingLibrary.insertionSort(result); //O(n^2)


        for (int i = 0; i < result.length; i++) { //O(n)
            if (i + 2 > result.length){
                sb.append(result[i]);
            } else {
                sb.append(result[i] + " ");
            }
        }

        return sb.toString();
    }

    /*
    Create a HashMap that tracks unique Isomorph patterns
    loop through the String array provided and
    if unique pattern, add the pattern as the key and the value in a new arraylist
    if the pattern matches something already in the map, add the word to the arraylist

    loop through the hashmap and remove any that only have an arraylist size of one
     */
    public static HashMap<String, List<String>> FindExactIsomorphs(String[] words){
        HashMap<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String wordPattern = IsomorphGenerator.GetExactPattern(words[i]);
            if (result.containsKey(wordPattern)){
                result.get(wordPattern).add(words[i]);
            } else {
                result.put(wordPattern, new ArrayList<>());
                result.get(wordPattern).add(words[i]);
            }
        }

        ArrayList<String> keysToRemove = new ArrayList<>();
        for (String i : result.keySet()) {
            if(result.get(i).size() == 1){
                keysToRemove.add(i);
            }
        }

        for (String key : keysToRemove){
            result.remove(key);
        }

        return result;
    }

    public static HashMap<String, List<String>> FindLooseIsomorphs(String[] words){
        HashMap<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String wordPattern = IsomorphGenerator.GetLoosePattern(words[i]);
            if (result.containsKey(wordPattern)){
                result.get(wordPattern).add(words[i]);
            } else {
                result.put(wordPattern, new ArrayList<>());
                result.get(wordPattern).add(words[i]);
            }
        }

        ArrayList<String> keysToRemove = new ArrayList<>();
        for (String i : result.keySet()) {
            if(result.get(i).size() == 1){
                keysToRemove.add(i);
            }
        }

        for (String key : keysToRemove){
            result.remove(key);
        }

        return result;
    }
}
