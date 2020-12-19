package e1;

import static e1.Estado.*;

public class Termostato
{
	private Estado estado = OFF;
	private Modo modo = Off.getInstance();
	private float currentTemperature;
	private final StringBuilder log = new StringBuilder();

	protected void setEstado(Estado estado) { this.estado = estado; }

	protected float getCurrentTemperature() { return currentTemperature; }

	protected Modo getModo() { return modo; }

	protected void setModo(Modo modo) { this.modo = modo; }

	public void setOff()
	{
		log.append(Off.getInstance().cambiarModo(this));
	}

	public void setManual()
	{
		log.append(Manual.getInstance().cambiarModo(this));
	}

	public void setTimer(int time)
	{
		Timer.setTime(time);
		log.append(Timer.getInstance().cambiarModo(this));

	}

	public void setProgram(float umbral)
	{
		Program.setUmbral(umbral);
		log.append(Program.getInstance().cambiarModo(this));
	}

	public Estado getEstado() { return estado; }
	
	public String screenInfo() { return log.toString(); }

	public void newTemperature(float currentTemperature)
	{
		this.currentTemperature = currentTemperature;
		log.append(modo.impEstado(this));
	}
}
