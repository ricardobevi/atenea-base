package org.squadra.atenea.base.graph;

import java.util.ArrayList;

import lombok.Data;

/**
 * Clase nodo que se utiliza en la clase Graph.
 * @author Ricardo Bevilacqua
 * @author Leandro Morrone
 *
 * @param <T> tipo de nodo
 */
public @Data class Node<T> {
	
	private Integer id;
	private T data;
	private ArrayList< Integer > inputRelations;
	private ArrayList< Integer > outputRelations;

	
	public Node(T data){
		this.data = data;
		inputRelations = new ArrayList< Integer >();
		outputRelations = new ArrayList< Integer >();
	}
	
	public Node(Node<T> newNode){
		id = newNode.id;
		data = newNode.data;
		inputRelations = newNode.inputRelations;
		outputRelations = newNode.outputRelations;
	}
	
	public Boolean isInputRelatedTo( Integer nodeIndex ){
		return inputRelations.contains(nodeIndex);
	}
	
	public Boolean isOutputRelatedTo( Integer nodeIndex ){
		return outputRelations.contains(nodeIndex);
	}
	
	public void inputRelate( Integer nodeIndex ){
		inputRelations.add(nodeIndex);
	}
	
	public void outputRelate( Integer nodeIndex ){
		outputRelations.add(nodeIndex);
	}

}
