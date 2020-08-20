package Improve;
// 仔细想想，这个也算不上改进，因为没有确保稳定性
public class H_CountSortImprove { // 改进在第 22 行，更好懂
    public int[] countSortImprove (int[] arr) {
        int max=arr[0];
        int min=arr[0];

        //step1:得到最大值和最小值，确定构建的数组长度
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)  max=arr[i];
            if(arr[i]<min) min=arr[i];
        }

        //step2:构建一个数组，用来存放每一个数对应出现的次数
        int d=max-min;

        // 统计每个数字出现的次数
        int [] counter=new int [d+1];
        for (int i = 0; i < arr.length; i++) counter[arr[i]-min]++;


        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[arr.length];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) { // 这里的 num 和上面的 num 不是一回事，哇这个计数排序牛逼！！！
            while (counter[num]-- > 0) {
                res[idx++] = num;
            }
        }
        return res;
    }
}
