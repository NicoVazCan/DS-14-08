package e1;

import static e1.Estado.*;

public class Termostato
{
	private Estado estado = OFF;
	private Modo modo = Off.getInstance();
	private float currentTemperature;
	private StringBuilder log = new StringBuilder();

	public void setEstado(Estado estado) { this.estado = estado; }

	public float getCurrentTemperature() { return currentTemperature; }

	public Modo getModo() { return modo; }

	void setModo(Modo modo)
	{
		this.modo = modo;
	}

	void setOff()
	{
		log.append(Off.getInstance().cambiarModo(this));
	}

	void setManual()
	{
		log.append(Manual.getInstance().cambiarModo(this));
	}

	void setTimer(int time)
	{
		Timer.setTime(time);
		log.append(Timer.getInstance().cambiarModo(this));

	}

	void setProgram(float umbral)
	{
		Program.setUmbral(umbral);
		log.append(Program.getInstance().cambiarModo(this));
	}
	
	String screenInfo() { return log.toString(); }

	void newTemperature(float currentTemperature)
	{
		this.currentTemperature = currentTemperature;
		log.append(modo.impEstado(this));
	}
}
