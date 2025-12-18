import java.util.Random;
public class TaxiDriver implements Taxi, Runnable {
    private int id;
    private String name;
    private boolean isAvailable;
    private Random random;

    public TaxiDriver(int id, String name){
        this.id = id;
        this.name = name;
        this.isAvailable = true;
        this.random = new Random();
    }

    @Override
    public void placeOrder (int orderId, String pickup, String destination) {
        System.out.println("Taxi " + name + " recieves order " + orderId + ": " + pickup + " -> " + destination );
        if (!isAvailable){
            System.out.println("Taxi " + name + " is not available");
            return;
        }
        isAvailable = false;
        new Thread(() -> processOrder(orderId, pickup, destination)).start();
    }

    private void processOrder(int orderId, String pickup, String destination) {
        try {
            int time = 1000 + random.nextInt(4000);
            System.out.println("Taxi " + name + " is processing " + orderId + " (" + time/1000 + " second)");
            Thread.sleep(time);
            System.out.println("Taxi " + name + " finished order " + orderId);
        } catch (InterruptedException e) {
            System.out.println("Taxi " + name + " is interrupted");
            Thread.currentThread().interrupt();
        } finally {
            isAvailable = true;
        }
    }
    public String getName(){
        return name;
    }

    @Override
    public void run(){
    }
}
