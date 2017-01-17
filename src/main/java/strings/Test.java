package strings;

/**
 * Created by andrew_yashin on 1/12/17.
 */
public class Test {
    int anInt;
    long aLong;
    float aFloat;
    double aDouble;

    public Test(int anInt, long aLong, float aFloat, double aDouble) {
        this.anInt = anInt;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
    }

    @Override
    public String toString() {
        return String.format(" int: %13d\n long: %13d\n float: %11.2e\n double: %10.3e",
                anInt, aLong, aFloat, aDouble);
    }

    public static void main(String... args){
        System.out.println(new Test(Integer.MAX_VALUE,Long.MAX_VALUE,Float.MAX_VALUE,Double.MAX_VALUE));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
