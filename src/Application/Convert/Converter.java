package Application.Convert;

import Application.Pages.ConvertResultPage;
import Application.Pages.ShowHistoryPage;
import Memory.Stack;

import java.util.Arrays;
import java.util.Locale;

public class Converter {
    private static int[] historyOfConvert = {0, 0, 0, 0, 0, 0};

    public Converter(int type, String input) {
        switch (type) {
            case 0:
                InfixToPostfix(input);
                return;

            case 1:
                PostfixToInfix(input);
                return;

            case 2:
                InfixToPrefix(input);
                return;

            case 3:
                PrefixToInfix(input);
                return;

            case 4:
                PrefixToPostfix(input);
                return;

            case 5:
                PostfixToPrefix(input);
                return;
            case 6:
                ShowHistory(input);
                return;
        }
    }

    //this method check the priority of operators ------------------------------------------------
    public static int Priority(String ch) {
        switch (ch.toLowerCase(Locale.ROOT)) {
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
        return 0;
    }


    //this method Print each series of steps ------------------------------------------------
    private static String Print(int i, Stack operators, String output, String convertStep) {
        convertStep += "(" + (i + 1) + ")" + "\n\nRPN:\n" + output;
        convertStep += "\n\nOperator operators:\n" + operators.toString();
        convertStep += "\n\n**************************************************************************\n\n";
        return convertStep;
    }

    private static String Print(int i, Stack operators, Stack output, String convertStep) {
        convertStep += "(" + (i + 1) + ")" + "\n\nRPN:\n" + output.toString();
        convertStep += "\n\nOperator operators:\n" + operators.toString();
        convertStep += "\n\n**************************************************************************\n\n";
        return convertStep;
    }

    private static String Print(int i, Stack output, String convertStep) {
        convertStep += "(" + (i + 1) + ")" + "\n\n" + output.toString();
        convertStep += "\n\n**************************************************************************\n\n";
        return convertStep;
    }

    //Converts Methods ------------------------------------------------
    public static String InfixToPostfix(String infix) {
        infix = infix.trim();
        String output = "";
        var operators = new Stack();
        String convertStep = "";
        String[] input = infix.split(" ");

        //check the input
        int count1 = 0, count2 = 0;
        String pattern1 = "[+*/^]{1}";
        String pattern2 = "[+*-/^]{1}";
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("("))
                count1++;
            else if (input[i].equals(")"))
                count2++;
            if (input[i].equals("(") && input[i + 1].matches(pattern1)) {
                ConvertResultPage.output.setText("The input infix expression is incorrect.\n");
                return null;
            }
            if (input[i].matches(pattern2) && input[i + 1].equals(")")) {
                ConvertResultPage.output.setText("The input infix expression is incorrect.\n");
                return null;
            }
        }
        if (count2 != count1) {
            ConvertResultPage.output.setText("The input infix expression is incorrect.\n" +
                    "There is a problem with parentheses.");
            return null;
        }


        for (int i = 0; i < input.length; i++) {
            String ch = input[i];

            //if character of infix is letter or digit push it to output
            String CheckDigitOrLetterPattern = "[\\d]*[a-zA-Z]?";
            if (ch.matches(CheckDigitOrLetterPattern)) {
                output += ch;
                output += " ";
            }

            //if character of infix is '(', push it to operators
            else if (ch.equals("("))
                operators.push(ch);

            else if (ch.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output += operators.pop();
                    output += " ";
                }
                //finally pop '(' in operators
                operators.pop();
            }
            //if character of infix is an operator
            else {
                while (!operators.isEmpty() && Priority(ch) <= Priority(operators.peek())) {
                    if (ch.equals("^") && operators.peek().equals("^")) {
                        String str = "";
                        i++;
                        str += input[i];
                        str += " ";
                        str += operators.pop();
                        str += " ";
                        output += str;
                        output += " ";
                    } else {
                        output += operators.pop();
                        output += " ";
                    }
                }

                //finally push the new operator of infix in operators
                operators.push(ch);
            }

