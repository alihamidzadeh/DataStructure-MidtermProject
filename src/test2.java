import java.util.Arrays;
import java.util.Stack;

public class test2 {
    public static void main(String[] args) {
//        String regex = "[sincostancot]*";
//        String data = "x y + sin z *";
//        System.out.println(data.matches(regex));

        String str = new String("");
        Stack<String> stack = new Stack<>();
        stack.push("salam");
        stack.push("maman");
        stack.push("baba");
//        str = String.valueOf(stack);
        for (String ch : stack) {
            str += ch;
            str += " ";
        }
        System.out.println(str);

    }
}
