package Executable;

/**
 * Created by Bryan on 10/4/2016.
 */
public class ComboBoxLists {

    private String[] typeFault = {"Normal","Reverse","Strike-slip"};
    private String[] porePressure = {"Hydrostatic","Overpressure", "Underpressure"};
    private String[] faultConductivity = {"High","Medium","Low","Unknown/None"};
    private String[] joint = {"High","Medium","Low","Unknown/None"};
    private String[] beddingUnconformity = {"Highly Conductive","Medium Conductive","Low Conductive","Unknown/None"};
    private String[] lithology = {"Shale","Salt","Sandstone","Siltstone","Limestone","Dolomite"};
    private String[] permeability = {"Low (μD)","Medium (mD)","High (Darcy)"};


    public void FaultType(){

    }

    public String[] GetFaultTypes(){

        return this.typeFault;
    }
    public String[] GetPorePressure(){

        return this.porePressure;
    }
    public String[] GetFaultConductivity(){

        return this.faultConductivity;
    }
    public String[] GetJoint(){

        return this.joint;
    }
    public String[] GetBeddingUnconformity(){

        return this.beddingUnconformity;
    }
    public String[] GetLithology(){

        return this.lithology;
    }
    public String[] GetPermeability(){

        return this.permeability;
    }
}


