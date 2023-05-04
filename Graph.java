public class Graph {

    private String[] nodes;
    private double[][] adjacencyMatrix;
    private int numberOfNodes;
    int filledNodes;

    public Graph (int n) {
        numberOfNodes = n;
        filledNodes = 0;
        nodes = new String[n];
        adjacencyMatrix =  new double[n][n];
        cleanMatrix();
    } //end constructor

    public void cleanMatrix() {
        for (int i = 0; i<numberOfNodes; i++) {
            for (int j = 0; j<numberOfNodes; j++) {
                if (i==j) {
                    adjacencyMatrix[i][j] = 0;
                } //end if
                else {
                    adjacencyMatrix[i][j] = Double.POSITIVE_INFINITY;
                } //end else
            } //end for
        } //end for
    } //end cleanMatrix




    public void addNodeName (String name) {

        if (filledNodes!=(numberOfNodes)){
            nodes[filledNodes] = name;
            filledNodes++;
        } //end if
        else {
            System.out.println("You don't have more preassigned nodes.");
        } //end else

    } //end addNodeName

    public void addEdge(int initialNode, int connectedTo, double weight) {
        adjacencyMatrix[initialNode][connectedTo] = weight;
    } //end addEdge


    public void addEdgeByName(String initialNode, String connectedTo, double weight) {
        int x = 0;
        int y = 0;
        boolean found1 = false;
        boolean found2 = false;
        for (int i = 0; i<numberOfNodes && (!found1 || !found2);i++) {
            if (nodes[i].equals(initialNode)) {
                x = i;
                found1 = true;
            } //end if
            if (nodes[i].equals(connectedTo)) {
                y = i;
                found2 = true;
            } //end if
        } //end for
        if (x==y) {
            System.out.println("Unable to add edge from " + initialNode + " to " + connectedTo);
        } //end if
        else {
            adjacencyMatrix[x][y]=weight;
            adjacencyMatrix[y][x]=weight;
        } //end else

    } //end addEdgeByName

    public void deleteEdge(int initialNode, int disconnectedTo) {
        adjacencyMatrix[initialNode][disconnectedTo] = Double.POSITIVE_INFINITY;
    } //end deleteEdge

    int getNodeIndex (String node) {
        int index = 0;
        boolean found = false;
        for (int i = 0; i<numberOfNodes && !found; i++) {
            if (nodes[i].equals(node)) {
                index = i;
                found = true;
            } //end if
        } //end for
        return index;
    } //endGetNodeIndex

    public double[][] findMinimumPaths (String node) {

        //get the node we will calculate its minimum paths
        boolean found = false;
        int position = 0;
        int initialNode = 0;
        position = getNodeIndex(node);
        initialNode = position;

        //initialize the matrix we will work in
        double[][] dijkstraResult;
        dijkstraResult =  new double[numberOfNodes][3];
        for (int i = 0; i<numberOfNodes;i++) {
            dijkstraResult[i][0] = i;
            dijkstraResult[i][1] = Double.POSITIVE_INFINITY;
            dijkstraResult[i][2] = Double.NEGATIVE_INFINITY;
        } //end for
        dijkstraResult[position][1] = 0;

        //initialize array containing already visited nodes
        int[] visitedNodes;
        int positionOfVisitedNodes = 1;
        visitedNodes = new int[numberOfNodes];
        visitedNodes[0] = position;
        for (int x = 1; x<numberOfNodes;x++) {
            visitedNodes[x] = -1;
        } //end for

        //initialize array containing not visited nodes
        int[] notVisitedNodes;
        notVisitedNodes = new int[numberOfNodes];
        for (int x = 0; x<numberOfNodes;x++) {
            if (x==position) {
                notVisitedNodes[x] = -1;
            } //end if
            else {
                notVisitedNodes[x] = x;
            } //end else
        } //end for

        //DIJKSTRA'S ALGORITHM
        while (positionOfVisitedNodes!=numberOfNodes) {

            //establish the new distances comparing if the previous ones are greater
            for (int i = 0; i<numberOfNodes; i++) {
                //if the previous is greater update the shortest distance and the previous node
                if ((dijkstraResult[position][1] + adjacencyMatrix[position][i])<dijkstraResult[i][1]) {
                    dijkstraResult[i][1] = dijkstraResult[position][1] + adjacencyMatrix[position][i];
                    dijkstraResult[i][2] = position;
                } //end if
            } //end for

            //get the minimum path for the next node
            double minimum = Double.POSITIVE_INFINITY;
            int minimumPosition = numberOfNodes+1;
            for (int i = 0; i<numberOfNodes;i++) {
                if (notVisitedNodes[i]!=-1) {
                    if (dijkstraResult[notVisitedNodes[i]][1]<minimum) {
                        minimum = dijkstraResult[notVisitedNodes[i]][1];
                        minimumPosition = notVisitedNodes[i];
                    } //end if
                } //end if
            } //end for

            //update not visited and visited nodes arrays
            if (minimumPosition!=(numberOfNodes+1)) {
                notVisitedNodes[minimumPosition] = -1;
                visitedNodes[positionOfVisitedNodes] = minimumPosition;
                positionOfVisitedNodes++;
                //change position to start analyzing in the following iteration from that node
                position = minimumPosition;
            } //end if
            else {
                for (int i =0; i<numberOfNodes; i++) {
                    if (dijkstraResult[i][2]<0) {
                        dijkstraResult[i][2] = -1;
                    } //end if
                } //end for
                positionOfVisitedNodes=numberOfNodes;
            } //end else

        } //end while

        TransformAndPrintDijkstrasResult(dijkstraResult,node, initialNode);
        return dijkstraResult;
    } //end findMinimumPaths

    public void TransformAndPrintDijkstrasResult (double[][] dijkstraResult, String node, int initialNode) {
        System.out.println("For node " + node + " the shortest paths are");
        System.out.printf("%-4S\t%-14S\t%-8S\n", "Node", "Weight", "Path");
        for (int i = 0; i<numberOfNodes; i++) {
            for (int j = 0; j<3;j++) {
                if (j==0) {
                    System.out.printf("%-4S\t",nodes[i]);
                } //end if
                if (j==1) {
                    System.out.printf("%-14f\t", dijkstraResult[i][j]);
                } //end if
                if (j==2 && i!=initialNode) {
                    if (dijkstraResult[i][2]==-1) {
                        System.out.printf("%-8s\t", "No path");
                    } //end if
                    else {
                        System.out.printf("%-8s\t", nodes[(int)dijkstraResult[i][j]]);
                    } //end else

                } //end if
            } //end for
            System.out.println(" ");
        } //end for
    }

    void showMinimumPath (double[][] dijkstraResult, String origin, String destiny) {

        int originIndex = getNodeIndex(origin);
        int destiniesIndex = getNodeIndex(destiny);

        if (origin.equals(destiny)) {
            System.out.print("The minimum path for " + origin + " to " + destiny + " is: " + dijkstraResult[destiniesIndex][1] + " (" + origin + "  )");
        } //end if
        else {
            System.out.print("The minimum path for " + origin + " to " + destiny + " is: " + dijkstraResult[destiniesIndex][1] + " (" + nodes[(int) dijkstraResult[destiniesIndex][0]] + "  ");

            while (dijkstraResult[destiniesIndex][2]!=originIndex) {
                System.out.print(nodes[(int) dijkstraResult[destiniesIndex][2]] + " ");
                destiniesIndex = (int) dijkstraResult[destiniesIndex][2];
            } //end while

            System.out.println(origin + ")");
        } //end else

    } //end showMinimumPath
    public void showGraph() {
        for (int i = 0; i<numberOfNodes;i++) {
            System.out.printf("Connections for %-4s ", nodes[i]);
            for (int j = 0; j<numberOfNodes;j++) {
                System.out.printf("|%4s:%-11f|",nodes[j],adjacencyMatrix[i][j]);
            } //end for
            System.out.println();
        } //end for
    } //end showGraph

} //end class