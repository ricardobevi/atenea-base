package org.squadra.atenea.base.word;

import lombok.Data;


/**
 * Clase que contiene una palabra y almacena sus tipos, numero, genero, tiempo verbal, etc.
 * El utilizada principalmente por el analizador sintactico para formar el arbol sintactico.
 * @author Leandro Morrone
 */
@Data
public class Word {

	/** Palabra propiamente dicha */
	private String name = "";
	
	/** Palabra en formato base (infinitivo, masculino, singular) */
	private String baseWord = "";
	
	/** Tipo de palabra */
	private String type = "";

	/** Subtipo de palabra si el tipo admite otra clasificacion */
	private String subType = "";
	
	/** Genero masculino, fenemino o neutro de la palabra */
	private String gender = "";
	
	/** Singular o plural */
	private String number = "";
	
	/** Modo verbal: indicativo, subjuntivo, imperativo, infinitivo, participio, gerundio */
	private String mode = "";
	
	/** Tiempo verbal: preterito, presente, futuro, condicional etc. */
	private String tense = "";
	
	/** Persona (1ra, 2da o 3ra del singular o plural) */
	private String person = "";
	
	/** Heuristica, indica si la clasificacion fue deducida por heuristica */
	private boolean heuristic = false;

	/** Heuristica, indica si la clasificacion fue deducida por heuristica */
	private Integer contraction = 0;
	
	
	// Constructor parametrizado completo
	public Word(String name, String baseword , String type, String subType,
			String gender, String number, String mode, String tense,
			String person, boolean heuristic, Integer contraction) {
		
		this.name = name;
		this.baseWord = baseword;
		this.type = type;
		this.subType = subType;
		this.gender = gender;
		this.number = number;
		this.mode = mode;
		this.tense = tense;
		this.person = person;
		this.heuristic = heuristic;
		this.contraction = contraction;
	}
	
	
	// Constructor por defecto
	public Word() {
		// Deja todos los atributos vacios.
	}

	
	// Constructor parametrizado con palabra
	public Word(String name) {
		this.name = name;
	}


	// Constructor parametrizado con palabra y tipo
	public Word(String name, String type) {
		this.name = name;
		this.type = type;
	}


	@Override
	public String toString() {
		return name + " [" + baseWord + "]"
				+ "\n |  tipo:     " + type 
				+ "\n |  subtipo:  " + subType
				+ "\n |  genero:   " + gender 
				+ "\n |  numero:   " + number 
				+ "\n |  modo:     " + mode 
				+ "\n |  tiempo:   " + tense 
				+ "\n |  persona:  " + person 
				+ "\n |  heur:     " + heuristic 
				+ "\n |  contract: " + contraction 
				+ "\n";
	}
	
	@Override
	public boolean equals(Object word) {
		return this.name.toLowerCase().equals( 
				((Word)word).getName().toLowerCase());
	}
	
	public String getBaseWord(Object word) {
		return this.baseWord != null && this.baseWord != ""? this.baseWord : this.name;  
	}
	
}
