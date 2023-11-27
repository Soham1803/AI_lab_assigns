package Uninformed_search;


    import java.util.*;

    class City {
        String name;
        List<City> neighbors;

        public City(String name) {
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(City city) {

            neighbors.add(city);
        }
    }

    class Graph {
        private Map<String, City> cityMap;

        public Graph() {
            cityMap = new HashMap<>();
        }

        public void addCity(String cityName) {
            cityMap.put(cityName, new City(cityName));
        }

        public void addConnection(String city1, String city2) {
            City cityOne = cityMap.get(city1);
            City cityTwo = cityMap.get(city2);

            if (cityOne != null && cityTwo != null) {
                cityOne.addNeighbor(cityTwo);
                cityTwo.addNeighbor(cityOne);
            }
        }

        public void dfs(String startCity) {
            City start = cityMap.get(startCity);
            if (start == null) {
                System.out.println("Start city not found.");
                return;
            }

            Set<City> visited = new HashSet<>();
            dfsHelper(start, visited);
        }

        private void dfsHelper(City currentCity, Set<City> visited) {
            System.out.println(currentCity.name);
            visited.add(currentCity);

            for (City neighbor : currentCity.neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited);
                }
            }
        }

        public void bfs(String startCity) {
            City start = cityMap.get(startCity);
            if (start == null) {
                System.out.println("Start city not found.");
                return;
            }

            Queue<City> queue = new LinkedList<>();
            Set<City> visited = new HashSet<>();

            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                City currentCity = queue.poll();
                System.out.println(currentCity.name);

                for (City neighbor : currentCity.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

}

public class DFS_BFS{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addCity("D");
        graph.addCity("E");

        graph.addConnection("A", "B");
        graph.addConnection("A", "C");
        graph.addConnection("B", "D");
        graph.addConnection("C", "E");

        System.out.println("DFS traversal:");
        graph.dfs("A");

        System.out.println("\nBFS traversal:");
        graph.bfs("A");
    }
}
