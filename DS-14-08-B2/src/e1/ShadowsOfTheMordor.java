package e1;

import java.util.Random;

public class ShadowsOfTheMordor {
    Heroe Heroe1 = new Heroe();
    Heroe Heroe2 = new Heroe();
    Heroe Heroe3 = new Heroe();

    Bestia Bestia1 = new Bestia();
    Bestia Bestia2 = new Bestia();
}

class Heroe {

    public enum Raza {Humano, Elfo, Enano};

    Raza raza;

    String nombre = "Heroe";

    void nombrees(String nuevoN){
        this.nombre = nuevoN;
    }

    void esHumano(){
        this.raza = Raza.Humano;
    }

    void esElfo(){
        this.raza = Raza.Elfo;
    }

    void esEnano(){
        this.raza = Raza.Enano;
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

}

class Bestia {

    public enum Raza {Orco, Trasgo};

    Raza raza;

    String nombre = "Bestia";

    void nombrees(String nuevoN){
        this.nombre = nuevoN;
    }

    void esOrco(){
        this.raza = Raza.Orco;
    }

    void esTrasgo(){
        this.raza = Raza.Trasgo;
    }

    int DadosBestias(){
        Random d1 = new Random();
        return d1.nextInt(91);
    }

    int DadosTrucadosBestias(){
        Random d1 = new Random(4480);
        return d1.nextInt(91);
    }

}