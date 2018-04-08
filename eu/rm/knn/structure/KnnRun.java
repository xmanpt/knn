package eu.rm.knn.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnnRun<T extends Dataset, U extends Sample, V> {

    private double trainPercentage = 0.8d;
    private int knnSize = 5;

    private List<U> trainData = new ArrayList<>();
    private List<U> testData = new ArrayList<>();

    private Integer correct;


    public KnnRun(T t) {


        List dataset = t.getDataset();
        Collections.shuffle(dataset);

        int trainSetSize = (int) (dataset.size() * trainPercentage);

        this.trainData.addAll(dataset.subList(0, trainSetSize));
        this.testData.addAll(dataset.subList(trainSetSize, dataset.size()));

        correct = 0;
        run();
    }

    private void run() {
        for(U testSample : this.testData){
            V result = (V) testSample.classifySample(this.trainData, knnSize);
            V real = (V) testSample.getSampleClass();
            if(real==result){
                correct++;
            }
        }
    }

    public Double getPrecision() {
        if(correct==null){
            throw new RuntimeException("Dataset not trainned yet");
        }
        return Double.valueOf(correct*100)/Double.valueOf(this.testData.size());
    }

}
