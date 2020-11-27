package e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


class MatrixTest
{

	@Test
	void CrearMatriz()
	{
        int filas=3,columnas=4,dato=22;
        int filabuscar=0,columnabuscar=0;

        Matrix test1 = new Matrix(filas,columnas);
        assertEquals(test1.StringMatriz(), "[0 ,0 ,0 ,0]\n" +
                                                 "[0 ,0 ,0 ,0]\n" +
                                                 "[0 ,0 ,0 ,0]\n");

        test1.setCelda(dato,1,1);
        assertEquals(test1.getCelda(1, 1), dato);
        test1.setCelda(1,0,0);
        test1.setCelda(2,0,1);
        test1.setCelda(3,1,0);
        assertEquals(test1.StringMatriz(), "[1 ,2 ,0 ,0]\n" +
                                                 "[3 ,22 ,0 ,0]\n" +
                                                 "[0 ,0 ,0 ,0]\n");
        assertEquals(test1.getColumnas(), columnas);
        assertEquals(test1.getFilas(), filas);
        assertEquals(Arrays.toString(test1.getColum(columnabuscar)),"[1, 3, 0]");
        assertEquals(Arrays.toString(test1.getFila(filabuscar)),"[1, 2, 0, 0]");

        Matrix test2 = new Matrix(test1.getMatriz());
        assertEquals(test2.StringMatriz(), "[1 ,2 ,0 ,0]\n" +
                                                 "[3 ,22 ,0 ,0]\n" +
                                                 "[0 ,0 ,0 ,0]\n");

        assertThrows(IndexOutOfBoundsException.class, () -> new Matrix(0,0));
        assertThrows(IndexOutOfBoundsException.class, () -> test1.getCelda(filas+1,columnas+1));
        assertThrows(IndexOutOfBoundsException.class, () -> test1.setCelda(dato,filas+1,columnas+1));
        assertThrows(IndexOutOfBoundsException.class, () -> test1.getColum(columnas+1));
        assertThrows(IndexOutOfBoundsException.class, () -> test1.getFila(filas+1));

	}
	@Test
    void Iteradores(){
        int filas=3,columnas=4,dato=22;

        Matrix test1 = new Matrix(filas,columnas);
        test1.setCelda(dato,1,1);
        test1.setCelda(1,0,0);
        test1.setCelda(2,0,1);
        test1.setCelda(3,1,0);

        test1.NexIteradorPrimeroFilas(true);
        int n=0;
        int [] Cons = new int [filas*columnas];
        for (Object o : test1) {
                int celda = (int) o;
                Cons [n] = celda;
                n++;
        }
        assertEquals(Arrays.toString(Cons),"[1, 2, 0, 0, 3, 22, 0, 0, 0, 0, 0, 0]");

        test1.NexIteradorPrimeroFilas(false);
        n=0;
        for (Object o : test1) {
                int celda = (int) o;
                Cons [n] = celda;
                n++;
        }
        assertEquals(Arrays.toString(Cons),"[1, 3, 0, 2, 22, 0, 0, 0, 0, 0, 0, 0]");
        Iterator M1 = new RowColumnIterator(test1.data);
        assertThrows(UnsupportedOperationException.class, M1::remove);
        Iterator M2 = new ColumnRowIterator(test1.data);
        assertThrows(UnsupportedOperationException.class, M2::remove);
	}
	@Test
        void suma(){
            int filas=3,columnas=4,dato=22;

            Matrix test1 = new Matrix(filas,columnas);
            test1.setCelda(dato,1,1);
            test1.setCelda(1,0,0);
            test1.setCelda(2,0,1);
            test1.setCelda(3,1,0);
            Matrix test2 = new Matrix(test1.getMatriz());
            MatrixAddition ma = new MatrixAddition();

            assertEquals(ma.sumar(test1,test2).StringMatriz(),"[2 ,4 ,0 ,0]\n" +
                    "[6 ,44 ,0 ,0]\n" +
                    "[0 ,0 ,0 ,0]\n");
            Matrix test3 = new Matrix(filas+1,columnas+1);

            assertThrows(ArithmeticException.class, () -> ma.sumar(test3,test2));
    }
}