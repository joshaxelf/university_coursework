package films;

import java.io.*;
import java.io.BufferedReader;


public class films {

    // Use we use 'static' for all methods to keep things simple, so we can call those methods main
    static void Assert(boolean res) // We use this to test our results - don't delete or modify!
    {
        if (!res) {
            System.out.print("Something went wrong.");
            System.exit(0);
        }
    }


    static double dot(double[] U, double[] V) { // dot product of two vectors
        // add your code
        Assert(U.length == V.length);
        double result = 0;
        for (int i = 0; i < U.length; i++)
            result += U[i] * V[i];

        return result;

    }


    static int NumberOfFeatures = 13;

    static double[] toFeatureVector(double id, String genre, double runtime, double year, double imdb, double rt, double budget, double boxOffice) {
        double[] feature = new double[NumberOfFeatures];


        switch (genre) { // We also use represent each movie genre as an integer number:
            case "Action": feature[0] = 1; break;
            case "Fantasy": feature[1] = 1; break;
            case "Romance": feature[2] = 1; break;
            case "Sci-Fi": feature[3] = -1; break;
            case "Adventure": feature[4] = 1; break;
            case "Horror": feature[5] = 0.25; break;
            case "Comedy": feature[6] = 1; break;
            case "Thriller": feature[7] = 1; break;
            default: Assert(false);

        }
        ;

        feature[8] = imdb / 10; // Weighted IMDB score
        //feature[9] = rt / 100; // Normalise rotten tomatoes score - Removing due to less predicitve than IMDB
        //feature[10] = runtime / 128; // Normalise runtime by longest runtime (Lost in the Jungle)
        //feature[11] = boxOffice / 517;
        //feature[12] = budget / 154;

        return feature;
    }

    static double euclidean(double[] u, double[] v) {
        Assert(u.length == v.length);
        double sumSquares = 0;
        for (int i = 0; i < u.length; i++) {
            sumSquares += Math.pow(u[i] - v[i], 2);
        }
        return Math.sqrt(sumSquares);
    }


    // We have implemented KNN classifier for the K=1 case only. You are welcome to modify it to support any K
    static int knnClassify(double[][] trainingData, int[] trainingLabels, double[] testFeature) {
        int bestMatch = -1;
        double bestDistance = Double.MAX_VALUE;

        for (int i = 0; i < trainingData.length; i++) {
            double currentDistance = euclidean(testFeature, trainingData[i]);
            if (currentDistance < bestDistance) {
                bestDistance = currentDistance;
                bestMatch = i;
            }
        }

        return trainingLabels[bestMatch];
    }

    static void loadData(String filePath, double[][] dataFeatures, int[] dataLabels) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int idx = 0;
            br.readLine(); // skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Assuming csv format: MovieID,Title,Genre,Runtime,Year,Lead Actor,Director,IMDB,RT(%),Budget,Box Office Revenue (in million $),Like it
                double id = Double.parseDouble(values[0]);
                String genre = values[2];
                double runtime = Double.parseDouble(values[10]);
                double year = Double.parseDouble(values[3]);
                double imdb = Double.parseDouble(values[7]);
                double rt = Double.parseDouble(values[6]);
                double budget = Double.parseDouble(values[9]);
                double boxOffice = Double.parseDouble(values[8]);

                dataFeatures[idx] = toFeatureVector(id, genre, runtime, year, imdb, rt, budget, boxOffice);
                dataLabels[idx] = Integer.parseInt(values[11]); // Assuming the label is the last column and is numeric
                idx++;
            }
        }
    }

    public static void main(String[] args) {

        double[][] trainingData = new double[100][];
        int[] trainingLabels = new int[100];
        double[][] testingData = new double[100][];
        int[] testingLabels = new int[100];
        try {
            // You may need to change the path:
            loadData("/Users/joshforeman/code/university-coursework/java/predictiveFilmModel/training-set.csv", trainingData, trainingLabels);
            loadData("/Users/joshforeman/code/university-coursework/java/predictiveFilmModel/testing-set.csv", testingData, testingLabels);
        } catch (IOException e) {
            System.out.println("Error reading data files: " + e.getMessage());
            return;
        }

        // Compute accuracy on the testing set
        int correctPredictions = 0;
        int k = 3;

        for (int i = 0; i < trainingData.length; i++) {
            int predictedLabel = knnClassify(trainingData, trainingLabels, testingData[i]);
            if (predictedLabel == testingLabels[i]) {
                correctPredictions++;
            }
        }

        double accuracy = (double) correctPredictions / trainingData.length * 100;
        System.out.printf("A: %.2f%%\n", accuracy);
    }
}