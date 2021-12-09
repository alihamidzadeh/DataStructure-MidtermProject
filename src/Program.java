import java.util.*;
import java.util.Stack;

public class Program {


    public static void main(String[] args) {
        String exp1 = null;
        Scanner sc = new Scanner(System.in);


        //Todo test for (Infix To Postfix) && (Infix To Prefix)
        exp1 = "A / B - C + D * E - A * C";
        exp1 = "( A / ( B - C + D ) ) * ( E - A ) * C";
        exp1 = "10 + 3 * 5 / ( 16 - 4 )";
        exp1 = "u + ( w / z ) * y + x";
        exp1 = "x + y * z / w + u";
        exp1 = "( a * b ) + c";
        exp1 = "sin ( x + y ) * z";
        exp1 = "Tan ( x + y ) * z";
        exp1 = "sin ( a + b ) * 10";


//        exp1 = sc.nextLine();
//        System.out.println("******************************************************");
//        System.out.println("Output is:\n" + InfixToPostfix(exp1));
//        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + InfixToPrefix(exp1));

        //Todo test for (Postfix To Infix) && (Postfix To Prefix)
        exp1 = "A B / C - D E * + A C * -";
        exp1 = "A B C - D + / E A - * C *";
        exp1 = "10 3 5 * 16 4 - / +";
        exp1 = "u w z / y * + x +";
        exp1 = "x y z * w / + u +";
        exp1 = "a b * c +";
        exp1 = "x y + sin z *";
        exp1 = "x y + Tan z *";
        exp1 = "a b + sin 10 *";

        //        exp1 = sc.nextLine();
//        System.out.println("******************************************************");
//        System.out.println("Output is:\n" + PostfixToInfix(exp1));
//        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + PostfixToPrefix(exp1));

        //Todo test for (Prefix To Infix) && (Prefix To Postix)
        exp1 = "- + - / A B C * D E * A C";
        exp1 = "* * / A + - B C D - E A C";
        exp1 = "+ 10 / * 3 5 - 16 4";
        exp1 = "+ + u * / w z y x";
        exp1 = "+ + x / * y z w u";
        exp1 = "+ * a b c";
        exp1 = "* sin + x y z";
        exp1 = "* Tan + x y z";
        exp1 = "* sin + a b 10";

        //        exp1 = sc.nextLine();
        System.out.println("******************************************************");
//        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + PrefixToInfix(exp1));
        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + PrefixToPostfix(exp1));

    }

    //this method check the priority of operators
    public static int Priority(String ch) {
        switch (ch.toLowerCase()) {
            case "sin":
            case "cos":
            case "tan":
            case "cot":
                return 5;
            case "^":
                return 4;
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 2;
        }
        return -1;
    }

    //this method Print each series of steps
    private static void Print(int i, Stack<String> operators, Stack<String> output) {
        System.out.println("(" + (i + 1) + ")" + "\nRPN:\n" + output.toString());
        System.out.println("Operator operators:\n" + operators.toString());
        System.out.println("******************************************************\n");

    }

    private static void Print(int i, Stack<String> output) {
        System.out.println("(" + (i + 1) + ")" + "\n" + output.toString());
        System.out.println("******************************************************\n");
    }

    public static String InfixToPostfix(String infix) {
        infix = infix.trim();
        Stack<String> output = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] input = infix.split(" ");
        System.out.println("Infix Expression:\n" + infix + "\n");

        for (int i = 0; i < input.length; i++) {
            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]?";
            if (ch.matches(CheckDigitOrLetterPattern))
                output.push(ch);

                //if character of infix is '(', push it to operators
            else if (ch.equals("("))
                operators.push(ch);

            else if (ch.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("("))
                    output.push(operators.pop());
                //finally pop '(' in operators
                operators.pop();
            }
            //if character of infix is an operator
            else {
                while (!operators.isEmpty() && Priority(ch) <= Priority(operators.peek()))
                    output.push(operators.pop());

                //finally push the new operator of infix in operators
                operators.push(ch);
            }

            //Print each series of steps
            Print(i, operators, output);
        }

        //Finally, check the input expression is correct
        // and move the operators from the operators to the output
        while (!operators.isEmpty()) {
            if (operators.peek() == "(")
                return "The input infix statement is invalid";
            output.push(operators.pop());
        }

        String str = new String("");
        for (String ch : output) {
            str += ch;
            str += " ";
        }
        return output.toString() + " => " + str.trim();
    }

    public static String PostfixToInfix(String postfix) {
        postfix = postfix.trim();
        Stack<String> output = new Stack<>();
        String[] input = postfix.split(" ");
        System.out.println("Postfix Expression:\n" + postfix + "\n");

        for (int i = 0; i < input.length; i++) {
            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]?";
            if (ch.matches(CheckDigitOrLetterPattern))
                output.push(ch);
            else if (ch.equalsIgnoreCase("sin") || ch.equalsIgnoreCase("cos")
                    || ch.equalsIgnoreCase("tan") || ch.equalsIgnoreCase("cot")) {
                String a = output.pop();
                output.push(ch + "(" + a + ")");
            } else {  //if character of infix is operator,
                // add it between the last two elements of the stack
                String b = output.pop();
                String a = output.pop();
                if (output.size() == 0)
                    output.push(a + ch + b);
                else
                    output.push("(" + a + ch + b + ")");
            }
            //Print each series of steps
            Print(i, output);

        }
        String str = new String("");
        for (String ch : output) {
            str += ch;
            str += " ";
        }
        return output.toString() + " => " + str.trim();
    }

    public static String InfixToPrefix(String infix) {
        infix = infix.trim();
        System.out.println("Infix Expression:\n" + infix + "\n");

        String[] InfixArray = infix.split(" ");
        String[] ReverseInfixArray = new String[InfixArray.length];
        for (int i = 0; i < InfixArray.length; i++) {
            ReverseInfixArray[i] = InfixArray[InfixArray.length - i - 1];
        }
        infix = Arrays.toString(ReverseInfixArray).replace(",", "")
                .replace("[", "").replace("]", "");
        Stack<String> output = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] input = infix.split(" ");

        for (int i = 0; i < input.length; i++) {

            if (input[i].equals("("))
                input[i] = ")";
            else if (input[i].equals(")"))
                input[i] = "(";

            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]?";
            if (ch.matches(CheckDigitOrLetterPattern))
                output.push(ch);

                //if character of infix is '(', push it to operators
            else if (ch.equals("("))
                operators.push(ch);

            else if (ch.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("("))
                    output.push(operators.pop());
                //finally pop '(' in operators
                operators.pop();
            }
            //if character of infix is an operator
            else {
                if (!operators.isEmpty() && Priority(ch) < Priority(operators.peek()))
                    while (!operators.isEmpty() && Priority(ch) < Priority(operators.peek()))
                        output.push(operators.pop());
                else if (!operators.isEmpty() && Priority(ch) == Priority(operators.peek())) {
                    operators.push(ch);
                    continue;
                }

                //finally push the new operator of infix in operators
                operators.push(ch);
            }

            //Print each series of steps
            Print(i, operators, output);
        }

        //Finally, check the input expression is correct
        // and move the operators from the operators to the output
        while (!operators.isEmpty()) {
            if (operators.peek() == "(")
                return "The input infix statement is invalid";
            output.push(operators.pop());
        }

        String[] OutputArray = String.valueOf(output).split(" ");
        String[] ReverseOutputArray = new String[OutputArray.length];

        for (int i = 0; i < OutputArray.length; i++)
            ReverseOutputArray[i] = OutputArray[OutputArray.length - i - 1];

        String OutputPostfix = Arrays.toString(ReverseOutputArray).replace(",", "")
                .replace("[", "").replace("]", "").trim();
        return output.toString() + " => " + OutputPostfix;
    }

    public static String PrefixToInfix(String prefix) {
        prefix = prefix.trim();
        System.out.println("prefix Expression:\n" + prefix + "\n");
        Stack<String> output = new Stack<>();
        String[] input = prefix.split(" ");
        String operatorRegex = "[-+*/]?";

        for (int i = input.length - 1; i >= 0; i--) {
            String ch = input[i];
            if (ch.matches(operatorRegex)) {
                String a = output.pop();
                String b = output.pop();
                output.push("(" + a + " " + ch + " " + b + ")");
            } else
                output.push(ch);

            Print(input.length - i - 1, output);
        }

        String str = new String("");
        for (String ch : output) {
            str += ch;
            str += " ";
        }
        return output.toString() + " => " + str.trim();
    }

    public static String PrefixToPostfix(String prefix) {
        prefix = prefix.trim();
        System.out.println("prefix Expression:\n" + prefix + "\n");
        Stack<String> output = new Stack<>();
        String[] input = prefix.split(" ");
        String operatorRegex = "[-+*/]?";
        String TrigonometricFunctionsRegex = "[";
        for (int i = input.length - 1; i >= 0; i--) {
            String ch = input[i];
            if (ch.matches(operatorRegex)) {
                String a = output.pop();
                String b = output.pop();
                output.push(a + " " + b + " " + ch);
            } else if (ch.equalsIgnoreCase("sin") || ch.equalsIgnoreCase("cos")
                    || ch.equalsIgnoreCase("tan") || ch.equalsIgnoreCase("cot")) {
                String a = output.pop();
                output.push(a + " " + ch);
            } else
                output.push(ch);

            Print(input.length - i - 1, output);
        }
        String str = new String("");
        for (String ch : output) {
            str += ch;
            str += " ";
        }
        return output.toString() + " => " + str.trim();
    }

    //***************************************************************************************

    public static String PostfixToPrefix(String postfix) {
        String str = null;


        return str;
    }

    public static String ShowHistory() {
        String str = null;


        return str;
    }
}
