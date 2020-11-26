package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MatrixTest
{

	@Test
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
            assertEquals(test.getCelda(c, columnabuscar), test.getColum(columnabuscar)[c]);

        for (int f = 0; f< columnas; f++)
            assertEquals(test.getCelda(filabuscar, f), test.getFila(filabuscar)[f]);

        Matriz test2 = new Matriz(test.getMatriz());
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++)
                assertEquals(test2.getCelda(i, j), test.getCelda(i, j));
        }
        test.setIterador(true);
        int celda1f=0,celda1c=-1;
        for (Object o : test) {
            int celda = (int) o;
            if (celda1c != columnas - 1)
                celda1c++;
            else {
                celda1c = 0;
                celda1f++;
            }
            assertEquals(test.getCelda(celda1f, celda1c),celda);
        }
        test.setIterador(false);
        int celda2f=-1,celda2c=0;
        for (Object o : test) {
            int celda = (int) o;
            if (celda2f != filas - 1)
                celda2f++;
            else {
                celda2f = 0;
                celda2c++;
            }
            assertEquals(test.getCelda(celda2f, celda2c),celda);
        }
	}
}