package e1;

public abstract class Modo
{
	public String cambiarModo(Termostato term, Modo nextModo)
	{
		term.setModo(nextModo);
		return "Se activa el modo " + nextModo.getModoName() + ".\n";
	}

	public String impEstado(Termostato term)
	{
		return term.currentTemperature + "Modo " + getModoName() + " - " + term.estado.getText() + ".\n";
	}

	private String getModoName()
	{
		String modo = toString();
		int beg = (modo.indexOf('.') + 1),
				end = modo.lastIndexOf('@');

		return modo.substring(beg, end);
	}
}
