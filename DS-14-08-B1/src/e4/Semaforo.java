package e4;

public class Semaforo
{
	private EnuColor colLuz;

	Semaforo(int entEntra)
	{
		if(entEntra == EnuSemaf.NORTH.recivirTiempo())
		{
			colLuz = EnuColor.GREEN;
		}
		else
		{
			colLuz = EnuColor.RED;
		}
	}

	public void cambiarColor(EnuColor entLuz)
	{
		this.colLuz = entLuz;
	}

	public String recivirColor()
	{
		return switch(colLuz)
		{
			case GREEN -> EnuColor.GREEN.name();
			case AMBER -> EnuColor.AMBER.name();
			case RED -> EnuColor.RED.name();
		};
	}
}
