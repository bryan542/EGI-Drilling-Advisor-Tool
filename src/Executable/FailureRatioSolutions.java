package Executable;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;


import java.util.Arrays;

/**
 * Created by bryan on 3/9/2017.
 */
public class FailureRatioSolutions extends DrillingEquations {

    // This method find solutions for a wide range of sigmaH values. First the principal stress solutions for each value of sigmaH. Then, rock property GSI array solutions are added.
    // Following, the mohr and failure line are built for each principal stress and rock property solution. Finally, the failure criteria does a ratio comparrison between the mohr circle
    // and the failure line. Failure occurs if the ratio is above 1 and is stable below 1. The higher the value above 1 the higher the magnitude and likelyhood of failure.
    public DefaultCategoryDataset principalStresses(double sigmaVGradient, double sigmahGradient,double sigmaHGradientInitial, double depth, double mudweight, double alpha, double gamma, double deltaP, double poisson, double gradientUM, double porePressureGradient, double lengthUM,String GSI,String Lithology, double D, double verticalStress, String returnParam){

        double gradientIndex = -1;
        double sigmaHGradient = -1;
        double SV = -1;
        double SH = -1;
        double Sh = -1;
        double thoXY = -1;
        double thoXZ = -1;
        double thoYZ = -1;
        double DeltaP = -1;
        double sigmaR = -1;
        double[] sigmaTheta;
        double[] sigmaZ;
        double[] thoThetaZ;
        double gradientChange = 1/gradientUM;
        double incriment = .01;

        //double arrayDoubleSize = gradientChange/(gradientChange*incriment);
        //int arrayIntSize = (int) Math.round(arrayDoubleSize);

        double sigma1;
        double sigma2;
        double sigma3;

        double MohryValue = -1;
        double MohrxValue = -1;
        double FailureyValue = -1;
        double FailurexValue = -1;
        double diameter = -1;
        double radius = -1;
        double midpoint = -1;
        //First mohr element x value
        int mohrxInitial = -1;
        int failurexInitial = -1;
        double incrimentRange = -1;
        //Construct the dataset
        DefaultCategoryDataset shearDCD = new DefaultCategoryDataset();
        DefaultCategoryDataset tensileDCD = new DefaultCategoryDataset();

        //Makes sure sigmaH cannot be less than sigmah and greater than sigmaV gradient. That wouldn't make sense.
        double sigmahGradientRange = sigmahGradient/depth+porePressureGradient;
        double sigmaVGradientRange = sigmaVGradient/depth+porePressureGradient;
        double sigmaHGradientRange = sigmaHGradientInitial/depth + porePressureGradient;
        double initialRange = -1;
        double finalRange = -1;
        // sets the amount of bars on the ratio graph. reduce or increase the number amount to change the amount reported on the graph

        if(gradientChange ==1){

            incrimentRange = (sigmaVGradientRange-sigmahGradientRange)/18;
            initialRange = sigmahGradientRange;
            finalRange = sigmaVGradientRange;

            // sets a proper range if
            if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange < sigmahGradientRange && sigmahGradientRange > sigmaHGradientRange){

                incrimentRange = (sigmahGradientRange-sigmaVGradientRange)/18;
                initialRange = sigmaVGradientRange;
                finalRange = sigmahGradientRange;

            }
            else if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange < sigmahGradientRange && sigmahGradientRange < sigmaHGradientRange ){

                incrimentRange = (sigmaHGradientRange-sigmaVGradientRange)/18;
                initialRange = sigmaVGradientRange;
                finalRange = sigmaHGradientRange;
            }
            else if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange > sigmahGradientRange && sigmahGradientRange < sigmaHGradientRange ){

                incrimentRange = (sigmaHGradientRange-sigmahGradientRange)/18;
                initialRange = sigmahGradientRange;
                finalRange = sigmaHGradientRange;
            }
        }
        else{
            incrimentRange = (sigmaVGradientRange-sigmahGradientRange)/10;

            initialRange = sigmahGradientRange;
            finalRange = sigmaVGradientRange;

            if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange < sigmahGradientRange && sigmahGradientRange > sigmaHGradientRange){

                incrimentRange = (sigmahGradientRange-sigmaVGradientRange)/10;
                initialRange = sigmaVGradientRange;
                finalRange = sigmahGradientRange;

            }
            else if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange < sigmahGradientRange && sigmahGradientRange < sigmaHGradientRange ){

                incrimentRange = (sigmaHGradientRange-sigmaVGradientRange)/18;
                initialRange = sigmaVGradientRange;
                finalRange = sigmaHGradientRange;
            }
            else if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange > sigmahGradientRange && sigmahGradientRange < sigmaHGradientRange ){

                incrimentRange = (sigmaHGradientRange-sigmahGradientRange)/18;
                initialRange = sigmahGradientRange;
                finalRange = sigmaHGradientRange;
            }
        }


        for (double i = initialRange;i< finalRange;i += incrimentRange){



            gradientIndex = Math.round((i)*100);
            gradientIndex = gradientIndex/100;


            sigmaHGradient = DrillingEquations.SigmaH(depth,i, porePressureGradient);
            SV = DrillingEquations.SV(sigmaVGradient,sigmaHGradient,sigmahGradient,gamma,alpha);
            SH = DrillingEquations.SH(sigmaVGradient,sigmaHGradient,sigmahGradient,gamma,alpha);
            Sh = DrillingEquations.Sh(sigmaVGradient,sigmaHGradient,sigmahGradient,gamma,alpha);
            deltaP = DrillingEquations.deltaP(depth,mudweight,porePressureGradient);
            thoXY = DrillingEquations.thoXY(sigmaHGradient,sigmahGradient,alpha,gamma);
            thoXZ = DrillingEquations.thoXZ(sigmaVGradient,sigmaHGradient,sigmahGradient,alpha,gamma);
            thoYZ = DrillingEquations.thoYZ(sigmaHGradient,sigmahGradient,alpha,gamma);
            sigmaR = DrillingEquations.sigmaR(deltaP);
            sigmaTheta = DrillingEquations.sigmaTheta(SH,Sh,thoXY,deltaP);
            sigmaZ = DrillingEquations.sigmaZ(SV,poisson,Sh,SH,thoXY);
            thoThetaZ = DrillingEquations.thoThetaZ(thoXZ,thoYZ);
            sigma1 = DrillingEquations.sigma1(sigmaTheta,sigmaZ,thoThetaZ);
            sigma2 = DrillingEquations.sigma2(sigmaTheta,sigmaZ,thoThetaZ);
            sigma3 = sigmaR;


            double compressiveStrengthIntact = rockPropertyGSISolver(sigma1,sigma2,sigma3,GSI,Lithology,D,verticalStress,"Compressive Strength Intact");
            double compressiveStrength = rockPropertyGSISolver(sigma1,sigma2,sigma3,GSI,Lithology,D,verticalStress,"Compressive Strength");
            double tensileStrength = -1*rockPropertyGSISolver(sigma1,sigma2,sigma3,GSI,Lithology,D,verticalStress,"Tensile Strength");
            double cohesion = rockPropertyGSISolver(sigma1,sigma2,sigma3,GSI,Lithology,D,verticalStress,"Cohesion");
            double  coeffFriction = rockPropertyGSISolver(sigma1,sigma2,sigma3,GSI,Lithology,D,verticalStress,"CoeffFriction");
            double  shearStrength = rockPropertyGSISolver(sigma1,sigma2,sigma3,GSI,Lithology,D,verticalStress,"Shear Strength");


            XYSeries cohesionLine = new XYSeries("Failure Envelope");
            XYSeries Sigma3MohrLine = new XYSeries("σ3 Mohr Circle");

            double shearFailureRatio = -1;
            double tensileFailureRatio = -1;

            int sigma1Int = (int) sigma1;
            int sigma2Int = (int) sigma2;
            int sigma3Int = (int) sigma3;

            //Build the tensile failure ratio
            tensileFailureRatio = sigma2/tensileStrength;
            //build the failure line
            for(int j = 0; j <sigma1Int;j++){

                FailurexValue = (double) j;
                FailureyValue = coeffFriction*FailurexValue+cohesion;
                cohesionLine.add(FailurexValue,FailureyValue);
            }


            // build the mohr circle
            for (int j=sigma2Int;j<=sigma1Int;j++){

                diameter = sigma1-sigma2;
                radius = diameter/2;
                midpoint = radius+sigma2;
                MohrxValue = (double) j;
                MohryValue = Math.sqrt(Math.pow(radius,2)-Math.pow(MohrxValue-midpoint,2));

                if (Double.isNaN(MohryValue)){
                    MohryValue = 0;
                }
                Sigma3MohrLine.add(MohrxValue,MohryValue);
            }


            //searches for the x-value to align the faliure curve to the Mohr curve.
            if(Sigma3MohrLine.getDataItem(0).getX().intValue()   < 0){

                for(int j = 0; j <= Sigma3MohrLine.getItemCount()-1;j++){

                    if(Sigma3MohrLine.getDataItem(j).getX().intValue() == 0){

                        mohrxInitial = j;
                        break;
                    }

                }
                failurexInitial = 0;
            }
            else if (Sigma3MohrLine.getDataItem(0).getX().intValue() >= 0){

                for(int j = 0; j <= cohesionLine.getItemCount()-1;j++){

                    if(cohesionLine.getDataItem(j).getX().intValue() == Sigma3MohrLine.getDataItem(0).getX().intValue()){

                        failurexInitial = j;
                        break;
                    }

                }

                mohrxInitial = 0;
            }


            //failure criteria check between mohr and failure curve. failurexInitial is the element offset to start comparing the value analysis between the 2 curves
            for (int j = 0;j<=Sigma3MohrLine.getItemCount()-mohrxInitial-2;j++){

                //fills the element in the first array
                if (j == 0){

                    shearFailureRatio = Sigma3MohrLine.getDataItem(j+mohrxInitial).getY().doubleValue()/cohesionLine.getDataItem(j+failurexInitial).getY().doubleValue();
                }
                else{

                    //We are looking for the highest failure ratio. This loop does a sorter check for the highest value and returns it to the array
                    if(Sigma3MohrLine.getDataItem(j+mohrxInitial).getY().doubleValue()/cohesionLine.getDataItem(j+failurexInitial).getY().doubleValue() > shearFailureRatio){

                        shearFailureRatio = Sigma3MohrLine.getDataItem(j+mohrxInitial).getY().doubleValue()/cohesionLine.getDataItem(j+failurexInitial).getY().doubleValue();
                    }
                }
            }

            // Clear the data series at the end of a loop of iteration i
            cohesionLine.clear();
            Sigma3MohrLine.clear();

            //Populates the dataset
            if(gradientChange == 1){

                shearDCD.addValue(shearFailureRatio,"Sigma H Max Range (psi/ft)", Double.toString(gradientIndex));
                tensileDCD.addValue(tensileFailureRatio,"Sigma H Max Range (psi/ft)",Double.toString(gradientIndex));
            }
            else{

                //rounds to kPa/m to 2 decimal places
                gradientIndex = Math.round((gradientIndex/(gradientUM*1000))*100);
                gradientIndex = gradientIndex/100;
                shearDCD.addValue(shearFailureRatio,"Sigma H Max Range (kPa/m)", Double.toString(gradientIndex));
                tensileDCD.addValue(tensileFailureRatio,"Sigma H Max Range (kPa/m)",Double.toString(gradientIndex));
            }


        }

        if (returnParam == "Shear Failure Ratio"){

            return shearDCD;
        }
        else  {

            return tensileDCD;
        }

    }

}
