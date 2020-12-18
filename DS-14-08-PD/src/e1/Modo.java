package e1;

public abstract class Modo
{
	String modoName;
	Estado estado;

	public String cambiarModo(Termostato term)
	{
		term.setEstado(estado);
		term.setModo(this);
		return "Se activa el modo " + modoName + ".\n";
	}

	public String impEstado(Termostato term)
	{
		return term.getCurrentTemperature() + " Modo " + modoName + " - " + estado.getText() + ".\n";
	}
}
