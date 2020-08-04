public class A_BubbleSort {
    public static void sort(int[] arr) {
        if(arr==null)
            return;
        int len=arr.length;
        //i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for(int i=0;i<len-1;i++) {
            //j控制比较次数，为了保证arr[j+1]不越界，j<len-i-1
            for(int j=0;j<len-i-1;j++) {
                //如果前一个数比后一个数大，则交换位置将大的数往后放。
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
