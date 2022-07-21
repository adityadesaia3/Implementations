public class HeapSort {
    private static int heapSize;

    private static void maxHeapify(int[] arr, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = Integer.MIN_VALUE;
        if (left <= heapSize && arr[left] > arr[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            // exchange largest with index
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            
            maxHeapify(arr, largest);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for (int index = heapSize / 2; index >= 0; index--) {
            maxHeapify(arr, index);
        }
    }

    public static void heapsort(int[] arr) {
        heapSize = arr.length - 1;
        buildMaxHeap(arr);
        for (int index = arr.length - 1; index >= 1; index--) {
            // exchange ith child with root i.e. index - 0
            int temp = arr[index];
            arr[index] = arr[0];
            arr[0] = temp;

            heapSize -= 1;
            maxHeapify(arr, 0);
        }
    }
}
