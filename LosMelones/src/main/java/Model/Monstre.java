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
	@Column(name="id_monstre", nullable=false)
	private int id;
	
	@Column(name="partida", nullable = false)
	private Partida partida;
	
	@Column(name="jugador", length = 40, nullable = false)
	private Jugador jugador;
	
	@Column(name="nom", nullable = false)
	private String nom;
	
	@Column(name="vides", columnDefinition = "10", nullable=false)
	private int vides;
	
	@Column(name="p_victoria", columnDefinition = "0", nullable=false)
	private int p_victoria;
	
	@Column(name="energia", columnDefinition =  "0", nullable=false)
	private int energia;
	
	@Column(name="toquio", columnDefinition = "false", nullable=false)
	private boolean toquio;
	
	@Column(name="eliminat", nullable=false)
	private boolean eleminat;
	
	@Column(name="id_m_poder", nullable = false)
	private int id_m_poder;
}
