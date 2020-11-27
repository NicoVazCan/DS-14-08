package e2;

import java.util.Arrays;
import java.util.Iterator;


public class Matrix implements Iterable{

    public int [][] data;
    private final int filas, columnas;
    public static boolean filocol=true;

    public Matrix(int fil, int col) {
        if(col>0&&fil>0) {
            this.columnas = col;
            this.filas = fil;
            data = new int[fil][col];
            for (int i = 0; i < fil; i++)
                for (int j = 0; j < col; j++)
                    data[i][j] = 0;
        }
        else throw new IndexOutOfBoundsException();
    }
    public boolean Rectangular(int[][] data){
        int columnas = data[0].length;
        for(int i=1;i<data.length;i++){
            if(columnas!=data[i].length)return false;
        }
        return true;
    }
    public Matrix(int[][] data) {
        int filas = data.length;
        int columnas = data[0].length;
        if(columnas!=filas&& Rectangular(data)) {
            this.columnas=columnas;
            this.filas=filas;
            this.data = new int[filas][columnas];
            for (int i = 0; i < filas; i++){
                System.arraycopy(data[i], 0, this.data[i], 0, columnas);
            }
        }
        else throw new IndexOutOfBoundsException();
    }
    public int getFilas() {
        return this.filas;
    }
    public int getColumnas() {
        return this.columnas;
    }
    public void NexIteradorPrimeroFilas(boolean nuevo){
        filocol=nuevo;
    }
    public void setCelda(int o,int fil,int col) {
        if ((col >= 0 && col < columnas)&&(fil >= 0 && fil < filas)){
            this.data[fil][col]=o;
        }
        else throw new IndexOutOfBoundsException();
    }
    public int getCelda(int fil,int col) {
        if ((col >= 0 && col < columnas)&&(fil >= 0 && fil < filas))
            return data[fil][col];
        throw new IndexOutOfBoundsException();
    }
    public int[][] getMatriz() {
        int [][] nueva = new int[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++)
            if (this.columnas >= 0) System.arraycopy(data[i], 0, nueva[i], 0, this.columnas);
        return nueva;
    }
    public int[] getFila(int fil) {
        if (fil >= 0 && fil < this.filas){
            int [] fila = new int[this.columnas];
            if (this.columnas >= 0) System.arraycopy(data[fil], 0, fila, 0, this.columnas);
            return fila;
        }
        throw new IndexOutOfBoundsException();
    }
    public int[] getColum(int col) {
        if (col >= 0 && col < this.columnas){
            int [] columna = new int [this.filas];
            for (int c = 0; c< this.filas; c++)
                columna[c]= data[c][col];
            return columna;
        }
        throw new IndexOutOfBoundsException();
    }
    public String StringMatriz(){
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < this.filas; i++){
            c.append("[");
            for (int j = 0; j < this.columnas; j++) {
                c.append(data[i][j]);
                if(j<this.columnas-1) c.append(" ,");
            }
            c.append("]\n");
        }
        return c.toString();
    }
    public RowColumnIterator rowColumnIterator() {
        return new RowColumnIterator(this.data);
    }

    public Iterator columnRowIterator() {
        return new ColumnRowIterator(this.data);
    }
    @Override
    public Iterator iterator() {
        if (filocol) return rowColumnIterator();
        else return columnRowIterator();
    }

    public static void main(String[]args)
    {
        int filas=3,columnas=4;
        int filabuscar=0,columnabuscar=0;
        Matrix test1 = new Matrix(filas,columnas);
        System.out.println(test1.StringMatriz());
        test1.setCelda(22,2,2);
        System.out.println(test1.StringMatriz());
        test1.setCelda(1,0,0);
        test1.setCelda(2,0,1);
        test1.setCelda(3,0,2);
        test1.setCelda(1,1,0);
        test1.setCelda(1,2,0);
        System.out.println(test1.StringMatriz());
        System.out.println("Celda 2,2 = "+test1.getCelda(2,2));
        System.out.println("Columnas = "+test1.getColumnas());
        System.out.println("Filas = "+test1.getFilas());

        System.out.println("Columna"+(columnabuscar+1)+":");
        System.out.println(Arrays.toString(test1.getColum(filabuscar)));

        System.out.println("Fila"+(filabuscar+1)+":");
        System.out.println(Arrays.toString(test1.getFila(filabuscar)));


        System.out.println("Matriz1:");
        for (int i = 0; i < filas; i++){
            System.out.println("Fila"+(i+1)+":");
            for (int j = 0; j < columnas; j++)
                System.out.println(test1.getMatriz()[i][j]);
        }

        System.out.println("paptata");

        Matrix test2 = new Matrix(test1.getMatriz());
        System.out.println(test2.StringMatriz());
        System.out.println("Matriz2:");
        for (int i = 0; i < filas; i++){
            System.out.println("Fila"+(i+1)+":");
            for (int j = 0; j < columnas; j++)
                System.out.println(test2.getMatriz()[i][j]);
        }

        System.out.println("Iterador 1");
        test1.NexIteradorPrimeroFilas(true);
        int celda1f=0,celda1c=-1;
        for (Object o : test1) {
            int celda = (int) o;
            if (celda1c != columnas - 1)
                celda1c++;
            else {
                celda1c = 0;
                celda1f++;
            }
            System.out.print(test1.getCelda(celda1f, celda1c)+ " ");
            System.out.println(celda);
        }

        System.out.println("");
        System.out.println("Iterador 2");
        test1.NexIteradorPrimeroFilas(false);
        int celda2f=-1,celda2c=0;
        for (Object o : test1) {
            int celda = (int) o;
            if (celda2f != filas - 1)
                celda2f++;
            else {
                celda2f = 0;
                celda2c++;
            }
            System.out.print(test1.getCelda(celda2f, celda2c)+ " ");
            System.out.println(celda);
        }
        System.out.println("");

        MatrixAddition ma = new MatrixAddition();

        if(ma.Posible(test1,test1)) System.out.println(ma.sumar(test1,test2).StringMatriz());
        else System.out.println("No posible");

    }
}
