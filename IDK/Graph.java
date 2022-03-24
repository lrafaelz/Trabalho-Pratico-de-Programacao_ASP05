// // import java.util.Enumeration;
// // import java.util.NoSuchElementException;

// // public interface Graph <E,T>{

  



// //   //metodos
// //   // int getNumberOfEdges(); // retorna o número de arestas do grafo
// //   // int getNumberOfVertices();  // retorna o número de vértices do grafo
// //   boolean isDirected(); // retorna se o grafo é direcionado
// //   void addVertex(int v);  // insere um vértice no grafo. Se um grafo tem n vértices, eles estão numerados [0..(n-1)] {não informa peso ou dado}
// //   void addVertex(int v, Weight w); // insere vértice com peso 'w' {não informa dados para o vértice}
// //   void addVertex(int v, Weight weight, T data); // insere vértice com peso 'w' e dado de vértice ('data')
// //   Vertex<T> getVertex(int v) throws NoSuchElementException; // retorna o 'v'ésimo vértice do grafo
// //   void addEdge(int v, int w) throws IllegalArgumentException; // insere a aresta (v,w) no grafo
// //   void addEdge(int v, int w, Weight weight) throws IllegalArgumentException;  // insere a aresta (v,w) no grafo, com o peso weight
// //   void addEdge(int v, int w, Weight weight, E data) throws IllegalArgumentException;  // insere a aresta (v,w) no grafo, com o peso weight, e dado 'data';
// //   Edge<E> getEdge(int v, int w) throws NoSuchElementException; // retorna a aresta <v,w>
// //   boolean isEdge(int v, int w); // retorna true se o grafo possui a aresta<v,w>  
// //   boolean isConnected();  // retorna true se o grafo é conexo.
// //   boolean isCyclic(); // returna true se o grafo é um ciclo.
// //   Enumeration getVertices();  // retorna uma enumeração dos vértices do grafo
// //   Enumeration getEdges(); // retorna uma enumeração das arestas do grafo
//   // void depthFirstTraversal(PrePostVisitor visitor, int start, int solicitado){
//   //  int i;
//   //  for(this.grafo)
   
   
   
   
//   //   // if(visitor.preVisit(obj)==solicitado){
      
//   //   //   while(visitor.preVisit(obj)!=solicitado){
//   //   //     visitor.preVisit(obj)=start

//   //   //   }
//   //   //}
//   // }  // busca em profundidade no grafo (DFS), a partir do vértice 'start'
//   void breadthFirstTraversal(Visitor visitor, int start); // busca em largura no grafo (BFS), a partir do vértice 'start'
//   void breadthFirstTraversal(Visitor visitor); // busca em largura no grafo (BFS), sem definir um vértice de início

//   //Outros algoritmos
//   Graph PrimsAlgorithm(Graph g, int s); // Arvore Geradora Mínima (MST - minimum spanning tree) pelo algoritmo de Prim - Este método pode ser implementado como um método de classe (static)
//   Graph KruskalAlgorithm(Graph g); // Arvore Geradora Mínima (MST - minimum spanning tree) pelo algoritmo de Kruskal - Este método pode ser implementado como um método de classe (static)

// }

// /* Link para livro de Estruturas de Dados de Bruno Preiss:
// https://book.huihoo.com/data-structures-and-algorithms-with-object-oriented-design-patterns-in-java/html/page9.html

// */
//   public void addVertice(int maxNode){
//       for(int i = 0; i < maxNode; i++){
//         this.vertices.add(new Vertex(i));
//       }
//       // int i= this.posicaoVertice(node); 
      
//       // if(i==this.vertices.size()){
//       //   this.vertices.add(new Vertex(node));
//       //   return (this.vertices.size() - 1);
      
//     }

import java.util.ArrayList;

public class Graph {
    private ArrayList<Edge> arestas;
    private ArrayList<Vertex> vertices;
    private boolean eDirecionado;

    public Graph(){
        this.arestas = new ArrayList<Edge>();
        this.vertices = new ArrayList<Vertex>();
    }
    
