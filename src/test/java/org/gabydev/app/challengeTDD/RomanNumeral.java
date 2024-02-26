package org.gabydev.app.challengeTDD;

import java.util.TreeMap;

/**
 * Clase para convertir un numero arábico a romano.
 * @author Gabriel Gramajo
 * @version 1.0.0
 * @see <a href="https://github.com/gabygramajo">mi github</a>
 */
public class RomanNumeral {

    private final static TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    static {/* bloque de inicialización estática.
        * Es un bloque de código que se ejecuta cuando la clase se carga en la JVM
        * y solo se ejecuta una vez, independientemente de la cantidad de instancias
        * de la clase que se creen. Puedes utilizarlo para inicializar variables estáticas
        * o realizar otras acciones de inicialización específicas de la clase.*/
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    /**
     * Convierte y retorna un número arábico a romano. Si el número ingresado no se encuentra en el romanNumerals, el método arabicToRoman se llamará recursivamente factorizando el número hasta convertirlo en número romano.
     * @param number número arábico a convertir
     * @return devuelve el número arábico en número Romano
     */
    public static String arabicToRoman(int number) {


        int lowestNearestKey = romanNumerals.floorKey(number);

        if (number == lowestNearestKey) {
            return romanNumerals.get(number);
        }

        return romanNumerals.get(lowestNearestKey) + arabicToRoman(number - lowestNearestKey);

    }

}
