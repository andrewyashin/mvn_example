package ipk2;

/**
 * Created by andrew_yashin on 12/29/16.
 */
public class Frog extends Ambhibian{
    private String name;

    Frog(){
        name = "frog";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNameMod() {
        return super.getNameMod();
    }

    public static void  main(String... args){
        Frog frog = new Frog();
        Ambhibian ambhibian = new Ambhibian();
        System.out.println(((Frog) ambhibian).getName());

    }

}

class Ambhibian {
    private String name;

    Ambhibian(){
        name = "ambhibian";
    }

    public String getName() {
        return name;
    }

    public String getNameMod(){
        return name+" tralala";
    }
}
