// JavaProgram to convert prefix to postfix

import java.util.*;

class GFG {

    // function to check if character
    // is operator or not
    static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    static String preToPost(String input) {

        Stack<String> s = new Stack<String>();

        int length = input.length();

        for (int i = length - 1; i >= 0; i--) {
            if (isOperator(input.charAt(i))) {
                String op1 = s.pop();
                String op2 = s.pop();
                s.push(op1 + " " + op2 + " " + input.charAt(i));
            }

            else
                s.push(input.charAt(i)+"");
        }

        // stack contains only the Postfix expression
        return s.peek();
    }

    // Driver Code
    public static void main(String args[]) {
        String input = "*-A/BC-/AKL";
        input = "-+-/ABC*DE*AC";
        System.out.println("Postfix : "
                + preToPost(input));
    }
}

// This code is contributed by Arnab Kundu
