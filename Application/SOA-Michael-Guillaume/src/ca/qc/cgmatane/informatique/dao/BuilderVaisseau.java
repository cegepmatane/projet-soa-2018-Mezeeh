package ca.qc.cgmatane.informatique.dao;

import java.util.List;

import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;

public class BuilderVaisseau {
	 protected int id, capaciter, porter;
	protected String nom, description;
	 protected List<Voyage> listeVoyages;
	 
	 public BuilderVaisseau setId(int id) {
			this.id = id;
			return this;
	}
	public BuilderVaisseau setCapaciter(int capaciter) {
		this.capaciter = capaciter;
		return this;
	}
	public BuilderVaisseau setPorter(int porter) {
		this.porter = porter;
		return this;
	}
	public BuilderVaisseau setNom(String nom) {
		this.nom = nom;
		return this;
	}
	public BuilderVaisseau setDescription(String description) {
		this.description = description;
		return this;
	}
	public BuilderVaisseau setListeVoyages(List<Voyage> listeVoyages) {
		this.listeVoyages = listeVoyages;
		return this;
	}
	public Vaisseau buildVaisseau()
	{
		return new Vaisseau(id, nom, description, capaciter, porter);
	}
}
