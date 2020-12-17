package e2;

public abstract class ElementEmp
{
	private final String name;

	ElementEmp(String name) { this.name = name; }

	public abstract int getCost();

	public abstract int getHoras();

	public String getInfo()
	{
		return this.getElemType() +
						this.name + ": " +
						this.getHoras() + " hours, " +
						this.getCost() + " €\n";
	}

	public abstract String getComps();

	public abstract String getElemType();
}
