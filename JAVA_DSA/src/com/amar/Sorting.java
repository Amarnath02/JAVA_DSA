import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {29, 22, 33, 12, 21};
        int[] arr1 = {5, 4, 3, 2, 1};
        Insertion(arr);
        Cyclic(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
    
    // Bubble Sort
    
    static void Bubble(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }
    
    // Selection Sort
    
    static void Selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int max = getMax(arr, 0, last);
            swap(arr, max, last);
        }
    }
    
    // Insertion Sort
    
    static void Insertion(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    swap(arr, j , j-1);
                }
                else {
                    break;
                }
            }
        }
    }
    
    // Cyclic Sort
    
    static void Cyclic(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else {
                i++;
            }
        }
    }
    
    static int getMax(int[] arr, int start, int last){
        int max = start;
        for (int i = start; i <= last; i++) {
            if (arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
    
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
