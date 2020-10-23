package e4;

public enum EnuSemaf
{
	NORTH(0), SOUTH(22), EAST(44), WEST(66);

	private int entTiempo;

	EnuSemaf(int entTiempo)
	{
		this.entTiempo = entTiempo;
	}
	public int recivirTiempo()
	{
		return entTiempo;
	}
}
