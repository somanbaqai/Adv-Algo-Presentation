package com.AdvanceAlgoProject;

import java.util.Arrays;

public class LIS {


    public static int search_id(int[] arr, int N, int X) {
        int mid;
        int low = 0;
        int high = N;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void FindLIS(int[] a, int n) {
        int[] temp = new int[n];
        int[] position = new int[n];
        Arrays.fill(temp, Integer.MAX_VALUE);
        int pt = 0;
        temp[0] = a[0];
        position[0] = 0;
        for (int i = 1; i < n; i++) {
            if (temp[pt] < a[i]) {
                temp[pt + 1] = a[i];
                position[pt + 1] = i;
                pt++;
            } else {
                int ind = search_id(temp, n, a[i]);

                temp[ind] = a[i];
                position[ind] = i;
            }
        }
        System.out.print("Length of longest increasing subsequence ");
        System.out.print(pt + 1);
        System.out.print("\n");
        for (int i = 0; i < pt + 1; i++) {
            System.out.print(a[position[i]]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        int n = a.length;
        FindLIS(a, n);
    }

}

