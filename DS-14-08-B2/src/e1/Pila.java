package e1;

public interface Pila<T>
{
	public void apilar(T element);

	public T mostrar();

	public void quitar();

	public boolean isEmpty();
}
