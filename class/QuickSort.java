package SortingPractice;

import java.util.Arrays;

public class QuickSort {

//    public void sort(int[] arr){
//        quickSort(arr, 0, arr.length-1);
//    }

    private void quickSort (int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition (int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private void swap (int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] a = {62,98,33,21,60,96,75,46};

        qs.quickSort(a, 0, a.length-1);
        printArray(a, a.length);

        Arrays.sort(a);
        System.out.println((Arrays.toString(a)));

    }

}
