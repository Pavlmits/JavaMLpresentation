import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KmeansClustering {

    public List<List<Sight>> showRoutes() throws IOException {
        Dataset data = FileHandler.loadDataset(new File("paris.txt"), 2, ",");
        List<List<Sight>> sightList = new ArrayList<>();

        int k = 3;
        Clusterer km = new KMeans(k);
        Dataset[] clusters = km.cluster(data);

        for(int i = 0; i<clusters.length;i++)
        {
            List<Sight> sights = new ArrayList<>();
            for(int j = 0;j < clusters[i].size();j++)
            {
                Sight sight = new Sight();
                sight.setName((String)clusters[i].get(j).classValue());
                sight.setLatitude(clusters[i].get(j).get(0));
                sight.setLongitude(clusters[i].get(j).get(1));
                sights.add(sight);
            }
            sightList.add(sights);
        }
        return sightList;
    }

}
