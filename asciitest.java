//General file for testing different fucntions to be added to main code


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class asciitest {
    public static void main(String[] args) {
    BiMap<Character,Character> test = HashBiMap.create();
        String r1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        char [] r1a = r1.toCharArray();

        for(int i = 0; i < 26; i++){
            test.put((char) (i + 65), r1a[i]);
        }

        System.out.println("forward: " + test.keySet() + "\nvalues:  " + test.values());


        //Shifting values

        char end = test.get('A');

        for(int i = 65; i < 90; i++){
            char temp = test.get((char) (i + 1));
            test.remove((char) (i + 1));
            test.put((char) (i), temp);
        }
        test.put('Z',end);

        System.out.println("\nforward: " + test.keySet() + "\nvalues:  " + test.values());

    }
}

