package e2;

public class Proyecto extends ConjuntElem
{
	Proyecto(String name) { super(name, "Project "); }

	@Override
	public void addComp(ElementEmp comp)
	{
		if(!(comp instanceof Proyecto))
		{
			super.addComp(comp);
		}
	}
}
