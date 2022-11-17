package Main;

import java.util.List;
import java.util.Scanner;

import Model.Monstre;

public class MainMelonero {

	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		boolean jugar = true;
		int numeroJugadors=0;
		/****MENU PRINCIPAL****/
		System.out.println("Benvinguts a King of Tokio, \n"+
		"Sisplau, indiqui número de jugadors per aquesta partida: ");
		numeroJugadors = scan.nextInt();
		System.out.println("Creant una partida per a " + numeroJugadors + " jugadors, esperi.");
		StartGame sg = new StartGame(numeroJugadors);
		NovaPartida partida1 = new NovaPartida(numeroJugadors);
		//partida1.carregarDades();
		
		sg.SetMonstreTokioAleatori();
		List<Monstre> monstresVius = sg.ListMonstresVius();
		sg.ActualitzarMonstresVius();
		
		
		
		scan.close();
		
				
	}
}
