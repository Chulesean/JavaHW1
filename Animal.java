public abstract class Animal {
    //fields
    private int id;
    private double height;
    private Supervisor supervisor;

    //constructors
    public Animal(int id, double height) {
        this.id = id;
        this.height = height;
    }

    //methods
    public int getId(){
        return id;
    }
    public double getHeight(){
        return height;
    }
    public Supervisor getSupervisor(){
        return supervisor;
    }
    public void setSupervisor(Supervisor supervisor){
        this.supervisor = supervisor;
    }
    public abstract void makeSound();
}