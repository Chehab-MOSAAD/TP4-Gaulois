package villagegauloisold;

public class Poisson extends Produit {
    private String dateDePeche;

    public Poisson(String dateDePeche) {
        super("poisson", Unite.PIECE);
        this.dateDePeche = dateDePeche;
    }

    @Override
    public void setDescription(String description) {
        // la méthode setDescription() ne fait rien dans la classe Poisson,
        // car la description est spécifiée dans la méthode getDescription().
    }

    @Override
    public String getDescription() {
        return "Poisson pêché " + dateDePeche + ".";
    }

    @Override
    public double calculerPrix(int prix) {
        return prix;
    }
}