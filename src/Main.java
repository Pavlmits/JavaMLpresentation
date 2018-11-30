import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException
    {
        KmeansClustering clustering = new KmeansClustering();

        List<List<Sight>> clusters = clustering.showRoutes();

        for(List<Sight> sights:clusters)
        {
            for(Sight sight:sights) {
                System.out.println(sight.getName() +" ,");
            }
            System.out.println("\n");
        }

    }
}
