public class ExpressionEvaluator {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
          // Stack to hold operands
        Stack<Integer> stack = new Stack<>(); 

        // Iterate over each character in the postfix expression
        for (char token : expression.toCharArray()) {
            // If the character is a digit, push it to the stack
            if (Character.isDigit(token)) {
                stack.push(token - '0');
            } else {
                // If the character is an operator,
                  // pop two operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                  // Perform the operation and push
                  // The result back to the stack
                switch (token) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        // The result of the expression is the last element in the stack
        return stack.pop();
    }

    // Method to convert an infix expression to a postfix expression
    public static String infixToPostfix(String expression) {
      
          // String to hold the postfix expression
        StringBuilder result = new StringBuilder(); 
      
          // Stack to hold operators and parentheses
        Stack<Character> stack = new Stack<>(); 

        // Iterate over each character in the infix expression
        for (char token : expression.toCharArray()) {
            // If the character is an operand, append it to the result
            if (Character.isLetterOrDigit(token)) {
                result.append(token);
            } else if (token == '(') {
              
                // If the character is '(', push it to the stack
                stack.push(token);
            } else if (token == ')') {
                
                  // If the character is ')', pop and
                  // append from the stack until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove the '(' from the stack
            } else {
                // If the character is an operator, pop and append from the stack while
                // the precedence of the operator is less than or equal to the precedence
                // of the operator at the top of the stack
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                  
                  // Push the current operator to the stack
                stack.push(token); 
            }
        }

        // Pop all remaining operators from the stack and append to the result
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1; // Precedence of + and - is 1
            case '*':
            case '/':
                return 2; // Precedence of * and / is 2
        }
        return -1; // Default precedence (should not be reached)
    }
    public static void main(String[] args) {
        String infix = "2+(3*5)";
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Evaluated Result: " + evaluatePostfix(postfix));
    }
}
