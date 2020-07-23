package sample;

public class stringReverse {
        stringReverse(){

        }

        public boolean checkRecord(String s) {
            char[] ch = new char[s.length()];

            for (int i = 0; i < s.length(); i++) {
                ch[i] = s.charAt(i);
            }

            int a = 0;
            for(char c: ch ){

                if (c == 'A') a++;

            }

            if (a > 1)  return false;
            else return true;


        }

        public static void main(String[] args) {
            String string = "APPLL";
            sample.student s = new sample.student();
            s.checkRecord(string);


            System.out.println( string);
            System.out.println(         s.checkRecord(string));

        }
}
