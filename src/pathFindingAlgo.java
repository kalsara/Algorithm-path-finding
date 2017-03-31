
public class pathFindingAlgo{

public  ArrayList<Node> PathFind(boolean[][] open, int Ai, int Aj, int Bi, int Bj,double dDistance,String name) {
        Node [][]squareGrid;
        //size of randomlyGenMatrix boolean 2D array
        int size = open.length;
        //start cordinate
        Node startPoint = new Node(Ai, Aj);
        //end cordinate
        Node endPoint = new Node(Bi, Bj);
        // The 2d Node array that is used to store Nodes
        squareGrid = new Node[size][size];
        // finding blocked cells in the squareGrid
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                squareGrid[i][j] = new Node(i, j);
                if (open[i][j] == false) {

                    squareGrid[i][j].blockedCell = true;


                }
// setting start distance to 0.
        // All other Nodes will have infinity distance at the beginning
        startPoint.distance =0;

        // a comparator object that compare elements in the queue and replace
        //making a min piroty-queue
        Comparator<Node> distancecomparator = (left, right) -> {
            if (left.distance > (right.distance)) {
                return 1;

            }
            return -1;
        };


        // Queue to store visiting Nodes
        Queue<Node> distanceQueue = new PriorityQueue(size, distancecomparator);
       //first visiting node
        distanceQueue.add(startPoint);
       //check all elements in the queue
        while(distanceQueue.size() > 0) {
           //get minimum value to currentNode
            Node currentNode = distanceQueue.remove();
            Node otherNode;
            //check path met end point
            if(currentNode.x==endPoint.x  && currentNode.y==endPoint.y){

                break;
            }

            // check Top node exist
            if (currentNode.x - 1 >= 0) {

                //get top node cordinates to otherNode object
                otherNode = squareGrid[currentNode.x - 1][currentNode.y];
                //check for valid Node
                if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + hVDistance) {
                    //replace the distance from source point
                    otherNode.distance = currentNode.distance + hVDistance;
                    //put visted node to parent(for back track)
                    otherNode.parent = currentNode;

                    distanceQueue.add(otherNode);
                }
                // check Top Right node exist
                if (currentNode.y + 1 < size) {
                    otherNode= squareGrid[currentNode.x - 1][currentNode.y + 1];
                    if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + dDistance) {
                        otherNode.distance = currentNode.distance + dDistance;
                        otherNode.parent = currentNode;
                        distanceQueue.add(otherNode);
                    }
                }

                // check Top Left node exist
                if (currentNode.y - 1 > 0) {
                    otherNode = squareGrid[currentNode.x - 1][currentNode.y - 1];
                    if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + dDistance) {
                        otherNode.distance = currentNode.distance + dDistance;
                        otherNode.parent = currentNode;
                        distanceQueue.add(otherNode);
                    }
                }


            }

            // check Left node exixt
            if (currentNode.y - 1 > 0) {
                otherNode = squareGrid[currentNode.x][currentNode.y - 1];
                if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + hVDistance) {
                    otherNode.distance = currentNode.distance + hVDistance;
                    otherNode.parent = currentNode;
                    distanceQueue.add(otherNode);
                }
            }

            // check Right node exist
            if (currentNode.y + 1 < size) {
                otherNode = squareGrid[currentNode.x][currentNode.y + 1];
                if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + hVDistance) {
                    otherNode.distance = currentNode.distance + hVDistance;
                    otherNode.parent = currentNode;
                    distanceQueue.add(otherNode);
                }
            }
            // check down node exixt
            if (currentNode.x + 1 < size) {

                otherNode = squareGrid[currentNode.x + 1][currentNode.y];
                if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + hVDistance) {
                    otherNode.distance = currentNode.distance + hVDistance;
                    otherNode.parent = currentNode;
                    distanceQueue.add(otherNode);
                }

                // check Down Left node exist
                if (currentNode.y - 1 >= 0) {
                    otherNode = squareGrid[currentNode.x + 1][currentNode.y - 1];
                    if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + dDistance) {
                        otherNode.distance = currentNode.distance + dDistance;
                        otherNode.parent = currentNode;
                        distanceQueue.add(otherNode);
                    }
                }

                // check Down Right node exist node
                if (currentNode.y + 1 < size) {
                    otherNode = squareGrid[currentNode.x + 1][currentNode.y + 1];
                    if (!otherNode.visitedCell && !otherNode.blockedCell && otherNode.distance > currentNode.distance + dDistance) {
                        otherNode.distance = currentNode.distance + dDistance;
                        otherNode.parent = currentNode;
                        distanceQueue.add(otherNode);
                    }
                }
            }
             //marked as visited
            currentNode.visitedCell = true;
        }

        ArrayList<Node> backTrackPath = new ArrayList<>();


        // Checking if a path exists
        if (!(squareGrid[endPoint.x][endPoint.y].distance == Integer.MAX_VALUE  || squareGrid[startPoint.x][startPoint.y].distance == Integer.MAX_VALUE)) {
            //Trace back the path
            Node currentNode = squareGrid[endPoint.x][endPoint.y];
            //add end point cordinates to backTrackPath
            backTrackPath.add(currentNode);
            System.out.println(name+":"+currentNode.distance);
            while (currentNode.parent != null) {
                backTrackPath.add(currentNode.parent);

                currentNode = currentNode.parent;
            }
        } else System.out.println("No possible path");


        return backTrackPath;
    }
            }
        }

/make grid
    public static void show(boolean[][] a, boolean which) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.square(j, N - i - 1, .5);
                else StdDraw.filledSquare(j, N - i - 1, .5);
    }
// return a random N-by-N boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int N, double p) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }
// draw the N-by-N boolean matrix to standard draw, including the points A (x1, y1) and B (x2,y2) to be marked by a circle
    //draw particular path by a line
    public static void show(boolean[][] a, boolean which, int x1, int y1, int x2, int y2,ArrayList<Node> backTrackPath) {
        int N = a.length;
        int s = backTrackPath.size();
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    if ((i == x1 && j == y1) || (i == x2 && j == y2)) {
                        StdDraw.setPenColor(Color.GREEN);
                        StdDraw.circle(j, N - i - 1, .4);

                    }

        int i = 0;
        int prex = 0;
        int prey = 0;
        Collections.reverse(backTrackPath);

        for (Node Node : backTrackPath) {
           /* if(s-count==1){
                return;
            }*/
            count++;

           
            StdDraw.setPenColor(Color.RED);
            if (i == 0) {

                i++;
                prex = Node.x;
                prey = Node.y;
            } else {

                StdDraw.setPenRadius(0.01);
                StdDraw.line(prey, N - prex - 1, Node.y, N - Node.x - 1);
                prey = Node.y;
                prex = Node.x;


            }
        }
    }


}

