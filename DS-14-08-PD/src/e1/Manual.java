package e1;

public class Manual extends Modo
{
	private static final Manual estado = new Manual();

	private Manual() {  modoName = "Manual"; }

	public static Manual getInstance() { return estado; }
}