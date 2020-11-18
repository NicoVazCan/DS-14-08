package e1;

public enum Razas
{
	ElFO(true) {public Personaje crear(String name, int hp, int dp) {return new Elfo(name, hp, dp);} },
	HOBBIT(true) {public Personaje crear(String name, int hp, int dp) {return new Hobbit(name, hp, dp);} },
	HUMANO(true) {public Personaje crear(String name, int hp, int dp) {return new Humano(name, hp, dp);} },
	ORCO(false) {public Personaje crear(String name, int hp, int dp) {return new Orco(name, hp, dp);} },
	TRASGO(false) {public Personaje crear(String name, int hp, int dp) {return new Trasgo(name, hp, dp);} };

	private boolean heroe;

	Razas(boolean heroe)
	{
		this.heroe = heroe;
	}

	public boolean esHeroe()
	{
		return heroe;
	}

	public abstract Personaje crear(String name, int hp, int dp);
}
