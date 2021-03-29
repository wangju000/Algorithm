package sort;

import java.util.Arrays;

/**
 * 归并排序使用分治思想，通过递归技巧，把数组分解为小数组，排序后合并
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {11, 8, 3, 9, 7, 1, 2, 5, 6, 22, 11, 8, 4, 6};
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        // 合并两个有序数组
        merge(arr, start, end, mid);
    }

    private void merge(int[] arr, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;

        int index = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        if (i > mid) {
            while (j <= end) {
                temp[index] = arr[j];
                j++;
                index++;
            }
        } else {
            while (i <= mid) {
                temp[index] = arr[i];
                i++;
                index++;
            }
        }
        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }
}
