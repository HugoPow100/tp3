public class Portefeuille
{
	private Cryptomonnaie monnaie;
	private double montant; // Soit le nombre de jetons
	private String proprietaire;

	public Portefeuille(Cryptomonnaie monnaie, double montant, String proprietaire)
	{
		this.monnaie      = monnaie;
		this.montant      = montant;
		this.proprietaire = proprietaire;
	}

	/**
	 * Cette fonction vous permet de transférer des devises du portefeuille actuel 
	 * vers le portefeuille de destination pour le montant indiqué. Le type de devise 
	 * (nom du Jeton) doit être le même entre les deux portefeuilles et le montant 
	 * du portefeuille actuel doit être supérieur ou égal à celui indiqué.
	 * @param destination Le portefeuille de destination.
	 * @param montantJetons Le montant de jetons à transférer.
	 * @return Vrai si la transaction a été effectuée, faux sinon.  
	 */
	public boolean transfertDevise(Portefeuille destination, double montantJetons)
	{
	    // Vérifie si le type de devise est le même entre les deux portefeuilles
	    if (!this.monnaie.equals(destination.getMonnaie()))
	    {
	        return false;
	    }

	    // Vérifie si le montant actuel est suffisant pour effectuer le transfert
	    if (this.montant < montantJetons || montantJetons <= 0)
	    {
	        return false;
	    }

	    // Effectue le transfert
	    this.montant -= montantJetons;
	    destination.montant += montantJetons;

	    return true;
	}

	/**
	 * Cette fonction vous permet d'acheter des jetons de la 
	 * crypto-devise en fonction de leur valeur en euros. 
	 * Le résultat est l'augmentation des jetons de la crypto-monnaie.
	 * @param montantEuros Valeur d'achat en euros 
	 * @return true si le montant en euros est supérieur ou égal à 0 
	 */
	public boolean achatDevise (double montantEuros)
	{
		// Vérifie si le montant en euros est valide
		if (montantEuros <= 0)
		{
			return false;
		}

		// Calcule le nombre de jetons achetés
		double jetonsAchetes = montantEuros / this.monnaie.getValeurDeJeton();

		// Augmente le montant de jetons dans le portefeuille
		this.montant += jetonsAchetes;

		return true;
	}

	/**
	 * Valide si le proprietaire passé en parametre est celui
	 * qui as le portefeuille
	 * @param proprietaire
	 * @return true si les nom du propriétaire est correct
	 */
	public boolean estProprietaire (String proprietaire)
	{
		return (proprietaire.equals(this.proprietaire))?true:false;
	}

	/**
	 * 
	 * @return La valeur en euros du Portefeuille. 
	 * Autrement dit, le monant de jetons multiplié par la valeur des jetons. 
	 */
	public double valeurEnEuros()
	{
		return this.montant * this.monnaie.getValeurDeJeton();
	}

	public String        getProprietaire(){return proprietaire;}

	public Cryptomonnaie getMonnaie()     {return monnaie;     }

	public double        getMontant()     {return montant;     }

	@Override
	public String toString()
	{
		return String.format("%10s",proprietaire) + " : "
			+ String.format("%10.1f", montant)   + " x " 
			+ this.monnaie.toString()            + " = "
			+ String.format("%10.1f", valeurEnEuros());
	}

}
