package org.squadra.atenea.base.word;

import lombok.*;

/**
 * Clase que contiene una palabra y almacena sus tipos, numero, genero, tiempo verbal, etc.
 * El utilizada principalmente por el analizador sintactico para formar el arbol sintactico.
 * @author Leandro Morrone
 */
public class Word {

	/** Palabra propiamente dicha */
	@Getter @Setter private String name;
	
	/** Palabra en formato base (infinitivo, masculino, singular) */
	@Getter @Setter private String baseWord;
	
	/** Tipo de palabra */
	@Getter @Setter private String type;

	/** Subtipo de palabra si el tipo admite otra clasificacion */
	@Getter @Setter private String subType;
	
	/** Genero masculino, fenemino o neutro de la palabra */
	@Getter @Setter private String gender;
	
	/** Singular o plural */
	@Getter @Setter private String number;
	
	/** Modo verbal: indicativo, subjuntivo, imperativo, infinitivo, participio, gerundio */
	@Getter @Setter private String mode;
	
	/** Tiempo verbal: preterito, presente, futuro, condicional etc. */
	@Getter @Setter private String tense;
	
	/** Persona (1ra, 2da o 3ra del singular o plural) */
	@Getter @Setter private String person;
	
	/** Heuristica, indica si la clasificacion fue deducida por heuristica */
	@Getter @Setter private boolean heuristic;

	/*
	 * TODO: Falta guardar en algun lugar si el verbo es auxiliar o mainverb, los -sam
	 * que hacemos con las locuciones (ej: a=pesar=de, mientras=que, Estados=Unidos)
	 */
	
	public Word() {}
	
	public Word(String name, String baseWord, String type, String subType,
			String gender, String number, String mode, String tense,
			String person, boolean heuristic) {
		this.name = name;
		this.baseWord = baseWord;
		this.type = type;
		this.subType = subType;
		this.gender = gender;
		this.number = number;
		this.mode = mode;
		this.tense = tense;
		this.person = person;
		this.heuristic = heuristic;
	}
	

	@Override
	public String toString() {
		return name + " [" + baseWord + "]\n"
				+ "   type:   " + type + " | subType:" + subType + "\n"
				+ "   gender: " + gender + " | number:" + number + "\n"
				+ "   mode:   " + mode + " | tense:" + tense + " | person:" + person + "\n"
				+ "   heur:   " + heuristic + "\n";
	}



	
}
