package e1;

import static e1.Estado.*;

public class Termostato
{
	private Estado estado = OFF;
	private Modo modo = Off.getInstance();
	private float currentTemperature;
	private StringBuilder log = new StringBuilder();

	public Estado getEstado() { return estado; }

	public void setEstado(Estado estado) { this.estado = estado; }

	public float getCurrentTemperature() { return currentTemperature; }

	public Modo getModo() { return modo; }

	void setModo(Modo modo)
	{
		this.modo = modo;
	}

	void setOff()
	{
		this.estado = OFF;
		modo = Off.getInstance();
		log.append(modo.cambiarModo(this));
	}

	void setManual()
	{
		this.estado = ON;
		modo = Manual.getInstance();
		log.append(modo.cambiarModo(this));
	}

	void setTimer(int time)
	{
		this.estado = ON;
		Timer.setTime(time);
		modo = Timer.getInstance();
		log.append(modo.cambiarModo(this));

	}

	void setProgram(float umbral)
	{
		Program.setUmbral(umbral);
		modo = Program.getInstance();
		log.append(modo.cambiarModo(this));
	}
	
	String screenInfo() { return log.toString(); }

	void newTemperature(float currentTemperature)
	{
		this.currentTemperature = currentTemperature;
		log.append(modo.impEstado(this));
	}
}
