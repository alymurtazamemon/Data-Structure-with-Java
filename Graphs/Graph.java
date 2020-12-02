package Graphs;

public class Graph {
    private int MAX_VERTS = 20;
    private int nVert;
    private Vertices[] vertexList;
    private int adjMat[][];

    public Graph() {
        vertexList = new Vertices[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVert = 0;

        for (int i = 0; i < MAX_VERTS; i++)
            for (int j = 0; j < MAX_VERTS; j++)
                adjMat[i][j] = 0;
    }

    public static void main(String[] args) {
        Graph obj = new Graph();
        obj.addVertex('A');
        obj.addVertex('B');
        obj.addVertex('C');
        obj.addVertex('D');
        obj.addVertex('E');
        obj.addVertex('F');

        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(0, 3);
        obj.addEdge(1, 4);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);
        obj.addEdge(3, 5);
        obj.addEdge(4, 5);

        obj.printTable();
    }

    public void printTable() {
        for (int i = 0; i < nVert; i++) {
            for (int j = 0; j < nVert; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getAdjUnvisitedVertex() {

    }

    public void addVertex(char vertex) {
        vertexList[nVert++] = new Vertices(vertex);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int index) {
        System.out.println(vertexList[index].lable);
    }
}
