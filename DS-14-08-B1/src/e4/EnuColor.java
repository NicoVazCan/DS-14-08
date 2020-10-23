package e4;

public enum EnuColor
{
	GREEN(0), AMBER(16), RED(22);

	private int entTiempo;

	EnuColor(int entTiempo)
	{
		this.entTiempo = entTiempo;
	}
	public int recivirTiempo()
	{
		return entTiempo;
	}
}
