
import java.util.*;


public class Si
{
    public static void main(String[] args) 
    {
        Juego juego1 = new Juego();
        juego1.bienvenida();
        juego1.mostrarMenu();

    }
    
    
}

class TablaPuntuaciones 
{
    private static final int MAX_LONGITUD_NOMBRE = 12;
    private static final int MAX_PUNTUACION = 9999;

    

    private ArrayList<Jugador> jugadores;

    public TablaPuntuaciones() 
    {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(String nombre, int puntos, int tiempo) 
    {
        String nombreFormateado = formatearNombre(nombre);
        Jugador jugador = new Jugador(nombreFormateado, puntos, tiempo);
        jugadores.add(jugador);
    }
    class Jugador 
    {
        private String nombre;
        private int puntos;
        private int tiempo;

        public Jugador(String nombre, int puntos, int tiempo) {
            this.nombre = nombre;
            this.puntos = puntos;
            this.tiempo = tiempo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPuntos() {
            return puntos;
        }

        public int getTiempo() {
            return tiempo;
        }
    }

    private String formatearNombre(String nombre) 
    {
        if (nombre.length() > MAX_LONGITUD_NOMBRE) 
        {
            return nombre.substring(0, MAX_LONGITUD_NOMBRE);
        } else 
        {
            return nombre;
        }
    }

    public void mostrarTabla() 
    {
        System.out.println("Nombre\t\tPuntos\tTiempo");
        System.out.println("------------------------------");

        for (Jugador jugador : jugadores) 
        {
            System.out.printf("%-12s\t%4d\t%d%n", jugador.getNombre(), jugador.getPuntos(), jugador.getTiempo());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}

class Juego
{
    private Scanner sc = new Scanner (System.in);
    Scanner ramon= new Scanner(System.in);
    private int filasDificultad = 3;
    private int colsDificultad = 4;
    private TablaPuntuaciones tablaPuntuaciones = new TablaPuntuaciones();
    
    public void bienvenida()
    {
        System.out.println(" ___________   ______   _____ ______   _____     ______   _______   ______   _____ ______   _____     ");
        System.out.println(" \\          \\ |\\     \\ |     |\\     \\  \\    \\   |\\     \\  \\      \\ |\\     \\ |     |\\     \\  \\    \\    ");
        System.out.println("  \\    /\\    \\ \\     \\|     | \\    |  |    |    \\     \\ |     /|\\ \\     \\|     | \\    |  |    |    ");
        System.out.println("   |   \\_\\    |\\ \\           |  |   |  |    |     \\|     \\|     //  \\ \\           |  |   |  |    |    ");
        System.out.println("   |      ___/  \\ \\____      |  |    \\_/   /|      |     |_____//    \\ \\____      |  |    \\_/   /|    ");
        System.out.println("   |      \\  ____\\|___/     /|  |\\         \\|      |     |\\     \\     \\|___/     /|  |\\         \\|    ");
        System.out.println("  /     /\\ \\/    \\   /     / |  | \\         \\__   /     /|\\|     |        /     / |  | \\         \\__  ");
        System.out.println(" /_____/ |\\______|  /_____/  /   \\ \\_____\\/    \\ /_____/ |/_____/|       /_____/  /   \\ \\_____\\/    \\ ");
        System.out.println(" |     | | |     |  |     | /     \\ |    |/___/||     | / |    | |       |     | /     \\ |    |/___/| ");
        System.out.println(" |_____|/ \\|_____|  |_____|/       \\|____|   | ||_____|/  |____|/        |_____|/       \\|____|   | |");
        System.out.println("                                         |___|/                                               |___|/  ");
        System.out.println("                                                             ");
        System.out.println("                                         ¡Bienvenido a RyuKyu!                        ");
        
    }

    public void despedida()
    {
        System.out.println("                                                                ");
        System.out.println("                                         ,----..                ");
        System.out.println("    ,---,           ,---,       ,---,   /   /   \\    .--.--.    ");
        System.out.println("   '  .' \\        .'  .' `\\  ,`--.' |  /   .     :  /  /    '.  ");
        System.out.println("  /  ;    '.    ,---.'     \\ |   :  : .   /   ;.  \\|  :  /`. /  ");
        System.out.println(" :  :       \\   |   |  .`\\  |:   |  '.   ;   /  ` ;;  |  |--`   ");
        System.out.println(" :  |   /\\   \\  :   : |  '  ||   :  |;   |  ; \\ ; ||  :  ;_     ");
        System.out.println(" |  :  ' ;.   : |   ' '  ;  :'   '  ;|   :  | ; | ' \\  \\    `.  ");
        System.out.println(" |  |  ;/  \\   \\'   | ;  .  ||   |  |.   |  ' ' ' :  `----.   \\ ");
        System.out.println(" '  :  | \\  \\ ,'|   | :  |  ''   :  ;'   ;  \\; /  |  __ \\  \\  | ");
        System.out.println(" |  |  '  '--'  '   : | /  ; |   |  ' \\   \\  ',  /  /  /`--'  / ");
        System.out.println(" |  :  :        |   | '` ,/  '   :  |  ;   :    /  '--'.     /  ");
        System.out.println(" |  | ,'        ;   :  .'    ;   |.'    \\   \\ .'     `--'---'   ");
        System.out.println(" `--''          |   ,.'      '---'       `---`                  ");
        System.out.println("                '---'                                           ");
        System.out.println("                        ¡HASTA PRONTO!");

    }

    public static void limpiarPantalla()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public int mostrarMenu()
    { 
        int opcion = 0;
        do
        {
        System.out.println("1. El jugueteo");
        System.out.println("2. El cambiFilasDificultad"); 
        System.out.println("3. El cambiaCols");
        System.out.println("4. Tabla puntos");
        System.out.println("5. Salir");
        System.out.println("6. DIFICULTAD DE ESCALERA REAL");


        opcion = sc.nextInt();
        
        
            switch(opcion)
            {
                case 1 -> jugar();
                case 2 -> 
                {
                    limpiarPantalla();
                    System.out.println("Nueva dificultad de filas (1-3) :"); 
                    filasDificultad = sc.nextInt();
                }
                case 3 -> 
                {
                    limpiarPantalla();
                    System.out.println("Nueva dificultad de columnas (1-4) :"); 
                    colsDificultad = sc.nextInt();
                }
                case 4 -> 
                {
                    limpiarPantalla();
                    tablaPuntuaciones.mostrarTabla();
                }
                case 5 -> System.out.println("Salir");
                case 6 ->
                {
                    double numReps=1000000;
                    for (int i = 1; i < numReps; i++) {
                        Baraja barajaMod= new Baraja();
                        List<Carta> mano = new ArrayList<>();
                        
                        for (int j=0;j<5;j++)
                        {
                            mano.add(barajaMod.robar());
                        }
            
                        if (ComprobarEvs.evaluarHayEscaleraReal(mano)!=null) {
                            System.out.println("Se ha encontrado una escalera real en la iteración " + i);
                            System.out.println(mano.toString());
                            break;
                        } else{
                            System.out.println("No se encontró ninguna escalera real en " + i + " iteraciones.");
                        }
                    }
  

                }
                case -1 -> 
                {
                    //limpiarPantalla();
                    despedida();
                }
            }
        }while(opcion != -1);
        return opcion;
    }
    public Map<Integer, List<Carta>> obtenerFilas(Carta[][] tablero) 
    {
        Map<Integer, List<Carta>> filas = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<Carta> fila = new ArrayList<>();
            
            for (int j = 0; j < 5; j++) {
                fila.add(tablero[i][j]);
            }
            filas.put(i, fila);
        }
        return filas;
    }

    public Map<Integer, List<Carta>> obtenerColumnas(Carta[][] tablero) 
    {
        Map<Integer, List<Carta>> columnas = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<Carta> columna = new ArrayList<>();
            
            for (int j = 0; j < 5; j++) 
            {
                columna.add(tablero[j][i]);
            }
            columnas.put(i, columna);
        }
        return columnas;
    }

    public Map<Integer, List<Carta>> obtenerDiagonales(Carta[][] tablero) 
    {
        Map<Integer, List<Carta>> diagonales = new HashMap<>();
        List<Carta> diagonalPrincipal = new ArrayList<>();
        List<Carta> diagonalSecundaria = new ArrayList<>();

        for (int i = 0; i < 5; i++) 
        {
            diagonalPrincipal.add(tablero[i][i]);
            diagonalSecundaria.add(tablero[i][4 - i]);
        }

        diagonales.put(1, diagonalPrincipal);
        diagonales.put(2, diagonalSecundaria);
        return diagonales;
    }
    public Map<Integer, List<Carta>> obtenerManoModificacion2(Carta[][] tablero)
    {
        Map<Integer, List<Carta>> manoModificacion=new HashMap<>();
        List<Carta> mano = new ArrayList<>();
        
        mano.add(tablero[0][0]);
        mano.add(tablero[0][4]);
        mano.add(tablero[2][2]);
        mano.add(tablero[4][0]);
        mano.add(tablero[4][4]);
        manoModificacion.put(1, mano);
    
        return manoModificacion;
    }

    public void jugar()
    {
    Baraja baraja = new Baraja();
    Tablero tableroJuego = new Tablero();
    TableroArriba tableroArriba = new TableroArriba(filasDificultad,colsDificultad);
    tableroArriba.rellenarTableroArriba(baraja);
    int puntos = 0;
    long tiempo1;
    long tiempo2;
    int montones[] = new int[colsDificultad];                   //cantidad de montones de los que podremos extraer cartas dependiendo de las filas de dificultad
    int numCartas = 52 - (filasDificultad *colsDificultad);     //calculamos la cantidad de cartas restantes después de rellenar la matriz de extracción (arriba)
        //{
            numCartas = numCartas/colsDificultad;
            Arrays.fill(montones, numCartas);
            
        //}
        tiempo1 = System.currentTimeMillis();
    do
    {
        
        System.out.print("+");
        
            for (int j = 0; j < colsDificultad; j++) 
            {
                
                System.out.print("- "+montones[j]+ "-");
      
                System.out.print("+");
            }
            System.out.println();
            System.out.println();
        tableroArriba.dibujarTablero();
        tableroJuego.dibujarTablero();
        int colElegidaTableroArriba;
        int colElegidaTableroJuego;

        do
        {
            System.out.println("Escoge carta");
            colElegidaTableroArriba = sc.nextInt();
            colElegidaTableroArriba-=1;

            
        }while(colElegidaTableroArriba>=colsDificultad);
            montones[colElegidaTableroArriba]=montones[colElegidaTableroArriba];
        
        do
        {
            System.out.println("Escoge posicion");
            colElegidaTableroJuego = sc.nextInt();
            colElegidaTableroJuego-=1;
        }while(colElegidaTableroJuego > 4 );
            
        if (tableroJuego.columnIsFull(colElegidaTableroJuego) == false)
        {
            Carta carta = tableroArriba.sacarCarta(colElegidaTableroArriba, baraja,montones);
            tableroJuego.insertarCarta(colElegidaTableroJuego, carta);
        }
        
        limpiarPantalla();

    }while(!tableroJuego.isFull());
    tableroJuego.dibujarTablero();
    tiempo2 = System.currentTimeMillis();
    
    Map<Integer, List<Carta>> mapaFilas = obtenerFilas(tableroJuego.getTableroJuego());
    Map<Integer, List<Carta>> mapaColumnas = obtenerColumnas(tableroJuego.getTableroJuego());
    Map<Integer, List<Carta>> mapaDiagonales = obtenerDiagonales(tableroJuego.getTableroJuego());
    Map<Integer, List<Carta>> mapaModificacion2 = obtenerManoModificacion2(tableroJuego.getTableroJuego());

    System.out.println("Como te llamas");
        
        
        String nombreJugador = ramon.next();
        puntos += ComprobarEvs.calcularPuntuacionTotal(mapaFilas);
        puntos += ComprobarEvs.calcularPuntuacionTotal(mapaColumnas);
        puntos += ComprobarEvs.calcularPuntuacionTotal(mapaDiagonales);
        
        int pExtraidos;
        for (Map.Entry<Integer,List<Carta>> e: mapaModificacion2.entrySet())
        {
            System.out.println(e.getValue().get(2).getNumCartaInteger()
            );
            if(e.getValue().get(2).getNumCartaInteger()==1)
            {
                puntos+=(ComprobarEvs.calcularPuntuacionTotal(mapaModificacion2))*2;
                pExtraidos=(ComprobarEvs.calcularPuntuacionTotal(mapaModificacion2))*2;
                System.out.println(pExtraidos);
            }
            else
            {
                puntos+=ComprobarEvs.calcularPuntuacionTotal(mapaModificacion2);
                pExtraidos=ComprobarEvs.calcularPuntuacionTotal(mapaModificacion2);
                System.out.println(pExtraidos);
            }
            
        }
        
        
        long tTotal=(tiempo2-tiempo1)/1000;
        tablaPuntuaciones.agregarJugador(nombreJugador, puntos,(int)tTotal );
        tablaPuntuaciones.mostrarTabla();
    }
}

class Tablero 
{
    protected Carta[][] tableroJuego;
    protected int filas = 5;
    protected int columnas = 5; 

    Tablero() 
    {
        tableroJuego = new Carta[filas][columnas];
        // Inicializar todas las tableroJuego con un carácter específico (por ejemplo, '-')
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroJuego[i][j] = new Carta(" ", "  ");
            }
        }
    }

