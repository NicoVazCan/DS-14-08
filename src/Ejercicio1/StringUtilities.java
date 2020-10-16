package Ejercicio1;
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

    public static boolean isValidMix (String a , String b , String c ) {
        boolean correcto=false;
        int na=0;
        int nb=0;
        int nc=0;
        char[] letraA = a.toCharArray();
        char[] letraB = b.toCharArray();
        char[] letraC = c.toCharArray();
        if(c.length()==a.length()+b.length()) {
            System.out.println("Tamaño correcto");
            correcto =true;
            while (correcto) {
                if (nb!=b.length()&&letraC[nc] == letraB[nb]) {
                    System.out.println("Letra "+letraC[nc]+" es igual a "+ letraB[nb]+" en B");
                    nb++;
                    if(nc==c.length()-1) return correcto;
                    else nc++;
                } else if (na!=a.length()&&letraC[nc] == letraA[na]) {
                    System.out.println("Letra "+letraC[nc]+" es igual a "+ letraA[na]+" en A");
                    na++;
                    if(nc==c.length()-1) return correcto;
                    else nc++;
                } else {
                    System.out.println("Letras o orden incorrecto");
                    correcto = false;
                }
            }
            return correcto;
        }
        else{
            System.out.println("Tamaño incorrecto");
            return correcto;
        }
    }

    /* Generates a random valid mix for two Strings
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two. */

    public static String generateRandomValidMix (String a , String b) {
        char[] letraA = a.toCharArray();
        char[] letraB = b.toCharArray();
        int nc =a.length()+b.length(),v=0,n,na=0,nb=0;
        StringBuilder c = new StringBuilder();
        while(v!=nc){
                n=Aleatorio(2);
                if(na==a.length()||nb==b.length()){
                    if(na==a.length())n=1;
                    if(nb==b.length())n=0;
                }
                if(n==0&&na!=a.length()){
                    c.append(letraA[na]);
                    na++;
                    v++;
                }
                else if(n==1&&nb!=b.length()){
                    c.append(letraB[nb]);
                    nb++;
                    v++;
                }
        }
        return c.toString();
    }
/*
    public  static  void  main (String[]args){

        String a = "Bye";
        String b = "World";
        String c;

        c=generateRandomValidMix(a,b);
        System.out.println(c);

        if(isValidMix(a,b,c)) {
            System.out.println("Todo bien");
        }
        else System.out.println("Mal");
    }*/

}
