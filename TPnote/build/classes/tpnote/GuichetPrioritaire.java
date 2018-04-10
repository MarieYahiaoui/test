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
public class GuichetPrioritaire extends Guichet {
    
    
    /** Public attribut */
    
    public int m_numero; // numero du guichet prioritaire
    
    
    /** Constructor */
    
    public GuichetPrioritaire(int p_capacite, int p_numero)
    {
        // Constructeur classe mère
        super(p_capacite);
        // Initialisation du numéro du guichet prioritaire
        m_numero = p_numero;
    }
    
    @Override
    public String toString() // retourne une chaine
    {
        return( "le guichet prioritaire " + m_numero + " peut recevoir au maximum " + m_capacite + " usager(s)");
    }
}
