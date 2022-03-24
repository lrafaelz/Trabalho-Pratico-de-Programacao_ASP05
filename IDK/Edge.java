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
    private double peso;
	private Vertex origem;//inicio
	private Vertex destino;//fim
	
	private boolean visitado = false;
	
	
	public Edge(double peso, Vertex origem, Vertex destino) {
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
	}
	
	public boolean isVisitado() {//visitor get
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public double getPeso() {
		return peso;
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
	// public void AdcionarAresta()
	
	@Override
	public String toString() {
		String text = "";
		text += this.origem.getNode() + " -> " + this.destino.getNode() + " | ";
		return text;
	}
}
//////////////////////////////////////////////////////////////////////////
/*
public class Aresta<TIPO> {
    private Double peso;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;
    
    public Aresta(Double peso, Vertice<TIPO> inicio, Vertice<TIPO> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }

    public Vertice<TIPO> getFim() {
        return fim;
    }

    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }
    
    
}*/
