import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<V>
{
    private WeightedGraph<V> graph;
    public BreadthFirstSearch(WeightedGraph<V> graph)
    {
        this.graph = graph;
    }
    public void breadthFirstSearch(Vertex<V> startVertex)
    {
        Set<Vertex<V>> visited=new HashSet<>();
        Queue<Vertex<V>> queue=new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty())
        {
            Vertex<V> current=queue.poll();
            System.out.print(current.getData()+" ");

            for (Edge<Vertex> edge : graph.getEdges(current))
            {
                Vertex<V> neighbor=(Vertex<V>) edge.getDestination();
                if (!visited.contains(neighbor))
                {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

