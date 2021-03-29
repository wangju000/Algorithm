package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {11, 8, 3, 9, 7, 1, 2, 5, 6, 22, 11, 8, 4, 6};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        // 选择最后一个元素作为分区点
        int pivot = arr[end];
        int i = start;
        int j = end; // 考虑到最小数组最终有两个元素，所以 j 不能直接赋值 end - 1

        while (i != j) {
            // 若选择end为分区点，则需要先移动i;反之，先移动j
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, end);

        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
