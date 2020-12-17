package e1;

public class Timer extends Modo
{
	private static final Timer estado = new Timer();
	private static int time = 15;

	private Timer() { modoName = "Timer"; }

	public static Timer getInstance() { return estado; }

	public static void setTime(int time)
	{
		Timer.time = time;
	}

	@Override
	public String cambiarModo(Termostato term, Modo nextModo)
	{
		if(nextModo instanceof Program)
		{
			throw new IllegalStateException();
		}
		else { return super.cambiarModo(term, nextModo); }
	}

	@Override
	public String impEstado(Termostato term)
	{
		if(time > 0)
		{
			time -= 5;
			return term.currentTemperature + "Modo " + modoName + " (faltan" + time + "minutos) - " + term.estado.getText() + ".\n";
		}
		else { return super.cambiarModo(term, Off.getInstance()); }
	}
}