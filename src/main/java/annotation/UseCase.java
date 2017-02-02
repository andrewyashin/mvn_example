package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by andrew_yashin on 1/31/17.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase{
    public int id();
    public String declaration() default "No Declaration";
}

class PasswordUtils{
    @UseCase(id = 45, declaration = "Password must contain one numeric")
    public boolean validatePassword(String password){
        return Pattern.matches("\\w*\\d\\w*", password);
    }

    @UseCase(id = 46)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 47, declaration = "New password cannot be as previous ones")
    public boolean chechPassword(List<String> oldPasswords, String newPassword){
        return !oldPasswords.contains(newPassword);
    }
}

class TrackUsesCases{
    public static void main(String... args){
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 45,46,47,48,49);
        testUsesCases(list, PasswordUtils.class);
    }

    public static void testUsesCases(List<Integer> list, Class<?> passwordUtilsClass) {
        for (Method method: passwordUtilsClass.getDeclaredMethods()){
            UseCase uc = method.getAnnotation(UseCase.class);

            if(uc != null) {
                System.out.println("id = " + uc.id() + "  declaration = " + uc.declaration());

                list.remove(new Integer(uc.id()));
            }


        }

        for(int i: list){
            System.out.println("Warning: missing usesCase - " + i);
        }
    }
}



