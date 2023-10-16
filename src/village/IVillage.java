package village;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegauloisold.DepenseMarchand;
import villagegauloisold.Produit;

public interface IVillage {
	public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix);
	public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee);
}
