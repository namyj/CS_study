package lecture;

public class Array {
    /**
     * 특정 위치에 원소 삽입하기
     * @param idx
     * @param num
     * @param arr
     * @param len
     * - 맨 오른쪽 원소부터 이동하면, 메모리 절약 가능
     */
    public static void insert(int idx, int num, int arr[], int len) {
        for (int i = len; i > idx ; i--)
            arr[i] = arr[i-1];
        arr[idx] = num;
        len++;
    }

    public static void erase(int idx, int arr[], int len) {
        len--;
        for (int i = idx; i < len; i++) {
            arr[i] = arr[idx-1];
        }
    }
    public static void main(String[] args) {

    }
}
