//This file will handle the rotors of the enigma machine.
//Each rotor will have a different setting to which it connects to another letter.
//Later iterations of code will have the rotors move with every entry.
//Th refelctor will send the signal back to the start


// currently the rotors will be stuck on setting AAA
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


   static void buildRotors(){
       String r1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
       char [] r1a = r1.toCharArray();
       String r2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
       char [] r2a = r2.toCharArray();
       String r3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
       char [] r3a = r3.toCharArray();

       for(int i = 0; i < 26; i++){
           //Select rotor - key is A to Z (have to add 64 for the correct Ascii value / Object is chosen from the char array
           rotor1.put((char) (i + 65), r1a[i]);
           rotor2.put((char) (i + 65), r2a[i]);
           rotor3.put((char) (i + 65), r3a[i]);
       }

    }

     static void printRotors(){
        System.out.println(rotor1.entrySet());
        System.out.println(rotor2.entrySet());
        System.out.println(rotor3.entrySet());
    }

    private static char r1mix(char a){
       return rotor1.get(a);
    }
    private static char r2mix(char a){
       return rotor2.get(a);
    }
    private static char r3mix(char a){
       return rotor3.get(a);
    }

    static char rotorRun(char a){
       return rotor3.get(rotor2.get(rotor1.get(a)));
    }
}
