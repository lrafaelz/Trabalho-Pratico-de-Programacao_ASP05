// < T extends <Comparable <T> >
// public interface Edge<E> extends Comparable<Edge<E>>{
//     Vertex getV0(); 
//     // retorna o vértice v0: direcionado(v0->v1); não direconado:(v0,v1)|(v1,v0)
//     Vertex getV1(); 
//     // retorna o vértice v1: direcionado(v0->v1); não direconado:(v0,v1)|(v1,v0)
//     Weight getWeight(); 
//     // obtém o peso da aresta (grafo não ponderado retorna um 'null')
//     E getData();    
//     // retorna qualquer dado associado à aresta (e.g. rótulo textual) - pode ser 'null' se nenhum.
//     boolean isDirected(); 
//     // indica se a aresta é (true) | não é (fasle) direcionada
//     Vertex getMate(Vertex vertex);  
//     // retorna o outro vértice "parceiro" em uma aresta: e.getMate(e.getV0()) == e.getV1()) && e.getMate(e.getV1()) == e.getV0())
//   }

// import java.util.ArrayList;


public class Edge {
    private int peso;
	private Vertex origem;
	private Vertex destino;
	private boolean visitado = false;
	
	
	public Edge(int peso, Vertex origem, Vertex destino) {
		this.setPeso(peso);
		this.setOrigem(origem);
		this.setDestino(destino);
	}
	
	public boolean isVisitado() {//visitor get
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Vertex getOrigem() {
		return origem;
	}

	public void setOrigem(Vertex origem) {
		
		this.origem = origem;
	}

	public Vertex getDestino() {
		return destino;
	}

	public void setDestino(Vertex destino) {
		
		this.destino = destino;
	}
	
	@Override
	public String toString() {
		String s = " ";
		s+= this.getOrigem().getNome() + this.getDestino().getNome();
		return s;
	}
}
