package Executable;

/**
 * Created by Bryan on 10/4/2016.
 */
public class ComboBoxLists {

    private String[] typeFault = {"Normal","Reverse","Strike-slip"};
    private String[] porePressure = {"Hydrostatic","Overpressure"};
    private String[] faultConductivity = {"High","Medium","Low"};
    private String[] deformation = {"Deformation Band","Compaction Band","Unknown"};
    private String[] joint = {"High","Medium","Low"};
    private String[] beddingUnconformity = {"Highly Conductive","Medium Conductive","Low Conductive","Unknown"};
    private String[] lithology = {"Shale","Salt","Sandstone","Siltstone","Limestone","Dolomite"};
    private String[] GSI = {"0-35","35-55","55-75","75-100"};
    private String[] permeability = {"High(D)","Medium(mD)","Low(μD)"};


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
    public String[] GetDeformation(){

        return this.deformation;
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
    public String[] GetGSI(){

        return this.GSI;
    }
    public String[] GetPermeability(){

        return this.permeability;
    }
}


