package br.com.unibf.posgraduacao.java.andersonbittencourt;

import java.lang.Math;
import java.util.Arrays;

public class TimSort {
    private static final int MIN_MERGE = 32;
    
    public static void sort(int[] arr) {
        int n = arr.length;
        
        // Caso base: Se o tamanho do array for menor que o mínimo para mesclagem, usar Insertion Sort
        if (n < MIN_MERGE) {
            insertionSort(arr, 0, n - 1);
            return;
        }
        
        // Dividir o array em runs
        int runSize = calculateRunSize(n);
        
        for (int i = 0; i < n; i += runSize) {
            insertionSort(arr, i, Math.min((i + runSize - 1), (n - 1)));
        }
        
        // Fazer a mesclagem dos runs
        int currSize = runSize;
        
        while (currSize < n) {
            for (int left = 0; left < n; left += (2 * currSize)) {
                int mid = left + currSize - 1;
                int right = Math.min((left + 2 * currSize - 1), (n - 1));
                merge(arr, left, mid, right);
            }
            currSize *= 2;
        }
    }
    
    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        
        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < len2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    private static int calculateRunSize(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 8, 2, 7, 3, 6, 4};
        System.out.println("Array antes da ordenação: " + Arrays.toString(arr));
        
        sort(arr);
        
        System.out.println("Array após a ordenação: " + Arrays.toString(arr));
    }
}