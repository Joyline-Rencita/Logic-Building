import java.util.Arrays;

class Test {
    static int[] removeOccurrences(int[] arr, int elem) {
        // Step 1: Count the number of occurrences of the specified element
        int count = 0;
        for (int num : arr) {
            if (num == elem) {
                count++;
            }
        } 
        // Step 2: Create a new array excluding the specified element
        int[] newArr = new int[arr.length - count];
        int index = 0;
        for (int num : arr) {
            if (num != elem) {
                newArr[index++] = num;
            }
        }  
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        int elem = 2; // Element to be removed
        int[] newArr = removeOccurrences(arr, elem);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Array after removing " + elem + ": " + Arrays.toString(newArr));
    }
    
}
