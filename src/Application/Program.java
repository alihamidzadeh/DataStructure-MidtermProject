package Application;

import javafx.application.Application;
public class Program {
    public static void main(String[] args) {
        Application.launch(Graphics.class, args);
    }

//    public static void main(String[] args) {
////        String exp1 = null;
//        Scanner sc = new Scanner(System.in);
//
////
////        //Todo test for (Infix To Postfix) && (Infix To Prefix)
////        exp1 = "A / B - C + D * E - A * C";
////        exp1 = "( A / ( B - C + D ) ) * ( E - A ) * C";
////        exp1 = "10 + 3 * 5 / ( 16 - 4 )";
////        exp1 = "u + ( w / z ) * y + x";
////        exp1 = "x + y * z / w + u";
////        exp1 = "( a * b ) + c";
////        exp1 = "sin ( x + y ) * z";
////        exp1 = "Tan ( x + y ) * z";
////        exp1 = "sin ( a + b ) * 10";
////
//////        exp1 = sc.nextLine();
//////        System.out.println("******************************************************");
//////        System.out.println("Output is:\n" + InfixToPostfix(exp1));
//////        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + InfixToPrefix(exp1));
////
////        //Todo test for (Postfix To Infix) && (Postfix To Prefix)
////        exp1 = "A B / C - D E * + A C * -";
////        exp1 = "A B C - D + / E A - * C *";
////        exp1 = "10 3 5 * 16 4 - / +";
////        exp1 = "u w z / y * + x +";
////        exp1 = "x y z * w / + u +";
////        exp1 = "a b * c +";
////        exp1 = "x y + sin z *";
////        exp1 = "x y + Tan z *";
////        exp1 = "a b + sin 10 *";
////
//////                exp1 = sc.nextLine();
//////        System.out.println("******************************************************");
//////        System.out.println("Output is:\n" + PostfixToInfix(exp1));
//////        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + PostfixToPrefix(exp1));
////
////        //Todo test for (Prefix To Infix) && (Prefix To Postix)
////        exp1 = "- + - / A B C * D E * A C";
////        exp1 = "* * / A + - B C D - E A C";
////        exp1 = "+ 10 / * 3 5 - 16 4";
////        exp1 = "+ + u * / w z y x";
////        exp1 = "+ + x / * y z w u";
////        exp1 = "+ * a b c";
////        exp1 = "* sin + x y z";
////        exp1 = "* Tan + x y z";
////        exp1 = "* sin + a b 10";
////        exp1 = sc.nextLine();
//////        System.out.println("******************************************************");
//////        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + PrefixToInfix(exp1));
//////        System.out.println("Input is:\n     " + exp1 + "\nOutput is:\n" + PrefixToPostfix(exp1));
////
//        while (true) {
//            System.out.println("Enter type of convert do you want to do:");
//            int type = sc.nextInt();
//            sc.nextLine();
//            String input = null;
//            if (type != 6) {
//                System.out.println("Enter Input String:");
//                input = sc.nextLine();
//            }
//            Converter converter = new Converter(type, input);
//
//            System.out.println("\n-------------------------------------------------------------------------");
//        }
//    }


    //***************************************************************************************


}
