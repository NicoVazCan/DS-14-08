package e2;
//comentario inutil
import java.util.Iterator;

public class RowColumnIterator implements Iterator {
    public int PosCol;
    public int PosFil;
    public int tamañoFil;
    public int tamañoCol;
    public int [][] Datos;


    public RowColumnIterator(int[][] data) {
        PosFil = 0;
        PosCol = 0;
        tamañoCol =data[0].length;
        tamañoFil =data.length;
        Datos = data;
    }

    @Override
    public boolean hasNext() {
        return !((PosCol == 0) && (PosFil == tamañoFil));
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            int celda = Datos[PosFil][PosCol];

            if (PosCol != tamañoCol-1) // Si no es final de línea.
                PosCol++;
            else {
                PosCol=0;
                PosFil++;
            }
            return celda;
        }
        else return null;
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException("No soportado.");
    }

}
