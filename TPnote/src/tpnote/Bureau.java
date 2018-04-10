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
public interface Bureau {
    
    public Guichet ouvrirNouveauGuichet(int p_capacite);
    
    public void ajouterUsager(int p_numero);
    
    public int premierUsager(Guichet p_guichet);
}
