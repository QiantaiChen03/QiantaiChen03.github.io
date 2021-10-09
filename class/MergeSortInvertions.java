package SortingPractice;

public class MergeSortInvertions {

    private int mergeSort(int arr[], int first, int last){
        int invertionCount = 0;
        if (first < last) {
            int mid = (first + last) / 2;
            invertionCount += mergeSort(arr, first, mid);
            invertionCount += mergeSort(arr, mid + 1, last);
            invertionCount += merge(arr, first, mid, mid + 1, last);
        }
        return invertionCount;
    }

    private int merge(int arr[], int first1, int last1, int first2, int last2){
        int index1 = first1;
        int index2 = first2;
        int tempIndex = 0;
        int invertionCount = 0;
        int temp[] = new int[arr.length];


        while (index1 <= last1 && index2 <= last2) {
            if (arr[index1] <= arr[index2]) {
                temp[tempIndex++] = arr[index1++];
            } else {
                temp[tempIndex++] = arr[index2++];
                System.out.println(arr[index1]+" "+ arr[index2-1]);
                invertionCount += last1 - index1 + 1;
            }
        }

        while (index1 <= last1) {
            temp[tempIndex++] = arr[index1++];
        }

        while (index2 <= last2) {
            temp[tempIndex++] = arr[index2++];
        }

        tempIndex = 0;
        int index = first1;

        while (index <= last2) {
            arr[index++] = temp[tempIndex++];
        }

        return invertionCount;
    }

    public static void main(String[] args){
        MergeSortInvertions ms = new MergeSortInvertions();
        int arr[] = {20,24,62,86,91,79,93,28,12,45,97,300,3694859,232567,1289043};
        int invertionCount = ms.mergeSort(arr, 0, arr.length-1);
        System.out.println("Total Inversion: " + invertionCount);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
