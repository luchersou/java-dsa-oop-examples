package org.example.Algorithms.Sort;

public class MergeSort {
    void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int[] arr, int l, int m, int r) {
        // Implementation of the merger
    }
}
