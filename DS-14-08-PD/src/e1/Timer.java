package e1;

public class Timer extends Modo
{
	private static final Timer estado = new Timer();
	private static int time;

	private Timer() { modoName = "Timer"; }

	public static Timer getInstance() { return estado; }

	public static void setTime(int time)
	{
		Timer.time = time;
	}

	@Override
	public String cambiarModo(Termostato term)
	{
		if(term.getModo() instanceof Program)
		{
			throw new IllegalStateException();
		}
		else
		{
			term.setModo(this);
			return "Se activa el modo " + modoName + " " + time + " minutos.\n";
		}
	}

	@Override
	public String impEstado(Termostato term)
	{
		if(time >= 5)
		{
			time -= 5;
			return term.getCurrentTemperature() + "Modo " + modoName +
							" (faltan" + time + "minutos) - " + term.getEstado().getText() + ".\n";
		}
		else
		{
			term.setEstado(Estado.OFF);
			term.setModo(Off.getInstance());
			return "Se desactiva el modo " + time + " .\n";
		}
	}
}
