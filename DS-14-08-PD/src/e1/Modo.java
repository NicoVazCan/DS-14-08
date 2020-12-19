package e1;

public abstract class Modo
{
	private final String modoName;
	private Estado estado;

	Modo(String modoName, Estado estado)
	{
		this.modoName = modoName;
		this.estado = estado;
	}

	public String getModoName() { return modoName; }

	public Estado getEstado() { return estado; }

	public void setEstado(Estado estado) { this.estado = estado; }

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
