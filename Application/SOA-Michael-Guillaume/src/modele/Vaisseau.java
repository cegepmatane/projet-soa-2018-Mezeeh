package modele;

public class Vaisseau {
    protected int id,
                capaciter,
                porter;

    protected String nom,
                    description;

    public Vaisseau(int id, String nom, String description, int capaciter, int porter) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.capaciter = capaciter;
        this.porter = porter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapaciter() {
        return capaciter;
    }

    public void setCapaciter(int capaciter) {
        this.capaciter = capaciter;
    }

    public int getPorter() {
        return porter;
    }

    public void setPorter(int porter) {
        this.porter = porter;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
