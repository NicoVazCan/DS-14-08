package e2;

public class Trabajador extends ElementEmp
{
	private final int CPH;
	private int horas;


	Trabajador(String name, int CPH, int horas)
	{
		super(name);
		this.CPH = CPH;
		this.horas = horas;
	}

	@Override
	public int getCost() { return CPH*horas; }

	@Override
	public int getHoras() { return horas; }

	@Override
	public String getComps() { return null; }

	@Override
	public String getElemType() { return "Worker "; }
}
