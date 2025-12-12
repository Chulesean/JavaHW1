public class Horse extends Animal{
    public Horse(int id, double height) {
        super(id, height);
    }

    @Override
    public void makeSound() {
        System.out.println("yeehaw");
    }
}
