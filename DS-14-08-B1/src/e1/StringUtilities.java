package e1;

import java.util.Random;

public class StringUtilities {

    public static int Aleatorio(int maximo){
        Random r = new Random();
        return r.nextInt(maximo);
    }

     /* Checks if a given string is a valid c of two others . That is , it contains
     * all characters of the other two and order of all characters in the individual
     * strings is preserved .
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @param c Mix of the two other Strings
     * @return true if the c is valid , false otherwise. */




    /*String text = "foo";
    char charAtZero = text.charAt(0);
    System.out.println(charAtZero); // Prints f*/



    public static boolean isValidMix (String a , String b , String c ) {
        boolean correcto=false;
        int na=0;
        int nb=0;
        int nc=0;
        char charA;
        char charB;
        char charC;

        if(!a.isEmpty() && !b.isEmpty() && !c.isEmpty() && a != null && b != null && c != null) {
            charA = a.charAt(na);
            charB = b.charAt(nb);
            charC = c.charAt(nc);

            if(c.length()==a.length()+b.length()) {
                System.out.println("Tamaño correcto");
                correcto =true;
                while (correcto) {
                    if (nb!=b.length()&&charC == charB) {
                        System.out.println("Letra "+charC+" es igual a "+ charB+" en B");
                        nb++;
                        if(nb!=b.length())charB = b.charAt(nb);
                        if(nc==c.length()-1) return correcto;
                        else nc++;charC = c.charAt(nc);
                    } else if (na!=a.length()&&charC == charA) {
                        System.out.println("Letra "+charC+" es igual a "+ charA+" en A");
                        na++;
                        if(na!=a.length())charA = a.charAt(na);
                        if(nc==c.length()-1) return correcto;
                        else nc++;charC = c.charAt(nc);
                    } else {
                        System.out.println("Letras o orden incorrecto");
                        System.out.println(charC);
                        correcto = false;
                    }
                }
                return correcto;
            }
            else{
                System.out.println("Tamaño incorrecto o nulo");
                return correcto;
            }
        }
        else{
            return correcto;
        }
    }

    /* Generates a random valid mix for two Strings
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two. */

    public static String generateRandomValidMix (String a , String b) {
        int nc =a.length()+b.length(),v=0,n,na=0,nb=0;
        char charA = a.charAt(na);
        char charB = b.charAt(nb);
        StringBuilder c = new StringBuilder();
        while(v!=nc){
                n=Aleatorio(2);
                if(na==a.length()||nb==b.length()){
                    if(na==a.length())n=1;
                    if(nb==b.length())n=0;
                }
                if(n==0&&na!=a.length()){
                    charA = a.charAt(na);
                    c.append(charA);
                    na++;
                    v++;
                }
                else if(n==1&&nb!=b.length()){
                    charB = b.charAt(nb);
                    c.append(charB);
                    nb++;
                    v++;
                }
        }
        return c.toString();
    }
}
