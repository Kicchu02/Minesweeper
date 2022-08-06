package com.kickass;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int numberOfTrailingZeroesInFactorial(int num) {
        int numberOfFactorsOf2 = 0, numberOfFactorsOf5 = 0;
        
        while (num != 1) {
            int n = num;
    
            while (n % 10 == 0) {
                n /= 10;
                numberOfFactorsOf2++;
                numberOfFactorsOf5++;
            }
    
            while (n % 2 == 0) {
                n /= 2;
                numberOfFactorsOf2++;
    
                while (n % 10 == 0) {
                    n /= 10;
                    numberOfFactorsOf2++;
                    numberOfFactorsOf5++;
                }
            }
    
            while (n % 5 == 0) {
                n /= 5;
                numberOfFactorsOf5++;
    
                while (n % 10 == 0) {
                    n /= 10;
                    numberOfFactorsOf2++;
                    numberOfFactorsOf5++;
                }
            }
            
            num--;
        }
        
        return Math.min(numberOfFactorsOf2, numberOfFactorsOf5);
    }
    
    private static boolean contains(int[] arr, int key) {
//        for (int i :
//                arr) {
//            if (i == key)
//                return true;
//        }
//
//        return false;
        
        int beg = 0, end = arr.length - 1;
        int mid = (beg + end) / 2;
        
        while (beg <= end) {
            if (arr[mid] == key)
                return true;
            else if (arr[mid] < key) {
                end = mid - 1;
                mid = (beg + end) / 2;
            } else {
                beg = mid + 1;
                mid = (beg + end) / 2;
            }
        }
        
        return false;
    }
    
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] <= arr[j + 1])
                    continue;
                
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
    }
    
    private static void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;
        
        int halfLength = arr.length / 2;
        
        int[] left = Arrays.copyOf(arr, halfLength);
        int[] right = Arrays.copyOfRange(arr, halfLength, arr.length);
        
        mergeSort(left);
        mergeSort(right);
        
        int leftIndex = 0, rightIndex = 0, mainIndex = 0;
        
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[mainIndex++] = left[leftIndex++];
            } else {
                arr[mainIndex++] = right[rightIndex++];
            }
        }
        
        while (leftIndex < left.length) {
            arr[mainIndex++] = left[leftIndex++];
        }
        
        while (rightIndex < right.length) {
            arr[mainIndex++] = right[rightIndex++];
        }
    }
    
    public static void main(String[] args) {
//        Random random = new Random();
//        int[] arr1 = new int[100000000];
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i] = random.nextInt();
//        }
//        int[] arr2 = arr1.clone();
//        //noinspection MismatchedReadAndWriteOfArray
//        int[] arr3 = arr1.clone();
//
//        long start, end;
////        System.out.println("Unsorted : " + Arrays.toString(arr));
//        start = System.currentTimeMillis();
//        mergeSort(arr1);
//        end = System.currentTimeMillis();
//        System.out.println("Merge Sort Executed in " + (end - start) + "ms");
//
//        start = System.currentTimeMillis();
//        Arrays.sort(arr3);
//        end = System.currentTimeMillis();
//        System.out.println("Java Sort Executed in " + (end - start) + "ms");
//
//        start = System.currentTimeMillis();
//        bubbleSort(arr2);
//        end = System.currentTimeMillis();
//        System.out.println("Bubble Sort Executed in " + (end - start) + "ms");
        
//        System.out.println("Sorted : " + Arrays.toString(arr2));
        long start, end;
        for (int i = (int) Math.pow(10, 9); i > 1; i /= 10) {
            start = System.currentTimeMillis();
            int numberToPrint = numberOfTrailingZeroesInFactorial(i);
            end = System.currentTimeMillis();
            System.out.println("Iteration " + i + " : " + numberToPrint + "\tExecution Time : " + (end - start) + "ms");
        }
    }
}
