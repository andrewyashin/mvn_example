package typeinfo;

/**
 * Created by andrew_yashin on 1/16/17.
 */
public class SaveObject<T> {
    T obj1;
    T obj2;
    T obj3;

    public SaveObject(T obj1, T obj2, T obj3) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    public T getFirst() { return obj1; }
    public T getSecond() { return obj2; }
    public T getThird() { return obj3; }

    public static void main(String... args){
        SaveObject<Integer> saveObject = new SaveObject<Integer>(1,2,3);

        System.out.println(saveObject.getFirst().getClass());

    }
}


