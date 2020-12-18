package e2;

public abstract class LeafElem extends ElementEmp
{
	private final int CPH;
	private int horas;

	LeafElem(String name, int CPH, int horas, String elemType)
	{
		super(name, elemType);
		this.CPH = CPH;
		this.horas = horas;
	}

	@Override
	public int getCost() { return CPH*horas; }

	@Override
	public int getHoras() { return horas; }
}
