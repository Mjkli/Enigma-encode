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

class rotors {
   private static Hashtable<Character,Character> rotor1 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor2 = new Hashtable<>();
   private static Hashtable<Character,Character> rotor3 = new Hashtable<>();
    private static Hashtable<Character,Character> rotor1rev = new Hashtable<>();
    private static Hashtable<Character,Character> rotor2rev = new Hashtable<>();
    private static Hashtable<Character,Character> rotor3rev = new Hashtable<>();
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
           rotor1rev.put(r1a[i],(char) (i + 65));

           rotor2.put((char) (i + 65), r2a[i]);
           rotor2rev.put(r2a[i],(char) (i + 65));

           rotor3.put((char) (i + 65), r3a[i]);
           rotor3rev.put(r3a[i],(char) (i + 65));

           reflector.put((char) (i + 65), refarr[i]);
       }

    }

     static void printRotors(){
         System.out.println("rotor1: " + rotor1.entrySet());
         System.out.println("rotor2: " + rotor2.entrySet());
         System.out.println("rotor3: " + rotor3.entrySet());
         System.out.println("Reflector: " + reflector.entrySet());
         System.out.println("rotor3rev: " + rotor3rev.entrySet());
         System.out.println("rotor2rev: " + rotor2rev.entrySet());
         System.out.println("rotor1rev: " + rotor1rev.entrySet());
    }

    static char rotorRun(char a){
        a = rotor3.get(rotor2.get(rotor1.get(a)));
        a = rotor1rev.get(rotor2rev.get(rotor3rev.get(reflector.get(a))));
       return a;
    }
}
