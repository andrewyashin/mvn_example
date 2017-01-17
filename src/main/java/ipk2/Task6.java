package ipk2;


/**
 * Created by andrew_yashin on 1/5/17.
 */

public interface Task6 {
    void printMessage();
    class Main implements Task6{
        static void print(){
            new Main().printMessage();
        }

        public void printMessage() {
            System.out.println("Main");
        }
    }

}