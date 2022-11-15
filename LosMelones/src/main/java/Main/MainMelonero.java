package Main;

import java.util.Scanner;

public class MainMelonero {

	public static void main(String[] args) {
		
	
		boolean jugar= true;
		
		int numeroJugadors=4;
		
		NovaPartida partida1 = new NovaPartida(numeroJugadors);
		
		partida1.carregarDades();
		
		StartGame sg = new StartGame(numeroJugadors);
		sg.SetMonstreTokioAleatori();
		System.out.println(sg.HiHaMonstreTokio());
		
		
	}
}
