
public class Main {
    public static void main(String[] args) {

        //NODES TIMES
        System.out.println("NODES TIMES \n");
        Graph nodesTimes = new Graph(15);

        nodesTimes.addNodeName("MX");
        nodesTimes.addNodeName("CV");
        nodesTimes.addNodeName("OA");
        nodesTimes.addNodeName("SI");
        nodesTimes.addNodeName("SA");
        nodesTimes.addNodeName("SM");
        nodesTimes.addNodeName("AT");
        nodesTimes.addNodeName("PB");
        nodesTimes.addNodeName("AZ");
        nodesTimes.addNodeName("EP");
        nodesTimes.addNodeName("FT");
        nodesTimes.addNodeName("CT");
        nodesTimes.addNodeName("PT");
        nodesTimes.addNodeName("VZ");
        nodesTimes.addNodeName("TL");

        nodesTimes.addEdgeByName("MX","SA",48.0);
        nodesTimes.addEdgeByName("MX","PB",195.0);

        nodesTimes.addEdgeByName("TL","MX",30.0);

        nodesTimes.addEdgeByName("CV","MX",123.0);
        nodesTimes.addEdgeByName("CV","TL",55.0);
        nodesTimes.addEdgeByName("CV","OA",16.0);
        nodesTimes.addEdgeByName("CV","PB",212.0);

        nodesTimes.addEdgeByName("OA","SI",67.0);

        nodesTimes.addEdgeByName("SI","AT",26.0);

        nodesTimes.addEdgeByName("SA","SM",48.0);

        nodesTimes.addEdgeByName("SM","PB",47.0);

        nodesTimes.addEdgeByName("AT","PB",20.0);

        nodesTimes.addEdgeByName("PB","VZ",354.0);
        nodesTimes.addEdgeByName("PB","AZ",57.0);
        nodesTimes.addEdgeByName("PB","FT",208.0);

        nodesTimes.addEdgeByName("AZ","EP",62.0);

        nodesTimes.addEdgeByName("EP","FT",57.0);

        nodesTimes.addEdgeByName("FT","VZ",120.0);
        nodesTimes.addEdgeByName("FT","CT",22.0);

        nodesTimes.addEdgeByName("CT","VZ",104.0);
        nodesTimes.addEdgeByName("CT","PT",54.0);

        nodesTimes.addEdgeByName("PT","VZ",14.0);


        nodesTimes.showGraph();


        //CUERNAVACA
        double[][] minimumPath = nodesTimes.findMinimumPaths("CV");
        System.out.println("\n\n");
        System.out.println("\nThe fastest way from Cuernavaca to the other states \n");
        nodesTimes.showMinimumPath(minimumPath, "CV", "MX");
        nodesTimes.showMinimumPath(minimumPath, "CV", "PB");
        nodesTimes.showMinimumPath(minimumPath, "CV", "VZ");
        System.out.println("\n\n");

        //MEXICO CITY
        minimumPath = nodesTimes.findMinimumPaths("MX");
        System.out.println("\n\n");
        System.out.println("\nThe fastest way from Mexico City to the other states \n");
        nodesTimes.showMinimumPath(minimumPath, "MX", "CV");
        nodesTimes.showMinimumPath(minimumPath, "MX", "PB");
        nodesTimes.showMinimumPath(minimumPath, "MX", "VZ");
        System.out.println("\n\n");


        //PUEBLA
        minimumPath = nodesTimes.findMinimumPaths("PB");
        System.out.println("\n\n");
        System.out.println("\nThe fastest way from PUEBLA to the other states \n");
        nodesTimes.showMinimumPath(minimumPath, "PB", "CV");
        nodesTimes.showMinimumPath(minimumPath, "PB", "MX");
        nodesTimes.showMinimumPath(minimumPath, "PB", "VZ");
        System.out.println("\n\n");


        //VERACRUZ
        minimumPath = nodesTimes.findMinimumPaths("VZ");
        System.out.println("\n\n");
        System.out.println("\nThe fastest way from VERACRUZ to the other states \n");
        nodesTimes.showMinimumPath(minimumPath, "VZ", "CV");
        nodesTimes.showMinimumPath(minimumPath, "VZ", "PB");
        nodesTimes.showMinimumPath(minimumPath, "VZ", "MX");
        System.out.println("\n\n");





        //NODES PRICE
        System.out.println("\n\nNODES PRICE \n");
        Graph nodesPrice = new Graph(15);

        nodesPrice.addNodeName("MX");
        nodesPrice.addNodeName("CV");
        nodesPrice.addNodeName("OA");
        nodesPrice.addNodeName("SI");
        nodesPrice.addNodeName("SA");
        nodesPrice.addNodeName("SM");
        nodesPrice.addNodeName("AT");
        nodesPrice.addNodeName("PB");
        nodesPrice.addNodeName("AZ");
        nodesPrice.addNodeName("EP");
        nodesPrice.addNodeName("FT");
        nodesPrice.addNodeName("CT");
        nodesPrice.addNodeName("PT");
        nodesPrice.addNodeName("VZ");
        nodesPrice.addNodeName("TL");

        nodesPrice.addEdgeByName("MX","SA",0.0);
        nodesPrice.addEdgeByName("MX","PB",0.0);

        nodesPrice.addEdgeByName("TL","MX",0.0);

        nodesPrice.addEdgeByName("CV","MX",0.0);
        nodesPrice.addEdgeByName("CV","TL",136.0);
        nodesPrice.addEdgeByName("CV","OA",34.0);
        nodesPrice.addEdgeByName("CV","PB",0.0);

        nodesPrice.addEdgeByName("OA","SI",175.0);

        nodesPrice.addEdgeByName("SI","AT",51.0);

        nodesPrice.addEdgeByName("SA","SM",137.0);

        nodesPrice.addEdgeByName("SM","PB",42.0);

        nodesPrice.addEdgeByName("AT","PB",0.0);

        nodesPrice.addEdgeByName("PB","VZ",0.0);
        nodesPrice.addEdgeByName("PB","AZ",72.0);
        nodesPrice.addEdgeByName("PB","FT",0.0);

        nodesPrice.addEdgeByName("AZ","EP",140.0);

        nodesPrice.addEdgeByName("EP","FT",33.0);

        nodesPrice.addEdgeByName("FT","VZ",0.0);
        nodesPrice.addEdgeByName("FT","CT",114.0);

        nodesPrice.addEdgeByName("CT","VZ",0.0);
        nodesPrice.addEdgeByName("CT","PT",108.0);

        nodesPrice.addEdgeByName("PT","VZ",0.0);


        nodesPrice.showGraph();




        //CUERNAVACA
        double[][] minimumPath2 = nodesPrice.findMinimumPaths("CV");
        System.out.println("\n\n");
        System.out.println("\nThe cheapest way to travel from Cuernavaca to the other states \n");
        nodesPrice.showMinimumPath(minimumPath2, "CV", "MX");
        nodesPrice.showMinimumPath(minimumPath2, "CV", "PB");
        nodesPrice.showMinimumPath(minimumPath2, "CV", "VZ");
        System.out.println("\n\n");


        //MEXICO CITY
        minimumPath2 = nodesPrice.findMinimumPaths("MX");
        System.out.println("\n\n");
        System.out.println("\nThe cheapest way to travel from Mexico City to the other states \n");
        nodesPrice.showMinimumPath(minimumPath2, "MX", "CV");
        nodesPrice.showMinimumPath(minimumPath2, "MX", "PB");
        nodesPrice.showMinimumPath(minimumPath2, "MX", "VZ");
        System.out.println("\n\n");


        //PUEBLA
        minimumPath2 = nodesPrice.findMinimumPaths("PB");
        System.out.println("\n\n");
        System.out.println("\nThe cheapest way to travel from Puebla to the other states \n");
        nodesPrice.showMinimumPath(minimumPath2, "PB", "CV");
        nodesPrice.showMinimumPath(minimumPath2, "PB", "MX");
        nodesPrice.showMinimumPath(minimumPath2, "PB", "VZ");
        System.out.println("\n\n");


        //VERACRUZ
        minimumPath2 = nodesPrice.findMinimumPaths("VZ");
        System.out.println("\n\n");
        System.out.println("\nThe cheapest way to travel from Veracruz to the other states \n");
        nodesPrice.showMinimumPath(minimumPath2, "VZ", "CV");
        nodesPrice.showMinimumPath(minimumPath2, "VZ", "PB");
        nodesPrice.showMinimumPath(minimumPath2, "VZ", "MX");
        System.out.println("\n\n");

    }
}
