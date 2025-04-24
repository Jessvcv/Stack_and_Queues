import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate through the string using a for loop with index
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                // If the stack is empty, return "NO"
                if (stack.isEmpty()) {
                    return "NO"; // No opening bracket to match
                }

                // Pop from the stack and check if it matches the closing bracket
                char top = stack.pop(); // Pop the last element
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return "NO"; // Mismatched brackets
                }
            }
        }

        // If the stack is empty, all brackets matched, return "YES"
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // Array of test cases to check
        String[] testCases = {"{[()]}", "{[(])}", "{{[[(())]]}}"};

        // Loop through the test cases using a for loop
        for (int i = 0; i < testCases.length; i++) {
            // Output the result of the isBalanced method for each test case
            System.out.println(isBalanced(testCases[i]));
        }
    }
}
