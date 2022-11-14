package Main;

import java.util.ArrayList;

import DAO.JugadorDAO;
import DAO.MonstreDAO;
import DAO.PartidaDAO;
import Model.Jugador;
import Model.Monstre;
import Model.Partida;

public class NovaPartida {
	
	int nJugadors;
	
	NovaPartida(int numJugadors){
		this.nJugadors = numJugadors;
	}
	
	public void carregarDades() {
		
		/******Crear la partida******/
		
		PartidaDAO partidaDAO = new PartidaDAO();
		
		Partida partida = new Partida();
		partidaDAO.Insert(partida);
		
		/******Crear Jugadors******/
		JugadorDAO jugadorDAO = new JugadorDAO();
		Jugador jugador1 = new Jugador("Raul", "Martin-Caro");
		Jugador jugador2 = new Jugador("Pol", "Sotillos");
		Jugador jugador3 = new Jugador("Jose", "Fuentes");
		Jugador jugador4 = new Jugador("Eloi", "Vazquez");
		
			/*Els fiquem a una llista de jugadors*/
		ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
		jugadors.add(jugador1);
		jugadors.add(jugador2);
		jugadors.add(jugador3);
		jugadors.add(jugador4);
		
		
		/******Crear Monstres******/
		MonstreDAO monstreDAO = new MonstreDAO();
		Monstre monstre1 = new Monstre(partida, "King");
		Monstre monstre2 = new Monstre(partida, "MekaDracron");
		Monstre monstre3 = new Monstre(partida, "Ciberkitty");
		Monstre monstre4 = new Monstre(partida, "Gigazaur");
		Monstre monstre5 = new Monstre(partida, "Space Penguin");
		Monstre monstre6 = new Monstre(partida, "Alienoid");
		
			/*Els fiquem a una llista de monstres*/
		ArrayList<Monstre> monstres = new ArrayList<Monstre>();
		monstres.add(monstre1);
		monstres.add(monstre2);
		monstres.add(monstre3);
		monstres.add(monstre4);
		monstres.add(monstre5);
		monstres.add(monstre6);
		
		/*Seleccionem un monstre aleatori de la llista, li assignem a un jugador i ho assignem a la partida*/
		for (int i = 0; i < this.nJugadors; i++) {
			Jugador seguentJugador = jugadors.get(i);
			int random = (int) Math.random() * monstres.size();
			Monstre monstreAleatori = monstres.get(random);
			monstres.remove(random);
			monstreAleatori.setJugador(seguentJugador);
			monstreAleatori.setPartida(partida);
			jugadorDAO.Insert(seguentJugador);
			monstreDAO.Insert(monstreAleatori);
		}
		
	}
	
}
