//Anthony Bruno
//Enigma

// get input from user
// switch string to char array
// Switch each char based on plug board
// run char through rotor for extra mixing
// reflector will send it back through the rotors again
// run char through plug board again
//  output encrypted message


//Strings should be encoded / decoded with same enigma settings

// Rotor maps a char to another char based on the settings of that rotor
// Rotor values change based on each key pressed - 3 rotors
// rotor 1 - changes every key pressed
// rotor 2 - changes every rotation from rotor 1 (26 keys pressed)
// rotor 3 - changes every rotation from rotor 2 ( 26 x 26 keys pressed)

//Plug board takes a char and transforms it into its pair

import java.io.PrintWriter;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner; //Gets user Input
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Enigma {

    private static char enigma(char a){
        //Go through the plugboard - then through the rotors - reflected back through the rotors - then back through the plugboard
        if(Character.isLetter(a)) {
            return plugboard.getChar(rotors.rotorRun(plugboard.getChar(a)));
        }
        return a;
    }

    public static void main(String[] args) {

        rotors.buildRotors();  //construct the rotors
        plugboard.buildBoard(); //construct the plugboard

        try{
            StringBuilder outLine = new StringBuilder(); //used for output from enigma
            BufferedReader reader = new BufferedReader(new FileReader("Unencrypted.txt")); //read file Unencrypted
            PrintWriter write = new PrintWriter("encrypted.txt", StandardCharsets.UTF_8); //write to file encrypted with UTF8


            String line = reader.readLine(); //line to get output from string
            int in = 1;
            while(line != null){
                char [] arr = line.toCharArray(); //convert output to char array to parse through
                for (char c : arr) {
                    outLine.append(enigma(c));
                    rotors.incrementRotor1(); //increment rotor1
                    in++;

                    if(in % 26 == 0){
                        rotors.incrementRotor2(); //increment rotor2
                    }
                    if(in % 646 == 0){
                        rotors.incrementRotor3(); //increment rotor3
                    }
                }


                write.println(outLine + "\n"); //output outline string to file
                outLine.delete(0,outLine.length()); //Clear outLine string for new input
                line = reader.readLine(); //get next line of file
            }

            write.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}