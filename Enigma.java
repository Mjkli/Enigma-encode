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

import java.util.Scanner; //Gets user Input


public class Enigma {

    private static char enigma(char a){
        return plugboard.getChar(rotors.rotorRun(plugboard.getChar(a)));
    }

    public static void main(String[] args) {

        rotors.buildRotors();
        plugboard.buildBoard();

        //Test input
        char a;
        StringBuilder output = new StringBuilder();
        Scanner input = new Scanner(System.in);

        //While the input char is not '0' Keep asking for new char
        //Plugboard.getchar will return connecting char and add it the string of output


        do{
                int in = 1;
                System.out.println("Enter a char: ");
                a = input.next().charAt(0);
                if(a != '0') {
                    output.append(enigma(a));
                    rotors.incrementRotor1();
                   // in++;

                    /*
                    if(in % 26 == 0){
                      //  rotors.incrementRotor2();
                    }
                    if(in % 646 == 0){
                        //rotors.incrementRotor3();
                    }
                    */

                }
        }while(a != '0');

        System.out.print(output);

    }
}
