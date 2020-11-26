package e2;

import java.util.Iterator;

public class MatrixAddition
{
	public static Matriz sumar(Matriz m1, Matriz m2)
	{
		Matriz suma;
		Iterator iterM1 = m1.iterator();
		Iterator iterM2 = m2.iterator();
		Iterator iterMS;
		int fil1 = m1.getFilas(), fil2 = m2.getFilas(),
		    col1 = m1.getColumnas(), col2 = m2.getColumnas(),
				n1 ,n2;

		if(fil1 == fil2 && col1 == col2)
		{
			suma = new Matriz(fil1, fil2);
			iterMS = suma.iterator();

			while(iterM1.hasNext())
			{
				n1 = (int) iterM1.next();
				n2 = (int) iterM2.next();
				Object aux = iterMS.next();

				aux = (Object) (n1 + n2);
			}
			return suma;
		}
		throw  new ArithmeticException();
	}

	public static void main(String[] args)
	{
		//int[][] a1 = {{1,2,3},{4,5,6}}, a2 = {{2,5,1},{4,2,7}};
		int aux;
		Matriz m1 = new Matriz(2,2), m2 = new Matriz(2,2), ms;
		m1.setCelda(1,0,0);
		m1.setCelda(2,1,0);
		m1.setCelda(3,0,1);
		m1.setCelda(4,1,1);

		m2.setCelda(2,0,0);
		m2.setCelda(3,1,0);
		m2.setCelda(4,0,1);
		m2.setCelda(5,1,1);

		aux = m1.getCelda(0,0);

		ms = sumar(m1, m2);
		System.out.println(ms.StringMatriz());
	}
}
