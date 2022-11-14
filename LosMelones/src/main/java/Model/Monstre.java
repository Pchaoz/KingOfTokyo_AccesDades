package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monstres")
public class Monstre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_monstre")
	private int id;
	
	@Column(name="partida")
	private Partida partida;
	
	@Column(name="jugador")
	private Jugador jugador;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="vides")
	private int vides;
	
	@Column(name="p_victoria")
	private int p_victoria;
	
	@Column(name="energia")
	private int energia;
	
	@Column(name="toquio")
	private boolean toquio;
	
	@Column(name="eliminat")
	private boolean eleminat;
	
	@Column(name="id_m_poder")
	private int id_m_poder;
}
