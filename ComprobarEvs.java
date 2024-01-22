import java.util.*;

public class ComprobarEvs 
{
    public static void main(String[] args) 
    {
        List<Carta> mano = new ArrayList<>();
    
        Carta c1= new Carta("\u2660", "1");
        Carta c2= new Carta("\u2660", "10");
        Carta c3= new Carta("\u2660", "11");
        Carta c4= new Carta("\u2660", "12");
        Carta c5= new Carta("\u2660", "13");
        mano.add(c1);
        mano.add(c2);
        mano.add(c3);
        mano.add(c4);
        mano.add(c5);
        
        System.out.println(obtenerPuntuacion(mano));
        
    }   
    public static int calcularPuntuacionTotal(Map<Integer,List<Carta>> manos)
    {
        Integer puntos = null;

        for (Map.Entry<Integer,List<Carta>> e: manos.entrySet())
        {
            if (puntos != null)
                puntos += obtenerPuntuacion(e.getValue());
            else
                puntos = obtenerPuntuacion(e.getValue());
        }
        return puntos;
    }

    public static Integer evaluarHayPareja(List<Carta> mano) {
        Integer siHay = 0;
        // Crear un mapa para contar la cantidad de ocurrencias de cada número de carta
        Map<String, Integer> contadorNumeros = new HashMap<>();
        // Iterar sobre todas las cartas y actualizar el contador de números
        for (Carta carta : mano) {
            String numero = carta.getNumCarta();
            contadorNumeros.put(numero, contadorNumeros.getOrDefault(numero, 0) + 1);
        }
        // Verificar si hay alguna pareja de cartas
        for (int count : contadorNumeros.values()) {
            if (count == 2) {
                siHay += 200; // Se encontró una pareja
            } else if (count == 0) {
                siHay = null;
            }
        }
        return siHay;
    }

    public static Integer evaluarHayDoblePareja(List<Carta> mano) {
        if (Integer.valueOf(evaluarHayPareja(mano)) == 400)
            return 400;
        else
            return null;
    }

    public static Integer evaluarHayTrio(List<Carta> mano) 
    {
        Integer siHay = null;
        // Crear un mapa para contar la cantidad de ocurrencias de cada número de carta
        Map<String, Integer> contadorNumeros = new HashMap<>();
        // Iterar sobre todas las cartas y actualizar el contador de números
        for (Carta carta : mano) {
            String numero = carta.getNumCarta();
            contadorNumeros.put(numero, contadorNumeros.getOrDefault(numero, 0) + 1);
        }
        // Verificar si hay alguna pareja de cartas
        for (int count : contadorNumeros.values()) {
            if (count == 3) {
                siHay = 800; // Se encontró una pareja
            }
        }
        return siHay;
    }

    public static Integer evaluarHayColor(List<Carta> mano) {
        // Verificar si todas las cartas tienen el mismo palo
        String primerPalo = mano.get(0).getPalo();
        for (int i = 1; i < mano.size(); i++) {
            String palo = mano.get(i).getPalo();
            if (!palo.equals(primerPalo)) {
                return null; // No hay color
            }
        }
        return 1400; // Hay color
    }

    public static Integer evaluarHayFullHouse(List<Carta> mano) 
    {
        if (evaluarHayTrio(mano) !=null && evaluarHayPareja(mano) == 200)
            return 1800;
        else
            return null;
    }

    public static Integer evaluarHayPoker(List<Carta> mano) {
        Integer siHay = null;
        // Crear un mapa para contar la cantidad de ocurrencias de cada número de carta
        Map<String, Integer> contadorNumeros = new HashMap<>();
        // Iterar sobre todas las cartas y actualizar el contador de números
        for (Carta carta : mano) {
            String numero = carta.getNumCarta();
            contadorNumeros.put(numero, contadorNumeros.getOrDefault(numero, 0) + 1);
        }
        // Verificar si hay alguna pareja de cartas
        for (int count : contadorNumeros.values()) {
            if (count == 4) {
                siHay = 2000; // Se encontró una pareja
            }
        }
        return siHay;
    }

    public static Integer evaluarHayEscalera(List<Carta> mano) {
        Integer siHay = null;
        // Crear una lista para almacenar todas las cartas de la mano
        List<Integer> numerosCarta = new ArrayList<>();
        // Obtener los números de carta como enteros y ordenarlos
        for (Carta carta : mano) {
            numerosCarta.add(carta.getNumCartaInteger());
        }
        Collections.sort(numerosCarta);
        // Verificar si hay una escalera
        int count = 1;
        for (int i = 1; i < numerosCarta.size(); i++) {
            if (numerosCarta.get(i) - numerosCarta.get(i - 1) == 1) {
                count++;
            } else {
                count = 1;
            }
            if (count == 5) {
                siHay = 1000; // Se encontró una escalera
                break;
            }
        }
        return siHay;
    }

    public static Integer evaluarHayEscaleraColor(List<Carta> mano) {
        Integer result = null;
        if (evaluarHayColor(mano) != null) 
            if (evaluarHayEscalera(mano) != null && evaluarHayEscalera(mano) == 1000)
                result = 2400;
        else result = null;
        return result;
    }

    public static Integer evaluarHayEscaleraReal(List<Carta> mano) {
        Integer siHay = null;
        // Crear una lista para almacenar todas las cartas de la mano
        List<Integer> numerosCarta = new ArrayList<>();
        List<String> palos = new ArrayList<>();
        // Obtener los números de carta como enteros y ordenarlos
        for (Carta carta : mano) {
            numerosCarta.add(carta.getNumCartaInteger());
            palos.add(carta.getPalo());
        }
        Collections.sort(numerosCarta);
        // Verificar si hay una escalera real
        boolean escaleraReal = numerosCarta.containsAll(Arrays.asList(1, 10, 11, 12, 13));
        boolean mismoPalo = palos.stream().distinct().count() == 1; // Verificar si todos los palos son iguales
        if (escaleraReal && mismoPalo ) {
            siHay = 2800; // Se encontró una escalera real
        }
        return siHay;
    }
    public static Integer obtenerPuntuacion(List<Carta> mano)
    {
        Integer puntuacion = null;

        Integer escaleraReal = evaluarHayEscaleraReal(mano);
        if (escaleraReal != null) {
            puntuacion = escaleraReal;
        } else {
            Integer escaleraColor = evaluarHayEscaleraColor(mano);
            if (escaleraColor != null) {
                puntuacion = escaleraColor;
            } else {
                Integer poker = evaluarHayPoker(mano);
                if (poker != null) {
                    puntuacion = poker;
                } else {
                    Integer fullHouse = evaluarHayFullHouse(mano);
                    if (fullHouse != null) {
                        puntuacion = fullHouse;
                    } else {
                        Integer color = evaluarHayColor(mano);
                        if (color != null) {
                            puntuacion = color;
                        } else {
                            Integer escalera = evaluarHayEscalera(mano);
                            if (escalera != null) {
                                puntuacion = escalera;
                            } else {
                                Integer trio = evaluarHayTrio(mano);
                                if (trio != null) {
                                    puntuacion = trio;
                                } else {
                                    Integer doblePareja = evaluarHayDoblePareja(mano);
                                    if (doblePareja != null) {
                                        puntuacion = doblePareja;
                                    } else {
                                        Integer pareja = evaluarHayPareja(mano);
                                        if (pareja != null) {
                                            puntuacion = pareja;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return puntuacion;
    }
    
}

