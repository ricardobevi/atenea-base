package org.squadra.atenea.base.graph;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

/**
 * Clase grafo que almacena nodos de cualquier tipo.
 * @author Ricardo Bevilacqua
 * @author Leandro Morrone
 *
 * @param <T> tipo de nodo
 */
public @Data class Graph<T> {

	private HashMap<Integer, Node<T> > graph;
	
	
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
	
	/**
	 * Crea una relacion unidireccional entre los nodos, pero ademas de 
	 * almacenar el indice del nodo destino en el de origen tambien almacena 
	 * el indice del nodo origen en el de destino para poder recorrer el
	 * grafo en ambas direcciones.
	 * @param index1 indice del nodo origen
	 * @param index2 indice del nodo destino
	 * @return
	 */
	public boolean relate(Integer index1, Integer index2){
		boolean canRelate = false;
		
		if ( graph.containsKey(index1) && graph.containsKey(index2) ){
			
			graph.get(index1).outputRelate(index2);
			graph.get(index2).inputRelate(index1);
			
			canRelate = true;
			
		} else {
			canRelate = false;
		}
		return canRelate;
	}
	
	
	/**
	 * Calcula la distancia entre un nodo cualquiera y el nodo raiz (nodo 0)
	 * @param nodeIndex Indice del nodo
	 * @return Distancia al nodo raiz
	 */
	public int getDistanceToRoot(int nodeIndex) {
		
		if ( this.graph.containsKey(nodeIndex) ) {
			
			int distance = 0;
			int currentNode = nodeIndex;
			
			while (currentNode != 0) {
				currentNode = this.graph.get(currentNode).getOutputRelations().get(0);
				distance++;
			}
			return distance;
		}
		return -1;
	}
	
	/**
	 * Devuelve un subconjunto de nodos cuya distancia al nodo raiz sea igual
	 * a la recibida como parametro
	 * @param distance Distancia al nodo raiz
	 * @return Lista de nodos
	 */
	public ArrayList< Node<T> > getNodesByDistance(int distance) {
		
		ArrayList<Node<T>> nodes = new ArrayList<Node<T>>();
		
		for (Node<T> node : graph.values()) {
			if (getDistanceToRoot(node.getId()) == distance) {
				nodes.add(node);
			}
		}
		return nodes;
	}
	
	
	/**
	 * Obtiene un subgrafo del grafo a partir de un nodo particular.
	 * @param nodeIndex Indice del nodo del que se quiere el subgrafo
	 * @return subgrafo
	 */
	public Graph<T> subGraph(int nodeIndex) {
		Graph<T> subGraph = new Graph<T>();
		addNodesToSubGraph(subGraph, nodeIndex);
		subGraph.getNode(nodeIndex).getOutputRelations().clear();
		return subGraph;
	}
	
	/**
	 * Funcion recursiva para agregar nodos a un subgrafo.
	 * @param subGraph
	 * @param nodeIndex
	 */
	private void addNodesToSubGraph(Graph<T> subGraph, int nodeIndex) {
		Node<T> node = new Node<T>(getNode(nodeIndex));
		subGraph.addNode(node, node.getId());
		for (Integer relation : node.getInputRelations()) {
			addNodesToSubGraph(subGraph, relation);
		}
	}
	
	
	@Override
	public String toString() {
		
		String stringObject = new String();
		
		stringObject += "<graph>\n";
		stringObject += "  <properties>\n";
		stringObject += "    size: " + graph.size() + "\n";
		stringObject += "  </properties>\n";
		
		stringObject += "  <nodes>\n";
		
		for( Node<T> node : graph.values() ){
			stringObject += "    <node key='"+ node.getId() +"'>\n";
			stringObject += "      " + node.toString();
			stringObject += "\n    </node>\n\n";
		}
		
		stringObject += "  </nodes>\n";
		stringObject += "</graph>\n";
		
		return stringObject;
	}
	
}
