package Calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Степан on 20.04.2015.
 */
public class UseCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("start");
//        calc.new Plus(10).execute();
        final List<Calculator.Command> list = Arrays.asList(//так как тут передаем пременную внутрь анонимного класса
                calc.new Plus(10),
                calc.new Plus(20),
                calc.new Plus(100),
                calc.new Minus(30),
                calc.new Get()

        );

        Collections.reverse(list);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Calculator.Command command : list) {
                    command.execute();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println("finish");


    }

}

