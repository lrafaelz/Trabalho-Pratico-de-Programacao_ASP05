import java.util.Enumeration;


//T extends <Comparable<T>
public interface Vertex<T> extends Comparable<Vertex<T>>{
  int getNumber();    
  // número que identifica o vértice--> n vértices --> [0 .. n-1]
  Weight getWeight(); 
  // obtém o peso do vértice (grafo não ponderado retorna um 'null')
  T getData();
  // retorna qualquer dado associado ao vértice (e.g. rótulo textual) - pode ser 'null' se nenhum.
  Enumeration<Edge> getIncidentEdges(); 
  // arestas que incidem no vértice
  Enumeration<Edge> getEmanatingEdges();
  // arestas que partem do vértice  
  Enumeration<Vertex> getPredecessors();  
  // vértices que são origem das arestas incidentes sobre o vértice atual
  Enumeration<Vertex> getSuccessors();
  // vértices que são destino das arestas que partem do vértice atual
}