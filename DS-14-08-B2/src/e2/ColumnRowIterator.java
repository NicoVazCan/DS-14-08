package e2;
//comentario inutil
import java.util.Iterator;

public class ColumnRowIterator implements Iterator {
    public static int PosCol;
    public static int PosFil;
    public static int tamañoFil;
    public static int tamañoCol;
    public static int [][] Datos;

    public ColumnRowIterator(int[][] data) {
        PosFil = 0;
        PosCol = 0;
        tamañoCol =data[0].length;
        tamañoFil =data.length;
        Datos = data;
    }

    @Override
    public boolean hasNext() {
        return !((PosCol == tamañoCol) && (PosFil == 0));
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            int celda = Datos[PosFil][PosCol];

            if (PosFil != tamañoFil-1) // Si no es final de columna.
                PosFil++;
            else {
                PosFil=0;
                PosCol++;
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
