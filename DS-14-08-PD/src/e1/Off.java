package e1;

public class Off extends Modo
{
	private static final Off estado = new Off();

	private Off() { modoName = "Off"; }

	public static Off getInstance() { return estado; }
}
