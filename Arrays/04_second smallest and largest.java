import java.io.*;
class Test
{
    static private int secondSmallest(int[] arr, int n)
    {
        if (n < 2)
        {
            return -1;
        }
        int small = arr[0];
        int second_small = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] < small)
            {
                second_small = small;
                small = arr[i];
            }
            else if (arr[i] < second_small && arr[i] != small)
            {
                second_small = arr[i];
            }
        }
        return second_small == small ? -1 : second_small;
    }

    static private int secondLargest(int[] arr, int n)
    {
        if (n < 2)
        {
            return -1;
        }
        int large = arr[0];
        int second_large = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > large)
            {
                second_large = large;
                large = arr[i];
            }
            else if (arr[i] > second_large && arr[i] != large)
            {
                second_large = arr[i];
            }
        }
        return second_large == large ? -1 : second_large;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 7, 7, 5};
        int n = arr.length;
        int sS = secondSmallest(arr, n);
        int sL = secondLargest(arr, n);
        System.out.println("Second smallest is " + sS);
        System.out.println("Second largest is " + sL);
    }
}
