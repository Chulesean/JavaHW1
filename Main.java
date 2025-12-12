import java.util.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        
        Supervisor[] supervisors = {
            new Supervisor(101, "Michael"),
            new Supervisor(102, "Sarah"),
            new Supervisor(103, "David"),
            new Supervisor(104, "Emma"),
            new Supervisor(105, "James")
        };
        
        Animal[] animals = {
            new Cat(1, 25.5),
            new Dog(2, 45.0),
            new Cat(3, 30.2),
            new Dog(4, 55.5),
            new Fish(5, 12.0),
            new Hippo(6, 150.0),
            new Horse(7, 175.0),
            new Cat(8, 28.7),
            new Dog(9, 48.3),
            new Fish(10, 15.8)
        };
        
        for (Supervisor supervisor : supervisors) {
            zoo.addSupervisor(supervisor);
        }
        
        for (Animal animal : animals) {
            zoo.addAnimal(animal);
        }
        
        zoo.assignSupervisorToAnimal(1, supervisors[0]);
        zoo.assignSupervisorToAnimal(3, supervisors[0]);
        zoo.assignSupervisorToAnimal(8, supervisors[0]);
        
        zoo.assignSupervisorToAnimal(2, supervisors[1]);
        zoo.assignSupervisorToAnimal(4, supervisors[1]);
        zoo.assignSupervisorToAnimal(9, supervisors[1]);
        
        zoo.assignSupervisorToAnimal(5, supervisors[2]);
        zoo.assignSupervisorToAnimal(10, supervisors[2]);
        
        zoo.assignSupervisorToAnimal(6, supervisors[3]);
        zoo.assignSupervisorToAnimal(7, supervisors[3]);
        
        Animal found = zoo.findAnimal(3);
        if (found != null) {
            System.out.println("Found animal ID 3: " + found.getClass().getSimpleName());
        }
        
        List<Animal> michaelsAnimals = zoo.getAnimalsBySupervisorId(101);
        System.out.println("Michael supervises " + michaelsAnimals.size() + " animals");
        
        List<Animal> tallAnimals = zoo.getAnimalHigher(40.0);
        System.out.println("Animals taller than 40cm: " + tallAnimals.size());
        
        List<Animal> allCats = zoo.getAnimalsByType(Cat.class);
        System.out.println("Total cats in zoo: " + allCats.size());
        
        List<Animal> animalsWithSound = zoo.getAnimalCanMakeSound();
        System.out.println("Animals that can make sound: " + animalsWithSound.size());
        
        System.out.println("\nAnimal sounds:");
        for (Animal animal : animalsWithSound) {
            System.out.print(animal.getClass().getSimpleName() + " " + animal.getId() + ": ");
            animal.makeSound();
        }
        
        boolean deleted = zoo.deleteAnimal(8);
        System.out.println("\nDeleted animal ID 8: " + deleted);
        
        Animal deletedAnimal = zoo.findAnimal(8);
        System.out.println("Animal ID 8 still exists: " + (deletedAnimal != null));
    }
}
