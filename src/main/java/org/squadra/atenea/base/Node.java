package org.squadra.atenea.base;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter
public class Node extends Word{
	
	private String source;
	private String language;
	
	public Node(){
		
	}
	
	public Node( Word word ){
		super(word);
	}
	
	public Node( Word word , String source , String language ){
		super(word);
		this.source = source;
		this.language = language;
	}

}
