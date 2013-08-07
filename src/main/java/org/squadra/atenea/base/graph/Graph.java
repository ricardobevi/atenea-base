package org.squadra.atenea.base.graph;

import java.util.HashMap;


public class Graph<T> {

	private HashMap<Integer, Node<T> > graph;
	
	
	public Graph(){
		graph = new HashMap<Integer, Node<T> >();
	}
	
	public void addNode( Node<T> node ){
		graph.put( graph.size(), node );
	}
	
	public void addNode(Node<T> node, Integer index){
			graph.put( index, node );
	}
	
	public Node<T> getNode(Integer index){
		return graph.get(index);
	}
	
	public void relate(Integer index1, Integer index2){
		graph.get(index1).relate(index2);
	}
	
}