            //Print each series of steps
            convertStep = Print(i, operators, output, convertStep);
        }

        //Finally, check the input expression is correct
        // and move the operators from the operators to the output
        while (!operators.isEmpty()) {
            if (operators.peek() == "(") {
                ConvertResultPage.output.clear();
                ConvertResultPage.result.clear();
                ConvertResultPage.output.setText("The input infix statement is invalid");
                return null;
            }
            output += operators.pop();
            output += " ";
        }
        historyOfConvert[0]++;
        ConvertResultPage.output.setText(convertStep);
        ConvertResultPage.result.setText(output.toString());
        return output.toString();
    }

    public static String PostfixToInfix(String postfix) {
        postfix = postfix.trim();
        var output = new Stack();
        String convertStep = "";
        String[] input = postfix.split(" ");

        //check the input
        String pattern1 = "[+*-/^]{1}";
        if (input[0].matches(pattern1) || !input[input.length - 1].matches(pattern1)) {
            ConvertResultPage.output.setText("The input postfix expression is incorrect.\n");
            return null;
        }

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
            convertStep = Print(i, output, convertStep);

        }

        historyOfConvert[1]++;
        ConvertResultPage.output.setText(convertStep);
        ConvertResultPage.result.setText(output.toString());
        return output.toString();
    }

    public static String InfixToPrefix(String infix) {
        infix = infix.trim();
        String convertStep = "";
        String[] InfixArray = infix.split(" ");
        String[] ReverseInfixArray = new String[InfixArray.length];

        //check the input
        int count1 = 0, count2 = 0;
        String pattern1 = "[+*/^]{1}";
        String pattern2 = "[+*-/^]{1}";
        for (int i = 0; i < InfixArray.length; i++) {
            if (InfixArray[i].equals("("))
                count1++;
            else if (InfixArray[i].equals(")"))
                count2++;
            if (InfixArray[i].equals("(") && InfixArray[i + 1].matches(pattern1)) {
                ConvertResultPage.output.setText("The input infix expression is incorrect.\n");
                return null;
            }
            if (InfixArray[i].matches(pattern2) && InfixArray[i + 1].equals(")")) {
                ConvertResultPage.output.setText("The input infix expression is incorrect.\n");
                return null;
            }
        }
        if (count2 != count1) {
            ConvertResultPage.output.setText("The input infix expression is incorrect.\n" +
                    "There is a problem with parentheses.");
            return null;
        }

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

            convertStep = Print(i, operators, output, convertStep);
        }

        //Finally, check the input expression is correct
        // and move the operators from the operators to the output
        while (!operators.isEmpty()) {
            if (operators.peek() == "(") {
                ConvertResultPage.output.clear();
                ConvertResultPage.output.setText("The input infix statement is invalid");
                return null;
            }
            output.push(operators.pop());
        }

        String[] OutputArray = String.valueOf(output).split(" ");
        String[] ReverseOutputArray = new String[OutputArray.length];

        for (int i = 0; i < OutputArray.length; i++)
            ReverseOutputArray[i] = OutputArray[OutputArray.length - i - 1];

        String OutputPostfix = Arrays.toString(ReverseOutputArray).replace(",", "")
                .replace("[", "").replace("]", "").trim();
        historyOfConvert[2]++;
        ConvertResultPage.output.setText(convertStep);
        ConvertResultPage.result.setText(OutputPostfix);
        return OutputPostfix;
    }

    public static String PrefixToInfix(String prefix) {
        prefix = prefix.trim();
        String convertStep = "";
        var output = new Stack();
        String[] input = prefix.split(" ");
        String operatorRegex = "[+*-/^]{1}";

        //check the input
        if (!input[0].matches(operatorRegex) || input[input.length - 1].matches(operatorRegex)) {
            ConvertResultPage.output.setText("The input prefix expression is incorrect.\n");
            return null;
        }

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

            convertStep = Print(input.length - i - 1, output, convertStep);
        }

        historyOfConvert[3]++;
        ConvertResultPage.output.setText(convertStep);
        ConvertResultPage.result.setText(output.toString());
        return output.toString();
    }

    public static String PrefixToPostfix(String prefix) {
        prefix = prefix.trim();
        String convertStep = new String("");
        var output = new Stack();
        String[] input = prefix.split(" ");
        String operatorRegex = "[-^+*/]?";
        //check the input
        if (!input[0].matches(operatorRegex) || input[input.length - 1].matches(operatorRegex)) {
            ConvertResultPage.output.setText("The input prefix expression is incorrect.\n");
            return null;
        }


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

            convertStep = Print(input.length - i - 1, output, convertStep);
        }
        historyOfConvert[4]++;
        ConvertResultPage.output.setText(convertStep);
        ConvertResultPage.result.setText(output.toString());
        return output.toString();
    }

    public static String PostfixToPrefix(String postfix) {
        postfix = postfix.trim();
        var output = new Stack();
        String convertStep = "";

        String[] input = postfix.split(" ");

        //check the input
        String operatorRegex = "[-^+*/]?";
        if (input[0].matches(operatorRegex) || !input[input.length - 1].matches(operatorRegex)) {
            ConvertResultPage.output.setText("The input postfix expression is incorrect.\n");
            return null;
        }

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


            convertStep = Print(i, output, convertStep);
        }

        historyOfConvert[5]++;
        ConvertResultPage.output.setText(convertStep);
        ConvertResultPage.result.setText(output.toString());
        return output.toString();
    }

    // Show History Method  ------------------------------------------------
    public void ShowHistory(String number) {
        int[] array2 = new int[6];
        for (int i = 0; i < 6; i++)
            array2[i] = historyOfConvert[i];
        String str = "";
        int count = 0;
        for (int i = 0; i < 6; i++)
            if (array2[i] == 0)
                count++;
        count = 6 - count;

        if (number.equals("1")) {
            for (int i = 0; i < count; i++) {
                int index = 0, max = 0;
                for (int j = 0; j < 6; j++) {
                    if (array2[j] > max) {
                        max = array2[j];
                        index = j;
                    }
                }
                array2[index] = -1;
                switch (index) {
                    case 0:
                        str += max + " : " + "Infix to Postfix\n";
                        continue;

                    case 1:
                        str += max + " : " + "Postfix to Infix\n";
                        continue;

                    case 2:
                        str += max + " : " + "Infix to Prefix\n";
                        continue;

                    case 3:
                        str += max + " : " + "Prefix to Infix\n";
                        continue;

                    case 4:
                        str += max + " : " + "Prefix to Postfix\n";
                        continue;

                    case 5:
                        str += max + " : " + "Postfix to Prefix\n";
                        continue;
                }
            }
            ShowHistoryPage.showHistory.setText(str);

        } else if (number.equals("2")) {
            for (int i = 0; i < count; i++) {
                int index = 0, min = 10000;
                for (int j = 0; j < 6; j++) {
                    if (array2[j] == 0)
                        continue;
                    if (array2[j] < min) {
                        min = array2[j];
                        index = j;
                    }
                }
                array2[index] = 10000;
                switch (index) {
                    case 0:
                        str += min + " : " + "Infix to Postfix\n";
                        continue;

                    case 1:
                        str += min + " : " + "Postfix to Infix\n";
                        continue;

                    case 2:
                        str += min + " : " + "Infix to Prefix\n";
                        continue;

                    case 3:
                        str += min + " : " + "Prefix to Infix\n";
                        continue;

                    case 4:
                        str += min + " : " + "Prefix to Postfix\n";
                        continue;

                    case 5:
                        str += min + " : " + "Postfix to Prefix\n";
                        continue;
                }
            }
            ShowHistoryPage.showHistory.setText(str);
        }
    }
}
