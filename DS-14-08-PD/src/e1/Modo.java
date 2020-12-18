package e1;

public abstract class Modo
{
	String modoName;

	public String cambiarModo(Termostato term)
	{
		term.setModo(this);
		return "Se activa el modo " + modoName + ".\n";
	}

	public String impEstado(Termostato term)
	{
		return term.getCurrentTemperature() + "Modo " + modoName + " - " + term.getEstado().getText() + ".\n";
	}
}
