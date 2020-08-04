import java.util.Arrays;

public class F_QuickSort {
    public static void sort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
//        System.out.println(Arrays.toString(arr));
        return i+1;
    }
}
// 面向前人智慧编程：https://www.geeksforgeeks.org/quick-sort/
