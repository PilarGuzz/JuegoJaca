package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import elementos.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega


	public Juego(PlayerType[] jugadores) throws JuegoException {
		super();
		this.tablero = new HashMap<>();
		this.coordenadaJugadores = new ArrayList<>();
		int jugador = 0;
		while(jugador<Constantes.NUM_JUGADORES) {
			if(crearJugador(jugadores[jugador])==true) {
				jugador++;
			}
		}
		this.jugadorJuega=0;
		
		this.crearTablero();
	}
	
	/**
	 * Método privado que crea los elementos del tablero menos los jugadores
	 */
	private void crearTablero() {
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}
	
	/**
	 * metodo para crear jugadores, devuelve un boolean y crea un jugador y una coordenada,
	 * Si la coordenada es nula, le añado la coordenada al tablero y el jugador.
	 * 
	 */
	private boolean crearJugador(PlayerType tipo) {
		boolean crear = false;
		Jugador jugador = new Jugador(tipo);
		Coordenada coordenada = new Coordenada();
		
		while (this.coordenadaJugadores.contains(coordenada)) {
			coordenada = new Coordenada();
		}
		
		if(this.tablero.get(coordenada)==null) {
			coordenadaJugadores.add(coordenada);
			tablero.put(coordenada, jugador);
			crear = true;
		}
		
		
		return crear;
	}

	/**
	 * Crea las rocas del tablero
	 */
	private void crearRocas() {
		int contador = 0;
		while (contador < Constantes.NUM_ROCAS) {
			Coordenada coor = new Coordenada();
			Element e = new Element(ElementType.ROCA);
			if (tablero.get(coor) == null) {
				this.tablero.put(coor, e);
				contador++;
			}

		}
	}
	
	
	/**
	 * Crea las gemas del tablero
	 */
	private void crearGemas() {
		int contador = 0;
		while (contador < Constantes.NUM_GEMAS) {
			Coordenada coor = new Coordenada();
			Element e = new Element(ElementType.GEMA);
			if (tablero.get(coor) == null) {
				this.tablero.put(coor, e);
				contador++;
			}

		}
	}
	
	
	/**
	 * Crea las pociones del tablero
	 */
	private void crearPociones() {
		int contador = 0;
		while (contador < Constantes.NUM_POCIONES) {
			Coordenada coor = new Coordenada();
			Element e = new Element(ElementType.POCION);
			if (tablero.get(coor) == null) {
				this.tablero.put(coor, e);
				contador++;
			}

		}
	}
	
	/**
	 * Crea las dinero del tablero
	 */
	private void crearDinero() {
		int contador = 0;
		while (contador < Constantes.NUM_DINERO) {
			Coordenada coor = new Coordenada();
			Element e = new Element(ElementType.DINERO);
			if (tablero.get(coor) == null) {
				this.tablero.put(coor, e);
				contador++;
			}

		}
	}

	/**
	 * Escribe el tablero en formato no grÃ¡fico. Devuelve el string con la
	 * informaciÃ³n
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	
	/**
	 * Devuelve un boolean que indica si está terminado o no. 
	 * Un juego está termindo si sólo queda un jugador o 
	 * si algún jugador tiene todo el dinero
	 * @return
	 */
	public boolean isTerminado() {
		boolean terminar = false;
		if (this.coordenadaJugadores.size() == 1) {
			terminar = true;
			
		}else {
			for(Element e : this.tablero.values() ) {
				if (e instanceof Jugador ju && ju.getDinero() == Constantes.DINERO) {
					
						terminar = true;

					
				}
			}	
		}
		
		return terminar;
	}

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}
	
	
	/**
	 * Función que imprime, devuelve, el nombre de los jugadores actuales. 
	 * El formato es El jugador 1 es un xxx El jugador 2 es un xxx
	 * @return
	 */
	public String imprimeNombreJugadores() {
		int contador = 1;
		StringBuilder sb = new StringBuilder();
		
		for (Coordenada coordenada : this.coordenadaJugadores) {
		Jugador j = (Jugador) tablero.get(coordenada);
			sb.append("El jugador "+ contador +" es un " + j.getNombre() + "\n");
			contador++;
		}
		return sb.toString();
	}
	
	/**
	 * Función que imprime, devuelve, los jugadores con sus valores de dinero, pociones y gemas.
	 * @return
	 */
	public String imprimeValoresJugadores() {
		StringBuilder sb = new StringBuilder();
		
		for (Coordenada coordenada : this.coordenadaJugadores) {
			Jugador jugador = (Jugador) tablero.get(coordenada);
			sb.append("Jugador " + jugador.getNombre() +"."
						+ " Dinero: " + jugador.getDinero() 
						+ " Gemas: " + jugador.getGemas() 
						+ " Pociones: " + jugador.getPociones() + "\n");
		
		}
		return sb.toString();
	}
	
	/**
	 * Elimina el jugador que está en la coordenadas que se le pasa por parámetro 
	 * Tiene que borrar el jugador del tablero y de la lista de coordenadas del jugadores
	 * @param coordenada
	 */
	private void eliminarJugador(Coordenada coordenada) {
		this.coordenadaJugadores.remove(coordenada);
		this.tablero.remove(coordenada);
	}
	
	
	/**
	 * Devuelve una coordenada que indica a donde se deberá mover el jugador. 
	 * Si no es una dirección válida N, S, E, O deberá lanzar una exception
	 * @param direccion
	 * @return
	 * @throws JuegoException
	 */
	private Coordenada getNextPosition (char direccion) throws JuegoException {
		if(direccion!='N' && direccion!='S' && direccion!='E' && direccion!='O') {
			throw new JuegoException("Error en la direccion.");
		}
		Coordenada coor;
			coor = coordenadaJugadores.get(jugadorJuega).clone();
			if(direccion=='N') {
				coor.goUp();
			}else if(direccion=='S') {
				coor.goDown();
			}else if(direccion=='E') {
				coor.goRight();
			}else {
				coor.goLeft();
			}
		
		return coor;
	}
	
	
	/**
	 * Cambia el jugador que juega a la posición indicada por parámetro. 
	 * Para cambiar un jugador a una determinada posición, hay que obtener la coordenada actual de jugador y el jugador. 
	 * Borrar del tablero la coordenada actual e insertar el jugador en la nueva coordenada. 
	 * Por último, en la lista de las coordenadas de los jugadores, hay que actualizar las coordenadas.
	 * @param coord
	 */
	private void cambiaJugadorAPosicion​(Coordenada coord) {
		
		Coordenada cJug =this.coordenadaJugadores.get(jugadorJuega);
		Element jugador = this.tablero.get(cJug);
		this.tablero.remove(cJug);
		this.tablero.put(coord, jugador);
		
		this.coordenadaJugadores.remove(jugadorJuega);
		this.coordenadaJugadores.add(jugadorJuega, coord);
		
	}

	
	

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una direcciÃ³n vÃ¡lida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador ) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pÃ³cima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pÃ³cima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(this.jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se lo salta
					this.jugadorJuega--;
					break;
					
				default :
					resul = "Algo ha salido mal";
					break;
				}
				// DespuÃ©s de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion​(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion​(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
					
				default :
					resul = "Algo ha salido mal";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion​(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion​(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion​(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion​(coordDestino);
		}

		return resul;
	}
	
	
	/**
	 * Actualiza la variable jugadorJuega al próximo jugador. Si es el último de la lista se debe empezar por el principio.
	 */
	public void proximoJugador() {
		if (this.jugadorJuega == coordenadaJugadores.size() - 1) {
			this.jugadorJuega = 0;
		} else {
			this.jugadorJuega++;
		}
	}

	
	
	/**
	 * Devuelve la información del ganador si sólo hay jugador o si no, si hay alguien que tiene todo el dinero
	 * @return
	 */
	public String getGanador() {
		StringBuilder resultado = new StringBuilder();
		
	
		if (this.coordenadaJugadores.size() == 1) {
			Jugador ju = (Jugador) tablero.get(coordenadaJugadores.get(0));
			resultado.append(ju.toString());
			
		}else {
			for(Element e : this.tablero.values() ) {
				if (e instanceof Jugador) {
		
					if (((Jugador) e).getDinero() == Constantes.DINERO) {
						resultado.append(e);

					}
				}
			}	
		}
		
		return resultado.toString();
	}
	
	/**
	 * Devuelve el nombre del jugador al que le toca jugar
	 * @return
	 */
	public String getNombreJugadorQueJuega() {
		Coordenada coor = this.coordenadaJugadores.get(jugadorJuega);
		Jugador jugador = (Jugador) this.tablero.get(coor);
		
		return jugador.getNombre();
	}
	
	/**
	 * Devuelve el número de movimientos que el jugador que está jugando debe hacer

	 * @return
	 */
	public int getMovimientoJugador() {
		Coordenada coor = this.coordenadaJugadores.get(jugadorJuega);
		Jugador jugador = (Jugador) this.tablero.get(coor);
		return jugador.getVelocidadParaLuchar();
	}
	
	
	/**
	 * Devuelve el valor actual del dado
	 * @return
	 */
	public int getValorDado() {
		return dado;
	}
	
	/**
	 * Decrementa el valor actual del dado
	 * @return
	 */
	public int decrementaDado() {
		return this.dado--;
	}
	
	
	public void setDado() {
		this.dado = ((Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega))).getVelocidadParaLuchar();
	}
	
	/**
	 * Devuelve el elemento que está en la coordenada coord. Devuelve el elemento, no una copia
	 * @param coord
	 * @return
	 */
	public Element obtenerElementoTablero(Coordenada coord) {
		return this.tablero.get(coord);
	}
	
	/**
	 * obtiene la coordenada del jugador que está jugando actualmente
	 * 
	 * @return
	 */
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return this.coordenadaJugadores.get(this.jugadorJuega);
		
		
	}
	
}
