package e1;

public abstract class Modo
{
	String modoName;

	public String cambiarModo(Termostato term, Modo nextModo)
	{
		term.setModo(nextModo);
		return "Se activa el modo " + nextModo.modoName + ".\n";
	}

	public String impEstado(Termostato term)
	{
		return term.currentTemperature + "Modo " + modoName + " - " + term.estado.getText() + ".\n";
	}
}
