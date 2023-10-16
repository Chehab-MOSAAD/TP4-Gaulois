package scenarioTest;

import personnages.Gaulois;
import villagegauloisold.DepenseMarchand;
import villagegauloisold.IProduit;
import villagegaulois.IEtal;
import villagegaulois.Etal;
import villagegauloisold.Poisson;
import villagegauloisold.Sanglier;

public class ScenarioTest {
	public static void main(String[] args) {
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };
		
		Etal<IProduit> etalSanglierObelix = new Etal<>();
		Etal<IProduit> etalSanglierAsterix = new Etal<>();
		Etal<IProduit> etalPoisson = new Etal<>();

		etalSanglierAsterix.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglierObelix.installerVendeur(obelix, sangliersObelix, 8);
		etalPoisson.installerVendeur(ordralfabetix, poissons, 5);
		
		System.out.println("ETAT MARCHE");
		System.out.println(etalSanglierAsterix.etatEtal());
		System.out.println(etalSanglierObelix.etatEtal());
		System.out.println(etalPoisson.etatEtal());
		
        int quantiteAchete = etalSanglierAsterix.contientProduit("sanglier", 2);
        double prixPaye = etalSanglierAsterix.acheterProduit(quantiteAchete);
        DepenseMarchand depenseAsterix = new DepenseMarchand(asterix, quantiteAchete, "sanglier", prixPaye);
        System.out.println(depenseAsterix.toString());
        
        quantiteAchete = etalSanglierObelix.contientProduit("sanglier", 1);
        prixPaye = etalSanglierObelix.acheterProduit(quantiteAchete);
        DepenseMarchand depenseObelix = new DepenseMarchand(obelix, quantiteAchete, "sanglier", prixPaye);
        System.out.println(depenseObelix.toString());
        
		System.out.println("ETAT MARCHE");
		System.out.println(etalSanglierAsterix.etatEtal());
		System.out.println(etalSanglierObelix.etatEtal());
		System.out.println(etalPoisson.etatEtal());
	}
}
