package Autoclicker;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InputParser {


    private static HashMap<String, String> map = new HashMap<String, String>();

//    private static HashMap<String, Integer> keyCodes= new HashMap<String, Integer>();
    private static List<String[]> inputs= new ArrayList<String[]>();

    private static HashMap<String, Integer> keyCodes= null;






    public static void readConfig() throws IOException {
        String line;
        String filePath = "./config.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
    }


    public static void readInputs() throws IOException {
        String line;
        String filePath = "./input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 3);
            if (parts.length == 1) {
                inputs.add(new String[]{parts[0], "0", "40"});
            }else if(parts.length == 2) {

                inputs.add(new String[]{parts[0], parts[1], "40"});
            }else if(parts.length == 3) {

                inputs.add(new String[]{parts[0], parts[1], parts[2]});
            }else {
                System.out.println("ignoring line: " + line);
            }
        }
    }


    public static void doInputs() throws InterruptedException, AWTException, IOException {
        keyCodes= Keyboard.getKeyCodes();
        for (String[] row:inputs){
            Keyboard.pressKey(keyCodes.get(row[0]),Integer.parseInt(row[1]),Integer.parseInt(row[2]));
        }
    }


}
