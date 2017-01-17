package inner.classes;

/**
 * Created by andrew_yashin on 1/5/17.
 */
public class Outer {
    private String string;

    public Outer(String string) {
        this.string = string;
    }

    class Inner{
        String label;
        Inner(String label){
            this.label = label;
        }

        public String toString() {
            printMEssage();
            return string;
        }
    }

    public Inner getInner(String label){
        return new Inner(label);
    }

    public void printMEssage(){
        System.out.println("MEssage");
    }

    public static void main(String ... args){

        Outer.Inner inner = new Outer("test").getInner("test2");
        System.out.println(inner);

        Test test = new Test();



    }

}

class Test{

    Test(){
        System.out.println("Test");
    }

    private class Test1{
        Test1(){
            System.out.println("Test1");
        }
    }

    protected class Test2{
        Test2(){
            System.out.println("Test2");
        }
    }

    public class Test3{
        Test3(){
            System.out.println("Test3");
        }
    }
}
