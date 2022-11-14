package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "partides")
public class Partida {

	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_Partida", nullable = false)
	private int partidaID;
	
	@Column(name = "Torn", nullable = false)
	private int Torn;

	@Column(name = "Numero Jugadors", nullable = false)
	private int Njugadors;

	public int getPartidaID() {
		return partidaID;
	}

	public void setPartidaID(int partidaID) {
		this.partidaID = partidaID;
	}

	public int getNom() {
		return Torn;
	}

	public void setNom(int nom) {
		Torn = nom;
	}

	public int getNjugadors() {
		return Njugadors;
	}

	public void setNjugadors(int njugadors) {
		Njugadors = njugadors;
	}

	@Override
	public String toString() {
		return "Partida [partidaID=" + partidaID + ", Nom=" + Torn + ", Njugadors=" + Njugadors + "]";
	}

	
	
	
}
