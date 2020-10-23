package e4;

public class TrafficJunction
{
	private static final EnuSemaf[] enuSemaf = EnuSemaf.values();
	private static final EnuColor[] enuColor = EnuColor.values();
	private static final int entMAXSEM = 4;

	private static int entTemp;
	private static int entTempColor;
	private static boolean bolParpadeo;
	private static Semaforo[] claSemaforos = new Semaforo[entMAXSEM];


	public TrafficJunction()
	{
		entTemp = 0;
		bolParpadeo = false;

		for(int entK = 0; entK < entMAXSEM; entK++)
		{
			claSemaforos[entK] = new Semaforo(entK);
		}
	}

	public void timesGoesBy()
	{
		int entAuxTemp;

		if(!bolParpadeo)
		{
			if(entTemp < 87)
			{
				entTemp++;
			}
			else
			{
				ReIniciar();
			}
		}

		for(int entK = 0; entK < entMAXSEM && !bolParpadeo; entK++)
		{
			entAuxTemp = entTemp - enuSemaf[entK].recivirTiempo();

			for(int entL = 0; entL < enuColor.length; entL++)
			if(entAuxTemp == enuColor[entL].recivirTiempo())
			{
				claSemaforos[entK].cambiarColor(enuColor[entL]);
			}
			if(entAuxTemp >= 0)
			{
				if(entAuxTemp < EnuColor.AMBER.recivirTiempo())
				{
					entTempColor = entAuxTemp;
				}
				else
				{
					entTempColor = entAuxTemp - EnuColor.AMBER.recivirTiempo();
				}
			}
		}
	}

	public void amberJunction(boolean active)
	{
		bolParpadeo = active;

		if(bolParpadeo)
		{
			for(int entK = 0; entK < entMAXSEM; entK++)
			{
				claSemaforos[entK].cambiarColor(EnuColor.AMBER);
			}
		}
		else
		{
			ReIniciar();
		}
	}

	@Override
	public String toString()
	{
		String stgResult = new String();

		for(int entK = 0; entK < entMAXSEM; entK++)
		{
			stgResult += "[" + enuSemaf[entK].toString() + ": ";

			if(claSemaforos[entK].recivirColor().equals(EnuColor.RED.name()))
			{
				stgResult += EnuColor.RED.name();
			}
			else
			{
				if(bolParpadeo)
				{
					stgResult += EnuColor.AMBER.name() + " ON";
				}
				else
				{
					if(claSemaforos[entK].recivirColor().equals(EnuColor.GREEN.name()))
					{
						stgResult += EnuColor.GREEN.name();
					}
					else
					{
						stgResult += EnuColor.AMBER.name() + " OFF";
					}
					stgResult += " " + entTempColor;
				}
			}
			stgResult += "]";

		}
		return(stgResult);
	}

	private void ReIniciar()
	{
		entTemp = 0;

		for(int entK = 0; entK < entMAXSEM; entK++)
		{
			if(entK == EnuSemaf.NORTH.recivirTiempo())
			{
				claSemaforos[entK].cambiarColor(EnuColor.GREEN);
			}
			else
			{
				claSemaforos[entK].cambiarColor(EnuColor.RED);
			}
		}
	}
}