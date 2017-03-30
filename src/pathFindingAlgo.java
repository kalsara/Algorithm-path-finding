
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

