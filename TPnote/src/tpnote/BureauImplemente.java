/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 *
 * @author marie
 */
public class BureauImplemente implements Bureau {
    
    /** Public attributs */
    public int m_nb_guichets; // nombre total de guichets
    public Guichet m_guichets[]; // tableau de guichets
    
    
    /** Constructor */
    public BureauImplemente(int p_nb_guichets)
    {
        // Initialisation du nombre de guichets
        m_nb_guichets = p_nb_guichets;
        // Instanciation du tableau de guichets
        m_guichets = new Guichet[m_nb_guichets];
    }
    
    
    /** Methods */
    
    @Override
    public Guichet ouvrirNouveauGuichet(int p_capacite)
    {
        // Instancier un nouveau guichet avec la capacité reçue en paramètre
        Guichet nouveau_guichet = new Guichet(p_capacite);
        // Retourner le nouveau guichet
        return nouveau_guichet;
    }
    
    @Override
    public void ajouterUsager(int p_numero)
    {
        // Indice auquel ajouter l'usager
        int indice_usager = -1;
        
        // Pour chaque guichet
        for(int indice=0; indice<m_guichets.length; indice++)
        {
            // S'il n'est pas saturé
            if( ! m_guichets[indice].guichetPlein() )
            {
                // S'il est le premier sur lequel on tombe ou si son nombre de places libres est inférieur à celui des précédents enregistrés, enregistrer son indice
                if( (indice_usager == -1) || ( m_guichets[indice].getCapaciteRestante() < m_guichets[indice_usager].getCapaciteRestante()) ) indice_usager = indice;
            }
        }
        
        // Si on a trouvé un guichet libre, y ajouter le numéro d'usager reçu en paramètre
        if(indice_usager != -1) m_guichets[indice_usager].ajouterUsager(p_numero);
        // Sinon (les guichets sont tous saturés), prévenir l'utilisateur que le bureau est saturé
        else System.out.println("le bureau est saturé");
    }
    
    @Override
    public int premierUsager(Guichet p_guichet) // retourne le numéro du guichet p_guichet reçu en paramètre
    {
        return (p_guichet.premierUsager());
    }
    
    
}
