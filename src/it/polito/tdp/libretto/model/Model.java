package it.polito.tdp.libretto.model;

import java.util.List;
import java.util.ArrayList;


public class Model {
	
	private List<Esame> esami ;
	
	public Model() {
		this.esami = new ArrayList<Esame>();
		//dovremo aggiungere altro
	}

	/**
	 * aggiunge un nuovo esame all'elenco esistente, verificando che non esista già
	 * @param e
	 */
	
	public boolean addEsame(Esame e) {
		if(!esami.contains(e)) {
		esami.add(e) ;
		return true ;
		
			} else {
			
				return false ;
			}
		
		}
	
	/**
	 * ricerca se esiste esame con codice specificato e restituisci la posizione di questo o null
	 * @param codice esame da cercare
	 * @return l'esame trovato, oppure null
	 */
	
	public Esame trovaEsame(String codice) {
		
		int pos = this.esami.indexOf (new Esame (codice, null, null));
		if (pos==-1) {
			return null; 
		} else {
			return esami.get(pos);
		}
	}
	
	
	}
	

