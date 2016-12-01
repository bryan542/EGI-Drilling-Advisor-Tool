package Executable;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by bryan on 11/30/2016.
 */
public class DistributionAnalysis {

    public double normalProbabilityDistributionOverburden(double mean, double stdev){
        NormalDistribution nd = new NormalDistribution(mean, stdev);
        double probability = nd.probability(1,1.1);
        return probability;

    }
    public double normalProbabilityDistributionMaxHorizontal(double mean, double stdev){
        NormalDistribution nd = new NormalDistribution(mean, stdev);
        double probability = nd.probability(.7,.9);
        return probability;

    } public double normalProbabilityDistributionMinHorizontal(double mean, double stdev){
        NormalDistribution nd = new NormalDistribution(mean, stdev);
        double probability = nd.probability(.76,.8);
        return probability;

    }
    public static void main(String[] args) {

        DistributionAnalysis da1 = new DistributionAnalysis();
        double probability1 = da1.normalProbabilityDistributionOverburden(1,.003433501);

        DistributionAnalysis da2 = new DistributionAnalysis();
        double probability2 = da2.normalProbabilityDistributionMaxHorizontal(.7, .058185);

        DistributionAnalysis da3 = new DistributionAnalysis();
        double probability3 = da3.normalProbabilityDistributionMinHorizontal  (.685,.049903);

        double productProbability = probability1*probability2*probability3;
        System.out.println(Double.toString(probability1));
        System.out.println(Double.toString(probability2));
        System.out.println(Double.toString(probability3));
        System.out.println(Double.toString(productProbability));

    }
}
