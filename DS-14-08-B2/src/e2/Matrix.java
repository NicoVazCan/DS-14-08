package e2;

import java.util.Iterator;

public class Matrix {
    public static void main(String[]args)
    {
        int filas=4,columnas=4;
        int filabuscar=0,columnabuscar=0;
        Matriz test = new Matriz(filas,columnas);
        System.out.println(test.tremendoString());
        test.setCelda(22,2,2);
        System.out.println(test.tremendoString());
        test.setCelda(1,0,0);
        test.setCelda(2,0,1);
        test.setCelda(3,0,2);
        test.setCelda(1,1,0);
        test.setCelda(1,2,0);
        System.out.println(test.tremendoString());
        System.out.println("Celda 2,2 = "+test.getCelda(2,2));
        System.out.println("Columnas = "+test.getColumnas());
        System.out.println("Filas = "+test.getFilas());
        System.out.println("");

        System.out.println("Columna"+(columnabuscar+1)+":");
        for (int c = 0; c< filas; c++)
            System.out.println(test.getColum(columnabuscar)[c]);
        System.out.println("");

        System.out.println("Fila"+(filabuscar+1)+":");
        for (int f = 0; f< columnas; f++)
            System.out.print(test.getFila(filabuscar)[f]);
        System.out.println("");
        System.out.println("");

        System.out.println("Matriz1:");
        for (int i = 0; i < filas; i++){
            System.out.println("Fila"+(i+1)+":");
            for (int j = 0; j < columnas; j++)
                System.out.println(test.getMatriz()[i][j]);
        }

        System.out.println("Papaya");
        Iterator it = test.iterator();
        while (it.hasNext()) {
            int celda = (int) it.next();
            System.out.print(celda+" ");
        }
        System.out.println("");
    }
}
class Matriz implements Iterable{

    public static int [][] data;
    private int filas, columnas;

    public Matriz(int fil, int col) {
        this.columnas=col;
        this.filas=fil;
        this.data = new int[fil][col];
        for (int i = 0; i < fil; i++)
            for (int j = 0; j < col; j++)
                this.data[i][j] = 0;
    }
    public Matriz(int[][] data) {
        int columnas = data.length;
        int filas = data[0].length;
        if(columnas!=filas)
            this.data = new int[filas][columnas];
            for (int i = 0; i < filas; i++)
                for (int j = 0; j < columnas; j++)
                    this.data[i][j] = data[i][j];
        throw new IndexOutOfBoundsException();
    }
    public int getFilas() {
        return this.filas;
    }
    public int getColumnas() {
        return this.columnas;
    }
    public boolean setCelda(int o,int fil,int col) {
        if ((col >= 0 && col < columnas)&&(fil >= 0 && fil < filas)){
            data[fil][col]=o;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }
    public int getCelda(int fil,int col) {
        if ((col >= 0 && col < columnas)&&(fil >= 0 && fil < filas))
            return data[fil][col];
        throw new IndexOutOfBoundsException();
    }
    public int[][] getMatriz() {
        int [][] nueva = new int[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++)
            for (int j = 0; j < this.columnas; j++)
                nueva[i][j] = this.data[i][j];
        return nueva;
    }
    public int[] getFila(int fil) {
        if (fil >= 0 && fil < this.filas){
            int [] fila = new int[this.columnas];
            for (int f = 0; f< this.columnas; f++)
                fila[f]=this.data[fil][f];
            return fila;
        }
        throw new IndexOutOfBoundsException();
    }
    public int[] getColum(int col) {
        if (col >= 0 && col < this.columnas){
            int [] columna = new int [this.filas];
            for (int c = 0; c< this.filas; c++)
                columna[c]=this.data[c][col];
            return columna;
        }
        throw new IndexOutOfBoundsException();
    }
    public String tremendoString(){
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < this.filas; i++){
            c.append("[");
            for (int j = 0; j < this.columnas; j++) {
                c.append(this.data[i][j]);
                if(j<this.columnas-1) c.append(" ,");
            }
            c.append("]\n");
        }
        return c.toString();
    }
    public Iterator rowColumnIterator() {
        return new RowColumnIterator();
    }

    public Iterator columnRowIterator() {
        return new ColumnRowIterator();
    }
    @Override
    public Iterator iterator() {
        boolean bool = true;
        if (bool) return rowColumnIterator();
        else return columnRowIterator();
    }
}
