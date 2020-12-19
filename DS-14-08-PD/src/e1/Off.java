package e1;

public class Off extends Modo
{
	private static final Off modo = new Off();

	private Off() { super("Off", Estado.OFF); }

	public static Off getInstance() { return modo; }
}
