package Autoclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.AWTException;



public class Clicker implements NativeKeyListener {
	    int howLong=(int)(10*1000);
    Timer time= new Timer("fuck you stack overflow");


    TimerTask task= null;

	/*public void nativeKeyPressed(NativeKeyEvent e) {
		//System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

		if (e.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
			System.out.print("autoclicker ended");
			System.exit(1);
        	}
	}*/

	public void nativeKeyReleased(NativeKeyEvent e) {
		//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		isTimerTyped(e,"P",true);
		isTimerTyped(e,"O",false);
		if (e.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
			System.out.print("Auto Clicker ended");
			System.exit(1);
        	}
	}


	public void isTimerTyped(NativeKeyEvent e,String l,boolean b){
		if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(l)){
			System.out.print(l);
        time.cancel();
        time= new Timer("replaced");
		if(b){
			task = new TimerTask() {

        @Override
        public void run() {
            
            try {
                Keyboard.pressKey(KeyEvent.VK_ESCAPE,400);
				Keyboard.pressKey(KeyEvent.VK_DOWN);
				Keyboard.pressKey(KeyEvent.VK_Z,400);
				Keyboard.pressKey(KeyEvent.VK_DOWN);
				Keyboard.pressKey(KeyEvent.VK_Z);

                System.out.println("ping");
            } catch (AWTException | InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("AWTException error");
            }
        
        
    }};

        
		}else{
			task= new TimerTask() {

        @Override
        public void run() {

            System.out.println("pong");
        
    }};

		}
		time.scheduleAtFixedRate(task, howLong/2, howLong);
		}
	}

	public static void main(String[] args) {
		//System.out.println(new File(".").getAbsoluteFile());
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		System.out.println("Auto Clicker started");

		GlobalScreen.addNativeKeyListener(new Clicker());
	}
}