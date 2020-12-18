package e1;

public class Timer extends Modo
{
	private static final Timer modo = new Timer();
	private static int time;

	private Timer()
	{
		modoName = "Timer";
		estado = Estado.ON;
	}

	public static Timer getInstance() { return modo; }

	public static void setTime(int time)
	{
		if(time <= 0)
		{
			throw new IllegalArgumentException();
		}
		else { Timer.time = time; }
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
			return term.getCurrentTemperature() + " Modo " + modoName +
							" (faltan " + time + " minutos) - " + estado.getText() + ".\n";
		}
		else
		{
			term.setEstado(Estado.OFF);
			term.setModo(Off.getInstance());
			return "Se desactiva el modo " + modoName + ".\n" +
							term.getModo().impEstado(term);
		}
	}
}
