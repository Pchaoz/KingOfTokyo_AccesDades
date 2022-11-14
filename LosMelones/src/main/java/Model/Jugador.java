package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadors")
public class Jugador {

	@Id
	@GeneratedValue
	@Column(name = "ID_Jugador", nullable = false)
	private int jugID;

	@Column(name = "Nom", length = 50 , nullable = false)
	private String Nom;

	@Column(name = "Cognom", length = 50 , nullable = false)
	private String Cognom;

	
	public Jugador() {
		super();
	}

	public int getJugID() {
		return jugID;
	}

	public void setJugID(int jugID) {
		this.jugID = jugID;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getCognom() {
		return Cognom;
	}

	public void setCognom(String cognom) {
		Cognom = cognom;
	}

	@Override
	public String toString() {
		return "Jugador [jugID=" + jugID + ", Nom=" + Nom + ", Cognom=" + Cognom + "]";
	}
	
}
