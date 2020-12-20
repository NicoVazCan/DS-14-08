package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProyectosTest {

    @Test
    void proyecto() {
        Proyecto p1 = new Proyecto("Practica.1");
        Equipo e1 = new Equipo("Ejer.1");
        Equipo e2 = new Equipo("Ejer.2");
        Trabajador d = new Trabajador("Diego", 20,10);
        Trabajador n = new Trabajador("Nicolas",10,20);
        assertEquals(10*20,n.getCost());
        assertEquals(10,d.getHoras());
        assertEquals("Worker Diego: 10 hours, 200 €\n",d.getInfo());
        assertEquals("Team Ejer.1: 0 hours, 0 €\n",e1.getInfo());
        e1.addComp(d);
        e2.addComp(n);
        assertEquals("Team Ejer.1: 10 hours, 200 €\n" +
                           "\tWorker Diego: 10 hours, 200 €\n",e1.getInfo());
        assertEquals("Team Ejer.2: 20 hours, 200 €\n" +
                           "\tWorker Nicolas: 20 hours, 200 €\n",e2.getInfo());
        e1.addComp(n);
        assertEquals("Team Ejer.1: 30 hours, 400 €\n" +
                           "\tWorker Diego: 10 hours, 200 €\n" +
                           "\tWorker Nicolas: 20 hours, 200 €\n",e1.getInfo());

        assertEquals(10*20*2,e1.getCost());
        assertEquals(30,e1.getHoras());

        e1.removeComp(n);
        assertEquals("Team Ejer.1: 10 hours, 200 €\n" +
                          "\tWorker Diego: 10 hours, 200 €\n",e1.getInfo());
        p1.addComp(e1);
        p1.addComp(e2);
        Trabajador x = new Trabajador("x",10,10);
        p1.addComp(n);
        p1.addComp(x);
        assertEquals("Project Practica.1: 40 hours, 500 €\n" +
                           "\tTeam Ejer.1: 10 hours, 200 €\n"+
                           "\t\tWorker Diego: 10 hours, 200 €\n"+
                           "\tTeam Ejer.2: 20 hours, 200 €\n"+
                           "\t\tWorker Nicolas: 20 hours, 200 €\n"+
                           "\tWorker x: 10 hours, 100 €\n",p1.getInfo());
        assertEquals(500,p1.getCost());
        assertEquals(40,p1.getHoras());
        p1.removeComp(x);
        p1.removeComp(e1);

        List<LeafElem> personal = new ArrayList<>();
        personal.add(d);
        personal.add(n);

        assertTrue(personal.containsAll(p1.getComps(p1)));
        assertTrue(personal.containsAll(e1.getComps(p1)));
        assertTrue(personal.containsAll(e2.getComps(p1)));
        assertTrue(personal.containsAll(d.getComps(p1)));
        assertTrue(personal.containsAll(n.getComps(p1)));

        assertThrows(IllegalArgumentException.class, () -> new Proyecto("Practica.1"));
        assertThrows(IllegalArgumentException.class, () -> new Equipo("Ejer.1"));
        assertThrows(IllegalArgumentException.class, () -> new Trabajador("Diego", 20,10));
    }
}
