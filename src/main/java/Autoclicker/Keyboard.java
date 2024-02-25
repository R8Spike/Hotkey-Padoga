package Autoclicker;

import java.awt.Robot;
import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

public class Keyboard {


    private static HashMap<String, Integer> keyCodes= new HashMap<String, Integer>();

    public static void setKeyCodes() throws IOException {
        for(int i = 0; i < 1000000; ++i) {
            String text = java.awt.event.KeyEvent.getKeyText(i);
            if(!text.contains("Unknown keyCode: ")) {
                keyCodes.put(text, i);
            }
        }
    }

    public static HashMap<String, Integer> getKeyCodes(){
        return keyCodes;
    }


    public static void pressKey(int keyCode) throws AWTException, InterruptedException {
        pressKey(keyCode, 0);
    }

    public static void pressKey(int keyCode, int delay) throws AWTException, InterruptedException {
        pressKey(keyCode, delay,40);
    }

    public static void pressKey(int keyCode, int delay, int holdTime) throws AWTException, InterruptedException {
        Robot robo = new Robot();
        robo.waitForIdle();
        robo.keyPress(keyCode);
        Thread.sleep(holdTime);
        robo.keyRelease(keyCode);
        Thread.sleep(delay);
    }

   
}












   
 