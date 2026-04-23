package edu.neumont.csc250.challenges;

import java.util.HashMap;

public class WeightSort {
    public static String orderWeightOld(String string){
        StringBuilder sb = new StringBuilder();
        String[] arr = string.split(" ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            int sum = 0;
            String[] digits = arr[i].split("");
            for (int j = 0; j < digits.length; j++) {
                sum += Integer.parseInt(digits[j]);
            }

            map.put(arr[i], sum);
        }

        String[] keys = new String[map.size()];

        int counter = 0;
        for (String i : map.keySet()) {
            keys[counter] = i;
            counter++;
        }

        for (int i = 0; i < keys.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < keys.length - 1 - i; j++) {
                if(map.get(keys[j]) > map.get(keys[j + 1])){
                    //swap based on key number
                    swapped = true;
                    String temp = keys[j];
                    keys[j] = keys[j+1];
                    keys[j+1] = temp;

                } else if (map.get(keys[j]).equals(map.get(keys[j + 1]))) {
                    //swap based on string
                    if (keys[j].compareTo(keys[j + 1]) > 0){
                        swapped = true;
                        String temp = keys[j];
                        keys[j] = keys[j+1];
                        keys[j+1] = temp;
                    }
                }
            }
            if (!swapped){
                break;
            }
        }

        for (int i = 0; i < keys.length; i++) {
            if (i + 2 > keys.length){
                sb.append(keys[i]);
            } else {
                sb.append(keys[i] + " ");
            }
        }

        return sb.toString();
    }

    public static String orderWeight(String string){
        StringBuilder sb = new StringBuilder();
        String[] arr = string.split(" ");
        String[][] map = new String[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            int sum = 0;
            String[] digits = arr[i].split("");
            for (int j = 0; j < digits.length; j++) {
                sum += Integer.parseInt(digits[j]);
            }

//            map.put(arr[i], sum);
            map[i][0] =  arr[i];
            map[i][1] = String.valueOf(sum);
        }

        for (int i = 0; i < map.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < map.length - 1 - i; j++) {
                if(Integer.parseInt(map[j][1])  > Integer.parseInt(map[j + 1][1])){
                    //swap based on key number
                    swapped = true;
                    for (int k = 0; k < 2; k++) {
                        String temp = map[j][k];
                        map[j][k] = map[j+1][k];
                        map[j+1][k] = temp;
                    }
//map.get(keys[j]).equals(map.get(keys[j + 1]))
                } else if (Integer.parseInt(map[j][1]) == Integer.parseInt(map[j + 1][1])) {
                    //swap based on string
                    if (map[j][0].compareTo(map[j + 1][0]) > 0){
                        swapped = true;
                        for (int k = 0; k < 2; k++) {
                            String temp = map[j][k];
                            map[j][k] = map[j+1][k];
                            map[j+1][k] = temp;
                        }
                    }
                }
            }
            if (!swapped){
                break;
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (i + 2 > map.length){
                sb.append(map[i][0]);
            } else {
                sb.append(map[i][0] + " ");
            }
        }

        return sb.toString();
    }
}
