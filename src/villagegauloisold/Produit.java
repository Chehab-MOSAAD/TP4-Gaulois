package villagegauloisold;

public abstract class Produit implements IProduit {
	protected String nom;
    protected Unite unite;

    public Produit(String nom, Unite unite) {
        this.nom = nom;
        this.unite = unite;
    }

    @Override
	public String getNom() {
        return nom;
    }

    @Override
	public void setDescription(String description) {
        // la méthode setDescription() ne fait rien dans la classe Produit,
        // car la description dépend du type de produit, qui est spécifié dans ses sous-classes.
    }

    @Override
	public String getDescription() {
        // la méthode getDescription() ne fait rien dans la classe Produit,
        // car la description dépend du type de produit, qui est spécifié dans ses sous-classes.
        return "";
    }
}