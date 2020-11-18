package e1;

public enum Razas
{
	ElFO(true), HOBBIT(true), HUMANO(true), ORCO(false), TRASGO(false);

	private boolean heroe;

	Razas(boolean heroe)
	{
		this.heroe = heroe;
	}

	public boolean esHeroe()
	{
		return heroe;
	}
}