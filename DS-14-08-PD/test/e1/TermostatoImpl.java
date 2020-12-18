package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TermostatoImpl {

    @Test
    void TermoOFFONOFF() {
        Termostato t = new Termostato();
        t.newTemperature(21);
        assertEquals("21.0 Modo Off - Calefaccion apagada.\n",t.screenInfo());
        t.setManual();
        t.newTemperature(22);
        t.setOff();
        t.newTemperature(20);
        assertEquals("21.0 Modo Off - Calefaccion apagada.\n" +
                             "Se activa el modo Manual.\n"+
                             "22.0 Modo Manual - Calefaccion encendida.\n" +
                             "Se activa el modo Off.\n"+
                             "20.0 Modo Off - Calefaccion apagada.\n",t.screenInfo());
    }
    @Test
    void TermoTimer() {
        Termostato t = new Termostato();
        assertEquals("",t.screenInfo());
        t.setTimer(19);
        t.newTemperature(21);
        t.newTemperature(21);
        t.newTemperature(21);
        t.newTemperature(21);
        assertEquals("Se activa el modo Timer 19 minutos.\n"+
                             "21.0 Modo Timer (faltan 14 minutos) - Calefaccion encendida.\n"+
                             "21.0 Modo Timer (faltan 9 minutos) - Calefaccion encendida.\n"+
                             "21.0 Modo Timer (faltan 4 minutos) - Calefaccion encendida.\n"+
                             "Se desactiva el modo Timer.\n"+
                             "21.0 Modo Off - Calefaccion apagada.\n",t.screenInfo());
    }
    @Test
    void TermoProgram(){
        Termostato t = new Termostato();
        t.screenInfo();
        t.setProgram(20);
        t.newTemperature(21);
        t.newTemperature(19);
        t.newTemperature(22);
        t.newTemperature(18);
        t.newTemperature(20);
        t.setOff();
        t.newTemperature(0);
        assertEquals("Se activa el modo Program a 20.0 grados.\n"+
                             "21.0 Modo Program (a 20.0 grados) - Calefaccion apagada.\n"+
                             "19.0 Modo Program (a 20.0 grados) - Calefaccion encendida.\n"+
                             "22.0 Modo Program (a 20.0 grados) - Calefaccion apagada.\n"+
                             "18.0 Modo Program (a 20.0 grados) - Calefaccion encendida.\n"+
                             "20.0 Modo Program (a 20.0 grados) - Calefaccion apagada.\n"+
                             "Se activa el modo Off.\n"+
                             "0.0 Modo Off - Calefaccion apagada.\n",t.screenInfo());
    }
    @Test
    void TermoErroresPro(){
        Termostato t = new Termostato();
        t.setProgram(20);
        assertThrows(IllegalStateException.class, () -> t.setTimer(20));
    }
    @Test
    void TermoErroresTim(){
        Termostato t = new Termostato();
        t.setTimer(20);
        assertThrows(IllegalStateException.class, () -> t.setProgram(20));
        assertThrows(IllegalArgumentException.class, () -> t.setTimer(-1));
    }
}
