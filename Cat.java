public class Cat extends Animal{
    public Cat(int id, double height){
        super(id, height);
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}