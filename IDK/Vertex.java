// import java.util.Enumeration;


// //T extends <Comparable<T>
// public interface Vertex<T> extends Comparable<Vertex<T>>{
//   int getNumber();    
//   // número que identifica o vértice--> n vértices --> [0 .. n-1]
//   Weight getWeight(); 
//   // obtém o peso do vértice (grafo não ponderado retorna um 'null')
//   T getData();
//   // retorna qualquer dado associado ao vértice (e.g. rótulo textual) - pode ser 'null' se nenhum.
//   Enumeration<Edge> getIncidentEdges(); 
//   // arestas que incidem no vértice
//   Enumeration<Edge> getEmanatingEdges();
//   // arestas que partem do vértice  
//   Enumeration<Vertex> getPredecessors();  
//   // vértices que são origem das arestas incidentes sobre o vértice atual
//   Enumeration<Vertex> getSuccessors();
//   // vértices que são destino das arestas que partem do vértice atual
// }

import java.util.ArrayList;

public class Vertex{
	private int node;
	// private int distancia = 0;
	private ArrayList<Edge> arestaEntrada = new ArrayList<Edge>();
	private ArrayList<Edge> arestaSaida = new ArrayList<Edge>();
//	private boolean visitado = false;

	public Vertex(int node){
		this.node = node;
		this.arestaEntrada=new ArrayList<Edge>();
		this.arestaSaida=new ArrayList<Edge>();	//para saber o valor 
	}
	public void addArestaSaida(Edge aresta){
		this.arestaEntrada.add(aresta);//conectando  a outra aresta
		
	}
	public void addArestaEntrada(Edge aresta){
		this.arestaSaida.add(aresta);//conectando  a outra aresta
		
	}
	
	public int getNode() {
		return node;
	}
    // public void editar(){

    // }


	
	// public int getDistancia() {/*receber da  GUI (a GUI não recebe nada só chamano caso a 
	// 							Classe animation receberia mas não será criada, talvez eu represente 
	// 							apenas o caminho dos algoritmos através de um frame ou será no terminal msm*/
	// 	return distancia;
	// }
	
	// public void setDistancia(int distancia) {
	// 	this.distancia = distancia;
	// }
	
	// public boolean isVisitado() {
	// 	return visitado;
	// }
	
	// public void setVisitado(boolean visitado) {
	// 	this.visitado = visitado;
	// }

	// public ArrayList<Edge> getIncidentes() {
	// 	return incidentes;
	// }
	
	// public void addIncidentes(Edge incide) {
	// 	this.incidentes.add(incide);
		
	// 	//adicionando vizinhos a lista
	// 	if ( (incide.getOrigem().getNode() ==(this.getNode())) &&
	// 			(!this.isVizinho(incide.getDestino())) ){
			
	// 		this.addVizinhos(incide.getDestino());
			
	// 	}else if ( (incide.getDestino().getNode() == this.getNode()) &&
	// 			(!this.isVizinho(incide.getOrigem())) ){
			
	// 		this.addVizinhos(incide.getOrigem());
	// 	}
	// }
	
	// public void addVizinhos(Vertex vizinho) {
	// 	this.vizinhos.add(vizinho);
	// }

	// public ArrayList<Vertex> getVizinhos() {
	// 	return vizinhos;
	// }
	
	// public boolean isVizinho(Vertex vizinho){
	// 	int i;
		
	// 	for (i=0; i<this.vizinhos.size() ; i++)
	// 		if (this.vizinhos.get(i).getNode()==(vizinho.getNode()))
	// 			return true;		
		
	// 	return false;
	// }
	@Override
	public String toString() {
		return node + ": ";
	}

//   public int compareTo(Vertex vertex) { // não era pra ter implementado a interface comparable?
  	
//       if(vertex.getDistancia() < getDistancia()) 
//       	return -1;
//       else if(vertex.getDistancia() == getDistancia()) 
//       	return 0;
  
//       return 1;  
//   }

}

//////////////////////////////////////////////////////////////////////////
/*
import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    
    public Vertice(TIPO valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<TIPO> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}
*/