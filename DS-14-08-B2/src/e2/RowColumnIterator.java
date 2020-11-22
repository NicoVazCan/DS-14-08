package e2;

import java.util.Iterator;

public class RowColumnIterator implements Iterator {
    public static int PosCol;
    public static int PosFil;

    public RowColumnIterator() {
        PosFil = 0;
        PosCol = 0;
    }

    @Override
    public boolean hasNext() {
        return !((PosCol == 0) && (PosFil == Matriz.data.length));
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            int celda = Matriz.data[PosFil][PosCol];

            if (PosCol != Matriz.data[0].length-1) // Si no es final de línea.
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
