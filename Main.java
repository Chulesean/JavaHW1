import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<TaxiDriver> taxis = new ArrayList<>();
        taxis.add(new TaxiDriver(1, "Yandex"));
        taxis.add(new TaxiDriver(2, "Drive"));
        taxis.add(new TaxiDriver(3, "Urent"));

        TaxiDispatcher dispatcher = new TaxiDispatcher(taxis);

        dispatcher.startDispatching();

        try {
            System.out.println("Waiting for taxis to finish orders");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}