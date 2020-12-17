package e1;

import java.util.ArrayList;
import java.util.List;
import static e1.Estado.*;

public class Termostato
{
	public Estado estado;
	private Modo modo;
	public float currentTemperature;
	private List<String> log = new ArrayList<>();

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
		System.out.println(log);
	}

	void newTemperature(float currentTemperature)
	{
		this.currentTemperature = currentTemperature;
		log.add(modo.impEstado(this));
	}

	void setModo(Modo modo)
	{
		this.modo = modo;
	}
}
