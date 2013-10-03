package org.squadra.atenea.base.word;

/**
 * Clase con clases estaticas y constantes que representan todos los tipos de
 * palabras
 * 
 * @author Leandro Morrone
 */
public class WordTypes {

	public static final String VOID = ""; 		// VACIO (cuando el campo DEBE estar vacio)
	public static final String UNKNOWN = "?";	// DESCONOCIDO (cuando esta vacio porque no sabemos que poner)

	public static class Type {

		public static final String NOUN = "N"; 					// SUSTANTIVO
		public static final String ADJECTIVE = "ADJ"; 			// ADJETIVO
		public static final String VERB = "V"; 					// VERBO
		public static final String PROPER_NAME = "PROP"; 		// NOMBRE PROPIO
		public static final String ARTICLE = "ART"; 			// ARTICULO
		public static final String PERSONAL_PRONOUN = "PERS"; 	// PRONOMBRE PERSONAL

		// Los siguientes tipos abarcan pronombres, adjetivos y algunos adverbios
		public static final String DEMONSTRATIVE = "DEM"; 		// PRONOMBRE DESMOSTRATIVO
		public static final String POSSESSIVE = "POSS"; 		// PRONOMBRE POSESIVO
		public static final String INDEFINITE = "QUANT"; 		// PRONOMBRE INDEFINIDO
		public static final String RELATIVE = "REL"; 			// PRONOMBRE RELATIVO
		public static final String INTERROGATIVE = "INTERR"; 	// PRONOMBRE INTERROG/EXCLAMATIVO

		public static final String ADVERB = "ADV"; 				// ADVERBIO
		public static final String PREPOSITION = "PRP"; 		// PREPOSICION
		public static final String NUMERIC = "NUM"; 			// NUMERO
		public static final String INTERJECTION = "IN"; 		// INTERJECCION
		public static final String CONJUNCTION = "CONJ"; 		// CONJUNCION

		public static final String PUNCTUATION = "PU"; 			// SIGNO DE PUNTUACION

		public static class ArticleSubtype {
			public static final String DEFINITIVE = "ADEF"; 	// DEFINIDO
			public static final String INDEFINITIVE = "AIND"; 	// INDEFINIDO
		}

		public static class PersonalPronounSubtype {
			public static final String NOMINATIVE = "NOM"; 		// NOMINATIVO
			public static final String PREPOSITIONAL = "PIV"; 	// PREPOSICIONAL
			public static final String DATIVE = "DAT"; 			// DATIVO
			public static final String ACCUSATIVE = "ACC"; 		// ACUSATIVO
			public static final String REFLEXIVE = "REF"; 		// REFLEXIVO
		}

		public static class VerbSubtype {
			public static final String TRANSITIVE = "TR"; 		// TRANSITIVO
			public static final String INTRANSITIVE = "INTR"; 	// INTRANSITIVO
		}

		public static class ConjunctionSubtype {
			public static final String COORDINATING = "KC"; 	// COORDINADA
			public static final String SUBORDINATING = "KS"; 	// SUBORDINADA
		}

		public static class AdverbSubtype {
			public static final String LOCATION = "aloc"; 		// ADVERBIO DE LUGAR
			public static final String TIME = "atemp"; 			// ADVERBIO DE TIEMPO
			public static final String MODE = "amod"; 			// ADVERBIO DE MODO
			public static final String NEGATION = "aneg"; 		// ADVERBIO DE NEGACION
			public static final String AFFIRMATION = "aaff"; 	// ADVERBIO DE AFIRMACION
			public static final String DOUBT = "adou"; 			// ADVERBIO DE DUDA
			public static final String QUANTIFIER = "aquant"; 	// ADVERBIO CUANTIFICADOR
		}

	}

	public static class Gender {

		public static final String MALE = "M"; 			// MASCULINO
		public static final String FAMALE = "F"; 		// FEMENINO
		public static final String NEUTRAL = "MF"; 		// NEUTRO
	}

	public static class Number {

