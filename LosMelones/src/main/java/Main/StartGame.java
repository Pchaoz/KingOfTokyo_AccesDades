package Main;

import java.util.ArrayList;
import java.util.Random;

import DAO.PartidaDAO;

public class StartGame {
	
	private int nJugadors;
	
	

	public StartGame(int nJugadors) {
		super();
		this.nJugadors = nJugadors;
		GenerarPartida();
	}

	public int getnJugadors() {
		return nJugadors;
	}

	public void setnJugadors(int nJugadors) {
		this.nJugadors = nJugadors;
	}
	

	private void GenerarPartida() {
		//aqui se genera la partida con los datos, dependiendo de los juagdores que tenga la partida
		Jugar();
	}
	
	private void Jugar() {
		boolean FiPartida=false;
		while(FiPartida) {
			//esta funcion ha de coger el turno de los jugadores
			SeleccionarTorn();
		}
	}
	
	
	private void SeleccionarTorn(){
		//cal comprobar si Tokio está lliure si cap
		//mosntre está a tokyo llavors el mosntre actual entra
		TirarDaus();
	}
	
	private void TirarDaus() {
		ArrayList <Integer>daus=new ArrayList<Integer>();
		Random azar= new Random();
		int dau;
		for (int i = 0; i < 6; i++) {
			dau= azar.nextInt(0,6+1);
			daus.add(dau);
		}
		
		//resoldreTirada(Jugador jugador);
		//comunica con clase monstre para que al jugador habil se le cambie los stats dependienddo de la tirada
		
		/*
		 * Sumar puntos de victoria.
		 * Sumar Vida
		 * Hacer Daño a los otros monstruos
		 * Si has pegado y no eres el monstruo de tokyo y el monstruo de tokyo esta vivo se ha de pregunatr si el monstruo de tokyo se quiere ir
		 * Si has matado al monstruo de Tokyo has de ser el monstruo de Tokyo
		 * Ganar Energia
		*/
		//Una vez resuelta la tira se debe comprobar:
		/*Cuanto poder teiens
		 * Condiciones de victoria: si eres el unico monstruo vivo o bien si tus puntis de victoria suben a 20 o mas.
		*/
		
	}
	private int ComprovarMonstres() {
		
		int vius = 0;
		
		//AQUEST METODE HA DE COMPROVAR EN UNA PARTIDA SI ELS MONSTRES DE TOTS ELS JUGADORS ESTA PER SOTA DE 1
		PartidaDAO partida = new PartidaDAO();
		
		partida.get(1);

		return vius;		
	}
}
