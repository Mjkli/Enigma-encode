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



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; //Gets user Input


public class Enigma {

    //Array to hold switch board values
    static node [] pb = new node [26];

    //nodes used to connect letters to eachother on the plug board
    public class node{
        char Letter; //letter used
        node connect; //connection to that letter
    }


    //Plugboard should take an input - then output the character it is connected to.
    // 1 to 1
    public static void plugBoard(){

        buildBoard();
        printBoard();




    }

    //Method to set up the plug board
    private static void buildBoard(){
        int let = 65; //used for assigning letters on the plugboard
        int con = 25; // used to connect letters to each other
        for(int i = 0; i < (pb.length / 2); i++){
            pb[i].Letter = (char) (i + let);
            pb[i].connect = pb[i + con];
            let--;
            con--;
        }
    }
    private static void printBoard(){
        for(int i = 0; i < pb.length; i++){
            System.out.println("Letter: " + pb[i].Letter +"\nConnection: " + pb[i].connect.Letter);
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Create Scanner object
        //System.out.println("Enter message: ");

        //String message = input.nextLine(); //Get string
        //message = message.toUpperCase(); //set chars to uppercase

        //char[] msg = message.toCharArray(); //convert to char array
        //char[] output = new char[msg.length];

        //for(int i = 0; i < msg.length; i++){
        //   if(Character.isWhitespace(msg[i])) //Take out spaces (enigma does not like spaces)
        //       output[i] = ' ';
        //    else
                plugBoard();
        //}

        //String out = Arrays.toString(output);

        //System.out.println("\n"+ out);


    }
}
