public class G_HeapSort {

    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
    }

    /**
     * 构建堆的过程
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int childIndex;
        int fatherValue;
        for (fatherValue = arr[i]; leftChild(i) < n; i = childIndex) {
            childIndex = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (childIndex != n - 1 && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (fatherValue < arr[childIndex]) {
                arr[i] = arr[childIndex];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = fatherValue;
    }
    // 在堆构建完成之前，i 是下筛的起点，如果进行了交换，说明 fatherValue 值是相对小的，会一直去到能去的最末端的 i。
    //      由于是从倒数第二层开始的，所以来到靠前的层级时下筛到第一个 break 时下面的已经是小号的大根堆，所以往后到结束之前会一直 break。
    // 在堆构建完成之后，最后一步 arr[i] = fatherValue 就是将当下最大值推入当下数组末端。
    //      因为第二个 if 总是 false，i 会去到最后一片叶子。

    // 获取到左孩子结点
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
} // https://blog.csdn.net/zdp072/article/details/44227317 基本是抄这个
