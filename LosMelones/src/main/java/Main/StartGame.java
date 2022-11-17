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

		System.out.println("Els resultats de les tirades son: " + resultadosDados.get(0) + " uns, "
				+ resultadosDados.get(1) + " dosos, " + resultadosDados.get(2) + " tresos, " + resultadosDados.get(3)
				+ " d'energia, " + resultadosDados.get(4) + " garres i " + resultadosDados.get(5) + " cors.");

		resoldreTirada(resultadosDados, JugActiu);

	}

	// cal comprobar si Tokio está lliure si cap
	// mosntre está a tokyo llavors el mosntre actual entra
	// Función de simulacion de tiradas de dados
	private void resoldreTirada(ArrayList<Integer> resultados, Jugador JugActiu) {
		//si Tokyo esta buit posem el monstre del jugador actiu a a Tokyo
		if(!HiHaMonstreTokio()) {
			System.out.println("Tokyo esta buit! Felicitats pots entrara a Tokyo!");
			SetMonstreTokyo(JugActiu);
		}
		//resolució de tirades
		//cas de sumar punts
		//En cas de sumar punts per daus amb el numeru 1
		if(resultados.get(0)>=3) {
			switch (resultados.get(0)){
				case 3:
					SumarPuntsMonstre(JugActiu, 1);
					break;
				case 4:
					SumarPuntsMonstre(JugActiu, 2);
					break;
				case 5:
					SumarPuntsMonstre(JugActiu, 3);
					break;
				case 6:
					SumarPuntsMonstre(JugActiu, 4);
					break;
			}
		}
		//En cas de sumar punts per daus amb el numeru 2
		if(resultados.get(1)>=3) {
			switch (resultados.get(0)){
				case 3:
					SumarPuntsMonstre(JugActiu, 2);
					break;
				case 4:
					SumarPuntsMonstre(JugActiu, 3);
					break;
				case 5:
					SumarPuntsMonstre(JugActiu, 4);
					break;
				case 6:
					SumarPuntsMonstre(JugActiu, 5);
					break;
			}
		}
		//En cas de sumar punts per daus amb el numeru 3
		if(resultados.get(2)>=3) {
			switch (resultados.get(0)){
				case 3:
					SumarPuntsMonstre(JugActiu, 3);
					break;
				case 4:
					SumarPuntsMonstre(JugActiu, 4);
					break;
				case 5:
					SumarPuntsMonstre(JugActiu, 5);
					break;
				case 6:
					SumarPuntsMonstre(JugActiu, 6);
					break;
			}
		}
		//En cas de sumar punt d'Energia
		if(resultados.get(3)>=1) {
			SumarPuntsEnergiaMonstre(JugActiu, resultados.get(3));
		}
		// En casa de que tingui garres
		if(resultados.get(4)>=1) {
			MonstrePega(JugActiu, resultados.get(4));
		}
		//en cas de que tregui cors
		if(resultados.get(5)>=1) {
			MonstreCuracio(JugActiu, resultados.get(5));
		}

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


	public void SetMonstreTokyo(Jugador jug) {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for(Monstre monstre : llistaMonstres) {
			if(monstre.getJugador()==jug) {
				monstre.setToquio(true);
				System.out.println("Sha ubicat a Tokyo el monstre "+monstre.getNom()+".");

			}else {
				monstre.setToquio(false);
			}
		}
		for (Monstre monstre : llistaMonstres) {
			monstreDAO.Update(monstre);
		}
	}

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
	//funcio per a sumar punts amb els valor de 1,2 y 3 enb els daus
	public void SumarPuntsMonstre(Jugador jug, int suma) {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for(Monstre monstre : llistaMonstres) {
			if(monstre.getJugador()==jug) {
				int var= monstre.getP_victoria() + suma;
				monstre.setP_victoria(var);
				System.out.println("El Monstre "+monstre.getNom()+" suma un total de "+var+" punts, la seva puntuació actual es de "+monstre.getP_victoria()+" punts.");
				monstreDAO.Update(monstre);


			}
		}

	}
	//funcio per guanyar punts d'energia
	public void SumarPuntsEnergiaMonstre(Jugador jug, int suma) {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for(Monstre monstre : llistaMonstres) {
			if(monstre.getJugador()==jug) {
				int var= monstre.getEnergia() + suma;
				monstre.setEnergia(var);
				System.out.println("El Monstre "+monstre.getNom()+" suma un total de "+var+" punts d'energia, té un total "+monstre.getEnergia()+" punts d'energia.");
				monstreDAO.Update(monstre);
			}
		}

	}
	//funco per a que mosntre pegui als altres monstres
	public void MonstrePega(Jugador jug, int suma) {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for(Monstre monstre : llistaMonstres) {
			if(monstre.getJugador()==jug) {
			//si el monstre del jugador está a Tokyo
				if(monstre.isToquio()) {
					//comprobo tots els monstres
					for(Monstre monstreAtacat : llistaMonstres) {
						//si el monstre no es el monstre que esta atacant
						if(monstre!=monstreAtacat) {
							int var =monstreAtacat.getVides()-suma;
							monstreAtacat.setVides(var);
							System.out.println("El Monstre "+monstreAtacat.getNom()+" es atacat per "+monstre.getNom()+" li fa un total de "+suma+" punts de mal, la seva vida actual es de "+monstreAtacat.getVides()+".");
						}
					}
				}else {
					//busquem el monstre de Tokyo per fer-li mal
					for (Monstre monstreTokyo : llistaMonstres) {
						if(monstreTokyo.isToquio()) {
							int var =monstreTokyo.getVides()-suma;
							monstreTokyo.setVides(var);
							System.out.println("El Monstre "+monstreTokyo.getNom()+" está a Tokyo i es atacat per "+monstre.getNom()+" li fa un total de "+suma+" punts de mal, la seva vida actual es de "+monstreTokyo.getVides()+".");
							//funcio per si mosntre es queda o no
							meQuedoOno(monstreTokyo,monstre);

						}
				}

				}
			}
		}
		for (Monstre monstre : llistaMonstres) {
			monstreDAO.Update(monstre);
		}

	}

	public void meQuedoOno(Monstre monstreTokyo,Monstre monstreAtacant) {
		if(monstreTokyo.getVides()<=0) {
			//monstreTokyo.isEleminat()
		}
		Random azar= new Random();
		boolean meQuedo=azar.nextBoolean();
		if(!meQuedo) {
			monstreTokyo.setToquio(false);
			monstreAtacant.setToquio(true);
			System.out.println("El monstre "+monstreTokyo.getNom()+" es un cobard i surt de Tokyo!");
			System.out.println("El monstre "+monstreAtacant.getNom()+" es el nou rey de Tokyo!");

		}else {
			System.out.println("El monstre "+monstreTokyo.getNom()+" esta fet un toro, aguanta en Tokyo!");
		}
	}

	public void MonstreCuracio(Jugador jug, int suma){
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for(Monstre monstre : llistaMonstres) {
			if(monstre.getJugador()==jug) {
				if(!monstre.isToquio()) {
					int var =monstre.getVides()+suma;
					monstre.setVides(var);
					System.out.println("El Monstre "+monstre.getNom()+" es cura un total de "+var+" punts de vida té un total "+monstre.getVides()+" punts dwe vida.");

					monstreDAO.Update(monstre);

				}
			}
		}
	}
	public boolean HiHaMonstreTokio() {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for (Monstre monstre : llistaMonstres) {
			if (monstre.isToquio()) {
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

	public void ActualitzarMonstresVius() {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		for (Monstre monstre : llistaMonstres) {
			if (monstre.getVides() <= 0) {
				System.out.println("El monstre "+monstre.getNom()+" té una vida de "+monstre.getVides()+" está eliminat!");
				monstre.setEleminat(true);
			}
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

	public List<Monstre> ListMonstresVius() {
		MonstreDAO monstreDAO = new MonstreDAO();
		List<Monstre> llistaMonstres = monstreDAO.listar();
		List<Monstre> llistaVius = new ArrayList<Monstre>();
		for (Monstre monstre : llistaMonstres) {
			if(!monstre.isEleminat()) {
				llistaVius.add(monstre);
			}
		}
		return llistaVius;
	}
}
