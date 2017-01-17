package typeinfo;

/**
 * Created by andrew_yashin on 1/17/17.
 */
public class SixTuple<A,B,C,D,E,G> {
    public final A a;
    public final B b;
    public final C c;
    public final D d;
    public final E e;
    public final G g;

    public SixTuple(A a, B b, C c, D d, E e, G g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.g = g;
    }

    @Override
    public String toString() {
        return "( " + a  + "," +
                b + "," +
                c + "," +
                d + "," +
                e + "," +
                g + ")";
    }

    public static void main(String... args){
        SixTuple<Integer,Double,String,Float,Character,Boolean> sixTuple =
                new SixTuple<Integer, Double, String, Float, Character, Boolean>(
                        1,2.45,"Hi", 3.45f, 'd', false
                );
        System.out.println(sixTuple);

    }
}
