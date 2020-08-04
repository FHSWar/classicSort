import java.util.Arrays;

public class D_ShellSort {
    public static void sort(int[] arr) {
        if(arr == null)
            return;
        int len = arr.length;//数组的长度
        int k = len/2;//初始的增量为数组长度的一半
        //while循环控制按增量的值来划不同分子序列，每完成一次增量就减少为原来的一半
        //增量的最小值为1，即最后一次对整个数组做直接插入排序
        while(k > 0) {//整型的 1 / 2 会等于 0
            //里边其实就是升级版的直接插入排序了，是对每一个子序列进行直接插入排序，
            //所以直接将直接插入排序中的‘1’变为‘k’就可以了。
            for(int i = k;i < len;i++) {
                int j = i;
                int target = arr[i];
                while(j >= k && target < arr[j-k]) {
                    arr[j] = arr[j-k];
                    j -= k;
                }
                arr[j] = target;
            }
            //不同增量排序后的结果
            System.out.println("增量为"+k+"排序之后："+ Arrays.toString(arr));
            k /= 2 ;
        }
    }
}
