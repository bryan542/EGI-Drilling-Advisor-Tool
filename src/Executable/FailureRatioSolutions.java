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
        double sigZ = -1;
        double sigX = -1;
        double sigY = -1;
        double failureAngle = -1;
        double thoXY = -1;
        double thoXZ = -1;
        double thoYZ = -1;
        double DeltaP = -1;
        double sigmaR = -1;
        double sigmaTheta;
        double sigmaZ;
        double thoThetaZ;
        double gradientChange = 1/gradientUM;
        double incriment = .01;

        //double arrayDoubleSize = gradientChange/(gradientChange*incriment);
        //int arrayIntSize = (int) Math.round(arrayDoubleSize);

        double sigma1;
        double sigma2;
        double sigma3;

        double criticalFailureAngle = -1;
        double criticalFailurePressure = -1;
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

        //total mudweight
        double mudweightTotal = mudweight*depth;
        //pore pressure
        double porePressureCombination = porePressureGradient*depth;

        //Makes sure sigmaH cannot be less than sigmah and greater than sigmaV gradient. That wouldn't make sense.
        double sigmahGradientRange = sigmahGradient/depth;
        double sigmaVGradientRange = sigmaVGradient/depth;
        double sigmaHGradientRange = sigmaHGradientInitial/depth;
        double initialRange = -1;
        double finalRange = -1;
        double incrimentAmount = 12;
        // sets the amount of bars on the ratio graph. reduce or increase incrimentAmount variable to change the amount reported on the graph
        //metric units
        if(gradientChange ==1){

            incrimentRange = (sigmaVGradientRange-sigmahGradientRange)/incrimentAmount;
            initialRange = sigmahGradientRange;
            finalRange = sigmaVGradientRange;

            // sets a proper range if strike-slip or reverse fault behavior gradients are input
            if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange < sigmahGradientRange && sigmahGradientRange > sigmaHGradientRange){

                incrimentRange = (sigmahGradientRange-sigmaVGradientRange)/incrimentAmount;
                initialRange = sigmaVGradientRange;
                finalRange = sigmahGradientRange;

            }
            else if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange < sigmahGradientRange && sigmahGradientRange < sigmaHGradientRange ){

                incrimentRange = (sigmaHGradientRange-sigmaVGradientRange)/incrimentAmount;
                initialRange = sigmaVGradientRange;
                finalRange = sigmaHGradientRange;
            }
            else if (sigmaHGradientRange > sigmaVGradientRange && sigmaVGradientRange > sigmahGradientRange && sigmahGradientRange < sigmaHGradientRange ){
                //strike-slip gradient range
                incrimentRange = (sigmaHGradientRange-sigmahGradientRange)/incrimentAmount;
                initialRange = sigmahGradientRange;
                finalRange = sigmaHGradientRange;
            }
        }
        //SI units
        else{

            //normal fault gradient range
            incrimentRange = (sigmaVGradientRange-sigmahGradientRange)/10;
            initialRange = sigmahGradientRange;
            finalRange = sigmaVGradientRange;


            // sets a proper range if strike-slip or reverse fault behavior gradients are input
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
                //strike-slip gradient range
                incrimentRange = (sigmaHGradientRange-sigmahGradientRange)/18;
                initialRange = sigmahGradientRange;
                finalRange = sigmaHGradientRange;
            }
        }


        for (double i = initialRange;i< finalRange;i += incrimentRange){

            gradientIndex = Math.round((i)*100);
            gradientIndex = gradientIndex/100;


            sigmaHGradient = DrillingEquations.sigmaH(depth,i, porePressureGradient);
            sigZ = DrillingEquations.sigZ(sigmaVGradient,sigmaHGradient,sigmahGradient,gamma,alpha);
            sigX = DrillingEquations.sigX(sigmaVGradient,sigmaHGradient,sigmahGradient,gamma,alpha);
            sigY = DrillingEquations.sigY(sigmaHGradient,sigmahGradient, alpha);
            deltaP = DrillingEquations.deltaP(depth,mudweight,porePressureGradient);
            thoXY = DrillingEquations.thoXY(sigmaHGradient,sigmahGradient,alpha,gamma);
            thoXZ = DrillingEquations.thoXZ(sigmaVGradient,sigmaHGradient,sigmahGradient,alpha,gamma);
            thoYZ = DrillingEquations.thoYZ(sigmaHGradient,sigmahGradient,alpha,gamma);
            sigmaR = DrillingEquations.sigmaR(depth*mudweight);
            failureAngle = DrillingEquations.failureAngle(thoXY,sigX,sigY);
            sigmaTheta = DrillingEquations.sigmaTheta(sigX,sigY,thoXY,failureAngle,depth*mudweight);
            sigmaZ = DrillingEquations.sigmaZ(sigZ,poisson,sigY,sigX,thoXY,failureAngle);
            thoThetaZ = DrillingEquations.thoThetaZ(thoXZ,thoYZ,failureAngle);
            sigma1 = DrillingEquations.sigma1(sigmaTheta,sigmaZ,thoThetaZ);
            sigma2 = DrillingEquations.sigma2(sigmaTheta,sigmaZ,thoThetaZ);
            sigma3 = sigmaR;

            // if is the collapsed cast, else is the fracture case
            if (mudweight>porePressureGradient){
                double place1 = sigma1;
                double place2 = sigma2;
                double place3 = sigma3;

                sigma1 =place1;
                sigma2 =place2;
                sigma3 =place3;
            }
            else{

                double place1 = sigma1;
                double place2 = sigma2;
                double place3 = sigma3;

                sigma1 =place3;
                sigma2 =place2;
                sigma3 =place1;

            }

            //the GSI calculator uses effective principal stresses
            double[] sortedPrincipalStresses = {sigma1,sigma2,sigma3};
            Arrays.sort(sortedPrincipalStresses);
            double[] sortedEffectiveStresses = {sortedPrincipalStresses[0]-porePressureCombination,sortedPrincipalStresses[1]-porePressureCombination,sortedPrincipalStresses[2]-porePressureCombination};


            double compressiveStrengthIntact = rockPropertyGSISolver(sortedEffectiveStresses[2],sortedEffectiveStresses[1],sortedEffectiveStresses[0],GSI,Lithology,D,verticalStress,"Compressive Strength Intact");
            double compressiveStrength = rockPropertyGSISolver(sortedEffectiveStresses[2],sortedEffectiveStresses[1],sortedEffectiveStresses[0],GSI,Lithology,D,verticalStress,"Compressive Strength");
            double tensileStrength = -1*rockPropertyGSISolver(sortedEffectiveStresses[2],sortedEffectiveStresses[1],sortedEffectiveStresses[0],GSI,Lithology,D,verticalStress,"Tensile Strength");
            double cohesion = rockPropertyGSISolver(sortedEffectiveStresses[2],sortedEffectiveStresses[1],sortedEffectiveStresses[0],GSI,Lithology,D,verticalStress,"Cohesion");
            double coeffFriction = rockPropertyGSISolver(sortedEffectiveStresses[2],sortedEffectiveStresses[1],sortedEffectiveStresses[0],GSI,Lithology,D,verticalStress,"CoeffFriction");
            double shearStrength = rockPropertyGSISolver(sortedEffectiveStresses[2],sortedEffectiveStresses[1],sortedEffectiveStresses[0],GSI,Lithology,D,verticalStress,"Shear Strength");

            // test
            double failureTest = -1;
            double tensileinitialtest = cohesion+(sortedEffectiveStresses[2]+sortedEffectiveStresses[0])/2*coeffFriction;
            double tensileMaxTest = (sortedEffectiveStresses[2]-sortedEffectiveStresses[0])/2;
            failureTest = tensileMaxTest/tensileinitialtest;
            //Find the critical failure pressure

            criticalFailurePressure = DrillingEquations.criticalFailurePressure(sigX,sigY,sigmaZ,thoXY,thoThetaZ,porePressureGradient*depth,tensileStrength,failureAngle,gamma);

            XYSeries cohesionLine = new XYSeries("Failure Envelope");
            XYSeries Sigma3MohrLine = new XYSeries("σ3 Mohr Circle");

            double shearFailureRatio = -1;
            double tensileFailureRatio = -1;

            double[] principalArray = {sigma1-porePressureCombination,sigma2-porePressureCombination,sigma3-porePressureCombination};
            Arrays.sort(principalArray);
            int sigma1Int = (int) (principalArray[2]);
            int sigma2Int = (int) (principalArray[1]);
            int sigma3Int = (int) (principalArray[0]);
            sigma1=principalArray[2];
            sigma2=principalArray[1];
            sigma3=principalArray[0];
            //Build the tensile failure ratio
            tensileFailureRatio = mudweightTotal/(criticalFailurePressure);
            //build the failure line
            for(int j = 0; j <sigma1Int;j++){

                FailurexValue = (double) j;
                FailureyValue = coeffFriction*FailurexValue+cohesion;
                cohesionLine.add(FailurexValue,FailureyValue);
            }


            // build the mohr circle
            for (int j=sigma3Int;j<=sigma1Int;j++){

                diameter = sigma1-sigma3;
                radius = diameter/2;
                midpoint = radius+sigma3;
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
