package e1;

import java.util.Random;


public class ShadowsOfTheMordor {
    public static void main(String[]args){
        Heroe gand = new Heroe("Gand", Heroe.Raza.Humano, 100, 10);
        Bestia uruk = new Bestia("Uruk", Bestia.Raza.Orco, 100, 10);
        System.out.println(gand.nombre + " " + gand.raza + " " + gand.vida + " " + gand.armadura);
        System.out.println(uruk.nombre + " " + uruk.raza + " " + uruk.vida + " " + uruk.armadura);
    }
}

class Heroe {

    public enum Raza {Humano, Elfo, Enano};

    Raza raza = Raza.Humano;

    String nombre = "Heroe";

    int vida=100;

    int armadura=20;

    void Armaduraes(int nuevaA){
        this.armadura = nuevaA;
    }

    void Vidaes(int nuevaV){
        this.vida = nuevaV;
    }

    void nombrees(String nuevoN){
        this.nombre = nuevoN;
    }

    void Razaes(Raza nuevaR){
        this.raza = nuevaR;
    }

    int DadosHeroe(){
        Random d1 = new Random();
        Random d2 = new Random();
        int Dado1 = d1.nextInt(101);
        int Dado2 = d2.nextInt(101);
        return Math.max(Dado1, Dado2);
    }

    int DadosTrucadosHeroe(){
        Random d1 = new Random(2020);
        Random d2 = new Random(202);
        int Dado1 = d1.nextInt(101);
        int Dado2 = d2.nextInt(101);
        return Math.max(Dado1, Dado2);
    }

    Heroe(String nombre, Raza raza, int vida, int armadura){

        this.nombrees(nombre);
        this.Razaes(raza);
        this.Vidaes(vida);
        this.Armaduraes(armadura);

    }
}

class Bestia {

    public enum Raza {Orco, Trasgo};

    Raza raza = Raza.Orco;

    String nombre = "Bestia";

    int vida=100;

    int armadura=20;

    void Armaduraes(int nuevaA){
        this.armadura = nuevaA;
    }

    void Vidaes(int nuevaV){
        this.vida = nuevaV;
    }

    void nombrees(String nuevoN){
        this.nombre = nuevoN;
    }

    void Razaes(Raza nuevaR){
        this.raza = nuevaR;
    }

    int DadosBestias(){
        Random d1 = new Random();
        return d1.nextInt(91);
    }

    int DadosTrucadosBestias(){
        Random d1 = new Random(4480);
        return d1.nextInt(91);
    }

    Bestia(String nombre, Raza raza, int vida, int armadura){

        this.nombrees(nombre);
        this.Razaes(raza);
        this.Vidaes(vida);
        this.Armaduraes(armadura);

    }
}