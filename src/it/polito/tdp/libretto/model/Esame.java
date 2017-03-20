package it.polito.tdp.libretto.model;

import java.time.LocalDate;

// oggetto semplice che contiene dati relativi ad un singolo esame
// POJO -> Plain Old Java Project
// dati privati (proprietà), costruttore, metodi get/set, metodi di servizio -> (hashCode, equals,compareto, ToString, ...) 


public class Esame {

	private String codice ;
	private String titolo ;
	private String docente ;
	// private Docente docente ;

	private boolean superato ;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * nuovo esame, non ancota superato
	 * @param codice - codice esame
	 * @param titolo - denominazione del corso
	 * @param docente - cognome e nome docente
	 */
	
	public Esame (String codice, String titolo, String docente) {
		
	super();
	this.codice = codice ;
	this.titolo = titolo ;
	this.docente = docente ;
	
	this.superato = false ;
	
	
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/** 
	 * @return the voto
	 */
	public int getVoto() {
		return voto;
		
	}

	/**restituisce voto solo se esame superato, altrimenti eccezione
	 * @param voto the voto to set
	 */
	public void setVoto(int voto) {
	if (this.superato) {
		this.voto = voto; }
	else {
		throw new IllegalStateException("Esame"+this.codice+" non superato.");
	}
	
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		
		return dataSuperamento;
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		if (this.superato) {
			this.dataSuperamento = dataSuperamento; }
		else {
			throw new IllegalStateException("Esame"+this.codice+" non superato.");
		}
		
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non è ancora superato, lo considera uperato con voto e data specificati; altrimenti, eccezione
	 * @param voto
	 * @param DataSuperamento
	 */
	
	public void supera (int voto, LocalDate data) {
		if (! this.superato ) {
			//non ancora superato
			this.superato = true;
			this.voto = voto;
			this.dataSuperamento = data;	
		} else {
			throw new IllegalStateException("Esame "+this.codice+" già superato."); //l'oggetto ha uno stato; a seconda di questo, ha più o meno senso chiamare un metodo
		}
	}
	
}
