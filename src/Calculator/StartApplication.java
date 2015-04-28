package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Степан on 23.04.2015.
 */
public class StartApplication {
    public static void main(String[] args) {

        if (0 == args.length) {
            System.out.println("There is nothing to calculate");
            System.exit(0);
        }

        Calculator calc = new Calculator();
        Stack<String> stack = new Stack<>();
        List<Calculator.Command> list = new ArrayList<>();



        for (int i = 0; i < args.length - 1; i++) {
            stack.push(args[i]);
        }
        int value = 0;
        while (stack.size() != 1) {
            value = Integer.valueOf(stack.pop());
            if (stack.peek().equals("plus")) {
                stack.pop();
                list.add(calc.new Plus(value));
            }
            if (stack.peek().equals("minus")) {
                stack.pop();
                list.add(calc.new Minus(value));
            }
        }
        value = Integer.valueOf(stack.pop());
        list.add(calc.new Plus(value));
        list.add(calc.new Get());

        for (Calculator.Command command : list) {
            command.execute();
        }

    }
}
