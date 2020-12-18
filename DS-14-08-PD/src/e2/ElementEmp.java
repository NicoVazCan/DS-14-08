package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementEmp
{
	private final String name;
	private final String elemType;

	ElementEmp(String name, String elemType)
	{
		this.name = name;
		this.elemType = elemType;
	}

	public abstract int getCost();

	public abstract int getHoras();

	public String getInfo()
	{
		return this.elemType +
						this.name + ": " +
						this.getHoras() + " hours, " +
						this.getCost() + " €\n";
	}

	private static void filter(List<LeafElem> to, List<ElementEmp> from)
	{
		for(ElementEmp e: from)
		{
			if(e instanceof ConjuntElem)
			{
				filter(to, ((ConjuntElem) e).getComponents());
			}
			else if(e instanceof LeafElem) { to.add((Trabajador) e); }
			else { throw new ArrayStoreException(); }
		}
	}

	public List<LeafElem> getComps(Proyecto pro)
	{

		List<LeafElem> personal = new ArrayList<>();
		filter(personal, pro.getComponents());
		return personal;
	}
}
