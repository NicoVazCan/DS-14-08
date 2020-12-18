package e1;

public class Program extends Modo
{
	private static final Program estado = new Program();
	private static float umbral;

	private Program() {  modoName = "Program"; }

	public static Program getInstance() { return estado; }

	public static void setUmbral(float umbral)
	{
		Program.umbral = umbral;
	}

	@Override
	public String cambiarModo(Termostato term)
	{
		if(term.getModo() instanceof Timer)
		{
			throw new IllegalStateException();
		}
		else
		{
			return "Se activa el modo " + modoName + " a " + umbral + " grados .";
		}
	}

	@Override
	public String impEstado(Termostato term)
	{
		term.setEstado(term.getCurrentTemperature() < umbral? Estado.ON: Estado.OFF);

		return term.getCurrentTemperature() + "Modo " + modoName +
						" (a " + umbral + " grados) - " + term.getEstado().getText() + ".\n";
	}
}
