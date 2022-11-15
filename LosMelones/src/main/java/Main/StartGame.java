package Main;

import java.util.ArrayList;
import java.util.Random;

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
		Jugar();
	}
	
	private void Jugar() {
		boolean FiPartida=false;
		while(!FiPartida) {
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
		//Función de simulacion de tiradas de dados	
		int cont1=0;
		int cont2=0;
		int cont3=0;
		int contEnergy=0;
		int contGarra=0;
		int contCorazon=0;

		Random azar= new Random();
		int dau;
		for (int i = 0; i < 6; i++) {
			dau= azar.nextInt(0,6+1);
			
			switch (dau) {
			case 1: 
				cont1++;
				break;
			case 2:
				cont2++;
				break;
			case 3:
				cont3++;
				break;
			case 4:
				contEnergy++;
				break;
			case 5:
				contGarra++;
				break;
			case 6:
				contCorazon++;
				break;
			}
			
		}
		
		System.out.println("Los resultados de la tirada són "+cont1+" unos, "+cont2+" doses, "+cont3+" treses, "
		+contEnergy+" de energia, "+contGarra+" garras i "+contCorazon+" corazones.");
		
		ArrayList<Integer>resultadosDados= new ArrayList<Integer>();
		resultadosDados.add(cont1);
		resultadosDados.add(cont2);
		resultadosDados.add(cont3);
		resultadosDados.add(contEnergy);
		resultadosDados.add(contGarra);
		resultadosDados.add(contCorazon);
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
