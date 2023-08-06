import java.util.Map;
public class Main
{
    public static void main(String[] args)
    {
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");
        Vertex<String> e = new Vertex<>("e");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        graph.addEdge(a, b, 3);
        graph.addEdge(a, c, 7);
        graph.addEdge(b, d, 2);
        graph.addEdge(c, d, 4);
        graph.addEdge(d, e, 6);

        // Example usage of Breadth-First Search
        Search<String> bfs = new Search<>();
        System.out.println("BFS:");
        bfs.breadthFirstSearch(a);
        System.out.println();

        // Example usage of Dijkstra
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        Map<Vertex<String>, Double> shortestDistances = dijkstra.dijkstraShortestPath(graph, a);
        System.out.println("distance from vertex:");
        for (Vertex<String> vertex : shortestDistances.keySet())
        {
            System.out.println(vertex.getData()+" "+shortestDistances.get(vertex));
        }
    }
}
