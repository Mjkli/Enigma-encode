public class asciitest {
    public static void main(String[] args) {
        int a = 65;
        int b = a + 25;

        for(int i = 0; i < 13; i++)
        {
            System.out.println((char)a + " " + (char)b);
            a++;
            b--;

        }
    }
}