    public boolean columnIsFull(int nColumn)
    {
        boolean columnIsFull = false;
        
        if (tableroJuego[0][nColumn].equals(new Carta(" ", "  ")) == false)
        {
            columnIsFull = true;
        }
    return columnIsFull;
    }
    public boolean isFull() //para saber si hemos acabado de completar la matriz
    {
        boolean isFull = false;
        int i;
        for (i = 0; i < 5; i++)
            if (tableroJuego[0][i].equals(new Carta(" ", "  ")))
            {
                break;
            }
        if (i == 5)
        {
            isFull = true;
        }
        return isFull;
    }

    public void dibujarTablero() 
    
    {
        int anchoCelda = 5; // Ancho de cada celda (incluyendo bordes y separadores)
        
        
        
        for (int i = 0; i < filas; i++) 
        {
            // Imprimir línea superior de la cuadrícula
            System.out.print("+");
            for (int j = 0; j < columnas; j++) 
            {
                for (int k = 0; k < anchoCelda; k++) 
                {
                    System.out.print("-");
                }
                System.out.print("+");
            }
            System.out.println();
    
            // Imprimir contenido de lastableroJuego y separadores de columna
            for (int j = 0; j < columnas; j++) {
                System.out.print("| ");
                Carta contenidoCelda =tableroJuego[i][j];
                int espaciosEnBlanco = anchoCelda - contenidoCelda.toString().length() - 1;
                System.out.print(contenidoCelda);
                for (int k = 0; k < espaciosEnBlanco; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    
        // Imprimir línea inferior de la cuadrícula
        System.out.print("+");
        for (int j = 0; j < columnas; j++) {
            
            for (int k = 0; k < anchoCelda; k++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    public Carta[][] getTableroJuego() 
    {
        return tableroJuego;
    }
    
    public void insertarCarta(int columna, Carta carta) 
    {
    for (int fila = 4; fila >= 0; fila--) {
        if (tableroJuego[fila][columna].equals(new Carta(" ","  "))) 
        {
            tableroJuego[fila][columna] = carta;
            break;
        } else if (fila == 0) {
            System.out.println("La columna está llena, no se puede insertar la carta.");
        }
    }
    }

}
class TableroArriba extends Tablero
{
    
    TableroArriba(int filas, int columnas)
    {
        this.filas=filas;
        this.columnas=columnas;
        
    }   
    public void rellenarTableroArriba(Baraja barajota)
    {
        for (int i = 0; i < filas; i++ ) //rellena la matriz con cartas de la baraja y a su vez los elmina de esta
            {
                for (int j = 0; j < columnas; j++) 
                {
                    Carta carta = barajota.robar();                                   //disminuimos la longitud ya que si no nos saldriamos de rango generando randoms
                    this.tableroJuego[i][j] = carta;                                 //rellenamos la matriz con la carta escogida
                }
            }
        }

    @Override
    public void dibujarTablero() 
    {
        
        super.dibujarTablero();
    }

    public Carta sacarCarta(int columnaElegida,Baraja baraja,int montones[])
    {
        int filasCopia = this.filas;
        Carta[][] copiaTablero = this.getTableroJuego();                                
        Carta carta = copiaTablero[this.filas-1][columnaElegida];
        Carta cartaVacia = new Carta(" ", "  ");
       
        if (montones[columnaElegida] != 0) // si quedan cartas en ese monton
        {
            if (this.filas != 1)   // si el numero de filas es solo uno no podemos bajar ninguna posición, por lo que omitimos este paso
            {
                for (int i = 0; i < filasCopia; i++ ) // baja las cartas de posicion
                {
                    copiaTablero[filasCopia-1][columnaElegida] = copiaTablero[filasCopia-2][columnaElegida];
                    filasCopia--;
                }
            }
            copiaTablero[filasCopia-1][columnaElegida] = baraja.robar();                               //insertamos esa carta encima de las que hemos bajado
            montones[columnaElegida]--;
            System.out.println("Numero de cartas del monton"+ columnaElegida +" = " +montones[columnaElegida]);

    
          if(montones[columnaElegida] < 3) // si el numero de montones es inferior a 3 significa que tienen que empezar a mostrarse espacios en blanco en esa columna
            {
                copiaTablero[filasCopia-1][columnaElegida] = cartaVacia;
            }
        }
            return carta;
    } 
    
}
class Baraja extends Carta
{
    private List<String> listaPalos;
    private static List<Carta> baraja;
    
    Baraja()
    {
        baraja = new ArrayList<>();
        listaPalos = new ArrayList<>();
        
        listaPalos.add("\u2660"); //picas
        listaPalos.add("\u2663");//trebols
        listaPalos.add("\u2661");//coras
        listaPalos.add("\u2662");//diamantes

        llenarBaraja();
    }
    public void llenarBaraja()
    {
    
        for (int i = 0; i < listaPalos.size(); i++)
        {
            for (int j = 1; j <=13; j++)
            {
                String palo = listaPalos.get(i);
                baraja.add(new Carta(palo, j+""));
                
            }   
        }
    }
    public List<Carta> getBaraja() {
        return baraja;
    }

    public static void barajar()
    {
        Collections.shuffle(baraja);
    }
    public Carta robar()
    {
        barajar();
        Carta cartaRobada = baraja.remove(0);
        return cartaRobada;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
class CartaComparator implements Comparator<Carta> {
    @Override
    public int compare(Carta carta1, Carta carta2) {
        // Da el valor de la carta
        int numCarta1 = Integer.parseInt(carta1.getNumCarta());
        int numCarta2 = Integer.parseInt(carta2.getNumCarta());

        // Compara el palo y el numero para saber orden
        if (carta1.getPalo().equals(carta2.getPalo())) {
            return Integer.compare(numCarta1, numCarta2);
        } else {
            return carta1.getPalo().compareTo(carta2.getPalo());
        }
    }
}

class Carta implements Comparator<Carta>
{
    protected String palo;
    protected String numCarta;

    Carta()
    {
        
    }
    Carta(String palo, String numCarta)
    {
        this.palo = palo;
        this.numCarta = numCarta;
    }
    public String getNumCarta() {
        return numCarta;
    }
    public Integer getNumCartaInteger() {
        return Integer.valueOf(numCarta);
    }

    public String getPalo() {
        return palo;
    }
    
    public void setNumCarta(String numCarta) {
        this.numCarta = numCarta;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }
    
    public boolean numeroIgual(Carta c1)
    {
        boolean flag=false;
        
        if (this.numCarta == c1.numCarta)
        {
            flag = true;
        }
            
        return flag;

    }
    @Override
    public boolean equals(Object obj) 
    {
        boolean equals = false;
        Carta otraCarta = (Carta) obj;

        if (this.palo.equals(otraCarta.palo) && this.numCarta == otraCarta.numCarta)
        {
            equals = true;
        }
            
        return equals;
        
    }
    
    @Override
    public int compare(Carta o1, Carta o2) 
    {
        return Integer.getInteger(o1.getNumCarta()) - Integer.getInteger(o2.getNumCarta()); // no sabemos si es asi o al reves
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String result = numCarta+" "+palo;
        String numCarta2= "";
        
        if (numCarta.equals("11") )
                    numCarta2="J";
                else if (numCarta.equals("12") )
                    numCarta2="Q";
                else if (numCarta.equals("13") )
                    numCarta2="K";
                else if (numCarta.equals("1") )
                    numCarta2="A";
                else 
                    numCarta2=numCarta;
        result= numCarta2+" "+palo;
        if(numCarta.equals("10"))
        {
            result= numCarta+palo;
        }
        return result;
    }
    
}