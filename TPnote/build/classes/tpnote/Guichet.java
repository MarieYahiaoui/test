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
public class Guichet {
    
    
    /** Private attributs */
    private int m_usagers[]; // tableau (file d'attente du guichet) privé des numéros entiers d'usagers
    
    /** Protected attributs */
    protected int m_id; // indice du premier usager (le plus ancien dans le tableau)
    
    /** Public attributs */
    public int m_nb_usagers; // nombre d'usagers dans le tableau
    public int m_capacite; // capacité maximale d'usagers du tableau
    
    
    /** Constructor */
    public Guichet(int p_capacite)
    {
        m_capacite = p_capacite;
        m_usagers = new int[m_capacite];
        m_id = 0;
        m_nb_usagers = 0;
    }
    
    
    /** Methods */
    
    public int getCapaciteRestante() // retourne la différence entre la capacité totale et le nombre d'usagers
    {
        return ( m_capacite - m_nb_usagers);
    }
    
    public boolean guichetVide() // retourne true si le nombre d'usager=0, sinon false
    {
        if(m_nb_usagers == 0) return true;
        else return false;
    }
    
    public boolean guichetPlein() // retourne true si nombre d'usagers=capacité, sinon false
    {
        if(m_nb_usagers == m_capacite) return true;
        else return false;
    }
    
    public int premierUsager() // défile et retourne le numero du premier usager du tableau
    {
        int numero_premier_usager = 0;
        int debut_tableau = 0;
        int fin_tableau = 0;
        
        // Si le guichet n'est pas vide
        if( ! this.guichetVide() )
        {
            // Décrémenter le nombre d'usager
            m_nb_usagers = m_nb_usagers - 1;
            // Affecter le numéro du premier usager
            numero_premier_usager = m_usagers[m_id];
            
            // Incrémenter circulairement cet id
            debut_tableau = m_id;
            fin_tableau = (m_id + m_nb_usagers)%m_capacite;
            for(int i=debut_tableau; i<fin_tableau; i++)
            {
                m_usagers[i] = m_usagers[i+1];
            }
            
            // Retourner le numéro du premier usager
            return numero_premier_usager;
        }
        // Si le guichet est vide
        else
        {
            // retourner 0
            return 0;
        }
    }
    
    public void ajouterUsager(int p_numero) // ajoute (enfile) un usager dans le tableau
    {
        int indice = (m_id + m_nb_usagers)%m_capacite;
        // Si le guichet n'est pas plein
        if( ! this.guichetPlein() )
        {
            // Placer le numéro à l'indice adéquat
            m_usagers[indice] = p_numero;
            // Invrémenter le nombre d'usagers
            m_nb_usagers = m_nb_usagers + 1;
        }
        // Sinon (le guichet est plein)
        else
        {
            System.out.println("le guichet est plein");
        }
    }
}
