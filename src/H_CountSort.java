import java.util.Arrays;

public class H_CountSort {
// 这个算法不倒序遍历不能确保稳定性这点，想象重复元素有下标且乱序，会发现我们输出排序时无法保证依次。啊，舒服了。
    private static int[] countSort(int[] arr) {
        int max=arr[0];
        int min=arr[0];

        //step1:得到最大值和最小值，确定构建的数组长度
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)  max=arr[i];
            if(arr[i]<min) min=arr[i];
        }

        //step2:构建一个数组，用来存放每一个数对应出现的次数
        int d=max-min;
        int [] count=new int [d+1];
        //统计次数
        for (int i = 0; i < arr.length; i++) count[arr[i]-min]++;
        System.out.println("统计不同元素出现的次数："+Arrays.toString( count));

        //step3:对此时的数组做变形,统计数组从第二个元素开始，每一个元素等于它本身都加上前面所有元素之和。
        for(int i=1;i<count.length;i++) count[i]+=count[i-1];
        System.out.println("变形后的数组："+Arrays.toString( count));

        //step4:倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组,确保稳定性
        /**
         * 这个插入很漂亮。
         * 语义是反向遍历，将原数组各元素根据“计数数组下标等于对应元素的值减一”
         * 所得下标插入新数组，用 -- 就把维护计数数组和正确赋值一次性搞定了。
         * 就 tm 天秀。
         */
        int[] sortedArray = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
//            sortedArray[count[arr[i]-min]-1]=arr[i];
//            count[arr[i]-min]--;
//            可优化为
            sortedArray[--(count[arr[i]-min])]=arr[i];

        return sortedArray;
    }

    public static void main(String[] args) {
        int arr[]={93,95,98,98,94,92,96,91};
        int[] sortedArray= countSort(arr);
        System.out.println("结果输出："+ Arrays.toString(sortedArray));
    }
}
/**
 *
 * 1.基本思想
 *
 *  计数排序是一个非基于比较的排序算法，该算法于1954年由 Harold H. Seward 提出。
 *  它的优势在于在对一定范围内的整数排序时，它的性能甚至快于哪些O(nlogn)的排序算法。
 *
 *  思路是开一个长度为 maxValue-minValue+1 的数组，然后
 *
 *  分配。扫描一遍原始数组，以当前值- minValue 作为下标，将该下标的计数器增1。
 *  收集。扫描一遍计数器数组，按倒序把值收集起来。(使排序为稳定排序)
 */
