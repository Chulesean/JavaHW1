public class Dog extends Animal{
    public Dog(int id, double height){
        super(id, height);
    }

    @Override
    public void makeSound() {
        System.out.println("woof");
    }
}