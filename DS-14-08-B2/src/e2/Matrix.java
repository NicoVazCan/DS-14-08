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
                this.data[i]=Arrays.copyOf(data[i], columnas);
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
            if (this.columnas >= 0) nueva[i]=Arrays.copyOf(data[i], this.columnas);
        return nueva;
    }
    public int[] getFila(int fil) {
        if (fil >= 0 && fil < this.filas){
            int [] fila = new int[this.columnas];
            if (this.columnas >= 0) fila=Arrays.copyOf(data[fil], this.columnas);
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
    public String stringMatriz(){
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < this.filas; i++){
            c.append(Arrays.toString(data[i]));
            c.append("\n");
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
}