		public static final String SINGULAR = "S"; 		// SINGULAR
		public static final String PLURAL = "P"; 		// PLURAL
		public static final String INDEFINITE = "SP"; 	// INDEFINIDO (para nombres propios)
	}

	public static class Mode {

		public static final String INDICATIVE = "IND"; 		// INDICATIVO juego
		public static final String SUBJUNCTIVE = "SUBJ"; 	// SUBJUNTIVO jugase
		public static final String IMPERATIVE = "IMP"; 		// IMPERATIVO juga
		public static final String INFINITIVE = "INF"; 		// INFINITIVO jugar
		public static final String GERUND = "GER"; 			// GERUNDIO jugando
		public static final String PARTICIPLE = "PCP"; 		// PARTICIPIO jugado
	}

	public static class Tense {

		public static final String PRESENT = "PR"; 			// PRESENTE juego
		public static final String PAST_IMPERFECT = "IMPF"; // PRET. IMPERFECTO jugaba
		public static final String PAST_SIMPLE = "PS"; 		// PRET. PERFECTO SIMPLE jugue
		public static final String FUTURE = "FUT"; 			// FUTURO SIMPLE jugare
		public static final String CONDITIONAL = "COND"; 	// CONDICIONAL SIMPLE jugaria
		public static final String OTHER = "OTHER"; 		// No se reconoce el tiempo verbal
	}

	public static class Person {

		public static final String _1S = "1S"; 		// 1ra PERSONA DEL SINGULAR
		public static final String _2S = "2S"; 		// 2da PERSONA DEL SINGULAR
		public static final String _3S = "3S"; 		// 3ra PERSONA DEL SINGULAR
		public static final String _1P = "1P"; 		// 1ra PERSONA DEL PLURAL
		public static final String _2P = "2P"; 		// 2da PERSONA DEL PLURAL
		public static final String _3P = "3P"; 		// 3ra PERSONA DEL PLURAL
		public static final String _1y3S = "1/3S"; 	// 1ra y 3ra PERSONA DEL SINGULAR
		public static final String _3SyP = "3S/P"; 	// 3ra PERSONA DEL SINGULAR O PLURAL
		// Agregar combinaciones si hace falta...
	}

	
	// TODO: FACU, SACA ESTO DE ACA Y PONELO EN EL WORD CLASSIFIER. Me ensucias el codigo!!
	// TODO: y no apretes Ctrl + Shift + F porque se descalabran los comentarios.
	
	public static String getPersonByNumber(Integer number) {

		String[] person = { "1S", "2S", "3S", "1P", "2P", "3P", "1/3S", "3S/P" };

		return person[number];

	}

	public static String getTenseRaeClasification(String RaeTense) {
		
		String tense;
		
		switch ( RaeTense ){
		case "Presente":
			tense = Tense.PRESENT;
			break;
		case "Futuro simple o Futuro":
			tense = Tense.FUTURE;
			break;
		case "Pret&eacute;rito imperfecto o Copret&eacute;rito":
			tense = Tense.PAST_IMPERFECT;
			break;
		case "Condicional simple o Pospret&eacute;rito":
			tense = Tense.CONDITIONAL;
			break;
		case "Pret&eacute;rito imperfecto o Pret&eacute;rito":
			tense = Tense.PAST_IMPERFECT;
			break;
		case "Pret&eacute;rito perfecto simple o Pret&eacute;rito":
			tense = Tense.PAST_SIMPLE;
			break;
		default:
			tense = Tense.OTHER;
			break;
		}
		
		return tense;
	}

	public static String getPersonByImperativeRaeDefinition(String RaePerson) {

		String person;
		
		switch ( RaePerson ){
		case "(t&uacute;)":
			person = Person._2S;
			break;
		case "(vos)":
			person = Person._2S;
			break;
		case "(vosotros)":
			person = Person._2P;
			break;
		case "(ustedes)":
			person =  Person._2P;
			break;
		default:
			person = "";
			break;
		}
		
		return person;
	}

}
