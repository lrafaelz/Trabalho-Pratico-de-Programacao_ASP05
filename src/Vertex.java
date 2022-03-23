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
	private String nome;
	private int distancia = 0;
	private Vertex pai;
	private ArrayList<Edge> incidentes = new ArrayList<Edge>();
	private ArrayList<Vertex> vizinhos = new ArrayList<Vertex>();
	private boolean visitado = false;
	private String cor = "branco"; 
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Vertex(String nome){
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public Vertex getPai() {
		return pai;
	}
	
	public void setPai(Vertex pai) {
		this.pai = pai;
	}
	
	public boolean isVisitado() {
		return visitado;
	}
	
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public ArrayList<Edge> getIncidentes() {
		return incidentes;
	}
	
	public void addIncidentes(Edge incide) {
		this.incidentes.add(incide);
		
		//adicionando vizinhos a lista
		if ( (incide.getOrigem().getNome().equals(this.getNome())) &&
				(!this.isVizinho(incide.getDestino())) ){
			
			this.addVizinhos(incide.getDestino());
			
		}else if ( (incide.getDestino().getNome().equals(this.getNome())) &&
				(!this.isVizinho(incide.getOrigem())) ){
			
			this.addVizinhos(incide.getOrigem());
		}
	}
	
	public void addVizinhos(Vertex vizinho) {
		this.vizinhos.add(vizinho);
	}

	public ArrayList<Vertex> getVizinhos() {
		return vizinhos;
	}
	
	public boolean isVizinho(Vertex vizinho){
		int i;
		
		for (i=0; i<this.vizinhos.size() ; i++)
			if (this.vizinhos.get(i).getNome().equals(vizinho.getNome()))
				return true;		
		
		return false;
	}
	

	@Override
	public String toString() {
		String s = " ";
		s+= this.getNome();
		return s;
	}

  public int compareTo(Vertex vertex) {
  	
      if(vertex.getDistancia() < getDistancia()) 
      	return -1;
      else if(vertex.getDistancia() == getDistancia()) 
      	return 0;
  
      return 1;  
  }

	}