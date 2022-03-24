import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.*;

public class Graph {

	ArrayList<Node> nodes;
	double[][] matrix;
    boolean isDirected;
    boolean isWeighted;

	Graph(int size, boolean isDirected, boolean isWeighted, boolean isFile, File grFile){
        if(!isFile){
            nodes = new ArrayList<>();
            matrix = new double[size][size];
            this.isDirected = isDirected;
            this.isWeighted = isWeighted;
        } else{
            readFile(grFile);
            this.isDirected = isDirected;
            this.isWeighted = isWeighted; 
        }
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(double wgt, int src, int dst) {
        
        if(isWeighted){
            if(isDirected)
                matrix[src][dst] = wgt;
            else{
                matrix[src][dst] = wgt;
                matrix[dst][src] = wgt;
            } 
        }
        else{
            if(isDirected)
                matrix[src][dst] = 1;
            else{
                matrix[src][dst] = 1;
                matrix[dst][src] = 1;
            }
        }
	}

    public void removeEdge(int src, int dst){
        
        if(isDirected)
            matrix[src][dst] = 0;
        else{
            matrix[src][dst] = 0;
            matrix[dst][src] = 0;
        }
    }
	
	public boolean checkEdge(int src, int dst) {
		if(matrix[src][dst] != 0) {
			return true;
		}
		else {
			return false;
		}
	}

    public Node returnNode(int data){
        int j = 0;
        for(Node i : nodes){
            j++;
            if(i.data == data);
                return nodes.get(j);
        }
        return null;
    }

    public void fillGraph(int maxNodes){
        for(int i = 0 ; i < maxNodes ; i++){
            addNode(new Node(i));
        }
    }

    public void randomEdge(int maxEdges, int maxNodes){
        Random generator = new Random();  
        int rand1; 
        int rand2;
        for (int i=0;i<maxEdges;i++){
            rand1 = generator.nextInt(maxNodes);
            rand2 = generator.nextInt(maxNodes);
            if(!checkEdge(rand1, rand2))
                addEdge(randomWeights(), rand1, rand2);
        }
    }

    public double randomWeights(){
        double random;
        Random generator = new Random();
        random = (double)generator.nextInt(9)+1 + (double)(generator.nextInt(9)+1)/10;
        return random;
    }

    public void depthFirstSearch(int src) {
		boolean[] visited = new boolean[matrix.length];
		dFSHelper(src, visited);
	}

	private void dFSHelper(int src, boolean[] visited) {
		
		if(visited[src]) {
			return;
		}
		else {
			visited[src] = true;
			System.out.println(nodes.get(src).data + " = visited");
		}
		
		for(int i = 0; i < matrix[src].length; i++) {
			if(matrix[src][i] != 0) {
				dFSHelper(i, visited);
			}
		}
		return;
	}


    public void breadthFirstSearch(int src) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[matrix.length];
		
		queue.offer(src);
		visited[src] = true;
		
		while(queue.size() != 0) {
			
			src = queue.poll();
			System.out.println(nodes.get(src).data + " = visited");
			
			for(int i = 0; i < matrix[src].length; i++) {
				if(matrix[src][i] != 0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
    }


    public void readFile(File recive){

        
        String file = recive.getAbsolutePath();
        BufferedReader reader = null;
        String line = "";
        System.out.println("File path: " + file);
  
        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
        
                String[] row = line.split(",");
            
          //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            for(String index : row) {
                System.out.printf("%-10s", index);
            }

            
            System.out.println();

            }
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        finally {

            try {

                reader.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    public void print() {
		System.out.print("  ");
		for(Node node : nodes) {
			System.out.print(" " + node.data + "  ");
		}
		System.out.println();
		
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
    
    
    
    
    
    
    public void shortestPath( double matriz [][]){
        
    }

}