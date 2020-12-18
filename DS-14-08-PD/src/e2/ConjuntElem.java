package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class ConjuntElem extends ElementEmp
{
	private List<ElementEmp> components = new ArrayList<>();

	ConjuntElem(String name, String elemType) { super(name, elemType); }

	public void addComp(ElementEmp comp) { components.add(comp); }

	public void removeComp(ElementEmp comp) { components.remove(comp); }

	public List<ElementEmp> getComponents() { return components; }

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

	@Override
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
}
