import java.util.*;

public class Main {
    public static void main(String[] args) {

        Zoo zoo = new Zoo();

        Cat cat = new Cat(1, 30.0);
        Dog dog = new Dog(2, 50.0);
        Supervisor messi = new Supervisor(123, "Messi");
        Supervisor ronaldo = new Supervisor(321, "Ronaldo");

        zoo.addAnimal(cat);
        zoo.addAnimal(dog);
        zoo.addSupervisor(messi);
        zoo.addSupervisor(ronaldo);

        zoo.assignSupervisorToAnimal(1, messi);
        zoo.assignSupervisorToAnimal(2, ronaldo);
    }
}