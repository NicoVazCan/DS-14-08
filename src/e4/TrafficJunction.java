package e4;

public class TrafficJunction
{
	/**
	 * Creates a traffic junction with four traffic lights named north , south ,
	 * east and west . The north traffic light has just started its green cycle .
	 */
	private static int entTiempo;
	private static boolean bolParpadeo = false;
	private static final String[] arySEMAFOROS = {"NORTH", "SOUTH", "EAST", "WEST"};

	private enum Semaforo
	{
		NORTH(0), SOUTH(22), EAST(44), WEST(66);

		private int entRetraso;

		Semaforo(int entRetraso)
		{
			this.entRetraso = entRetraso;
		}
		public int getRetraso()
		{
			return entRetraso;
		}
	}

	private enum Color
	{
		GREEN(0), AMBER(16), RED(22);

		private int entTiempo;

		Color(int entTiempo)
		{
			this.entTiempo = entTiempo;
		}
		public int getColor()
		{
			return entTiempo;
		}
	}

	public TrafficJunction()
	{
		entTiempo = 0;
	}


	/**
	 * Indicates that a second of time has passed , so the traffic light with
	 * the green or amber light should add 1 to its counter . If the counter
	 * passes its maximum value the color of the traffic light must change .
	 * If it changes to red then the following traffic light changes to green .
	 * The order is : north , south , east , west and then again north .
	 */
	public void timesGoesBy()
	{
		if(entTiempo < 87)
		{
			entTiempo++;
		}
		else
		{
			entTiempo = 0;
		}
	}

	/**
	 * If active is true all the traffic lights of the junction must change to
	 * blinking amber ( meaning a non - controlled junction ).
	 * If active is false it resets the traffic lights cycle and started again
	 * with north at green and the rest at red .
	 *
	 * @param active true or false
	 */
	public void amberJunction(boolean active)
	{
		bolParpadeo = active;
		entTiempo = 0;
	}

	/**
	 * Returns a String with the state of the traffic lights .
	 * The format for each traffic light is the following :
	 * - For red colors : "[ name : RED ]"
	 * - For green colors : "[ name : GREEN counter ]"
	 * - For yellow colors with blink at OFF : "[ name : YELLOW OFF counter ]
	 * - For yellow colors with blink at ON : "[ name : YELLOW ON ]
	 * Examples :
	 * [ NORTH : GREEN 2][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
	 * [ NORTH : AMBER OFF 5][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
	 * [ NORTH : AMBER ON ][ SOUTH : AMBER ON ][ EAST : AMBER ON ][ WEST : AMBER ON ]
	 *
	 * @return String that represents the state of the traffic lights
	 */
	@Override
	public String toString()
	{
		String stgResultado = new String();
		int entAuxTemp;

		for(int entS = 0; entS <= 3; entS++)
		{
			if(!bolParpadeo)
			{
				entAuxTemp = Semaforo.valueOf(arySEMAFOROS[entS]).getRetraso();
				if(entTiempo >= entAuxTemp && entTiempo <= entAuxTemp+21)
				{
					entAuxTemp = entTiempo - entAuxTemp;
					if(entAuxTemp < Color.AMBER.getColor())
					{
						stgResultado += "[" + arySEMAFOROS[entS] + ": GREEN " + (entAuxTemp - Color.GREEN.getColor()) + "]";
					}
					else if(entAuxTemp < Color.RED.getColor())
					{
						stgResultado += "[" + arySEMAFOROS[entS] + ": AMBER OFF " + (entAuxTemp - Color.AMBER.getColor()) + "]";
					}
				}
				else
				{
					stgResultado += "[" + arySEMAFOROS[entS] + ": RED]";
				}
			}
			else
			{
				stgResultado += "[" + arySEMAFOROS[entS] + ": AMBER ON]";
			}
		}
		return(stgResultado);
	}
}