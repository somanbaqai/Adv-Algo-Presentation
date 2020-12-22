package com.AdvanceAlgoProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivideAndConquerApproach {
    public static class nameValuePair {
        public int pos;
        public int val;

        public nameValuePair(int val, int pos) {
            this.pos = pos;
            this.val = val;
        }

        @Override
        public String toString() {
            return "nameValuePair{" +
                    "pos=" + pos +
                    ", val=" + val +
                    '}';
        }
    }


    private static void Compute_LIS(int[] s, int[] p) {
//        int n=s.length;
        if (s.length > 1) {
            int[] s1 = Arrays.copyOfRange(s, 0, s.length / 2);
            int[] s2 = Arrays.copyOfRange(s, s.length / 2, s.length);

            Compute_LIS(s1, p);
            Compute_LIS(s2, p);
            Combine(s, p);
        }

    }

    public static List<nameValuePair> b;

    private static void Combine(int[] s, int[] p) {
        int n = s.length, max = 0, max_si = 0, l = 0;
//         b = (Collections.nCopies(s.length, new nameValuePair(0,0)));// new ArrayList<nameValuePair>();
        List<Integer> isPresent = new ArrayList<Integer>(Collections.nCopies(s.length, 0));//new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int x = s[i], j = p[i], y = s[j], k = p[j];
            if (k + 1 > l) {
                l++;
            }
            if (x <= n / 2) {
                isPresent.set(b.get(k + 1).pos, 0);
                p[i] = k; //k(i,k);
                if (b.get(k + 1) == null) {
                    b.add(k + 1, new nameValuePair(x, i));
                }
//                b.get(k+1).val = x;
//                b.get(k+1).pos = i;
                isPresent.set(i, k + 1);
                if (max < x) {
                    max = x;
                    max_si = k + 1;
                }
            } else {
                if (k == 0) {
                    k = max_si;

                }

                int pos = b.get(k + 1).pos;
                isPresent.set(pos, 0);
                p[i] = k;//(i,k);

                b.get(k + 1).val = x;
                b.get(k + 1).pos = i;
                isPresent.set(i, k + 1);
            }

        }
    }

    public static void main(String[] args) {

        int[] s = new int[]{8, 9, 2, 6, 3, 7, 10, 4, 1, 5};
        int[] p = new int[s.length];
        Arrays.fill(p, 0);
//        Compute_LIS(mainList.stream().mapToInt(i -> i).toArray(),p.stream().mapToInt(i -> i).toArray());
        b = (Collections.nCopies(s.length, new nameValuePair(0, 0)));
        Compute_LIS(s, p);
        System.out.println(b.toString());

    }
}


