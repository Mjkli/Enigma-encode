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


import java.util.Hashtable;

public class rotors {
   private static Hashtable<Character,Character> rotor1 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor2 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor3 = new Hashtable<>();

    private static void buildRotor1(){
        rotor1.put('A','E');
        rotor1.put('B','K');
        rotor1.put('C','M');
        rotor1.put('D','F');
        rotor1.put('E','L');
        rotor1.put('F','G');
        rotor1.put('G','D');
        rotor1.put('H','Q');
        rotor1.put('G','D');

    }
}
