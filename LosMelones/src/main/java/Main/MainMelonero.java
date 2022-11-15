package Main;

import java.util.Scanner;

public class MainMelonero {

	public static void main(String[] args) {
		
	
		boolean jugar= true;
		
		int numeroJugadors=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Benvingut al joc de King of Tokyo!");
		
		System.out.println("En aquest s'enfrenten diferents monstres per la supermacia de Tokyo!");
		
		System.out.println("Vols jugar?");
		
		
		while(jugar!=false) {
			
			System.out.println("Quants jugadors jugaran? Mínim:2 i Màxim:4.");
			
			numeroJugadors=sc.nextInt();
			
			System.out.println("Jugaran "+numeroJugadors+" jugadors.");
			System.out.println("----------------------------------------");
			
			NovaPartida partida1 = new NovaPartida(numeroJugadors);
			partida1.carregarDades();
			StartGame st= new StartGame(numeroJugadors);
			
			System.out.println("----------------------------------------");
			System.out.println("Vols tornar a jugar? 1=SI, Qualsevol altre númer serà NO.");
			
			int jugarMes=sc.nextInt();
			
			if(jugarMes==1) {
				
			}else {
				jugar=false;
			}
			
		}
		
		System.out.println("Joc acabat!");
		sc.close();
	}
}
