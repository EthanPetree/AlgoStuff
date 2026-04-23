package edu.neumont.csc250.sorting.data;
import java.util.*;

public class DataGenerator {
    public static Integer[] generateRandomInts(int seed, int size) {
        Random rand = new Random(seed);
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100001);
        }
        return arr;
    }

    public static Integer[] generateAscendingInts(int seed, int size) {
        Integer[] arr = generateRandomInts(seed, size);
        Arrays.sort(arr);
        return arr;
    }

    public static Integer[] generateDescendingInts(int seed, int size) {
        Integer[] arr = generateRandomInts(seed, size);
        Arrays.sort(arr);
        reverse(arr);
        return arr;
    }

    public static Person[] generatePersons(int seed, int size, PersonOrder order) {
        Integer[] ids = switch (order) {
            case ASCENDING -> generateAscendingInts(seed, size);
            case DESCENDING -> generateDescendingInts(seed, size);
            default -> generateRandomInts(seed, size);
        };

        Person[] people = new Person[size];
        for (int i = 0; i < size; i++) {
            people[i] = new Person(ids[i]);
        }
        return people;
    }

    private static void reverse(Integer[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
