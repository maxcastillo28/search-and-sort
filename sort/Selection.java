package sort;

import java.util.Arrays;

/**
 * Write a description of class Quick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selection
{

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr) {
        int least = arr[0];
        int temp;
        int pos = 0;
        for (int i = 0; i < arr.length; i++){
            least = arr[i];
            for (int j = i; j < arr.length; j++){
                
                if (arr[j] < least){
                    least = arr[j];
                    pos = j;
                }
            }
            temp = least;
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr));
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
