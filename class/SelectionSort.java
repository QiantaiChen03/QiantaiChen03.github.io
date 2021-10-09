package SortingPractice;

public class SelectionSort {

    private void selectionsort (int arr[]) {
        //23,25,10,13,11
        for (int i = 0; i < arr.length-1; i++) {
            int minimumValue = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minimumValue]) {
                    minimumValue = j;
                }
            }
            int temp = arr[minimumValue];
            arr[minimumValue] = arr[i];
            arr[i] = temp;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    public static void main (String[] args) {

        SelectionSort ss = new SelectionSort();
        System.out.println("Selection Sort");
        int[] arr = {23,25,11,13,10};
        ss.selectionsort(arr);

    }
}
