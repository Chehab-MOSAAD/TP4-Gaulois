package villagegauloisold;

public interface IProduit {

	String getNom();

	void setDescription(String description);

	String getDescription();

	double calculerPrix(int prix);
	
}