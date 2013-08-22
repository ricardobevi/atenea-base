package org.squadra.atenea.base.graph;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

import com.google.gson.Gson;


public class Graph<T> {

	private @Getter @Setter HashMap<Integer, Node<T> > graph;
	
	
	public Graph(){
		graph = new HashMap<Integer, Node<T> >();
	}
	
	public void addNode( Node<T> node ){
		node.setId(graph.size());
		graph.put( graph.size(), node );
	}
	
	public void addNode(Node<T> node, Integer index){
		node.setId(index);
		graph.put(index, node);
	}
	
	public Node<T> getNode(Integer index){
		return graph.get(index);
	}
	
	public boolean relate(Integer index1, Integer index2){
		boolean canRelate = false;
		
		if ( graph.containsKey(index1) && graph.containsKey(index2) ){
			
			graph.get(index1).relate(index2);
			canRelate = true;
			
		} else {
			canRelate = false;
		}
		
		return canRelate;
	}
	
	public String toString() {
		
		String stringObject = new String();
		
		stringObject += "<graph>\n";
		stringObject += "  <properties>\n";
		stringObject += "    size: " + graph.size() + "\n";
		stringObject += "  </properties>\n";
		
		stringObject += "  <nodes>\n";
		
		for( Node<T> node : graph.values() ){
			stringObject += "    <node key='"+ node.getId() +"'>\n";
			
			stringObject += "      " +node.toString();
			
			stringObject += "\n    </node>\n\n";
		}
		
		stringObject += "  </nodes>\n";
		
		stringObject += "</graph>\n";
		
		return stringObject;
	}
	
}
