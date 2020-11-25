package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MatrixTest
{

	@BeforeEach
	void setUp()
	{
        int filas=3,columnas=4,dato=22;
        int filabuscar=0,columnabuscar=0;
        Matriz test = new Matriz(filas,columnas);
        assertEquals(test.getCelda(1, 1), 0);
        test.setCelda(dato,1,1);
        assertEquals(test.getCelda(1, 1), dato);
        test.setCelda(1,0,0);
        test.setCelda(2,0,1);
        test.setCelda(3,1,0);
        assertEquals(test.getColumnas(), columnas);
        assertEquals(test.getFilas(), filas);
        for (int c = 0; c< filas; c++)
            assertEquals(test.getCelda(c, 0), test.getColum(0)[c]);

        for (int f = 0; f< columnas; f++)
            assertEquals(test.getCelda(f, 0), test.getFila(0)[f]);

        Matriz test2 = new Matriz(test.getMatriz());
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++)
                assertEquals(test2.getCelda(i, j), test.getCelda(i, j));
        }
        /*Iterator it = test.iterator();
        while (it.hasNext()) {
            int celda = (int) it.next();
            System.out.print(celda+" ");
        }
        System.out.println("");*/
	}
	/*@AfterEach
	void tearDown()
	{
	}*/
}