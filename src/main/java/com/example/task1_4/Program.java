package com.example.task1_4;

import java.util.Date;
import java.util.Random;

public class Program {

    public static int[] generation(int c) {
        int arr[] = new int[c];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200 - 100);
        }
        return arr;
    }

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < 0 && arr[j] > 0) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        for (int c = 1; c <= 3; c++) {
            int[] array = generation(c*100000);
            solution(array);
        }

        for (int c = 1; c <= 10; c++) {
            int cnt = 0;
            long cntTime = 0;
            while (cnt < 5) {
                int[] arr = generation(c*10000);
                long time = System.nanoTime();
                solution(arr);
                cntTime += (System.nanoTime() - time);
                cnt++;
            }
            System.out.println(cntTime / cnt);
        }
    }
}
