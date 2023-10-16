package villagegauloisold;

import personnages.Gaulois;

public interface IEtal {

	boolean isEtalOccupe();

	Gaulois getVendeur();

	int getQuantite();

	IProduit getProduit();

	void occuperEtal(Gaulois vendeur, Produit produit, int quantite);

	boolean contientProduit(Produit produit);

	int acheterProduit(int quantiteAcheter);

	void libererEtal();

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [2] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	String[] etatEtal();
	
    public void afficherProduits();
    
    public void occuperEtal(Produit produit);

}