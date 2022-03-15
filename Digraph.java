public interface Digraph<E,T> extends Graph{
    boolean isStronglyConnected();  // retorna true se o dígrafo é fortemente conexo
    void topologicalOrderTraversal(Visitor visitor);  // Visita os nós do grafo considerando a ordenação topológica - Topological-Sort de um grafo aciclico orientado.
    
    // Outros algoritmos
    void StronglyConnectedComponents(); // Componentes fortemente conectados de um grafo orientado
    Digraph DijkstrasAlgorithm(int s); // Caminho mais curto a partir de uma unica fonte (s) - Algoritmo de Dijkstra - Este método pode ser implementado como um método de classe (static)
    Digraph FloydsAlgorithm(); // Caminho mais curto entre todos os pares de vértices - Algoritmo de Floyd - Este método pode ser implementado como um método de classe (static)
      
  }