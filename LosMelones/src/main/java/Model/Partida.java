package Model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "partides")
public class Partida {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Partida")
	private int partidaID;
	
	@Column(name = "Torn")
	private int Nom;

	@Column(name = "Numero Jugadors",length=1)
	private int Njugadors;

	@OneToMany(mappedBy="partida", cascade = CascadeType.ALL)
	private Set<Monstre> monstres;
	
	public int getPartidaID() {
		return partidaID;
	}

	public void setPartidaID(int partidaID) {
		this.partidaID = partidaID;
	}

	public int getNom() {
		return Nom;
	}

	public void setNom(int nom) {
		Nom = nom;
	}

	public int getNjugadors() {
		return Njugadors;
	}

	public void setNjugadors(int njugadors) {
		Njugadors = njugadors;
	}

	@Override
	public String toString() {
		return "Partida [partidaID=" + partidaID + ", Nom=" + Nom + ", Njugadors=" + Njugadors + "]";
	}

	
	
	
}
