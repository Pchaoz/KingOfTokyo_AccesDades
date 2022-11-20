package Main;

import java.util.List;
import java.util.Scanner;

import Model.Monstre;

public class MenuKing {
	

	public MenuKing() {
		super();
	}

	public void MenuStart() {
		
		boolean sortir= false;
		
		int numeroJugadors=0;
		
		StartGame sg = null;
		
		Scanner sc = new Scanner(System.in);
		
		while(sortir!=true) {
			
			
			System.out.println("Benvingut al menú de King of Tokyo!");
			
			System.out.println("----------------------------------------");
			
			System.out.println("Escolleix una opció:");
			System.out.println("1- Crear noves dades. ");
			System.out.println("2- Iniciar simulació. ");
			System.out.println("3- Assignar monstre aleatri en Tokyo. ");
			System.out.println("4- Llistar monstres vius. ");
			System.out.println("5- Actualitzar monstres vius. ");
			System.out.println("6- Sortir. ");

			int opcio=sc.nextInt();
			
			
			switch (opcio) {
			case 1:
				System.out.println("Quants jugadors jugaran? Mínim:2 i Màxim:4.");
				
				numeroJugadors=sc.nextInt();
				
				System.out.println("Creant una partida per a " + numeroJugadors + " jugadors, esperi.");
				
				NovaPartida partida1 = new NovaPartida(numeroJugadors);
				
				sg = new StartGame(numeroJugadors);
				
				partida1.carregarDades();
				
				break;
			case 2:
				if (numeroJugadors == 0) {

					System.out.println("Cal indicar primer el número de jugadors!");

					break;
				} else {

					System.out.println("Benvingut al joc de King of Tokyo!");

					System.out.println("En aquest s'enfrenten diferents monstres per la supermacia de Tokyo!");

					sg.Jugar();

					break;
				}
			case 3:
				if (sg == null) {

					System.out.println("Inicialitza dades per poder accedir!");

					break;

				} else {
					System.out.println("Asignant monstre aleatori a  Tokyo!");

					sg.SetMonstreTokioAleatori();

					break;
				}

			case 4:
				if (sg == null) {

					System.out.println("Inicialitda dades per poder accedir!");

					break;

				} else {
					System.out.println("Llistant monstres vius a Tokyo!");

					List<Monstre> monstresVius = sg.ListMonstresVius();

					break;
				}
			case 5:
				if (sg == null) {

					System.out.println("Inicialitda dades per poder accedir!");

					break;

				} else {
					System.out.println("Actualitzant monstres vius i informant dels monstres morts!");

					sg.ActualitzarMonstresVius();

					break;

				}
			case 6:

				System.out.println("Acabant progrma, fins la propera!");

				sortir = true;
			default:
				System.out.println("Opció incorrecta!");
				break;
			}

		}

		sc.close();
	}
}