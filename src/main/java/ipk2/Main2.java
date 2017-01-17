package ipk2;

import com.kpi.ipk.Main;
import inner.classes.Outer;
import javafx.scene.shape.Circle;
import rtti.Rtti;
import rtti.ToyTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrew_yashin on 12/29/16.
 */
public class Main2 {
    private int i = 0;
    private String string = " PRIVATE";

    private static HashMap<Integer, String> modifiers =
            new HashMap<Integer, String>();

    public static void main(String... args){

        modifiers.put(1, "public");
        modifiers.put(2, "protected");
        modifiers.put(4, "private");

        try {
            Class<?> cc = Class.forName("rtti.Circle");
            Class<?> shape = Class.forName("rtti.Shape");

            Field[] fields = cc.getDeclaredFields();
            Method[] methods = cc.getDeclaredMethods();

            Field[] fieldsShape = shape.getDeclaredFields();

            for (Field field: fields){
                field.setAccessible(true);
                System.out.println(field.getType() + " " + field.getName() + " = " +  field.get(ToyTest.newCircle()));
            }

            for (Method method: methods){
                method.setAccessible(true);
                method.invoke(ToyTest.newCircle());
            }



            for (Field field: fieldsShape){
                field.setAccessible(true);
                System.out.println(field.getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
