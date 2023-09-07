package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MergeSort {
    void merge(int array[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    // fill the left and right array
    for (int i = 0; i < n1; i++)
      L[i] = array[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = array[q + 1 + j];

    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    // for sorting in descending
    // use if(L[i] >= <[j])
    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = M[j];
        j++;
      }
      k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = M[j];
      j++;
      k++;
    }
  }

  // Divide the array into two sub arrays, sort them and merge them
  void mergeSort(int array[], int left, int right) {
    if (left < right) {

      // m is the point where the array is divided into two sub arrays
      int mid = (left + right) / 2;

      // recursive call to each sub arrays
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      // Merge the sorted sub arrays
      merge(array, left, mid, right);
    }
  }
    


    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    
         MergeSort ob = new MergeSort();
         ob.mergeSort(arr, 0, arr.length -1);
        
        testSort(arr);
    }

    public static void testSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("FAIL at index "+i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }

}