package ca.qc.cgmatane.informatique.modele;

public class Voyage {
	protected int id;
	protected String nom;
	protected String destination;
	protected String description;
	protected int distance;
	protected int idVaisseau;

	protected Vaisseau vaisseau;
	
	public Voyage(int id, String nom, String destination, String description, int distance, int idVaisseau){
		this.id = id;
		this.nom = nom;
		this.destination = destination;
		this.description = description;
		this.distance = distance;
		this.idVaisseau = idVaisseau;
	}

	public Voyage(String nom, String destination, String description, int distance, int idVaisseau) {
		this.nom = nom;
		this.destination = destination;
		this.description = description;
		this.distance = distance;
		this.idVaisseau = idVaisseau;
	}

	public Vaisseau getVaisseau() {
		return vaisseau;
	}

	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getIdVaisseau() {
		return idVaisseau;
	}

	public void setIdVaisseau(int idVaisseau) {
		this.idVaisseau = idVaisseau;
	}
}
