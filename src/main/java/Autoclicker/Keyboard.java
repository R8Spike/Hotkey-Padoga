package Autoclicker;



import java.awt.Robot;
import java.awt.AWTException;

public class Keyboard {


    public static void pressKey(int keyCode, int delay) throws AWTException, InterruptedException {
        pressKey(keyCode, delay,0);
    }

    public static void pressKey(int keyCode) throws AWTException, InterruptedException {
        pressKey(keyCode, 40);
    }

    public static void pressKey(int keyCode, int delay, int delay1) throws AWTException, InterruptedException {
        Robot robo = new Robot();
        robo.waitForIdle();
        robo.keyPress(keyCode);
        Thread.sleep(delay);
        robo.keyRelease(keyCode);
        Thread.sleep(delay1);
    }

   
}












   
 