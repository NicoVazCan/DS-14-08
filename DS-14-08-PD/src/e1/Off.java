package e1;

public class Off extends Modo
{
	private static final Off modo = new Off();

	private Off()
	{
		modoName = "Off";
		estado = Estado.OFF;
	}

	public static Off getInstance() { return modo; }
}
