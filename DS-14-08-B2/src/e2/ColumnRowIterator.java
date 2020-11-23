package e2;
//comentario inutil
import java.util.Iterator;

public class ColumnRowIterator implements Iterator {
    public static int PosCol;
    public static int PosFil;

    public ColumnRowIterator() {
        PosFil = 0;
        PosCol = 0;
    }

    @Override
    public boolean hasNext() {
        return !((PosCol == Matriz.data[0].length) && (PosFil == 0));
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            int celda = Matriz.data[PosFil][PosCol];

            if (PosFil != Matriz.data.length-1) // Si no es final de columna.
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
