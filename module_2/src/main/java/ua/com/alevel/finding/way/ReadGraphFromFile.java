package ua.com.alevel.finding.way;

import ua.com.alevel.util.ConstGlobal;
import ua.com.alevel.util.FileHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ReadGraphFromFile {
    public static final Map<String, String> searchWay = new HashMap<>();
    public static final List<Edge> edges = new ArrayList<>();

    public static void readGraph() throws IOException, NumberFormatException,IndexOutOfBoundsException {
        int countVertex;
        int countWay;
        String nameTown;
        int countSearchPaths;

        FileHelper.createFile(ConstGlobal.PATH_TO_FILE_FINDING_WAY_INPUT);
        BufferedReader reader = new BufferedReader(new FileReader(ConstGlobal.PATH_TO_FILE_FINDING_WAY_INPUT));
        countVertex = Integer.parseInt(reader.readLine());
        ArrayList<String> nameTowns = new ArrayList<>(countVertex);
        while (countVertex != 0) {
            nameTown = reader.readLine();
            countWay = Integer.parseInt(reader.readLine());
            nameTowns.add(nameTown);

            while (countWay != 0) {
                List<String> townAndDistance = parse(reader.readLine());
                edges.add(new Edge(nameTown, townAndDistance.get(0), Integer.parseInt(townAndDistance.get(1))));
                countWay--;
            }
            countVertex--;
        }
        edges.forEach(edge -> edge.setVertexFinish(nameTowns.get(Integer.parseInt(edge.getVertexFinish()) - 1)));
        countSearchPaths = Integer.parseInt(reader.readLine());
        while (countSearchPaths != 0) {
            List<String> searchPaths = parse(reader.readLine());

            searchWay.put(searchPaths.get(0), searchPaths.get(1));
            countSearchPaths--;
        }
        reader.close();

    }

    public static List<String> parse(String stringTownAndDistance) {
        return stringTownAndDistance.lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toList());
    }
}

