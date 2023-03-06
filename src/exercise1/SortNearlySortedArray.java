package exercise1;

import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static void sort(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);

        for (int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {
            minHeap.add(arr[i]);
            int min = minHeap.poll();
            arr[i - k - 1] = min;
        }

        while (!minHeap.isEmpty()) {
            arr[n - k - 1] = minHeap.poll();
            k--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 4, 70, 60, 50, 100 };
        int k = 3;
        sort(arr, k);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
