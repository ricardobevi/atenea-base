package org.squadra.atenea.base.graph;

import java.util.HashMap;

import com.google.gson.Gson;


public class Graph<T> {

	private HashMap<Integer, Node<T> > graph;
	
	
	public Graph(){
		graph = new HashMap<Integer, Node<T> >();
	}
	
	public void addNode( Node<T> node ){
		node.setId(graph.size());
		graph.put( graph.size(), node );
	}
	
	public void addNode(Node<T> node, Integer index){
		
		if ( !graph.containsKey(index) ){
			node.setId(index);
			graph.put( index, node );
		}
		
	}
	
	public Node<T> getNode(Integer index){
		return graph.get(index);
	}
	
	public void relate(Integer index1, Integer index2){
		graph.get(index1).relate(index2);
	}
	
	public String toString() {
		Gson gson = new Gson();
		String ret = "";

		ret = gson.toJson(this);

		return ret;
	}
	
}
