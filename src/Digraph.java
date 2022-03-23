import java.util.ArrayList;

public class Digraph{
    // boolean isStronglyConnected();  // retorna true se o dígrafo é fortemente conexo
    // void topologicalOrderTraversal(Visitor visitor);  // Visita os nós do grafo considerando a ordenação topológica - Topological-Sort de um grafo aciclico orientado.
    
    // Outros algoritmos
    // void StronglyConnectedComponents(); // Componentes fortemente conectados de um grafo orientado
    // Digraph DijkstrasAlgorithm(int s); // Caminho mais curto a partir de uma unica fonte (s) - Algoritmo de Dijkstra - Este método pode ser implementado como um método de classe (static)
    // Digraph FloydsAlgorithm(); // Caminho mais curto entre todos os pares de vértices - Algoritmo de Floyd - Este método pode ser implementado como um método de classe (static)
    private ArrayList<Edge> arestas = new ArrayList<Edge>();
    private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    private boolean hasCycle = false;

    public void clearLists(){//limpa TUDO 
      this.arestas.clear();
      this.vertices.clear();
      this.setHasCycle(false);
    }
    public boolean isHasCycle() {
      return hasCycle;
    }
    public void setHasCycle(boolean hasCycle) {
      this.hasCycle = hasCycle;
    }
    public void addAresta(int peso, String origem, String destino){
      int i,j,k;
      
      //adiciona vertices e retorna posicao
      i = this.addVertice(origem);
      j = this.addVertice(destino);
      
      //adiciona aresta na lista
      Edge a = new Edge(peso,
          this.vertices.get(i),
          this.vertices.get(j));
      
      temCiclo(a);
      this.arestas.add(a);
      k = this.arestas.size();
      
      //adiciona aresta na lista de arestas incidentes em cada vertice
      this.vertices.get(i).addIncidentes(this.arestas.get(k-1));
      this.vertices.get(j).addIncidentes(this.arestas.get(k-1));
    }
    public void setArestas(ArrayList<Edge> arestas) {
      this.clearLists();
      
      for (int i=0; i<arestas.size() ; i++)
        this.addAresta(arestas.get(i).getPeso(), 
                arestas.get(i).getOrigem().getNome(), 
                arestas.get(i).getDestino().getNome() );
    }
  
    public void setVertices(ArrayList<Vertex> vertices) {
      this.clearLists();
      
      for (int i=0; i<vertices.size() ; i++){
  
        //se ja existir na lista nao passara daqui
        if(this.posicaoVertice(vertices.get(i).getNome())==this.vertices.size()){
          //adicionando as arestas correspondentes a tais vertices
          for(int j=0; j<vertices.get(i).getIncidentes().size(); j++){
  
            //se o adicionado for a origem desse seu incidente, e o seu destino estiver na lista de vertices
            if ( (vertices.get(i).getNome().equals(vertices.get(i).getIncidentes().get(j).getOrigem().getNome())) &&
                (this.posicaoVertice(vertices.get(i).getIncidentes().get(j).getDestino().getNome())!=this.vertices.size()) ){
  
              this.addAresta(vertices.get(i).getIncidentes().get(j).getPeso(), 
                      vertices.get(i).getIncidentes().get(j).getOrigem().getNome(), 
                      vertices.get(i).getIncidentes().get(j).getDestino().getNome());
            
            //se o adicionado for o destino desse seu incidente, e o sua origem estiver na lista de vertices	
            }else if ( (vertices.get(i).getNome().equals(vertices.get(i).getIncidentes().get(j).getDestino().getNome())) &&
                (this.posicaoVertice(vertices.get(i).getIncidentes().get(j).getOrigem().getNome())!=this.vertices.size()) ){
  
              this.addAresta(vertices.get(i).getIncidentes().get(j).getPeso(), 
                  vertices.get(i).getIncidentes().get(j).getOrigem().getNome(), 
                  vertices.get(i).getIncidentes().get(j).getDestino().getNome());
              
            }
          }
          this.addVertice(vertices.get(i).getNome());
        }
      }
    }
  
    public int addVertice(String nome){
      int i= this.posicaoVertice(nome); 
      
      if(i==this.vertices.size()){
        this.vertices.add(new Vertex(nome));
        return (this.vertices.size() - 1);
      }
      
      return i;
    }
    
    public void limparVerticesPai(){
      for(int i=0; i<this.getVertices().size() ;i++)
        this.getVertices().get(i).setPai(null);
    }
    
    public void limparVerticeVisitado(){
      for(int i=0; i<this.getVertices().size() ;i++)
        this.getVertices().get(i).setVisitado(false);
    }
    
    public void limparArestaVisitada(){
      for(int i=0; i<this.getArestas().size() ;i++)
        this.getArestas().get(i).setVisitado(false);
    }
    
    public void imprimeArvore(){
      for (int i=0; i<arestas.size();i++)
        System.out.print(this.arestas.get(i).getOrigem().getNome() + this.arestas.get(i).getDestino().getNome() + " - " + this.arestas.get(i).getPeso() + " | ");
      System.out.println();
    }
  
    public ArrayList<Vertex> getVertices() {
      return vertices;
    }
    
    public int posicaoVertice(String nome){
      int i;
      
      for (i=0; i<this.vertices.size() ; i++)
        if (this.vertices.get(i).getNome().equals(nome))
          return i;
      
      //se nao encontrar retorna o tamanho da lista vertices
      return this.vertices.size();
    
    }
    
    public Vertex acharVertice(String nome){
      return this.vertices.get(this.posicaoVertice(nome));
    }
    
    public Edge acharAresta(Vertex vet1, Vertex vet2){
      for(int i=0; i<this.arestas.size();i++){
        if( ((this.arestas.get(i).getOrigem().getNome().equals(vet1.getNome())) &&
          (this.arestas.get(i).getDestino().getNome().equals(vet2.getNome()))) ||
          ((this.arestas.get(i).getOrigem().getNome().equals(vet2.getNome())) &&
          (this.arestas.get(i).getDestino().getNome().equals(vet1.getNome()))) ){
          return this.arestas.get(i);
        }
      }
      return null;
    }
    
    public ArrayList<Edge> getArestas() {
      return arestas;
    }
    public boolean temCiclo(Edge aresta){
		
      Vertex anterior = aresta.getDestino();
      
      for(int j=0; j<this.getArestas().size() ;j++){
        
        for(int i=0; i<this.getArestas().size() ;i++){
          
          if ((aresta==this.getArestas().get(i))&&(this.getArestas().get(i).isVisitado()==false))
            this.getArestas().get(i).setVisitado(true);
          else if (aresta!=this.getArestas().get(i)){
            
            if (anterior.getNome().equals(this.getArestas().get(i).getOrigem().getNome())){
              
              if	(aresta.getOrigem().getNome().equals(this.getArestas().get(i).getDestino().getNome())){
                this.limparArestaVisitada();
                this.hasCycle = true;
                return true;
              }else{
                anterior = this.getArestas().get(i).getDestino();
                this.getArestas().get(i).setVisitado(true);
              }	
              
            }else if (anterior.getNome().equals(this.getArestas().get(i).getDestino().getNome())){
              
              if	(aresta.getOrigem().getNome().equals(this.getArestas().get(i).getOrigem().getNome())){
                this.limparArestaVisitada();
                this.hasCycle = true;
                return true;
              }else{
                anterior = this.getArestas().get(i).getOrigem();
                this.getArestas().get(i).setVisitado(true);
              }
            }
          }
        }
      }
      this.limparArestaVisitada();
      this.hasCycle = false;
      return false;
    }

  }