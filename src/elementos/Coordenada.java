package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;

public class Coordenada {

	//atributos
	private int x;
	private int y;

	//constructor
	public Coordenada() {
		super();
		Random random =new Random();
		this.x=(random.nextInt(Constantes.TAMANNO));
		this.y=(random.nextInt(Constantes.TAMANNO));
	}
	//constructor
	public Coordenada(int x, int y) {
		super();
		if (x>=0 && x<=Constantes.TAMANNO && y>=0 && y<=Constantes.TAMANNO ) {
			this.x = x;
			this.y = y;
		}else {
			this.x=0;
			this.y=0;
		}

	}
	//guetter y setter//
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	//equals//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}
	@Override
	public String toString() {
		return "Coordenadas: x = " + x + ", y = " + y + "\n";
	}


	//metodos 
	/**
	 * Mueve a la derecha, si esta en el borde del tablero devuelve false.
	 * @return
	 */
	public boolean goRight () {
		
		boolean mueve=true;
		
		
		if (x==Constantes.TAMANNO-1) {
			mueve=false;
		}else {
			x++;
		}
		return mueve;
	}
	/**
	 * Mueve over a la izquierda, si esta en el borde izquierdo devuelve false
	 * @return
	 */
	public boolean goLeft() {
		
		boolean mueve=true;
		
		if (x==0) {
			
			mueve=false;
		}else {
			x--;
		}
		return mueve;
	}
	/**
	 *Mueve hacia arriba, si esta en el borde del tablero, devuelve false.
	 * @return
	 */
	public boolean goUp() {
		
		boolean mueve=true;
		
		if (y==0) {
			
			mueve=false;
		}else {
			y--;
		}
		return mueve;
	}
	/**
	 * Mueve hacia abajo, si esta en el borde devulve false.
	 * @return
	 */
	public boolean goDown() {
		
		boolean mueve=true;
		
		
		if (y==Constantes.TAMANNO-1) {
			
			mueve=false;
		}else {
			
			y++;
		}
		return mueve;
	}
	@Override
	public Coordenada clone() {
		return new Coordenada(this.x,this.y);
	}

}
