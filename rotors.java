//This file will handle the rotors of the enigma machine.
//Each rotor will have a different setting to which it connects to another letter.
//Later iterations of code will have the rotors move with every entry.
/*
Entry = ABCDEFGHIJKLMNOPQRSTUVWXYZ (rotor right side)
        ||||||||||||||||||||||||||
I     = EKMFLGDQVZNTOWYHXUSPAIBRCJ
II    = AJDKSIRUXBLHWTMCQGZNPYFVOE
III   = BDFHJLCPRTXVZNYEIWGAKMUSQO
IV    = ESOVPZJAYQUIRHXLNFTGKDCMWB
V     = VZBRGITYUPSDNHLXAWMJQOFECK
 */


import java.io.IOException; //Exception for void in paths file
import java.nio.file.Path; //Path and Paths used for file location
import java.nio.file.Paths;
import java.util.Hashtable; //used for rotor settings
import java.util.Scanner; //Gets fileinput

public class rotors {
   private static Hashtable<Character,Character> rotor1 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor2 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor3 = new Hashtable<>();
   rotors() throws IOException {
       buildRotors();
   }

    private static void buildRotors() throws IOException {
        Path path = Paths.get("rotor1.txt");
        Scanner scan = new Scanner(path);
        while(scan.hasNextLine()){
            rotor1.put(scan.next().charAt(0),scan.next().charAt(1));
        }
        scan.close();


    }

     static void printRotors(){
        System.out.println(rotor1.keySet());
    }
}
