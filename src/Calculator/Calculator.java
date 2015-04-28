package Calculator;

/**
 * Created by Степан on 20.04.2015.
 */
public class Calculator {
    int total = 0;

    abstract class Command {
        public void execute() {
            realExecute();
            System.out.println(total);
        }

        abstract void realExecute();
    }

    public class Plus extends Command {

        int _value;


        public Plus(int _value) {
            this._value = _value;
        }


        @Override
        void realExecute() {
            total += _value;
        }


    }

    public class Minus extends Plus { // наследование с целью вариации(изменение)

        Minus(int _value) {
            super(-_value);
        }
    }

    public class Clear extends Command {
        @Override
        void realExecute() {
            total = 0;
        }
    }

    public class Get extends Command {

        @Override
        void realExecute() {

        }
    }

//все эти методы теперь не нужны
//    public void clear() {
//        total = 0;
//    }
//
//    public void plus(int value) {
//        total += value;
//    }
//
//    public void minus(int value) {
//        total -= value;
//    }
//
//    public int get() {
//        return total;
//    }

}
