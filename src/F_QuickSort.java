import java.util.Arrays;

public class F_QuickSort {
    public static void sort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private static void quickSort(int arr[], int low, int high) { // 这里 quicksort 只是分治
        if (low < high) {
            int pivot = partition(arr, low, high); // 小的放 pivot 左边，大的放 pivot 右边，返回此次排序后 pivot 下标
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    private static int partition(int arr[], int low, int high) { // 真正进行排序的是这个 partition
        int pivot = arr[high]; // quicksort 的 pivot 和 partition 的 pivot 不一样嗷，这里的 pivot 是值。
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
// https://zhuanlan.zhihu.com/p/95080265

//快速排序的思想是这样的，如果要对数组区间 [p, r] 的数据进行排序，
// 我们先选择其中任意一个数据作为 pivot（分支点），一般为区间最后一个元素。
// 然后遍历数组，将小于 pivot 的数据放到左边，将大于 pivot 的数据放到右边。
// 接着，我们再递归对左右两边的数据进行排序，直到区间缩小为 1 ，说明所有的数据都排好了序。

//结合代码去思考，才算脚踏实地。 --2020.08.21
