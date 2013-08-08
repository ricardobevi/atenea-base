package org.squadra.atenea.base.graph;

import java.util.HashSet;

public class Node<T> {
	
	Integer id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
