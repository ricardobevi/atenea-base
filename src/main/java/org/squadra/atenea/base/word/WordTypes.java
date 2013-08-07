package org.squadra.atenea.base.word;

public class WordTypes {

	public static class Type {
		/*
		 * NOTAS: El articulo es devuelto como DET pero hay que cambiarlo a ART para no confundir
		 */
		public static final String ARTICLE 						= "ART"; 	// ARTICULO
		public static final String ADJECTIVE 					= "ADJ";	// ADJETIVO
		public static final String NOUN 						= "N";		// SUSTANTIVO
		public static final String PROPER_NAME 					= "PROP";	// NOMBRE PROPIO
		public static final String VERB 						= "V";		// VERBO
		public static final String PERSONAL_PRONOUN 			= "PERS";	// PRONOMBRE PERSONAL
		public static final String DETERMINER_PRONOUN 			= "DET";	// PRONOMBRE DETERMINADO
		public static final String INDEPENDIENT_PRONOUN 		= "INDP";	// PRONOMBRE INDEPENDIENTE
		public static final String ADVERB 						= "ADV";	// ADVERBIO
		public static final String PREPOSITION 					= "PRP";	// PREPOSICION
		public static final String NUMERAL 						= "NUM";	// NUMERO
		public static final String INTERJECTION 				= "IN";		// INTERJECCION
		public static final String COORDINATING_CONJUNCTION 	= "KC";		// CONJUNCION COORDINADA
		public static final String SUBORDINATING_CONJUNCTION 	= "KS";		// CONJUNCION SUBORDINADA
		
		
		public static class ArticleSubtype {
			public static final String DETERMINATIVE 		= "artd";	// DETERMINADO
			public static final String INDETERMINATIVE 		= "arti";	// INDETERMINADO
		}
		
		public static class PersonalPronounSubtype {
			public static final String NOMINATIVE 			= "NOM";		// NOMINATIVO
			public static final String PREPOSITIONAL 		= "PIV";		// PREPOSICIONAL
			public static final String DATIVE 				= "DAT"; 		// DATIVO
			public static final String ACCUSATIVE			= "ACC";		// ACUSATIVO
			public static final String REFLEXIVE 			= "ACC/DAT";	// REFLEXIVO
		}
		
		//TODO: ver de unificar todos los pronombres
		
		public static class DeterminerPronounSubtype {
			/*
			 * NOTAS: los demostrativos antes del nucleo figuran como <artd> (que choto! jaja)
			 * Esta parte es muy rara porque CG3 a veces devuelve subtipo y a veces no.
			 */
			public static final String DEMONSTRATIVE 		= "dem";		// DEMOSTRATIVO
			public static final String INDEFINITE 			= "quant";		// INDEFINIDO/CUANTITATIVO
			public static final String RELATIVE 			= "rel"; 		// RELATIVO
			public static final String INTERROGATIVE		= "interr";		// INTERROGATIVO
			public static final String POSSESSIVE 			= "poss";		// POSESIVO
		}
		
		public static class IndependientPronounSubtype {
			/*
			 * NOTAS: lo mismo que para los determinados (sin el posesivo)
			 */
			public static final String DEMONSTRATIVE 		= "dem";		// DEMOSTRATIVO
			public static final String INDEFINITE 			= "quant";		// INDEFINIDO/CUANTITATIVO
			public static final String RELATIVE 			= "rel"; 		// RELATIVO
			public static final String INTERROGATIVE		= "interr";		// INTERROGATIVO
		}
		
	}

	
	
	public static class Gender {
		
		public static final String MALE 	= "M";		// MASCULINO
		public static final String FAMALE 	= "F";		// FEMENINO
		public static final String NEUTRAL 	= "MF";		// NEUTRO
	}
	
	public static class Number {

		public static final String SINGULAR = "S";		// SINGULAR
		public static final String PLURAL 	= "P";		// PLURAL
	}
	
	public static class Mode {

		/*
		 * NOTAS: el indicativo y subjuntivo vienen acompañados de VFIN (verbo finito)
		 * aunque no sirve de nada. 
		 * Los imperativos, algunos no los reconoce la gramatica, otros aparecen con
		 * un @FS-COM al final y otros con un IMP acompañado de VFIN.
		 */
		
		public static final String INDICATIVO 	= "IND";	// INDICATIVO	juego
		public static final String SUBJUNCTIVE 	= "SUBJ";	// SUBJUNTIVO	jugase
		public static final String IMPERATIVE 	= "IMP";	// IMPERATIVO	juga
		public static final String INFINITIVE 	= "INF";	// INFINITIVO	jugar
		public static final String GERUND 		= "GER";	// GERUNDIO 	jugando
		public static final String PARTICIPLE 	= "PCP";	// PARTICIPIO	jugado
	}
	
	public static class Tense {

		/*
		 * NOTAS: el condicional viene acompañado del VFIN (en realidad pertenece 
		 * al modo indicativo)
		 */
		
		public static final String PRESENT			= "PR";		// PRESENTE					juego
		public static final String PAST_IMPERFECT 	= "IMPF";	// PRET. IMPERFECTO			jugaba
		public static final String PAST_SIMPLE 		= "PS";		// PRET. PERFECTO SIMPLE	jugue
		public static final String FUTURE 			= "FUT";	// FUTURO SIMPLE			jugare
		public static final String CONDITIONAL		= "COND";	// CONDICIONAL SIMPLE 		jugaria
	}
	
	public static class Person {

		public static final String _1S = "1S";			// 1ra PERSONA DEL SINGULAR
		public static final String _2S = "2S";			// 2da PERSONA DEL SINGULAR
		public static final String _3S = "3S";			// 3ra PERSONA DEL SINGULAR
		public static final String _1P = "1P";			// 1ra PERSONA DEL PLURAL
		public static final String _2P = "2P";			// 2da PERSONA DEL PLURAL
		public static final String _3P = "3P";			// 3ra PERSONA DEL PLURAL
		public static final String _1y3S = "1/3S";		// 1ra y 3ra PERSONA DEL SINGULAR
		public static final String _3SyP = "3S/P";		// 3ra PERSONA DEL SINGULAR O PLURAL
		// Agregar combinaciones si hace falta...
	}
	


}
