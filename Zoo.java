import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private List<Animal> animals;
    private List<Supervisor> supervisors;
    private Map<Integer, Animal> animalMap;

    public Zoo() {
        this.animals = new ArrayList<>();
        this.supervisors = new ArrayList<>();
        this.animalMap = new HashMap<>();
    }
    public Zoo(List<Animal> animals) {
        this();
        this.animals.addAll(animals);
        for(Animal animal : animals) {
            this.animalMap.put(animal.getId(), animal);
        }
    }


    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        this.animalMap.put(animal.getId(), animal);
    }
    public void addSupervisor(Supervisor supervisor) {
        this.supervisors.add(supervisor);
    }
    public Animal findAnimal(int animalId) {
        return animalMap.get(animalId);
    }
    public boolean deleteAnimal(int animalId) {
        Animal animalToDelete = findAnimal(animalId);
        if (animalToDelete != null) {
            animals.remove(animalToDelete);
            animalMap.remove(animalId);
            return true;
        }
        return false;
    }
    public void assignSupervisorToAnimal(int AnimalId, Supervisor supervisor) {
        Animal animalToAssign = findAnimal(AnimalId);
        if (animalToAssign != null){
            animalToAssign.setSupervisor(supervisor);
        }
    }
    public List<Animal> getAnimalsBySupervisorId(int supervisorId) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals){
            if (animal.getSupervisor().getId() == supervisorId) {
                result.add(animal);
            }
        }
        return result;
    }
    public List<Animal> getAnimalsBySupervisorName(String supervisorName) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals){
            if (animal.getSupervisor().getName().equals(supervisorName)) {
                result.add(animal);
            }
        }
        return result;
    }
    public List<Animal> getAnimalHigher(double standard) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals){
            if (animal.getHeight() > standard) {
                result.add(animal);
            }
        }
        return result;
    }
    public List<Animal> getAnimalCanMakeSound() {
        List<Animal> result = new ArrayList<>();
        for(Animal animal : animals){
            if (animal.getClass() != Fish.class) {
                result.add(animal);
            }
        }
        return result;
    }
    public List<Animal> getAnimalsByType(Class<?> animalType) {
        List<Animal> result = new ArrayList<>();
        for(Animal animal : animals) {
            if (animal.getClass() == animalType) {
                result.add(animal);
            }
        }
        return result;
    }
}
