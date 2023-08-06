import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V>
{
    public Map<Vertex<V>, Double> dijkstraShortestPath(WeightedGraph<V> graph, Vertex<V> source)
    {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Edge<V>> minHeap = new PriorityQueue<>((a, b) -> a.getWeight().compareTo(b.getWeight()));
        for (Vertex<V> vertex : graph.getVertices())
        {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        minHeap.add((Edge<V>)new Edge<>(null, source, 0.0));

        while (!minHeap.isEmpty())
        {
            Edge<V> currentEdge = minHeap.poll();
            Vertex<V> currentVertex =(Vertex<V>) currentEdge.getDestination();

            for (Edge<Vertex> edge : graph.getEdges(currentVertex))
            {
                double newDistance = distances.get(currentVertex) + edge.getWeight();
                Vertex<V> nextVertex =(Vertex<V>) edge.getDestination();

                if (newDistance < distances.get(nextVertex))
                {
                    distances.put(nextVertex, newDistance);
                    minHeap.add((Edge<V>)new Edge<>(currentVertex, nextVertex, newDistance));
                }
            }
        }
        return distances;
    }
}

