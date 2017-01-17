package strings;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by andrew_yashin on 1/12/17.
 */
public class Replace {
    public static String knights =
            "Then, when you have found a shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    private Replace() {
        System.out.println("Constructor");
    }

    public static Replace newInstance(){
        return new Replace();
    }

    public static void main(String[] args){
        String string = "Then .";
        System.out.println(knights.matches("^\\p{Upper}.+(!)"));
        System.out.println(Arrays.asList(knights.split("the|you")));
        System.out.println(knights.replaceAll("(a|A|e|E|y|Y|u|U|i|I|o|O|j|J)", "_"));

        Replace replace = newInstance();
        Replace replace1 = newInstance();
        Replace replace2 = newInstance();





    }
}

class ParseNumbers{
    int anInt;
    float aFloat;
    double aDouble;
    String string;

    public ParseNumbers(String line) {

    }
}
