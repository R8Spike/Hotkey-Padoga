package Autoclicker;

import java.io.IOException;
public class Main {

    public static void main (String[] args) throws IOException, InterruptedException {

        Keyboard.setKeyCodes();
        InputParser.readInputs();
        Clicker.main(null);

    }


}
