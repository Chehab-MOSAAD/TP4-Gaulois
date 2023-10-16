package scenarioTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import personnages.Gaulois;
import villagegauloisold.DepenseMarchand;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegauloisold.Poisson;
import villagegauloisold.Produit;
import villagegauloisold.Sanglier;
import village.IVillage;

public class Scenario {

	public static void main(String[] args) {

		// Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
		    private Etal<Sanglier> etalSanglierObelix = new Etal<>();
		    private Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		    private Etal<Poisson> etalPoisson = new Etal<>();
 
		    @Override
		    public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
		        etal.installerVendeur(vendeur, produit, prix);
		        return true;
		    }

		    @Override
		    public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
		        List<DepenseMarchand> depenses = new ArrayList<>();
		        System.out.println("I'm here 1");

		        int qteVendue = etalSanglierAsterix.contientProduit(produit, quantiteSouhaitee);
		        if (qteVendue > 0) {
		            double prixPaye = etalSanglierAsterix.acheterProduit(qteVendue);
		            depenses.add(new DepenseMarchand(etalSanglierAsterix.getVendeur(), qteVendue, produit, prixPaye));
		            quantiteSouhaitee -= qteVendue;
		        }

		        qteVendue = etalSanglierObelix.contientProduit(produit, quantiteSouhaitee);
		        if (qteVendue > 0) {
		            double prixPaye = etalSanglierObelix.acheterProduit(qteVendue);
		            depenses.add(new DepenseMarchand(etalSanglierObelix.getVendeur(), qteVendue, produit, prixPaye));
		            quantiteSouhaitee -= qteVendue;
		        }
		        
		        qteVendue = etalPoisson.contientProduit(produit, quantiteSouhaitee);
		        if (qteVendue > 0) {
		            double prixPaye = etalPoisson.acheterProduit(qteVendue);
		            depenses.add(new DepenseMarchand(etalPoisson.getVendeur(), qteVendue, produit, prixPaye));
		        }

		        return depenses.toArray(new DepenseMarchand[depenses.size()]);
		    }
		};

		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal etalSanglierObelix = new Etal<>();
		Etal etalSanglierAsterix = new Etal<>();
		Etal etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
