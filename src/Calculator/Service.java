package Calculator;

/**
 * Created by Степан on 20.04.2015.
 */
public class Service {

    abstract static class Command {

        Service _service;

        public Command(final Service service) {
            _service = service;
        }

        public abstract void execute();
    }

    static class Do2Command extends Command {

        public Do2Command(Service service) {
            super(service);
        }

        @Override
        public void execute() {
            _service.do2();

        }
    }

    public Service() {
        System.out.println("creating service");
    }

    public void doSomething() {
        System.out.println("doing something");
    }

    public void do2() {
    }

    public void do3() {
    }

}
