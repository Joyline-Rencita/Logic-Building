class Main {
    public static int factorial(int n)
    {
        // Base case: if n is 0 or 1, return 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: if n is greater than 1,
        // call the function with n-1 and multiply by n
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args)
    {
        // Call the factorial function and print the result
        int result = factorial(5);
        System.out.println(result); // Output: 120
    }
}
