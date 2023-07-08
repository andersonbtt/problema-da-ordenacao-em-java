package br.com.unibf.posgraduacao.java.andersonbittencourt;

import java.util.Arrays;

public class PatternDefeatingQuicksort {
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 > 3) {
                int pivotIndex = getPivotIndex(arr, low, high);
                int pivotPosition = partition(arr, low, high, pivotIndex);
                
                sort(arr, low, pivotPosition - 1);
                sort(arr, pivotPosition + 1, high);
            } else {
                insertionSort(arr, low, high);
            }
        }
    }
    
    private static int getPivotIndex(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        
        return mid;
    }
    
    private static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivotValue) {
                swap(arr, i, j);
                i++;
            }
        }
        
        swap(arr, i, high);
        
        return i;
    }
    
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 8, 2, 7, 3, 6, 4};
        System.out.println("Array antes da ordenação: " + Arrays.toString(arr));
        
        PatternDefeatingQuicksort.sort(arr, 0, arr.length - 1);
        
        System.out.println("Array após a ordenação: " + Arrays.toString(arr));
    }
}