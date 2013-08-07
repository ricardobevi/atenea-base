package org.squadra.atenea.base.graph;

import java.util.HashSet;

public class Node<T> {
	
	T data;
	HashSet< Integer > relatedTo;
	
	public Node(T data){
		this.data = data;
		relatedTo = new HashSet< Integer >();
	}
	
	public Boolean isRelatedTo( Integer nodeIndex ){
		return relatedTo.contains(nodeIndex);
	}
	
	
	public void relate( Integer nodeIndex ){
		relatedTo.add(nodeIndex);
	}

}
