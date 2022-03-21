import java.util.Enumeration;
import java.util.NoSuchElementException;

public interface Graph <E,T>{
  int getNumberOfEdges(); // retorna o número de arestas do grafo
  int getNumberOfVertices();  // retorna o número de vértices do grafo
  boolean isDirected(); // retorna se o grafo é direcionado
  void addVertex(int v);  // insere um vértice no grafo. Se um grafo tem n vértices, eles estão numerados [0..(n-1)] {não informa peso ou dado}
  void addVertex(int v, Weight w); // insere vértice com peso 'w' {não informa dados para o vértice}
  void addVertex(int v, Weight weight, T data); // insere vértice com peso 'w' e dado de vértice ('data')
  Vertex<T> getVertex(int v) throws NoSuchElementException; // retorna o 'v'ésimo vértice do grafo
  void addEdge(int v, int w) throws IllegalArgumentException; // insere a aresta (v,w) no grafo
  void addEdge(int v, int w, Weight weight) throws IllegalArgumentException;  // insere a aresta (v,w) no grafo, com o peso weight
  void addEdge(int v, int w, Weight weight, E data) throws IllegalArgumentException;  // insere a aresta (v,w) no grafo, com o peso weight, e dado 'data';
  Edge<E> getEdge(int v, int w) throws NoSuchElementException; // retorna a aresta <v,w>
  boolean isEdge(int v, int w); // retorna true se o grafo possui a aresta<v,w>  
  boolean isConnected();  // retorna true se o grafo é conexo.
  boolean isCyclic(); // returna true se o grafo é um ciclo.
  Enumeration getVertices();  // retorna uma enumeração dos vértices do grafo
  Enumeration getEdges(); // retorna uma enumeração das arestas do grafo
  void depthFirstTraversal(PrePostVisitor visitor, int start);  // busca em profundidade no grafo (DFS), a partir do vértice 'start'
  void breadthFirstTraversal(Visitor visitor, int start); // busca em largura no grafo (BFS), a partir do vértice 'start'
  void breadthFirstTraversal(Visitor visitor); // busca em largura no grafo (BFS), sem definir um vértice de início

  //Outros algoritmos
  Graph PrimsAlgorithm(Graph g, int s); // Arvore Geradora Mínima (MST - minimum spanning tree) pelo algoritmo de Prim - Este método pode ser implementado como um método de classe (static)
  Graph KruskalAlgorithm(Graph g); // Arvore Geradora Mínima (MST - minimum spanning tree) pelo algoritmo de Kruskal - Este método pode ser implementado como um método de classe (static)

}

/* Link para livro de Estruturas de Dados de Bruno Preiss:
https://book.huihoo.com/data-structures-and-algorithms-with-object-oriented-design-patterns-in-java/html/page9.html

*/