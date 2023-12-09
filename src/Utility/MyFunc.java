package Utility;

public class MyFunc {

    public static void Wait(int sec) {

        try{

            Thread.sleep(1000*sec);

        }catch (InterruptedException e){

            throw new RuntimeException(e);

        }

    }

}
