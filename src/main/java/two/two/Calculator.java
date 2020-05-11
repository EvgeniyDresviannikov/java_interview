package two.two;

import java.util.Stack;

public class Calculator {

    public static void main(String[] strings) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("2*(3+2*(1+2*(1+3)))"));
    }

    int calculate(String mathString) {
        String prepared = prepareMathString(mathString);
        return calc(expressionToRPN(prepared));
    }

    String prepareMathString(String mathString) {
        String prev = "";
        StringBuilder builder = new StringBuilder();

        if (mathString.charAt(0) == '-' && mathString.charAt(1) == '(') {
            mathString = mathString.substring(1, mathString.length());
            mathString = "(0-1)*" + mathString;
        }
        if (mathString.charAt(0) == '-') {
            mathString = "0" + mathString;
        }

        for (int i = 0; i < mathString.length(); i++) {
            if (prev.equals("(") && String.valueOf(mathString.charAt(i)).equals("-")) {
                builder.append("0");
            }
            builder.append(mathString.charAt(i));
            prev = String.valueOf(mathString.charAt(i));
        }

        return builder.toString();
    }

    String expressionToRPN(String expr) {
        StringBuilder builder = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char current = expr.charAt(i);
            if (getPriority(current) == 0) {
                builder.append(current);
            } else {
                appendSpace(builder);
                if (stack.isEmpty()) { stack.push(current); appendSpace(builder); continue; }

                if (getPriority(current) == -1) {
                    while (getPriority(stack.peek()) != 1) {
                        builder.append(stack.pop());
                        appendSpace(builder);
                    }
                    stack.pop();
                    appendSpace(builder);
                    continue;
                }

                if (getPriority(current) != 1) {
                while (!stack.isEmpty() && getPriority(stack.peek()) > getPriority(current)) {
                        builder.append(stack.pop());
                        appendSpace(builder);
                    }
                }
                appendSpace(builder);
                if (!stack.isEmpty() && String.valueOf(stack.peek()).equals("-") && current == '-') {
                    stack.push('+');
                } else {
                    stack.push(current);
                }
            }

        }

        appendSpace(builder);
        while (!stack.isEmpty()) {
            Character character = stack.pop();
            if (getPriority(character) != -1 && getPriority(character) != 1) {
                builder.append(character);
                appendSpace(builder);
            }
        }

        return builder.toString();
    }

    void appendSpace(StringBuilder builder) {
        if (builder.length() !=0 && !String.valueOf(builder.charAt(builder.length()-1)).equals(" ")) {
            builder.append(" ");
        }
    }

    int calc(String exprRPN) {
        Stack<String> stack = new Stack<>();
        String[] strings = exprRPN.split(" ");
        for (String string : strings) {
            if (string.equals("*") || string.equals("/") || string.equals("+") || string.equals("-")) {
                makeOperation(stack, string);
            } else {
                stack.push(string);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    void makeOperation(Stack<String> stack, String operation) {
        String b = stack.pop();
        String a = stack.pop();
        if (operation.equals("*")) {
            stack.push(String.valueOf(Integer.valueOf(a) * Integer.valueOf(b)));
        } else if (operation.equals("/")) {
            stack.push(String.valueOf(Integer.valueOf(a) / Integer.valueOf(b)));
        } else if (operation.equals("+")) {
            stack.push(String.valueOf(Math.addExact(Integer.valueOf(a), Integer.valueOf(b))));
        } else if (operation.equals("-")) {
            stack.push(String.valueOf(Math.subtractExact(Integer.valueOf(a), Integer.valueOf(b))));
        }
    }


    int getPriority(char symbol) {
        switch (Character.toString(symbol)) {
            case("*"): return 3;
            case("/"): return 3;
            case("+"): return 2;
            case("-"): return 2;
            case("("): return 1;
            case(")"): return -1;
            default: return 0;
        }
    }
}
