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
    static ArrayList<node> pb = new ArrayList<>(26);

    //nodes used to connect letters to eachother on the plug board
    public static class node{
        char Letter; //letter used
        node connect; //connection to that letter

        node(){
            Letter = '0';
            connect = null;
        }
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
        int con = let + 25; // used to connect letters to each other
        for(int i = 0; i < (pb.size() / 2); i++){
            node temp = new node();
            temp.Letter = (char) let; //Set letter to ith node
            let++;
            con--;
        }
    }
    private static void printBoard(){
        for(int i = 0; i < pb.size(); i++){
            System.out.println("Letter: " + pb.get(i).Letter +"\nConnection: " + pb.get(i).connect.Letter);
        }
    }


    public static void main(String[] args) {

        plugBoard();


    }
}
