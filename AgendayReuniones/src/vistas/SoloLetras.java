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
public class SoloLetras {
    
	static boolean esSoloLetras(String cadena)
	{
 
		for (int i = 0; i < cadena.length(); i++)
		{
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90) && valorASCII!=32)
                            
				return false; //Se ha encontrado un caracter que no es letra
                }
		return true;
	}
 
	static class NoEsLetraExcepcion extends Exception{
 
		public NoEsLetraExcepcion() {
			super("La cadena contiene caracteres que NO son letras");
		}
                
                public NoEsLetraExcepcion(String alerta) {
			super(alerta);
		}
 
	}
        
        static String pedirCadenaLetras(String palabra) throws NoEsLetraExcepcion
	{
		
		String cadena = palabra;
		if (esSoloLetras(cadena) || cadena.isEmpty()) //Para este caso, aceptamos cadena vacía como válida
			return cadena;
		else
			throw new NoEsLetraExcepcion("La cadena contiene caracteres que NO son letras");
	}
 
    
}
