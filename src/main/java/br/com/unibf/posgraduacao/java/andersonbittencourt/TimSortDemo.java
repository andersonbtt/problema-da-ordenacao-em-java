package br.com.unibf.posgraduacao.java.andersonbittencourt;
import java.util.Arrays;
import java.util.Random;

public class TimSortDemo {
    public static void sort(int[] array) {
        // Registrar o tempo inicial
        long startTime = System.currentTimeMillis(); 
        // Ordenar o array utilizando o Tim Sort
        TimSort.sort(array); 
        // Registrar o tempo final
        long endTime = System.currentTimeMillis(); 
        System.out.println("Array ordenado pelo Tim Sort:");
        System.out.println(Arrays.toString(array));
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }
    
}
