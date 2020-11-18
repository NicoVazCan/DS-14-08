package e1;

import java.util.ArrayList;

public class ArrayPila<T> implements Pila<T>
{
	private ArrayList<T> pila = new ArrayList();
	public int length = pila.size();

	public void apilar(T element)
	{
		pila.add(element);
	}

	public T mostrar()
	{
		return pila.get(length - 1);

	}

	public void quitar()
	{
		pila.remove(length - 1);
	}

	public boolean isEmpty()
	{
		return length == 0;
	}
}
