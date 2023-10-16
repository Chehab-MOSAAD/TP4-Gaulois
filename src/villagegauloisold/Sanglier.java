package villagegauloisold;

import personnages.Gaulois;

public class Sanglier extends Produit implements IProduit {
    private int poids;
    private Gaulois chasseur;

    public Sanglier(int poids, Gaulois chasseur) {
        super("sanglier", Unite.KILOGRAMME);
        this.poids = poids;
        this.chasseur = chasseur;
    }

    @Override
    public void setDescription(String description) {
        // la méthode setDescription() ne fait rien dans la classe Sanglier,
        // car la description est spécifiée dans la méthode getDescription().
    }

    @Override
    public String getDescription() {
        return "Sanglier de " + poids + " kg chassé par " + chasseur.getNom() + ".";
    }

    @Override
    public double calculerPrix(int prix) {
        return (prix * poids) / 1000;
    }
}