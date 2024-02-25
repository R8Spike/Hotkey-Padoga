package Autoclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.AWTException;

public class Clicker implements NativeKeyListener
{
	//howLong is cast to int so that when I add in json parsing it will handle decimals better
	int howLong=(int)(10.0*1000);
	//it's named that as some fucker on stack overflow didn't inform me of a timer class so I wasted a day trying to make it
    Timer time= new Timer("fuck you stack overflow");
    TimerTask task= null;

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
                            //if you want to hardcore the inputs instead of relying on the config replace this
                            InputParser.doInputs();

        	        		System.out.println("ping");
        	    		} catch (AWTException | InterruptedException e) {
        	        		// idk what to put here it only works in a try catch

        		        	System.out.println("AWTException error");
        	    		} catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
				};


			}else{
				task= new TimerTask() {
        			@Override
        			public void run() {
        	    	System.out.println("pong");
    				}
				};
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