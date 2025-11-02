public class Supervisor{
    private int id;
    private String name;
    //  private Animal animal;
    // 1 supervisor for many animals
    public Supervisor(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}