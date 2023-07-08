package br.com.unibf.posgraduacao.java.andersonbittencourt;

import java.util.Random;


public class App{
    public static void main(String[] args){
        int[] randomArray = generateRandomArray(1000);    
        TimSortDemo.sort(randomArray);
        PatternDefeatingQuicksortDemo.sort(randomArray);
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }

}