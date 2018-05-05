package ca.qc.cgmatane.informatique.dao;

import java.util.List;

import ca.qc.cgmatane.informatique.modele.Vaisseau;
import ca.qc.cgmatane.informatique.modele.Voyage;

public class BuilderVaisseau {
	 protected int id, capaciter, porter;
	 protected String nom, description;
	 protected List<Voyage> listeVoyages;
	 protected String typeParseur;
	 public BuilderVaisseau SetParseur(String type){
		this.typeParseur = type;
		return this;
	 }
}
