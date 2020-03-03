//This file will handle the rotors of the enigma machine.
//Each rotor will have a different setting to which it connects to another letter.
//Later iterations of code will have the rotors move with every entry.
//Th reflector will send the signal back to the start (UKW-B)
//UKW-B was the standard reflector during the war


// currently the rotors will be stuck on setting AAA
/*
Entry = ABCDEFGHIJKLMNOPQRSTUVWXYZ (rotor right side)
        ||||||||||||||||||||||||||
I     = EKMFLGDQVZNTOWYHXUSPAIBRCJ
II    = AJDKSIRUXBLHWTMCQGZNPYFVOE
III   = BDFHJLCPRTXVZNYEIWGAKMUSQO
IV    = ESOVPZJAYQUIRHXLNFTGKDCMWB
V     = VZBRGITYUPSDNHLXAWMJQOFECK
UKW-B = YRUHQSLDPXNGOKMIEBFZCWVJAT
 */

import java.util.Hashtable; //used for rotor settings
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

class rotors {
    private static BiMap<Character,Character> rotor1 = HashBiMap.create();
    private static BiMap<Character,Character> rotor2 = HashBiMap.create();
    private static BiMap<Character,Character> rotor3 = HashBiMap.create();
    private static Hashtable<Character,Character> reflector = new Hashtable<>();


   static void buildRotors(){
       String r1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
       char [] r1a = r1.toCharArray();
       String r2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
       char [] r2a = r2.toCharArray();
       String r3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
       char [] r3a = r3.toCharArray();
       String ref = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
       char [] refarr = ref.toCharArray();

       for(int i = 0; i < 26; i++){
           //Select rotor - key is A to Z (have to add 64 for the correct Ascii value / Object is chosen from the char array
           rotor1.put((char) (i + 65), r1a[i]);

           rotor2.put((char) (i + 65), r2a[i]);

           rotor3.put((char) (i + 65), r3a[i]);

           reflector.put((char) (i + 65), refarr[i]);
       }

    }

    static void printRotors(){
        System.out.println("rotor1: " + rotor1.entrySet());
        // System.out.println("rotor2: " + rotor2.entrySet());
        // System.out.println("rotor3: " + rotor3.entrySet());
        //System.out.println("Reflector: " + reflector.entrySet());
        System.out.println("rotor1rev: " + rotor1.inverse().entrySet());
    }

    static char rotorRun(char a){
        a = rotor3.get(rotor2.get(rotor1.get(a)));
        a = rotor1.inverse().get(rotor2.inverse().get(rotor3.inverse().get(reflector.get(a))));
       return a;
    }

    static void incrementRotor1(){
        char end = rotor1.get('A');

        for(int i = 65; i < 90; i++){
            char temp = rotor1.get((char) (i + 1));
            rotor1.remove((char) (i + 1));
            rotor1.put((char) (i), temp);
        }
        rotor1.put('Z',end);

    }

    static void incrementRotor2(){
        for(int i = 0; i < 26; i++){
            rotor2.replace((char) (i + 64), rotor2.get((char) (i + 64 + 1)));
            if(i == 25){
                rotor2.replace((char) (i + 64), rotor2.get((char) 64));
            }
        }

    }

    static void incrementRotor3(){
        for(int i = 0; i < 26; i++){
            rotor3.replace((char) (i + 64), rotor3.get((char) (i + 64 + 1)));
            if(i == 25){
                rotor3.replace((char) (i + 64), rotor3.get((char) 64));
            }
        }

    }
}
