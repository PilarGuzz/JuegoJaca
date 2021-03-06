package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

class TestJugador {

	Jugador j1 = new Jugador(PlayerType.ELFO);

	Jugador j2 = new Jugador(PlayerType.GUERRERO);
	Jugador j3 = new Jugador(PlayerType.OGRO);
	Jugador j4 = new Jugador(PlayerType.MAGO);
	Jugador j5 = j4;

	@Test
	public void testFuerzaParaLucharElfo() {
			for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.ELFO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.ELFO_FUERZA);
		}

	}

	@Test
	public void testFuerzaParaLucharOgro() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.OGRO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.OGRO_FUERZA);
		}

	}

	@Test
	public void testFuerzaParaLucharGuerrero() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.GUERRERO_FUERZA);
		}

	}

	@Test
	public void testFuerzaParaLucharMago() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.MAGO_FUERZA);
		}

	}

	@Test
	public void testVelocidadParaLucharElfo() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.ELFO);
			assertTrue(j1.getVelocidadParaLuchar() >= 0 && j1.getVelocidadParaLuchar() <= Constantes.ELFO_VELOCIDAD);
		}

	}

	@Test
	public void testVelocidadParaLucharOgro() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.OGRO);
			assertTrue(j1.getVelocidadParaLuchar() >= 0 && j1.getVelocidadParaLuchar() <= Constantes.OGRO_VELOCIDAD);
		}

	}

	@Test
	public void testVelocidadParaLucharGuerrero() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getVelocidadParaLuchar() >= 0 && j1.getVelocidadParaLuchar() <= Constantes.GUERRERO_VELOCIDAD);
		}

	}

	@Test
	public void testVelocidadParaLucharMago() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.MAGO);
			assertTrue(j1.getVelocidadParaLuchar() >= 0 && j1.getVelocidadParaLuchar() <= Constantes.MAGO_VELOCIDAD);
		}

	}

	@Test
	public void testMagiaParaLucharElfo() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.ELFO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.ELFO_MAGIA);
		}

	}

	@Test
	public void testMagiaParaLucharOgro() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.OGRO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.OGRO_MAGIA);
		}

	}

	@Test
	public void testMagiaParaLucharGuerrero() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.GUERRERO_MAGIA);
		}

	}

	@Test
	public void testMagiaParaLucharMago() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.MAGO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.MAGO_MAGIA);
		}

	}

	

	@Test
	public void setDineroLimiteBajo() {
		try {
			j1.setDinero(-1);
			assert(false);
		} catch (JugadorException e) {
			assert(true);
		}
	}




	@Test
	public void setPocionesLimiteAlto() {
		try {
			j1.setPociones(4);
			assert(false);
		} catch (JugadorException e) {
			assert(true);
		}
	}

	@Test
	public void setPocionesLimiteBajo() {
		try {
			j1.setPociones(-1);
			fail("Tiene que saltar la excepcion porque las pociones no puede ser negativo");
			assert(false);
		} catch (JugadorException e) {
				assert(true);
		}
	}

	

	@Test
	public void setPocionesLimite0() {
		try {
			j1.setPociones(0);
			assert(true);
			} catch (JugadorException e) {
				assert(false);
			}
	}

	@Test
	public void setGemasLimiteAlto() {
		try {
			j1.setGemas(6);
			assert(false);
			} catch (JugadorException e) {
				assert(true);
			}
	}

	@Test
	public void setGemasLimiteBajo() {
		try {
			j1.setGemas(-1);
			assert(false);
			} catch (JugadorException e) {
				assert(true);
			}
	}

	@Test
	public void setGemasLimite5() {
		try {
			j1.setGemas(5);
			assert(true);
			} catch (JugadorException e) {
				assert(false);
			}
	}

	@Test
	public void setGemasLimite0() {
		try {
			j1.setGemas(0);
			assert(true);
			} catch (JugadorException e) {
				assert(false);
			}
	}

	@Test
	public void resumen() {
		assertEquals("Nombre: OGRO Gemas: 0 Dinero: 0Pociones: 0", j3.resumen());
	}

	@Test
	public void encuentraGema() {
		j1.encuentraGema();
		assertEquals(1, j1.getGemas());
	}

	@Test
	public void encuentraDinero() {
		j1.encuentraDinero();
		assertEquals(1, j1.getDinero());
	}

	@Test
	public void rompeRocaConGema() {
		for (int i = 0; i < 10; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			j.encuentraGema();
			assertEquals(Constantes.ROMPE_ROCA_CON_GEMA, j.encuentraRoca());
		}
	}

	@Test
	public void ganaRocaOPierdeConRoca() {
		int encuentro = j1.encuentraRoca();
	
		assertTrue(encuentro == Constantes.GANA_A_LA_ROCA || encuentro == Constantes.PIERDE_A_LA_ROCA);
	}

	@Test
	public void lucha() {
		for (int i=0;i<10;i++) {
			int lucha = j4.lucha(j5);
			assertTrue(lucha == Constantes.EMPATE || lucha == Constantes.GANA_MUERE || lucha==Constantes.PIERDE_MUERE);
		}
		
	}
	
	@Test 
	public void luchaDinero() {
		for (int i=0;i<10;i++) {
			j4.encuentraDinero();
			j3.encuentraDinero();
			int lucha=j3.lucha(j4);
			assertTrue(lucha == Constantes.EMPATE || lucha == Constantes.GANA_DINERO || lucha==Constantes.PIERDE_DINERO);
		}
	}

}
