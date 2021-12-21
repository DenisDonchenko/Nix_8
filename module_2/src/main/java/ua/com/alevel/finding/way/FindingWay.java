package ua.com.alevel.finding.way;

import ua.com.alevel.util.ConstGlobal;
import ua.com.alevel.util.FileHelper;

import java.io.IOException;
import java.util.*;

public class FindingWay {
    private Map<String, Vertex> graph;
    private final ArrayList<String> outputCostWay = new ArrayList<>();

    public void run() {
        FileHelper.createFolders(ConstGlobal.FOLDERS_FINDING_WAY);
        try {
            ReadGraphFromFile.readGraph();
            addEdgesToGraph();

            for (Map.Entry<String, String> entry : ReadGraphFromFile.searchWay.entrySet()) {
                dijkstra(entry.getKey());
                printPath(entry.getValue());
            }

            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_FINDING_WAY_OUTPUT,
                    outputCostWay.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_FINDING_WAY_OUTPUT, "File is empty");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_FINDING_WAY_OUTPUT, "Error input." +
                    "\nn [number vertex]\n" +
                    "NAME [name vertex]\n" +
                    "p [number of city neighbors NAME]\n" +
                    "nr cost [nr - index of the neighbor NAME (starting from 1)]\n" +
                    "           [cost - the cost of the path]\n" +
                    "r [number of paths to find <= 100]\n" +
                    "NAME1 NAME2 [NAME1 - the beginning of the path, NAME2 - the end of the path]\n" +
                    "\n");
        }
    }

    private void addEdgesToGraph() {
        graph = new HashMap<>(ReadGraphFromFile.edges.size());

        for (Edge e : ReadGraphFromFile.edges) {
            if (!graph.containsKey(e.getVertexStart()))
                graph.put(e.getVertexStart(), new Vertex(e.getVertexStart()));
            if (!graph.containsKey(e.getVertexFinish()))
                graph.put(e.getVertexFinish(), new Vertex(e.getVertexFinish()));
        }

        for (Edge e : ReadGraphFromFile.edges) {
            graph.get(e.getVertexStart()).neighbours.put(graph.get(e.getVertexFinish()), e.getDistance());
            //  graph.get(e.getVertexFinish()).neighbours.put(graph.get(e.getVertexStart()), e.getDistance()); // also do this for an undirected graph
        }
    }


    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_FINDING_WAY_OUTPUT, "Graph doesn't contain start vertex \"+" + startName + "+\"\n");
            return;
        }
        Vertex source = graph.get(startName);
        NavigableSet<Vertex> vertices = new TreeSet<>();

        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.distanceMax = v == source ? 0 : Integer.MAX_VALUE;
            vertices.add(v);
        }

        dijkstra(vertices);
    }

    private void dijkstra(NavigableSet<Vertex> vertices) {
        Vertex vertexFirst;
        Vertex vertexSecond;
        while (!vertices.isEmpty()) {
            vertexFirst = vertices.pollFirst();

            if (vertexFirst.distanceMax == Integer.MAX_VALUE)
                break;

            for (Map.Entry<Vertex, Integer> a : vertexFirst.neighbours.entrySet()) {
                vertexSecond = a.getKey();
                int alternateDist = vertexFirst.distanceMax + a.getValue();
                if (alternateDist < vertexSecond.distanceMax) {
                    vertices.remove(vertexSecond);
                    vertexSecond.distanceMax = alternateDist;
                    vertexSecond.previous = vertexFirst;
                    vertices.add(vertexSecond);
                }
            }
        }
    }

    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_FINDING_WAY_OUTPUT, "Graph doesn't contain end vertex \"+" + endName + "+\"\n");
            return;
        }
        outputCostWay.add(graph.get(endName).printPath());
    }

    public static class Vertex implements Comparable<Vertex> {
        private final String name;
        private int distanceMax = Integer.MAX_VALUE;
        private Vertex previous = null;
        private final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(String name) {
            this.name = name;
        }

        private String printPath() {
            if (this == this.previous) {
                return "\"" + this.name + "\"";

            } else if (this.previous == null) {
                return this.name + "(unreached)";
            } else {
                this.previous.printPath();
                return "" + distanceMax;
            }
        }

        public int compareTo(Vertex other) {
            return Integer.compare(distanceMax, other.distanceMax);
        }
    }
}
