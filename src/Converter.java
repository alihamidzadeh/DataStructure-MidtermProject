import Stack_Src.Stack;
import java.util.Arrays;

public class Converter {
    private static int[] historyOfConvert = {0, 0, 0, 0, 0, 0};

    public Converter(int type, String input) {
        switch (type) {
            case 0:
//                InfixToPostfix(input);
                System.out.println("Output is:\n" + InfixToPostfix(input));
                return;

            case 1:
//                PostfixToInfix(input);
                System.out.println("Output is:\n" + PostfixToInfix(input));
                return;

            case 2:
//                InfixToPrefix(input);
                System.out.println("Input is:\n     " + input + "\nOutput is:\n" + InfixToPrefix(input));
                return;

            case 3:
//                PrefixToInfix(input);
                System.out.println("Input is:\n     " + input + "\nOutput is:\n" + PrefixToInfix(input));
                return;

            case 4:
//                PrefixToPostfix(input);
                System.out.println("Input is:\n     " + input + "\nOutput is:\n" + PrefixToPostfix(input));
                return;

            case 5:
//                PostfixToPrefix(input);
                System.out.println("Input is:\n     " + input + "\nOutput is:\n" + PostfixToPrefix(input));
                return;
            case 6:
                System.out.println("History:\n");
                ShowHistory(1);
                return;
        }
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
    private static void Print(int i, Stack operators, Stack output) {
        System.out.println("(" + (i + 1) + ")" + "\nRPN:\n" + output.toString());
        System.out.println("Operator operators:\n" + operators.toString());
        System.out.println("******************************************************\n");

    }

    private static void Print(int i, Stack output) {
        System.out.println("(" + (i + 1) + ")" + "\n" + output.toString());
        System.out.println("******************************************************\n");
    }


    //Converts Methods

    public static String InfixToPostfix(String infix) {

        infix = infix.trim();
        var output = new Stack();
        var operators = new Stack();
        String[] input = infix.split(" ");
        System.out.println("Infix Expression:\n" + infix + "\n");

        for (int i = 0; i < input.length; i++) {
            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]*";
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
                while (!operators.isEmpty() && Priority(ch) <= Priority((String) operators.peek()))
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
//        str += output.pop();
//        for (String ch : output) {
//            str += ch;
//            str += " ";
//        }
        while (!output.isEmpty()){
            str += output.pop();
            str += " ";
        }
        historyOfConvert[0]++;
        return output.toString() + " => " + str.trim();
    } //****

    public static String PostfixToInfix(String postfix) {
        postfix = postfix.trim();
        var output = new Stack();
        String[] input = postfix.split(" ");
        System.out.println("Postfix Expression:\n" + postfix + "\n");

        for (int i = 0; i < input.length; i++) {
            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]*";
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
//        for (String ch : output) {
//            str += ch;
//            str += " ";
//        }
        while (!output.isEmpty()){
            str += output.pop();
            str += " ";
        }
        historyOfConvert[1]++;
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
        var output = new Stack();
        var operators = new Stack();
        String[] input = infix.split(" ");

        for (int i = 0; i < input.length; i++) {

            if (input[i].equals("("))
                input[i] = ")";
            else if (input[i].equals(")"))
                input[i] = "(";

            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]*";
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
        historyOfConvert[2]++;
        return output.toString() + " => " + OutputPostfix;
    }

    public static String PrefixToInfix(String prefix) {
        prefix = prefix.trim();
        System.out.println("prefix Expression:\n" + prefix + "\n");
        var output = new Stack();
        String[] input = prefix.split(" ");
        String operatorRegex = "[-+*/]?";

        for (int i = input.length - 1; i >= 0; i--) {
            String ch = input[i];
            if (ch.matches(operatorRegex)) {
                String a = output.pop();
                String b = output.pop();
                output.push("(" + a + " " + ch + " " + b + ")");
            } else if (ch.equalsIgnoreCase("sin") || ch.equalsIgnoreCase("cos")
                    || ch.equalsIgnoreCase("tan") || ch.equalsIgnoreCase("cot")) {
                String a = output.pop();
                output.push(ch + " " + a);
            } else
                output.push(ch);

            Print(input.length - i - 1, output);
        }

        String str = new String("");
//        for (String ch : output) {
//            str += ch;
//            str += " ";
//        }
        while (!output.isEmpty()){
            str += output.pop();
            str += " ";
        }
        historyOfConvert[3]++;
        return output.toString() + " => " + str.trim();
    }

    public static String PrefixToPostfix(String prefix) {
        prefix = prefix.trim();
        System.out.println("prefix Expression:\n" + prefix + "\n");
        var output = new Stack();
        String[] input = prefix.split(" ");
        String operatorRegex = "[-+*/]?";
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
//        for (String ch : output) {
//            str += ch;
//            str += " ";
//        }
        while (!output.isEmpty()){
            str += output.pop();
            str += " ";
        }
        historyOfConvert[4]++;
        return output.toString() + " => " + str.trim();
    }

    public static String PostfixToPrefix(String postfix) {
        postfix = postfix.trim();
        System.out.println("postfix Expression:\n" + postfix + "\n");
        var output = new Stack();
        String[] input = postfix.split(" ");
        String operatorRegex = "[-+*/]?";

        for (int i = 0; i < input.length; i++) {
            String ch = input[i];
            if (ch.matches(operatorRegex)) {
                String b = output.pop();
                String a = output.pop();
                output.push(ch + " " + a + " " + b);
            } else if (ch.equalsIgnoreCase("sin") || ch.equalsIgnoreCase("cos") || ch.equalsIgnoreCase("tan") || ch.equalsIgnoreCase("cot")) {
                String a = output.pop();
                output.push(ch + " " + a);
            } else
                output.push(ch + "");


            Print(i, output);
        }

        String str = new String("");
//        for (String ch : output) {
//            str += ch;
//            str += " ";
//        }
        while (!output.isEmpty()){
            str += output.pop();
            str += " ";
        }
        historyOfConvert[5]++;
        return output.toString() + " => " + str.trim();
    }

    public static void ShowHistory(int number) {
        int[] array2 = historyOfConvert;

        if (number == 1){
            for (int j = 0; j < 6; j++) {
                int index = 0, max = 0;
                for (int i = 0; i < 6; i++) {
                    if (array2[i] > max) {
                        max = array2[i];
                        index = i;
                    }
                }
                array2[index] = -1;
                if (max == 0)
                    continue;
                switch (index) {
                    case 0:
                        System.out.println(max + " : " + "Infix to Postfix");
                        return;

                    case 1:
                        System.out.println(max + " : " + "Postfix to Infix");
                        return;

                    case 2:
                        System.out.println(max + " : " + "Infix to Prefix");
                        return;

                    case 3:
                        System.out.println(max + " : " + "Prefix to Infix");
                        return;

                    case 4:
                        System.out.println(max + " : " + "Prefix to Postfix");
                        return;

                    case 5:
                        System.out.println(max + " : " + "Postfix to Prefix");
                        return;
                }
            }
        }else {
            for (int j = 0; j < 6; j++) {
                int index = 0, min = 100000;
                for (int i = 0; i < 6; i++) {
                    if (array2[i] < min) {
                        min = array2[i];
                        index = i;
                    }
                }
                array2[index] = 100000;
                if (min == 0)
                    continue;
                switch (index) {
                    case 0:
                        System.out.println(min + " : " + "Infix to Postfix");
                        return;

                    case 1:
                        System.out.println(min + " : " + "Postfix to Infix");
                        return;

                    case 2:
                        System.out.println(min + " : " + "Infix to Prefix");
                        return;

                    case 3:
                        System.out.println(min + " : " + "Prefix to Infix");
                        return;

                    case 4:
                        System.out.println(min + " : " + "Prefix to Postfix");
                        return;

                    case 5:
                        System.out.println(min + " : " + "Postfix to Prefix");
                        return;
                }
            }
        }

    }
}
