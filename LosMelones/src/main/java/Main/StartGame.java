package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import DAO.MonstreDAO;
import Model.Monstre;

import DAO.JugadorDAO;
import Model.Jugador;

public class StartGame {

	private int nJugadors;

	public StartGame(int nJugadors) {
		super();
		this.nJugadors = nJugadors;
		Jugar();
	}

	public int getnJugadors() {
		return nJugadors;
	}

	public void setnJugadors(int nJugadors) {
		this.nJugadors = nJugadors;
	}

	private void Jugar() {
		boolean FiPartida = false;

		JugadorDAO jugadorDao = new JugadorDAO();
		List<Jugador> jugadors = jugadorDao.listar();
		Collections.shuffle(jugadors);

		while (!FiPartida) {

			System.out.println("Es el torn del jugador " + jugadors.get(0));
			Jugador jugadorActiu = jugadors.get(0);
			TirarDaus(jugadorActiu);
		}
	}

	private void TirarDaus(Jugador JugActiu) {

		ArrayList<Integer> resultadosDados = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			resultadosDados.add(0);
		}
		int var = 0;
		Random azar = new Random();
		int dau;
		for (int i = 0; i < 6; i++) {
			dau = azar.nextInt(0, 6 + 1);

			switch (dau) {
			case 1:
				var = resultadosDados.get(0) + 1;
				resultadosDados.set(0, var);
				break;
			case 2:
				var = resultadosDados.get(1) + 1;
				resultadosDados.set(1, var);
				break;
			case 3:
				var = resultadosDados.get(2) + 1;
				resultadosDados.set(2, var);
				break;
			case 4:
				var = resultadosDados.get(3) + 1;
				resultadosDados.set(3, var);
				break;
			case 5:
				var = resultadosDados.get(4) + 1;
				resultadosDados.set(4, var);
				break;
			case 6:
				var = resultadosDados.get(5) + 1;
				resultadosDados.set(5, var);
				break;
			}

		}

		System.out.println("Los resultados de la tirada són " + resultadosDados.get(0) + " unos, "
				+ resultadosDados.get(1) + " doses, " + resultadosDados.get(2) + " treses, " + resultadosDados.get(3)
				+ " de energia, " + resultadosDados.get(4) + " garras i " + resultadosDados.get(5) + " corazones.");

		resoldreTirada(resultadosDados, JugActiu);

	}

	// cal comprobar si Tokio está lliure si cap
	// mosntre está a tokyo llavors el mosntre actual entra
	// Función de simulacion de tiradas de dados
	private void resoldreTirada(ArrayList<Integer> resultados, Jugador JugActiu) {




	}
	// comunica con clase monstre para que al jugador habil se le cambie los stats
	// dependienddo de la tirada

	/*
	 * Sumar puntos de victoria. Sumar Vida Hacer Daño a los otros monstruos Si has
	 * pegado y no eres el monstruo de tokyo y el monstruo de tokyo esta vivo se ha
	 * de pregunatr si el monstruo de tokyo se quiere ir Si has matado al monstruo
	 * de Tokyo has de ser el monstruo de Tokyo Ganar Energia
	 */
	// Una vez resuelta la tira se debe comprobar:
	/*
	 * Cuanto poder teiens Condiciones de victoria: si eres el unico monstruo vivo o
	 * bien si tus puntis de victoria suben a 20 o mas.
	 */


	public void SetMonstreTokioAleatori() {
		MonstreDAO monstreDAO = new MonstreDAO();
		//Fiquem tots els resultats
		List<Monstre> llistaMonstres = monstreDAO.listar();
		int random = (int) Math.random() * llistaMonstres.size();
		for (int i = 0; i < llistaMonstres.size(); i++) {
			if(random == i) {
				llistaMonstres.get(i).setToquio(true);
				System.out.println("S' ha ubicat a Toquio el monstre " + llistaMonstres.get(i).getNom() + ".");
			} else {
				llistaMonstres.get(i).setToquio(false);
			}
		}

		for (Monstre monstre : llistaMonstres) {
			monstreDAO.Update(monstre);
		}
	}

	public boolean HiHaMonstreTokio() {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for (Monstre monstre : llistaMonstres) {
			if(monstre.isToquio()) {
				System.out.println("Hi ha un monstre a Toquio. Nom: " + monstre.getNom());
				return true;
			}
		}
		return false;
	}
	public int ComprovarMonstres() {

		int vius = 0;

		MonstreDAO mons = new MonstreDAO();
		List<Monstre> monsList = mons.listar();

		for (Monstre mon : monsList) {
			if (!mon.isEleminat()) {
				System.out.println(mon.getNom() + " esta encara viu i te " + mon.getVides() + "!!");
				vius++;
			}
		}
		return vius;
	}
	
	public Monstre GetMonstreToquio() {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for (Monstre monstre : llistaMonstres) {
			if(monstre.isToquio()) {
				return monstre;
			}
		}
		return null;
	}
	
	public List<Monstre> ListMonstresViusContrincants(Monstre mons) {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		List<Monstre> monstresContrincants = new ArrayList<Monstre>();
		for (Monstre monstre : monstresContrincants) {
			if(monstre.getId() != mons.getId() && !monstre.isEleminat()) {
				monstresContrincants.add(monstre);
			}
		}
		return monstresContrincants;
	}
}
