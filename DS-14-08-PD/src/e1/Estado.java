package e1;

public enum Estado
{
	ON("Calefaccion encendida"), OFF("Calefaccion apagada");

	private final String text;

	Estado(String text)
	{
		this.text = text;
	}
	public String getText()
	{
		return text;
	}
}