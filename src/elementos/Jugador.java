package elementos;

import java.util.Random;

import logicaJuego.Constantes;

public class Jugador extends Element {
	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;
	private Random random = new Random();

	
	public Jugador(PlayerType tipo) {
		super(ElementType.valueOf(tipo.name()));
		this.player = PlayerType.valueOf(tipo.name());
		this.dinero = 0;
		this.gemas = 0;
		this.pociones = 0;
	}

	
	public String getNombre() {
		return player.name();
	}

	private int getFuerza() {
		return player.getFuerza();
	}
	
	public int getFuerzaParaLuchar() {
		return random.nextInt(getFuerza()+1);
	}


	private int getMagia() {
		return player.getMagia();
	}

	public int getMagiaParaLuchar() {
		return random.nextInt(getMagia()+1);
	}

	private int getVelocidad() {
		return player.getVelocidad();
	}

	public int getVelocidadParaLuchar() {
		return random.nextInt(getVelocidad())+1;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero){
		
		if (dinero < 0) {
			
			throw new JugadorException("El dinero no puede ser menor a 0 o morirás");
			
		} else {
			this.dinero = dinero;
		}
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones){
		
		if (pociones < 0) {
			
			throw new JugadorException("Error. Las pociones no pueden ser negativas");
			
		} else {
			this.pociones = pociones;
		}
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas){
		
		if (gemas < 0) {
			
			throw new JugadorException("Error. Las gemas no pueden ser negativas");
			
		} else {
			this.gemas = gemas;
		}

	}

	public String resumen() {
		
		return "Jugador: " + this.getNombre() 
		+ " Gemas: " + this.getGemas() 
		+ " Dinero: " + this.getDinero()
		+ "Pociones: " + this.getPociones();
	}

	
	public PlayerType getPlayer() {
		return player;
	}
	
	//metodo para luchar entre dos jugadores//
	
	/**
	 * Cuando dos jugadores se encuentran:
	 * si la fuerza es igual, quedaria en empate.
	 * si un jugador gana en fuerza al jugador contrario, el contrario puede:
	 * -usar pocion si no tiene dinero
	 * -perder su dinero.
	 * -morir.
	 * O quedar empate y no pasaría nada. 
	 * 
	 * @param j2: jugador 2
	 * @return
	 * 
	 */
	public int lucha(Jugador j2) {
		int res=-1;
		int miFuerza= this.getFuerzaParaLuchar();
		int fuerzaJ2= j2.getFuerzaParaLuchar();
		
		//fuerza igual, empate
		if(miFuerza==fuerzaJ2) {
			
			res= Constantes.EMPATE;
		
		//Si tenemos más fuerza hay diversas opciones:
		}else if (miFuerza> fuerzaJ2) {
			
			//Si no tiene dinero ni pociones, muere el enemigo.
			if (j2.getDinero()==0 && j2.getPociones()==0) {
				res = Constantes.GANA_MUERE;
				
			//Si tiene dinero lo pierde.	
			}else if(j2.getDinero()>0) {
				this.dinero= this.dinero + j2.getDinero();
				j2.setDinero(0);
	
				res = Constantes.GANA_DINERO;
				
			//Si no tiene dinero pero si pocion, salva su vida.
			}else if(j2.getDinero()==0 && j2.getPociones()>0) {
				
				j2.setPociones(j2.pociones-1);
				res = Constantes.GANA_USA_POCIMA;
			}
		//Si el J2 nos supera en fuerza:	
		}else {
			//Si no tenemos dinero ni pociones morimos.
			if (this.getDinero()==0 && this.getPociones()==0) {
				res = Constantes.PIERDE_MUERE;
				
			//Si tiene dinero lo pierde.	
			}else if(this.getDinero()>0) {
				j2.setDinero(j2.getDinero()+ this.dinero);
				this.setDinero(0);
		
				res = Constantes.PIERDE_DINERO;
				
			//Si no tiene dinero pero si pocion, salva su vida.
			}else if(this.getDinero()==0 && this.getPociones()>0) {
				
				this.setPociones(this.pociones-1);
				res = Constantes.PIERDE_USA_POCIMA;
			}
			
		}	
		
		
		return res;
	}
	
	/**
	 * Roca en el camino:
	 * Si hay gema se rompe y perdemos una gema
	 * si sacamos mas de un 4 con magia ganamos
	 * si es menor a 4 perdemos.
	 * 
	 * @return
	 */
	public int encuentraRoca() {
		int res=-1;
		
		if (this.gemas>0) {
			res=Constantes.ROMPE_ROCA_CON_GEMA;
			
			this.setGemas(this.gemas-1);
		}else {
			if (this.getMagiaParaLuchar()>4) {
				
				res=Constantes.GANA_A_LA_ROCA;
				
			}else {
				res=Constantes.PIERDE_A_LA_ROCA;
			}
			
		}
		return res;
	}
	
	//encuentra dinero al moverse//
	public void encuentraDinero() {
		this.dinero++;
	}
	//encuentra pocion //
	public void encuentraPocion() {
		this.pociones++;
	}
	//encuetra gemas//
	public void encuentraGema() {
		this.gemas++;
	}
	

}
