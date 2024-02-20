package Autoclicker;



import java.awt.*;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit.*;
//import java.util.concurrent.*;

public class Keyboard {
    private static Robot robo= null;


    public static void pressKey(int keyCode, int delay) throws AWTException, InterruptedException{

        robo= new Robot();
        robo.waitForIdle();
        robo.keyPress(keyCode);
        Thread.sleep(delay);
        robo.keyRelease(keyCode);
    }

    public static void pressKey(int keyCode) throws AWTException, InterruptedException{
        pressKey(keyCode, 40);
    }

   
}












   
 