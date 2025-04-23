import java.util.ArrayList;

public class CryptoMarche
{

	private ArrayList<Portefeuille> portefeuilles;
	private static CryptoMarche marche;

	private CryptoMarche()
	{
		portefeuilles = new ArrayList<Portefeuille>();
	}

	public static CryptoMarche getInstance()
	{
		if(marche == null){ marche = new CryptoMarche();}
		return marche;
	}

	public void ajouter(Portefeuille p)
	{
		portefeuilles.add(p);
	}

	/**
	 * Cette fonction recherche sur le marché tous les portefeuilles 
	 * du propriétaire et calcule son capital en euros. 
	 * @param proprietaire
	 * @return capital en euros du propriétaire.
	 */
	public double capitalEnEuros(String proprietaire)
	{
		double capitalTotal = 0;

		for (Portefeuille p : portefeuilles)
		{
			if (p.estProprietaire(proprietaire))
			{
				capitalTotal += p.valeurEnEuros();
			}
		}

		return capitalTotal;
	}

	/**
	 * Cette fonction recherche sur le marché tous les portefeuilles 
	 * d'un type de devise et calcule le volume total de capital de 
	 * cette devise sur le marché 
	 * @param monnaie
	 * @return capital total en circulation de la cryptomonnaie (en euros).
	 */
	public double capitalMonneaie(Cryptomonnaie monnaie)
	{
		double capitalTotal = 0;

		for (Portefeuille p : portefeuilles)
		{
			if (p.getMonnaie().getNom().equals(monnaie.getNom()))
			{
				capitalTotal += p.valeurEnEuros();
			}
		}

		return capitalTotal;
	}

	@Override
	public String toString()
	{
		String ret = "";
		for(Portefeuille p : this.portefeuilles){
			ret += p.toString() + "\n";
		}
		return ret;
	}

}