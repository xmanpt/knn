package eu.rm.knn.iris;


import eu.rm.knn.structure.Dataset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IrisDataset implements Dataset<IrisSample> {

    private static final String DATASET_PATH = System.getProperty("user.dir") + "/src/main" + "/resources/iris.txt";

    private List<IrisSample> dataset = new ArrayList<>();

    public List<IrisSample> getDataset() {
        return dataset;
    }

    @Override
    public IrisSample createSampleFromString(String sampleData) {
        String[] split = sampleData.split(",");
        IrisSample sample = new IrisSample();
        sample.setSepalLength(new BigDecimal(split[0]));
        sample.setSepalWidth(new BigDecimal(split[1]));
        sample.setPetalLength(new BigDecimal(split[2]));
        sample.setPetalWidth(new BigDecimal(split[3]));
        sample.setSampleClass(sample.getClassByName(split[4]));
        return sample;
    }


    @Override
    public String getDatasetPath() { return DATASET_PATH;    }

}
