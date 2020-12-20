package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class ConjuntElem extends ElementEmp
{
	private final List<ElementEmp> components = new ArrayList<>();

	ConjuntElem(String name, String elemType) { super(name, elemType); }

	public void addComp(ElementEmp comp)
	{
		if(!this.equals(comp) && !find(comp, components))
		{
			components.add(comp);
		}
	}

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


	private String getInfo(int ntabs)
	{
		StringBuilder info = new StringBuilder(super.getInfo());

		for(ElementEmp e: components)
		{
			info.append("\t".repeat(ntabs));

			if(e instanceof ConjuntElem)
			{
				info.append(((ConjuntElem) e).getInfo(ntabs+1));
			}
			else if(e instanceof LeafElem)
			{
				info.append(e.getInfo());
			}
			else { throw new ArrayStoreException(); }
		}
		return info.toString();
	}

	@Override
	public String getInfo()
	{
		return getInfo(1);
	}

	private static boolean find(ElementEmp elem, List<ElementEmp> list)
	{
		boolean res = false;

		for(ElementEmp e: list)
		{
			if(e.equals(elem))
			{
				res = true;
			}
			else if(e instanceof ConjuntElem)
			{
				res = res || find(elem, ((ConjuntElem) e).getComponents());
			}
		}
		return res;
	}
}
