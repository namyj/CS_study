package lecture;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 2, 7, 116, 62};
        int n = arr.length;

        for (int i=n-1; i > 0 ; i--) {
            int maxidx = 0;
            for (int j=1; j <= i; j++) {
                if (arr[maxidx] < arr[j]) maxidx = j;
            }
            int tmp = arr[maxidx];
            arr[maxidx] = arr[i];
            arr[i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
