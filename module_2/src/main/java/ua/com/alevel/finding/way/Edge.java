package ua.com.alevel.finding.way;

public class Edge {
    private String vertexStart;
    private String vertexFinish;
    private int distance;

    public Edge(String vertexStart, String vertexFinish, int distance) {
        this.vertexStart = vertexStart;
        this.vertexFinish = vertexFinish;
        this.distance = distance;
    }
    public Edge(String vertexStart) {
        this.vertexStart = vertexStart;
    }

    public String getVertexStart() {
        return vertexStart;
    }

    public void setVertexStart(String vertexStart) {
        this.vertexStart = vertexStart;
    }

    public String getVertexFinish() {
        return vertexFinish;
    }

    public void setVertexFinish(String vertexFinish) {
        this.vertexFinish = vertexFinish;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
