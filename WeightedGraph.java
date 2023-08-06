import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V>
{
    private Map<Vertex<V>, List<Edge<Vertex>>> map = new HashMap<>();
    public WeightedGraph()
    {
        map = new HashMap<>();
    }
    public void addVertex(Vertex<V> vertex)
    {
        map.put(vertex, new ArrayList<>());
    }
    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight)
    {
        map.get(source).add((Edge<Vertex>)new Edge<>(source, dest, weight));
    }
    public List<Edge<Vertex>> getEdges(Vertex<V> vertex)
    {
        return map.get(vertex);
    }
    public Iterable<Vertex<V>> getVertices()
    {
        return map.keySet();
    }
}

