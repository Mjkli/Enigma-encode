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

import java.util.Hashtable; //used for rotor settings

public class rotors {
   private static Hashtable<Character,Character> rotor1 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor2 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor3 = new Hashtable<>();
   rotors(){
       buildRotors();
   }

    private static void buildRotors(){


    }

     static void printRotors(){
        System.out.println(rotor1.keySet());
    }
}
