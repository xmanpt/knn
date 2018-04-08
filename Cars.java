import eu.rm.knn.car.CarsClass;
import eu.rm.knn.car.CarsDataset;
import eu.rm.knn.car.CarsSample;
import eu.rm.knn.structure.KnnRun;

import java.io.IOException;

public class Cars {




    public static void main(String[] args) throws IOException {
        CarsDataset ds = new CarsDataset();
        ds.loadDataset();

        KnnRun<CarsDataset, CarsSample, CarsClass> knnRun = new KnnRun<>(ds);
        System.out.println(knnRun.getPrecision());


    }
}
