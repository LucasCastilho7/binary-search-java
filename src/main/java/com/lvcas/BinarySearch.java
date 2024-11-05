package com.lvcas;

public class BinarySearch {
    static class Result {
        int comparisons;
        boolean found;

        Result(int comparisons, boolean found) {
            this.comparisons = comparisons;
            this.found = found;
        }
    }

    public static Result binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;

        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return new Result(comparisons, true);
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new Result(comparisons, false);
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        int target = -1;

        for (int size : sizes) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }

            Result result = binarySearch(array, target);
            System.out.println("Tamanho da lista: " + size + ", Comparações: " + result.comparisons);
        }
    }
}
