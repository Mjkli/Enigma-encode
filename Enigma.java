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


import java.util.Hashtable; //hashtable defined for the plugboard
import java.util.Scanner; //Gets user Input


public class Enigma {

    //Array to hold switch board values
    private static Hashtable<Character,Character> pb = new Hashtable<>();


    //Plug board should take an input - then output the character it is connected to.
    // 1 to 1
    private static char plugBoard(char a){

        a = Character.toUpperCase(a);
        a = pb.get(a);

        return a;
    }

    //Method to set up the plug board
    //Initial Method will reverse Alphabet A -> Z , B -> Y , ...
    private static void buildBoard(){
        int let = 65; //used for assigning letters on the plugboard
        int con = let + 25; // used to connect letters to each other
        for(int i = 0; i < 13; i++){

            pb.put((char) let,(char) con);
            pb.put((char) con,(char) let);



            let++;
            con--;
        }
    }

    private static void printboard(){
        System.out.println(pb.entrySet());
    }


    public static void main(String[] args) {

        buildBoard();

        //Test input
        char a = 'A';
        StringBuilder output = new StringBuilder();
        Scanner input = new Scanner(System.in);
        do{
                System.out.println("Enter a char: ");
                a = input.next().charAt(0);
                if(a != '0')
                    output.append(plugBoard(a));
        }while(a != '0');

        System.out.print(output);
    }
}
