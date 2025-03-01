import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // Build multi-digit numbers
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef"};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println(decodeString(testCases[i]));
        }
    }
}
