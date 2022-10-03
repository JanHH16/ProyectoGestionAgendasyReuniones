/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;


/**
 *
 * @author 56974
 */
public class SoloNumeros {
    
    static boolean esSoloNumeros(String cadena)
	{
 
		for (int i = 0; i < cadena.length(); i++)
		{
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII == 165 || (valorASCII < 48 || valorASCII > 57))
                            
				return false; //Se ha encontrado un caracter que no es numero
                }
		return true;
	}
    
    static class NoEsNumeroExcepcion extends Exception{
 
		public NoEsNumeroExcepcion() {
			super("La cadena contiene caracteres que NO son letras");
		}
                
                public NoEsNumeroExcepcion(String alerta) {
			super(alerta);
		}
 
	}
    
    static String pedirCadenaNumeros(String palabra) throws SoloNumeros.NoEsNumeroExcepcion
	{
		
		String cadena = palabra;
		if (esSoloNumeros(cadena) || cadena.isEmpty()) 
			return cadena;
		else
			throw new SoloNumeros.NoEsNumeroExcepcion("La cadena contiene caracteres que NO son numeros");
	}
    
}
