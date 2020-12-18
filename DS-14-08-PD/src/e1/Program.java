package e1;

public class Program extends Modo
{
	private static final Program modo = new Program();
	private static float umbral;

	private Program() {  modoName = "Program"; }

	public static Program getInstance() { return modo; }

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
			return "Se activa el modo " + modoName + " a " + umbral + " grados .\n";
		}
	}

	@Override
	public String impEstado(Termostato term)
	{
		estado = term.getCurrentTemperature() < umbral? Estado.ON: Estado.OFF;

		term.setEstado(estado);
		return term.getCurrentTemperature() + " Modo " + modoName +
						" (a " + umbral + " grados) - " + estado.getText() + ".\n";
	}
}
