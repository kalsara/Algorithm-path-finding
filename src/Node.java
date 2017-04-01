/**
 * Created by Dell on 3/31/2017.
 */
public class Node {
         int x;
         int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
        //set all Node values to infinity
        double distance = Integer.MAX_VALUE;
        boolean visitedCell;
        boolean blockedCell;
        Node parent;



    //Manhattan value
    public  double Manhattan() {

        double dDistance = 2;
        return dDistance;
    }

    //Euclidean value
    public  double Euclidean() {
        double dDistance = 1.4;
        return dDistance;
    }

    //Chebyshev value

    public  double Chebyshev() {
        double dDistance = 1;
        return dDistance;
    }
    }

