import eu.rm.knn.iris.IrisClass;
import eu.rm.knn.iris.IrisDataset;
import eu.rm.knn.iris.IrisSample;
import eu.rm.knn.structure.KnnRun;

import java.io.IOException;

public class Iris {

    public static void main(String[] args) throws IOException {
        IrisDataset ds = new IrisDataset();
        ds.loadDataset();

        KnnRun<IrisDataset, IrisSample, IrisClass> knnRun = new KnnRun<>(ds);
        System.out.println(knnRun.run(0.3d, 3 ));
        knnRun.study();



    }
}
