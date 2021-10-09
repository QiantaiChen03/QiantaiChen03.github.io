package SortingPractice;

public class InsertionSort {

    private void insertionSort (int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > x) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        InsertionSort is = new InsertionSort();
        System.out.println("Selection Sort");
        int[] arr = {23,25,11,13,10};
        is.insertionSort(arr);

    }
}
