import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.nanoTime;

public class Main {

    public static void main(String[] args) {

        File file = new File(".\\src\\goods_in_the_store.csv");
        ArrayList<Store> storeList = Store.input(file);
        ArrayList<Store> originalList = new ArrayList<>(storeList);

        System.out.println("");
        System.out.println("Bubble Sort");
        System.out.println("----------------------------------------------------------------------------");
        bubbleSort(storeList);
        refreshList(storeList, originalList);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Selection Sort");
        System.out.println("----------------------------------------------------------------------------");
        selectionSort(storeList);
        refreshList(storeList, originalList);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Shell Sort");
        System.out.println("----------------------------------------------------------------------------");
        refreshList(storeList, originalList);
        shellSort(storeList);
    }
    public static void refreshList(ArrayList<Store> storeList, ArrayList<Store> originalList){
        storeList.clear();
        storeList.addAll(originalList);
    }

    public static void bubbleSort(ArrayList<Store> storeList) {
        long start = nanoTime();
        int comparitions = 0;
        int swaps = 0;
        for (int i = 0; i < storeList.size() - 1; i++) {
            for (int j = 0; j < storeList.size() - i - 1; j++) {
                ++comparitions;

                if(storeList.get(j).compareTo(storeList.get(j + 1)) > 0){
                    ++swaps;
                    Store temp = storeList.get(j);
                    storeList.set(j, storeList.get(j + 1));
                    storeList.set(j + 1, temp);
                }
            }
        }
        long end = (nanoTime() - start);
        for (Store store: storeList) {
            System.out.println(store);
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Comparitions = " + comparitions);
        System.out.println("Swaps = " + swaps);
        System.out.println("Execution time \u2248 " + end/Math.pow(10, 9) + " seconds");
    }

    public static void selectionSort(ArrayList<Store> storeList){
        long start = nanoTime();
        int comparitions = 0;
        int swaps = 0;
        for (int i = 0; i < storeList.size() - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < storeList.size(); j++) {
                ++comparitions;
                if(storeList.get(j).compareTo(storeList.get(min_idx)) < 0)
                    min_idx = j;
            }
            if(i != min_idx){
                ++swaps;
                Store temp = storeList.get(i);
                storeList.set(i, storeList.get(min_idx));
                storeList.set(min_idx, temp);
            }
        }
        long end = (nanoTime() - start);
        for (Store student: storeList) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Comparitions = " + comparitions);
        System.out.println("Swaps = " + swaps);
        System.out.println("Execution time \u2248 " + end/Math.pow(10, 9) + " seconds");
    }

    public static void shellSort(ArrayList<Store> storeList){
        long start = nanoTime();
        int comparitions = 0;
        int swaps = 0;
        for (int i = storeList.size() / 2; i > 0; i /= 2) {
            for (int j = i; j < storeList.size(); j++) {
                Store temp = storeList.get(j);
                int g;
                ++comparitions;
                for (g = i; g >= i && storeList.get(g - i).compareTo(temp) > 0 ; g -= i) {
                    ++swaps;
                    storeList.set(j, storeList.get(g - i));
                }
                ++swaps;
                storeList.set(g, temp);
            }
        }
        long end = (nanoTime() - start);
        for (Store store: storeList) {
            System.out.println(store);
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Comparitions = " + comparitions);
        System.out.println("Swaps = " + swaps);
        System.out.println("Execution time \u2248 " + end/Math.pow(10, 9) + " seconds");
    }
}
