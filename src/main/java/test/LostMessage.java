package test;

/**
 * Created by andrew_yashin on 1/11/17.
 */

class OneException extends Exception{
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class TwoException extends Exception{
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class ThirdException extends Exception{
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
public class LostMessage {
    void f() throws OneException{
        throw new OneException();
    }

    void g() throws TwoException{
        throw new TwoException();
    }

    void h() throws ThirdException{
        throw new ThirdException();
    }

    public static void main(String... args){
        try{
            LostMessage lostMessage = new LostMessage();
            try{
                lostMessage.f();
            } finally {
                try{
                    lostMessage.g();
                } finally {
                    lostMessage.h();
                    return;
                }
            }
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
