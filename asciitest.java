//General file for testing different fucntions to be added to main code

public class asciitest {
    public static void main(String[] args) {


        String test = "";
        char [] test2 = test.toCharArray();
        for(int i = 0; i < test.length();i++){
            if(!Character.isAlphabetic(test2[i])){
                System.out.print(test);
            }
        }
    }
}

