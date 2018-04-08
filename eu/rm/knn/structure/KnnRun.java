package eu.rm.knn.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnnRun<T extends Dataset, U extends Sample, V> {

    private double DEFAULT_TRAIN_PERCENTAGE = 0.8d;
    private int DEFAULLT_KNN_SIZE = 5;

    private List<U> dataset;
    private List<U> trainData;
    private List<U> testData;


    public KnnRun(T t) {
        this.dataset = t.getDataset();
    }


    private void prepare(double trainPercentage){
        Collections.shuffle(dataset);
        int trainSetSize = (int) (dataset.size() * trainPercentage);

        this.trainData = new ArrayList<>(dataset.subList(0, trainSetSize));
        this.testData = new ArrayList<>(dataset.subList(trainSetSize, dataset.size()));
    }

    public Double run(){
        return this.run(DEFAULT_TRAIN_PERCENTAGE, DEFAULLT_KNN_SIZE);

    }

    public Double run(double trainPercentage, int knnSize){
        prepare(trainPercentage);
        return classifyTestData(knnSize);
    }

    public Double classifyTestData(int knnSize) {
        int correct = 0;
        for(U testSample : this.testData){
            V result = (V) testSample.classifySample(this.trainData, knnSize);
            V real = (V) testSample.getSampleClass();
            if(real==result){
                correct++;
            }
        }
        return Double.valueOf(correct*100)/Double.valueOf(this.testData.size());
    }

    public void study() {

    }

    public List<U> getDataset() {
        return dataset;
    }

    public void setDataset(List<U> dataset) {
        this.dataset = dataset;
    }

    public List<U> getTrainData() {
        return trainData;
    }

    public void setTrainData(List<U> trainData) {
        this.trainData = trainData;
    }

    public List<U> getTestData() {
        return testData;
    }

    public void setTestData(List<U> testData) {
        this.testData = testData;
    }
}
