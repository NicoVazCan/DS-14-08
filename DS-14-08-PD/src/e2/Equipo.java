package e2;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends ElementEmp
{
	private List<ElementEmp> components = new ArrayList<>();

	Equipo(String name)
	{
		super(name);
	}

	public void addComp(ElementEmp comp)
	{
		components.add(comp);
	}

	public void removeComp(ElementEmp comp)
	{
		components.remove(comp);
	}

	@Override
	public int getCost()
	{
		int cost = 0;

		for(ElementEmp e: components)
		{
			cost += e.getCost();
		}
		return cost;
	}

	public int getHoras()
	{
		int horas = 0;

		for(ElementEmp e: components)
		{
			horas += e.getHoras();
		}
		return horas;
	}

	@Override
	public String getInfo()
	{
		StringBuilder info = new StringBuilder(super.getInfo());

		for(ElementEmp e: components)
		{
			info.append("\t");
			info.append(e.getInfo());
		}
		return info.toString();
	}

	@Override
	public String getComps()
	{
		StringBuilder comps = new StringBuilder();

		for(ElementEmp e: components)
		{
			comps.append(e.getInfo());
		}
		return comps.toString();
	}

	@Override
	public String getElemType() { return "Team "; }
}
