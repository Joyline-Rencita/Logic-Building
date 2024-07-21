public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        
        // Print the result array
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        
        // Initialize the first element of ans to 1 because there are no elements to the left of the first element
        ans[0] = 1;
        
        // Calculate the left products for each element
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        // Initialize right product to 1 because there are no elements to the right of the last element
        int right = 1;
        
        // Calculate the right products and multiply with the left products
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        
        return ans;
    }
}
