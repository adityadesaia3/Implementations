import java.util.Arrays;

public class MergeSort {
    /***
     * 
     * @param arr 
     *      0-indexed array
     * @param start 
     * @param end
     */
    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }
    public static void mergesort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergesort(arr, start, mid);
            mergesort(arr, mid + 1, end);
            merge(arr, start, mid, mid + 1, end);
        }
    }

    private static void merge(int[] arr, int start1, int end1, int start2, int end2) {
        int[] brr = Arrays.copyOf(arr, arr.length);

        int index = start1;
        while (start1 <= end1 && start2 <= end2) {
            if (brr[start1] <= brr[start2]) {
                arr[index] = brr[start1];
                start1 += 1;
            } else {
                arr[index] = brr[start2];
                start2 += 1;
            }
            index += 1;
        }

        while (start1 <= end1) {
            arr[index] = brr[start1];
            start1 += 1;
            index += 1;
        }
        while (start2 <= end2) {
            arr[index] = brr[start2];
            start2 += 1;
            index += 1;
        }
    }
}