package e1;

public enum Estado
{
	ON("Calefaccion apagada"), OFF("Calefaccion encendida");

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