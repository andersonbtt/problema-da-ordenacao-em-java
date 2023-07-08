package br.com.unibf.posgraduacao.java.andersonbittencourt;
import java.util.Arrays;
import java.util.Random;

public class PatternDefeatingQuicksortDemo {
    public static void sort(int[] array) {
        // Registrar o tempo inicial
        long startTime = System.currentTimeMillis(); 
        // Ordenar o array utilizando o Pattern-Defeating Quicksort
        PatternDefeatingQuicksort.sort(array, 0, array.length - 1); 
        // Registrar o tempo final
        long endTime = System.currentTimeMillis(); 
        System.out.println("Array ordenado pelo Pattern-Defeating Quicksort:");
        System.out.println(Arrays.toString(array));
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }
}