package e1;

public class Manual extends Modo
{
	private static final Manual modo = new Manual();

	private Manual()
	{
		super("Manual", Estado.ON);
	}

	public static Manual getInstance() { return modo; }
}
