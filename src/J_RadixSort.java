import java.util.Arrays;

public class J_RadixSort {
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[]) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
//    基数排序是基于计数排序的,真牛逼啊！
    static void countSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
//        Arrays.fill(count,0); no need

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) count[ (arr[i]/exp) % 10 ]++;
        // 24行 arr[i] / exp % 10 妙啊，不管什么数字进来都会剩下目标位数
        // 外面套个 count 就更炫酷了

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
//            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
//            count[ (arr[i]/exp)%10 ]--;  这两行可以简化为下面这行
            output[ --count[ (arr[i]/exp)%10 ] ] = arr[i];
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int arr[]) {
        // Find the maximum number to know number of digits
        int m = getMax(arr);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i  Exponentiation
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    // A utility function to print an array
    static void print(int arr[], int n) {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }


    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr);
        print(arr, n);
    }
}
// LSD: Least Significant Digit first 低位优先