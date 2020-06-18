package Lectura;

import java.io.*;
public class Leer
{
  // Lee una cadea
  public static String leeCadena()
  {
    String sdato = "";
    try
    {
      // Definir un flujo de caracteres de entrada: flujoE
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader flujoE = new BufferedReader(isr);
      
      // Leer. La entrada finaliza al pulsar la tecla Entrar
      sdato = flujoE.readLine();
    }
    catch(IOException e)
    {
      System.err.println("Error: " + e.getMessage());
    }
    return sdato; // devolver el dato tecleado
  }
  
  // Lectura de un dato de tipo short
  public static short leeShort()
  {
    try
    {
      return Short.parseShort(leeCadena());
    }
    catch(NumberFormatException e)
    {
      System.out.println("Error: " + e.getMessage());
	  return Short.MIN_VALUE; // valor más pequeño
    }
  }
  
//Lectura de un dato de tipo short
 public static byte leeByte()
 {
   try
   {
     return Byte.parseByte(leeCadena());
   }
   catch(NumberFormatException e)
   {
     System.out.println("Error: " + e.getMessage());
	  return Byte.MIN_VALUE; // valor más pequeño
   }
 }
 
 
  // Lectura de un dato de tipo int
  public static int leeInt()
  {
    try
    {
      return Integer.parseInt(leeCadena());
    }
    catch(NumberFormatException e)
    {
      System.out.println("Error: " + e.getMessage());
	  return Integer.MIN_VALUE; // valor más pequeño
    }
  }
  
    // Lectura de un dato de tipo long
  public static long leeLong()
  {
    try
    {
      return Long.parseLong(leeCadena());
    }
    catch(NumberFormatException e)
    {
      System.out.println("Error: " + e.getMessage());
	  return Long.MIN_VALUE; // valor más pequeño
    }
  }
  
  // Lectura de un dato de tipo float
  public static float leeFloat()
  {
    try
    {
      Float f = new Float(leeCadena());
      return f.floatValue();
    }
    catch(NumberFormatException e)
    {
      System.out.println("Error: " + e.getMessage());
	  return Float.NaN; // No es un Número; valor float.
    }
  }
  
  // Lectura de un dato de tipo double
  public static double leeDouble()
  {
    try
    {
      Double d = new Double(leeCadena());
      return d.doubleValue();
    }
    catch(NumberFormatException e)
    {
	  System.out.println("Error: " + e.getMessage());
	  return Double.NaN; // No es un Número; valor double.
    }
  }

  // Lectura de un dato tipo char
 /* public static char leeChar()
  {
	char d=' ';
	try
	{
		d = (char)System.in.read();
	}
	catch (IOException e)
	{
		System.out.println("Error: " + e.getMessage());
	}
    return d;
  }
  */
  
//Método para poder leer un char
  public static char leeChar()
	{
		char c=' ';
		try	{
			c = (char)System.in.read();  // Lee el siguiente byte del canal
			System.in.skip(3);  // Descarta del canal 3 bytes
		}
		catch (Exception ex) {
		   System.out.println("Error de lectura");
		}
		return Character.toUpperCase(c);
	}
}









