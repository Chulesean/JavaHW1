import java.util.ArrayList;
import java.util.List;

public class TaxiDispatcher implements Dispatcher {
    private List<TaxiDriver> taxis;
    private int orderCounter;

    public TaxiDispatcher(List<TaxiDriver> taxis) {
        this.taxis = taxis;
        this.orderCounter = 1;
    }

    @Override
    public void startDispatching() {
        System.out.println("Start dispatching ");
        for (int i=0; i < 10; i++) {
            TaxiDriver selectedTaxi = taxis.get(i % taxis.size());
            String[] locations = {"Street A", "Street B", "Street C"};
            String pickup = locations[i % locations.length];
            String destination = locations[(i + 1) % locations.length];

            System.out.println("Sending order " + orderCounter + " to " + selectedTaxi.getName() + ": " + pickup + " -> " + destination);
            selectedTaxi.placeOrder(orderCounter, pickup, destination);
            orderCounter ++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
