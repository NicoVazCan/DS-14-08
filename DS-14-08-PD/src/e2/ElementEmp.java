package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ElementEmp
{
	private final String name;
	private final String elemType;
	private static final List<ElementEmp> instancias = new ArrayList<>();

	ElementEmp(String name, String elemType)
	{
		this.name = name;
		this.elemType = elemType;

		if(!instancias.contains(this))
		{
			instancias.add(this);
		}
		else { throw new IllegalArgumentException(); }
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

	public static List<LeafElem> getComps(ConjuntElem conj)
	{

		List<LeafElem> personal = new ArrayList<>();
		filter(personal, conj.getComponents());
		return personal;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof ElementEmp)) return false;
		ElementEmp that = (ElementEmp) o;
		return Objects.equals(name, that.name) &&
						Objects.equals(elemType, that.elemType);
	}
}
