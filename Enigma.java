//Anthony Bruno
//Enigma

// get input from user
// switch string to char array
// Switch each char based on plug board
// run char through rotor for extra mixing
// run char through plug board again
//  output encrypted message


//Strings should be encoded / decoded with same enigma settings

// Rotor maps a char to another char based on the settings of that rotor
// Rotor values change based on each key pressed - 3 rotors
// rotor 1 - changes every key pressed
// rotor 2 - changes every rotation from rotor 1 (26 keys pressed)
// rotor 3 - changes every rotation from rotor 2 ( 26 x 26 keys pressed)

//Plug board takes a char and transforms it into its pair



import java.util.Arrays;
import java.util.Scanner; //Gets user Input


public class Enigma {


    public static char plugBoard(char a){


        a = rotor(a);
        return a;
    }

    public static char rotor(char a){




        return a;
    }

    public static void reset(){

        //Reset plug board
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){

            }
        }

    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Create Scanner object
        System.out.println("Enter message");

        String message = input.nextLine(); //Get string

        char[] msg = message.toCharArray(); //convert to char array
        char[] output = new char[msg.length];

        for(int i = 0; i < msg.length; i++){
            if(Character.isWhitespace(msg[i])) //Take out spaces (enigma doesnt like spaces)
                output[i] = ' ';
            else
                output[i] = plugBoard(msg[i]);
        }

        String out = Arrays.toString(output);

        System.out.println("\n"+ out);


    }
}
