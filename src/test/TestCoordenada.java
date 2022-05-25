package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class TestCoordenada {

	@Test
	public void crearCoordenadaCorrecta() {
		Coordenada c =new Coordenada(1,1);
		assertEquals(c.getX(), 1);
		assertEquals(c.getY(), 1);

		
	}
	@Test
	public void creaCoordenadaIncorrecta() {
		Coordenada c =new Coordenada(0,20);
		assertEquals(c.getY(), 0 );
	}


	@Test 
	public void mueveGoRight() {
		Coordenada c =new Coordenada(1,1);
		c.goRight();
		assertEquals(c.getX(), 2);
	}
	@Test
	public void noMueveGoRight() {
		Coordenada c =new Coordenada(9,1);
		assertFalse(c.goRight());
	}
	
	
	@Test 
	public void mueveGoDown() {
		Coordenada c =new Coordenada(1,1);
		c.goDown();
		assertEquals(c.getY(), 2);
	}
	@Test 
	public void noMueveGoDown() {
		Coordenada c =new Coordenada(1,9);
		assertFalse(c.goDown());
	}
	@Test 
	public void mueveGoLeft() {
		Coordenada c =new Coordenada(1,1);
		c.goLeft();
		assertEquals(c.getX(), 0);
	}
	@Test 
	public void noMueveGoLeft() {
		Coordenada c =new Coordenada(0,0);
		
		assertFalse(c.goLeft());
	}
	@Test 
	public void mueveGoUp() {
		Coordenada c =new Coordenada(1,1);
		c.goUp();
		assertEquals(c.getY(), 0);
	}
	@Test 
	public void noMueveGoUp() {
		Coordenada c =new Coordenada(0,0);
		c.goUp();
		assertFalse(c.goUp());
	}

}
