package abs.intr;

/**
 * Created by andrew_yashin on 1/3/17.
 */

interface Cycle {
    void sendMessage();
}

class UniCycle implements Cycle{
    public void sendMessage(){
        System.out.println(getClass().getName());
    }
}

class Bicycle implements Cycle{
    public void sendMessage() {
        System.out.println(getClass().getName());
    }
}

class Tricycle implements Cycle{
    public void sendMessage() {
        System.out.println(getClass().getName());
    }
}

interface CycleFactory{
    Cycle getCycle();
}

class UniCycleFactory implements CycleFactory{
    public Cycle getCycle() {
        return new UniCycle();
    }
}


class BicycleFactory implements CycleFactory{
    public Cycle getCycle() {
        return new Bicycle();
    }
}


class TricycleFactory implements CycleFactory{
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Main{
    public static void main(String... args){
        CycleFactory cycleFactory = new TricycleFactory();
        Cycle cycle = cycleFactory.getCycle();
        System.out.println(cycle.toString());
    }
}