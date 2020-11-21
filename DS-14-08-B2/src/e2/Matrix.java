package e2;

import e1.Razas;
import e1.ShadowsOfTheMordor;

public class Matrix {
    public static void main(String[]args)
    {
        Matriz test = new Matriz(3,3);
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
        System.out.println("Colum1.1 = "+test.getColum(0)[0]);
        System.out.println("Colum1.2 = "+test.getColum(0)[1]);
        System.out.println("Colum1.3 = "+test.getColum(0)[2]);
        System.out.println("Fila1.1 = "+test.getFila(0)[0]);
        System.out.println("Fila1.2 = "+test.getFila(0)[1]);
        System.out.println("Fila1.3 = "+test.getFila(0)[2]);
        System.out.println(test.getMatriz()[0][0]+" "+test.getMatriz()[0][1]+" "+test.getMatriz()[0][2]);
        System.out.println(test.getMatriz()[1][0]+" "+test.getMatriz()[1][1]+" "+test.getMatriz()[1][2]);
        System.out.println(test.getMatriz()[2][0]+" "+test.getMatriz()[2][1]+" "+test.getMatriz()[2][2]);
    }
}
class Matriz{

    private int [][] data;
    private int filas, columnas;

    public Matriz(int col, int fil) {
        this.columnas=col;
        this.filas=fil;
        this.data = new int[col][fil];
        for (int i = 0; i < col; i++)
            for (int j = 0; j < fil; j++)
                this.data[i][j] = 0;
    }
    public Matriz(int[][] data) {
        int columnas = data.length;
        int filas = data[0].length;
        if(columnas!=filas)
            this.data = new int[columnas][filas];
            for (int i = 0; i < columnas; i++)
                for (int j = 0; j < filas; j++)
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
            data[col][fil]=o;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }
    public int getCelda(int fil,int col) {
        if ((col >= 0 && col < columnas)&&(fil >= 0 && fil < filas))
            return data[col][fil];
        throw new IndexOutOfBoundsException();
    }
    public int[][] getMatriz() {
        int [][] nueva = new int[this.columnas][this.filas];
        for (int i = 0; i < this.columnas; i++)
            for (int j = 0; j < this.filas; j++)
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
}