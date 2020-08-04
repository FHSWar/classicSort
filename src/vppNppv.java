import java.util.Arrays;

public class vppNppv {
    public static void main(String[] args) {

        int[] a = new int[3];
        int k = 0;
        a[k++] = 3;
        int[] b = new int[3];
        int l = 0;
        b[++l] = 3;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
