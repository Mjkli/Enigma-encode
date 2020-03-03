//This class handels the front of the enigma machine. i.e. the plugboard. connecting one letter to another
//In later iterations the settings should be able to be changed.



import java.util.Hashtable;

class plugboard {

    private static Hashtable<Character,Character> pb = new Hashtable<>();


    //Plug board should take an input - then output the character it is connected to.
    // 1 to 1
    static char getChar(char a){

        a = Character.toUpperCase(a);
        return pb.get(a);
    }

    //Method to set up the plug board
    //Initial Method will reverse Alphabet A -> Z , B -> Y , ...
    static void buildBoard(){
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

}
