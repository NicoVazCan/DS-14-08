package e2;

public class Code
{
	/**
	 * Determines whether a keypad is valid . To do this , it must be a rectangle and
	 * the numbers must follow the alphanumeric sequence indicated . If the array
	 * ( or any of its subarrays ) is null it will be returned false .
	 *
	 * @param keypad The keypad to be analyzed .
	 * @return true if it is valid , false otherwise .
	 */
	public static boolean isKeypadValid(char[][] keypad)
	{
		int entK = 1, entAltu = 0, entLong = 0, entNumLetra = 48;
		char chrAux;
		boolean bolColFil = false;

		if(keypad == null)
		{
			return(false);
		}

		for(int entJ = 0; entJ < keypad.length-1; entJ++)
		{
			if(keypad[entJ] == null || keypad[entJ+1] == null || keypad[entJ].length != keypad[entJ+1].length)
			{
				return(false);
			}
		}

		if(keypad[0][0] == '1')
		{
			if(keypad.length > 1 && keypad[1][0] == '2')
			{
				bolColFil = true;
				entAltu = keypad.length;
				entLong = keypad[0].length;
			}
			else if(keypad[0].length > 1 && keypad[0][1] == '2')
			{
				bolColFil = false;
				entAltu = keypad[0].length;
				entLong = keypad.length;
			}
			else if(keypad.length == 1 && keypad[0].length == 1)
			{
				return(true);
			}
			else
			{
				return(false);
			}
		}
		else
		{
			return(false);
		}

		for(int entX = 0; entX < entLong; entX++)
		{
			for(int entY = 0; entY < entAltu ; entY++)
			{
				chrAux = (char)(entK+entNumLetra);
				if(bolColFil)
				{
					if(keypad[entY][entX] != chrAux)
					{
						return (false);
					}
				}
				else
				{
					if(keypad[entX][entY] != chrAux)
					{
						return (false);
					}
				}
				if(entK == 9)
				{
					entNumLetra = 38;
				}
				else if(entK == 10)
				{
					entNumLetra = 54;
				}
				else if(entK+entNumLetra > 90)
				{
					return(false);
				}
				entK++;
			}
		}
		return(true);
	}

	/**
	 * Checks if an array of movements is valid when obtaining a key on a keypad .
	 * An array of movements is valid if it is formed by Strings that only have the
	 * four capital letters U , D , L and R . If the array of Strings or any of the
	 * Strings is null it will be returned false .
	 *
	 * @param movements Array of Strings representing movements .
	 * @return true if it is valid , false otherwise .
	 */
	public static boolean areMovementsValid(String[] movements)
	{
		int entStrings = 0, entChar = 0;;
		String stgDirecciones = "UDRL", stgAux;

		if(movements != null)
		{
			entStrings = movements.length;
			for(int entS = 0; entS < entStrings; entS++)
			{
				if(movements[entS] != null)
				{
					entChar = movements[entS].length();
					for(int entC = 0; entC < entChar; entC++)
					{
						stgAux = Character.toString(movements[entS].charAt(entC));
						if(stgAux != null && !stgDirecciones.contains(stgAux))
						{
							return(false);
						}
					}
				}
				else
				{
					return(false);
				}
			}
			return (true);
		}
		else
		{
			return(false);
		}
	}

	/**
	 * Given a keypad and an array of movements , it returns a String with the code
	 * resulting from applying the movements on the keypad .
	 *
	 * @param keypad    alphanumeric keypad .
	 * @param movements Array with the different movements to be made for each
	 *                  number of the key .
	 * @return Resulting code .
	 * @throws IllegalArgumentException if the keypad of the movements are invalid .
	 */
	public static String obtainCode(char[][] keypad, String[] movements) throws IllegalArgumentException
	{
		int entAltu = 0, entY = 0, entStings = 0;
		int entLong = 0, entX = 0, entChars = 0;
		String stgResultado = new String();

		if(!isKeypadValid(keypad))
		{
			throw new IllegalArgumentException("Keypad no valido");
		}
		else if(!areMovementsValid(movements))
		{
			throw new IllegalArgumentException("Movimiento no valido");
		}
		else
		{
			entAltu = keypad.length;
			entLong = keypad[0].length;
			entStings = movements.length;

			for(int entS = 0; entS < entStings; entS++)
			{
				entChars = movements[entS].length();
				for(int entC = 0; entC < entChars; entC++)
				{
					switch(movements[entS].charAt(entC))
					{
						case 'U':
							if(entY > 0)
							{
								entY--;
							}
							break;

						case 'D':
							if(entY < entAltu-1)
							{
								entY++;
							}
							break;

						case 'R':
							if(entX < entLong-1)
							{
								entX++;
							}
							break;

						case 'L':
							if(entX > 0)
							{
								entX--;
							}
							break;
					}
				}
				stgResultado += Character.toString(keypad[entY][entX]);;
			}
		}
		return(stgResultado);
	}
}