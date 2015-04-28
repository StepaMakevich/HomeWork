package Calculator;

/**
 * Created by Степан on 20.04.2015.
 */
public class Example {
    public static void main(String[] args) {

        System.out.println("start");

        Service service = new Service();
        service.doSomething();
        service.do2();
        service.do3();

        Service.Command command = new Service.Do2Command(service);

        System.out.println("finish");
    }
}