    public void addVertice(int node){
        vertices.add(new Vertex(node));
        
    }

    public void preencherComVertices(int maxVertices){
        for(int i = 0; i < maxVertices; i++)
            addVertice(i);
    }

    public void addAresta(double peso, Vertex origem, Vertex destino){
            Edge aresta = new Edge(peso, origem, destino);
            origem.addArestaSaida(aresta);//colocando o valor na aresta de saida
            destino.addArestaSaida(aresta);
            this.arestas.add(aresta);
             arestas.add(aresta);
            
    }

    public void preencherComArestas(int maxArestas, int maxVertices, boolean isWeighted){
            // for(int i = 0; i < maxVertices; i++){
        //     for(int j = i+1 ; j < maxVertices ; j++){
        //         if(isWeighted)
        //             addAresta((float)Math.floor(Math.random()*(50-1+1)+1), vertices.get(i), vertices.get(j));
        //         else
        //             addAresta(0, vertices.get(i), vertices.get(j));
        //     }
        // }
        int j = 0;
        for(int i = 0; i < maxArestas; i++){
            if(i < vertices.size())
                addAresta(0, vertices.get(j), vertices.get(i+1));
                if(i+1 == vertices.size())
                    j ++;
        }
    }

    
    public void preencherComArestas2(int maxArestas, int maxVertices, boolean isWeighted, int x){
            
        if(x == null){

                
            
        }else{



        }
    }


    
    
    public Vertex getVertice(int node){//Encontrar o vertice
        Vertex vertice=null;
        for( int i =0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).getNode() == node)
                vertice = vertices.get(i);
                break;
        }
        return vertice;
    }

    public void newGraphReceivedFromGUI(int maxVertex, int maxEdge, boolean isWeighed, boolean isDirected){
        this.eDirecionado = isDirected;
        preencherComVertices(maxVertex);
        preencherComArestas(maxEdge, maxVertex, isWeighed);
    }
    
   @Override
	public String toString() {
		String s = " ";
        int i;
        for(i=0;i<vertices.size();i++){
            s += "\n\n" + vertices.get(i).toString();
            for(int j=0;j<arestas.size();j++)
                s += arestas.get(j).toString();
        }
		return s;
    }
}


    // public void transformaEmInt(String edgeTo, String edgeWeight, boolean isWeighted){
    //     ArrayList<String> splitEdges = new ArrayList<String>(Arrays.asList(edgeTo.split(", "))); 
    //     int edge;
    //     int weight;

    //     for(String i : splitEdges)
    //         edge = Integer.parseInt(i);

    //     if(isWeighted){
    //         ArrayList<String> splitWeights = new ArrayList<String>(Arrays.asList(edgeWeight.split(", "))); 
    //         for(String i : splitWeights)
    //             weight = Integer.parseInt(i);
    //     }

    // }
  //continuar dps
    // public void buscaEmLargura(){
    //     ArrayList<Vertex> Marc= new ArrayList<Vertex>();
    //     ArrayList<Vertex> fila= new ArrayList<Vertex>();
    //     vertices atual=  
    // }




//////////////////////////////////////////////////////////////////////////
/* public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }
    
    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<TIPO> getVertice(TIPO dado){
        Vertice<TIPO> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public void buscaEmLargura(){
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<TIPO> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)){ //se o vértice ainda não foi marcado
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }
}

public class Aula25_grafos {
    
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Creuza");
        grafo.adicionarVertice("Créber");
        grafo.adicionarVertice("Cráudio");
        
        grafo.adicionarAresta(2.0, "João", "Lorenzo");
        grafo.adicionarAresta(3.0, "Lorenzo", "Créber");
        grafo.adicionarAresta(1.0, "Créber", "Creuza");
        grafo.adicionarAresta(1.0, "João", "Creuza");
        grafo.adicionarAresta(3.0, "Cráudio", "João");
        grafo.adicionarAresta(2.0, "Cráudio", "Lorenzo");
        
        
        grafo.buscaEmLargura();
    }
    
}*/