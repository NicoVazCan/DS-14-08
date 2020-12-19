package e1;

public class Program extends Modo
{
	private static final Program modo = new Program();
	private static float umbral;

	private Program() { super("Program", Estado.OFF); }

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
			term.setEstado(term.getCurrentTemperature() < umbral? Estado.ON: Estado.OFF);
			term.setModo(this);
			return "Se activa el modo " + getModoName() + " a " + umbral + " grados.\n";
		}
	}

	@Override
	public String impEstado(Termostato term)
	{
		Estado actual = term.getCurrentTemperature() < umbral? Estado.ON: Estado.OFF;

		super.setEstado(actual);
		term.setEstado(actual);
		return term.getCurrentTemperature() + " Modo " + getModoName() +
						" (a " + umbral + " grados) - " + actual.getText() + ".\n";
	}
}
