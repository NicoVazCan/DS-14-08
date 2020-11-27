package e2;

import java.util.Iterator;

public class MatrixAddition {
    public boolean Posible(Matrix m1, Matrix m2){
        if(m1.data.length == m2.data.length && m1.data[0].length == m2.data[0].length){
            return true;
        }
        else throw new ArithmeticException();
    }
    public void sumaFC(){
        
    }
	public static Matrix sumar(Matrix m1, Matrix m2)
	{
		Matrix suma;
		Iterator iterM1 = new RowColumnIterator(m1.data);
		Iterator iterM2 = new RowColumnIterator(m2.data);
		int fil1 = m1.getFilas(), fil2 = m2.getFilas(),
		    col1 = m1.getColumnas(), col2 = m2.getColumnas(),
				n1 ,n2;

		if(fil1 == fil2 && col1 == col2)
		{
			suma = new Matrix(fil1, col2);

			for(int x = 0, y = 0; iterM1.hasNext(); y++)
			{
				n1 = (int) iterM1.next();
				n2 = (int) iterM2.next();
				if(y == col1)
				{
					y = 0;
					x++;
				}

				suma.setCelda((n1 + n2), x, y);
			}
			return suma;
		}
		throw  new ArithmeticException();
	}

	public static void main(String[] args)
	{
		//int[][] a1 = {{1,2,3},{4,5,6}}, a2 = {{2,5,1},{4,2,7}};
		Matrix m1 = new Matrix(2,2), m2 = new Matrix(2,2), ms;
		m1.setCelda(1,0,0);
		m1.setCelda(2,1,0);
		m1.setCelda(3,0,1);
		m1.setCelda(4,1,1);

		m2.setCelda(5,0,0);
		m2.setCelda(6,1,0);
		m2.setCelda(7,0,1);
		m2.setCelda(8,1,1);

		ms = sumar(m1, m2);
		System.out.println(ms.StringMatriz());
	}
}
