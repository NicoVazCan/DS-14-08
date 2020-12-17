package e1;

import static e1.Estado.*;

public class Termostato
{
	public Estado estado = OFF;
	private Modo modo = Off.getInstance();
	public float currentTemperature;
	private StringBuilder log = new StringBuilder();

	void setOff()
	{
		this.estado = OFF;
		modo.cambiarModo(this, Off.getInstance());
	}

	void setManual()
	{
		this.estado = ON;
		modo.cambiarModo(this, Manual.getInstance());
	}

	void setTimer(int time)
	{
		this.estado = ON;
		Timer.setTime(time);
		modo.cambiarModo(this, Timer.getInstance());

	}

	void setProgram(float umbral)
	{
		Program.setUmbral(umbral);
		modo.cambiarModo(this, Program.getInstance());
	}
	
	void screenInfo()
	{
		System.out.println(log.toString());
	}

	void newTemperature(float currentTemperature)
	{
		this.currentTemperature = currentTemperature;
		log.append(modo.impEstado(this));
	}

	void setModo(Modo modo)
	{
		this.modo = modo;
	}
}
