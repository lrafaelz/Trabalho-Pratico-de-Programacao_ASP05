import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Graph {

	ArrayList<Node> nodes;
	double[][] matrix;
    boolean isDirected;
	
	Graph(int size, boolean isDirected, boolean isFile, File grFile){
        if(!isFile){
            nodes = new ArrayList<>();
            matrix = new double[size][size];
            this.isDirected = isDirected;
        } else{
            readFile(grFile);
        }

	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(double wgt, int src, int dst) {
        if(isDirected)
            matrix[src][dst] = wgt;
        else{
            matrix[src][dst] = wgt;
            matrix[dst][src] = wgt;
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
            System.out.println(nodes.get(src).data + " = not_visited");
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

    public void readFile(File grFile){

        File myObj;
		
        try {

            myObj = grFile;
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                System.out.println("File: " + myObj.getName());

            }

        } catch (FileNotFoundException e) {

            System.out.println("Error! File could not be opened.");
            e.printStackTrace();
		
		}

		nodes = new ArrayList<Node>();
        //matrix = new double[size][size];
        this.isDirected = true;
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

}