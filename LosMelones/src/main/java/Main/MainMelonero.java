package Main;

import java.util.List;
import java.util.Scanner;

import DAO.MonstreDAO;
import Model.Monstre;

public class MainMelonero {

	
	
	public static void main(String[] args) {
		
		MonstreDAO monstreDAO = new MonstreDAO();
		
		NovaPartida partida1 = new NovaPartida(4);
		partida1.carregarDades();
		StartGame sg1 = new StartGame(4);
		
		List<Monstre> monstrePoder = sg1.ListMonstrePoderLliure();
		List<Monstre> monstresvius = sg1.ListMonstresVius();
		
		Monstre monstre = monstresvius.get(0);
		Monstre carta = monstrePoder.get(0);
		
		monstre.setMonstreCarta(carta);
		//carta.setMonstreCarta(monstre);
		
		//monstreDAO.Update(carta);
		monstreDAO.Update(monstre);
		
		
		
		
		//MenuKing mk1= new MenuKing("mk1");
		//mk1.MenuStart();
		/*Scanner scan = new Scanner(System.in);
		
		boolean jugar = true;
		int numeroJugadors=0;*/

		/*
		System.out.println("Benvinguts a King of Tokio, \n"+
		"Sisplau, indiqui número de jugadors per aquesta partida: ");
		numeroJugadors = scan.nextInt();
		System.out.println("Creant una partida per a " + numeroJugadors + " jugadors, esperi.");
		StartGame sg = new StartGame(numeroJugadors);
		NovaPartida partida1 = new NovaPartida(numeroJugadors);
		partida1.carregarDades();
		
		sg.SetMonstreTokioAleatori();
		List<Monstre> monstresVius = sg.ListMonstresVius();
		sg.ActualitzarMonstresVius();
		
		
		
		scan.close();
		*/
				
	}
}
