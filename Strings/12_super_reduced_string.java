public class Solution {

    private static String super_reduced_string(String s) {
        Stack<Character> stack = new Stack<>(); // Initialize a stack to store characters
        for (char ch : s.toCharArray()) {       // Loop through each character in the string
            if (!stack.isEmpty() && stack.peek() == ch)  // If the stack is not empty and the top character matches current
                stack.pop();  // Remove the top character (eliminate the pair)
            else
                stack.push(ch);  // Otherwise, add the current character to the stack
        }

        if (stack.isEmpty())  // If the stack is empty after processing, return "Empty String"
            return "Empty String";
        else {
            StringBuilder sb = new StringBuilder();  // Otherwise, create a new string by popping elements from the stack
            while (!stack.isEmpty()) {
                sb.append(stack.pop());  // Pop characters from the stack and append to the string builder
            }
            return sb.reverse().toString();  // Reverse the string builder to get the correct order and return it
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Input scanner
        String s = in.next();  // Read the input string
        String result = super_reduced_string(s);  // Call the function to reduce the string
        System.out.println(result);  // Print the result
    }
}
