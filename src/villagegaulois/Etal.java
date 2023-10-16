package villagegaulois;

import personnages.Gaulois;
import villagegauloisold.IProduit;

public class Etal<P extends IProduit> implements IEtal {
    private Gaulois vendeur;
    private P[] produits;
    private int nbProduits;
    private int prix;

    @Override
    public Gaulois getVendeur() {
        return this.vendeur;
    }

    @Override
    public double donnerPrix() {
        return this.prix;
    }

    @Override
    public int contientProduit(String produit, int quantiteSouhaitee) {
        int quantiteAVendre = 0;
        if (nbProduits != 0 && this.produits[0].getNom().equals(produit)) {
            if (nbProduits >= quantiteSouhaitee) {
                    quantiteAVendre = quantiteSouhaitee;
            } else {
                    quantiteAVendre = nbProduits;
            }
        } 
        return quantiteAVendre;
    } 
    
    @Override
    public double acheterProduit(int quantiteSouhaitee) {
        double prixPaye = 0;
        for (int i = nbProduits - 1; i > nbProduits - quantiteSouhaitee - 1 || i > 1; i--) {
            prixPaye += produits[i].calculerPrix(prix);
        } 
        if (nbProduits >= quantiteSouhaitee) {
            nbProduits -= quantiteSouhaitee;
        } else {
            nbProduits = 0;
        }
        return prixPaye;
    }
        
    @Override
    public String etatEtal() {
        StringBuilder chaine = new StringBuilder(vendeur.getNom());
        if (nbProduits > 0) {
            chaine.append(" vend ");
            chaine.append(nbProduits + " produits :");
            for (int i = 0; i < nbProduits; i++) {
                chaine.append("\n- " + produits[i].getDescription());
            }
        } else {
            chaine.append(" n'a plus rien à vendre.");
        }
        chaine.append("\n");
        return chaine.toString();
    }

    public void installerVendeur(Gaulois vendeur, P[] produits, int prix) {
        this.vendeur = vendeur;
        this.produits = produits;
        this.nbProduits = produits.length;
        this.prix = prix;
    }
}
