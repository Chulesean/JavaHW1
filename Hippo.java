public class Hippo extends Animal{
    public Hippo(int id, double height) {
        super(id, height);
    }

    @Override
    public void makeSound() {
        System.out.println("oink");
    }
}
