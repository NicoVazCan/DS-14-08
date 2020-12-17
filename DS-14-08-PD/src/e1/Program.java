package e1;

public class Program extends Modo
{
	private static final Program estado = new Program();
	private static float umbral = 20;

	private Program() {  modoName = "Program"; }

	public static Program getInstance() { return estado; }

	public static void setUmbral(float umbral)
	{
		Program.umbral = umbral;
	}

	@Override
	public String cambiarModo(Termostato term, Modo nextModo)
	{
		if(nextModo instanceof Timer)
		{
			throw new IllegalStateException();
		}
		else { return super.cambiarModo(term, nextModo); }
	}

	@Override
	public String impEstado(Termostato term)
	{
		term.estado = term.currentTemperature < umbral? Estado.ON: Estado.OFF;

		return term.currentTemperature + "Modo " + modoName + " (a " + umbral + " grados) - " + term.estado.getText() + ".\n";
	}
}
