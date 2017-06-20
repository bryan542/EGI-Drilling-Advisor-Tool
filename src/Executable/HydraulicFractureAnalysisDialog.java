package Executable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

public class HydraulicFractureAnalysisDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JComboBox youngModulusComboBox;
    private JTextField slickwaterYoungsTextField;
    private JTextField hybridYoungsTextField;
    private JTextField crossLinkedYoungsTextField;
    private JTextField foamYoungsTextField;
    private JTextField fluidVolumeYoungsHighJtextField;
    private JTextField fluidVolumeYoungsModerateJtextField;
    private JTextField fluidVolumeYoungsLowJtextField;
    private JTextField fluidLossYoungsHighJTextField;
    private JTextField fluidLossYoungsModerateJTextField;
    private JTextField fluidLossYoungsLowJTextField;
    private JTextField treatmentRateYoungsHighJTextField;
    private JTextField treatmentRateYoungsModerateJTextField;
    private JTextField treatmentRateYoungsLowJTextField;
    private JTextField rampUpYoungsFastJTextField;
    private JTextField rampUpYoungsModerateJTextField;
    private JTextField rampUpYoungsSlowJTextField;
    private JTextField fracturePressureYoungsHighJTextField;
    private JTextField fracturePressureYoungsModerateJTextField;
    private JTextField fracturePressureYoungsLowJTextField;
    private JTextField proppantConcentrationYoungsHighJTextField;
    private JTextField proppantConcentrationYoungsModerateJTextField;
    private JTextField proppantConcentrationYoungsLowJTextField;
    private JTextField proppantSizeYoungsHighMeshJTextField;
    private JTextField proppantSizeYoungsHybridJTextField;
    private JTextField proppantSizeYoungsLowMeshJTextField;
    private JTextField proppantDensityYoungsNormalJTextField;
    private JTextField proppantDensityYoungsModerateJTextField;
    private JTextField proppantDensityYoungsLowJTextField;
    private JTextField proppantVolumeYoungsHighJTextField;
    private JTextField proppantVolumeYoungsModerateJTextField;
    private JTextField proppantVolumeYoungsLowJTextField;
    private JTextField proppedSurfaceAreaYoungsHighJTextField;
    private JTextField proppedSurfaceAreaYoungsModerateJTextField;
    private JTextField proppedSurfaceAreaYoungsLowJTextField;
    private JTextField perforationClustersYoungsMoreFourJTextField;
    private JTextField perforationClustersYoungsThreeJTextField;
    private JTextField perforationClustersYoungsTwoJTextField;
    private JTextField fractureGeometryYoungsComplexJTextField;
    private JTextField fractureGeometryYoungsModerateComplexJTextField;
    private JTextField fractureGeometryYoungsPlanarJTextField;
    private JTextField fractureGeometryYoungsPlanarOrShearingJTextField;
    private JTextField propagationResistanceYoungsHigherJTextField;
    private JTextField propagationResistanceYoungsHighJTextField;
    private JTextField propagationResistanceYoungsModerateJTextField;
    private JTextField propagationResistanceYoungsLowJTextField;
    private JTextField fractureHeightYoungsHighJTextField;
    private JTextField fractureHeightYoungsModerateJTextField;
    private JTextField fractureHeightYoungsImpliedJTextField;
    private JTextField fractureLengthYoungsLongJTextField;
    private JTextField fractureLengthYoungsModerateJTextField;
    private JTextField fractureLengthYoungsSmallJTextField;
    private JTextField EURYoungsHighJTextField;
    private JTextField EURYoungsModerateJTextField;
    private JTextField EURYoungsLowJTextField;
    private JComboBox naturalFractureComboBox;

    public JTextField getSlickwaterNaturalFractureJTextField() {
        return slickwaterNaturalFractureJTextField;
    }
    public JTextField getHybridNaturalFractureJTextField() {
        return hybridNaturalFractureJTextField;
    }
    public JTextField getCrossLinkedNaturalFractureJTextField() {
        return crossLinkedNaturalFractureJTextField;
    }
    public JTextField getFoamNaturalFractureJTextField() {
        return foamNaturalFractureJTextField;
    }
    public JTextField getFluidVolumeNaturalFractureHighJTextField() {
        return fluidVolumeNaturalFractureHighJTextField;
    }
    public JTextField getFluidVolumeNaturalFractureModerateJTextField() {
        return fluidVolumeNaturalFractureModerateJTextField;
    }
    public JTextField getFluidVolumeNaturalFractureLowJTextField() {
        return fluidVolumeNaturalFractureLowJTextField;
    }
    public JTextField getFluidLossNaturalFractureHighJTextField() {
        return fluidLossNaturalFractureHighJTextField;
    }
    public JTextField getFluidLossNaturalFractureModerateJTextField() {
        return fluidLossNaturalFractureModerateJTextField;
    }
    public JTextField getFluidLossNaturalFractureLowJTextField() {
        return fluidLossNaturalFractureLowJTextField;
    }
    public JTextField getTreatmentRateNaturalFractureLowJTextField() {
        return treatmentRateNaturalFractureLowJTextField;
    }
    public JTextField getTreatmentRateNaturalFractureModerateJTextField() {
        return treatmentRateNaturalFractureModerateJTextField;
    }
    public JTextField getTreatmentRateNaturalFractureHighJTextField() {
        return treatmentRateNaturalFractureHighJTextField;
    }
    public JTextField getRampUpNaturalFractureSlowJTextField() {
        return rampUpNaturalFractureSlowJTextField;
    }
    public JTextField getRampUpNaturalFractureModerateJTextField() {
        return rampUpNaturalFractureModerateJTextField;
    }
    public JTextField getRampUpNaturalFractureFastJTextField() {
        return rampUpNaturalFractureFastJTextField;
    }
    public JTextField getFracturePressureNaturalFractureHighJTextField() {
        return fracturePressureNaturalFractureHighJTextField;
    }
    public JTextField getFracturePressureNaturalFractureModerateJTextField() {
        return fracturePressureNaturalFractureModerateJTextField;
    }
    public JTextField getFracturePressureNaturalFractureLowJTextField() {
        return fracturePressureNaturalFractureLowJTextField;
    }
    public JTextField getProppantConcentrationNaturalFractureHighJTextField() {
        return proppantConcentrationNaturalFractureHighJTextField;
    }
    public JTextField getProppantConcentrationNaturalFractureModerateJTextField() {
        return proppantConcentrationNaturalFractureModerateJTextField;
    }
    public JTextField getProppantConcentrationNaturalFractureLowJTextField() {
        return proppantConcentrationNaturalFractureLowJTextField;
    }
    public JTextField getProppantSizeNaturalFractureHighMeshJTextField() {
        return proppantSizeNaturalFractureHighMeshJTextField;
    }
    public JTextField getProppantSizeNaturalFractureHybridJTextField() {
        return proppantSizeNaturalFractureHybridJTextField;
    }
    public JTextField getProppantSizeNaturalFractureLowMeshJTextField() {
        return proppantSizeNaturalFractureLowMeshJTextField;
    }
    public JTextField getProppantDensityNaturalFractureLowJTextField() {
        return proppantDensityNaturalFractureLowJTextField;
    }
    public JTextField getProppantDensityNaturalFractureModerateJTextField() {
        return proppantDensityNaturalFractureModerateJTextField;
    }
    public JTextField getProppantDensityNaturalFractureNormalJTextField() {
        return proppantDensityNaturalFractureNormalJTextField;
    }
    public JTextField getProppantVolumeNaturalFractureHighJTextField() {
        return proppantVolumeNaturalFractureHighJTextField;
    }
    public JTextField getProppantVolumeNaturalFractureModerateJTextField() {
        return proppantVolumeNaturalFractureModerateJTextField;
    }
    public JTextField getProppantVolumeNaturalFractureLowJTextField() {
        return proppantVolumeNaturalFractureLowJTextField;
    }
    public JTextField getProppedSurfaceAreaNaturalFractureHighJTextField() {
        return proppedSurfaceAreaNaturalFractureHighJTextField;
    }
    public JTextField getProppedSurfaceAreaNaturalFractureModerateJTextField() {
        return proppedSurfaceAreaNaturalFractureModerateJTextField;
    }
    public JTextField getProppedSurfaceAreaNaturalFractureLowJTextField() {
        return proppedSurfaceAreaNaturalFractureLowJTextField;
    }
    public JTextField getPerforationClustersNaturalFractureMoreFourJTextField() {
        return perforationClustersNaturalFractureMoreFourJTextField;
    }
    public JTextField getPerforationClustersNaturalFractureThreeJTextField() {
        return perforationClustersNaturalFractureThreeJTextField;
    }
    public JTextField getPerforationClustersNaturalFracturesTwoJTextField() {
        return perforationClustersNaturalFracturesTwoJTextField;
    }
    public JTextField getFractureGeometryNaturalFractureComplexJTextField() {
        return fractureGeometryNaturalFractureComplexJTextField;
    }
    public JTextField getFractureGeometryNaturalFractureModerateComplexJTextField() {
        return fractureGeometryNaturalFractureModerateComplexJTextField;
    }
    public JTextField getFractureGeometryNaturalFracturePlanarJTextField() {
        return fractureGeometryNaturalFracturePlanarJTextField;
    }
    public JTextField getFractureGeometryNaturalFracturePlanarOrShearingJTextField() {
        return fractureGeometryNaturalFracturePlanarOrShearingJTextField;
    }
    public JTextField getPropagationResistanceNaturalFractureHigherJTextField() {
        return propagationResistanceNaturalFractureHigherJTextField;
    }
    public JTextField getPropagationResistanceNaturalFractureHighJTextField() {
        return propagationResistanceNaturalFractureHighJTextField;
    }
    public JTextField getPropagationResistanceNaturalFractureModerateJTextField() {
        return propagationResistanceNaturalFractureModerateJTextField;
    }
    public JTextField getPropagationResistanceNaturalFractureLowJTextField() {
        return propagationResistanceNaturalFractureLowJTextField;
    }
    public JTextField getFractureHeightNaturalFractureHighJTextField() {
        return fractureHeightNaturalFractureHighJTextField;
    }
    public JTextField getFractureHeightNaturalFractureModerateJTextField() {
        return fractureHeightNaturalFractureModerateJTextField;
    }
    public JTextField getFractureHeightNaturalFractureImpliedJTextField() {
        return fractureHeightNaturalFractureImpliedJTextField;
    }
    public JTextField getFractureLengthNaturalFractureSmallJTextField() {
        return fractureLengthNaturalFractureSmallJTextField;
    }
    public JTextField getFractureLengthNaturalFractureModerateJTextField() {
        return fractureLengthNaturalFractureModerateJTextField;
    }
    public JTextField getFractureLengthNaturalFractureLongJTextField() {
        return fractureLengthNaturalFractureLongJTextField;
    }
    public JTextField getEURNaturalFractureHighJTextField() {
        return EURNaturalFractureHighJTextField;
    }
    public JTextField getEURNaturalFractureModerateJTextField() {
        return EURNaturalFractureModerateJTextField;
    }
    public JTextField getEURNaturalFractureLowJTextField() {
        return EURNaturalFractureLowJTextField;
    }

    private JTextField slickwaterNaturalFractureJTextField;
    private JTextField hybridNaturalFractureJTextField;
    private JTextField crossLinkedNaturalFractureJTextField;
    private JTextField foamNaturalFractureJTextField;
    private JTextField fluidVolumeNaturalFractureHighJTextField;
    private JTextField fluidVolumeNaturalFractureModerateJTextField;
    private JTextField fluidVolumeNaturalFractureLowJTextField;
    private JTextField fluidLossNaturalFractureHighJTextField;
    private JTextField fluidLossNaturalFractureModerateJTextField;
    private JTextField fluidLossNaturalFractureLowJTextField;
    private JTextField treatmentRateNaturalFractureLowJTextField;
    private JTextField treatmentRateNaturalFractureModerateJTextField;
    private JTextField treatmentRateNaturalFractureHighJTextField;
    private JTextField rampUpNaturalFractureSlowJTextField;
    private JTextField rampUpNaturalFractureModerateJTextField;
    private JTextField rampUpNaturalFractureFastJTextField;
    private JTextField fracturePressureNaturalFractureHighJTextField;
    private JTextField fracturePressureNaturalFractureModerateJTextField;
    private JTextField fracturePressureNaturalFractureLowJTextField;
    private JTextField proppantConcentrationNaturalFractureHighJTextField;
    private JTextField proppantConcentrationNaturalFractureModerateJTextField;
    private JTextField proppantConcentrationNaturalFractureLowJTextField;
    private JTextField proppantSizeNaturalFractureHighMeshJTextField;
    private JTextField proppantSizeNaturalFractureHybridJTextField;
    private JTextField proppantSizeNaturalFractureLowMeshJTextField;
    private JTextField proppantDensityNaturalFractureLowJTextField;
    private JTextField proppantDensityNaturalFractureModerateJTextField;
    private JTextField proppantDensityNaturalFractureNormalJTextField;
    private JTextField proppantVolumeNaturalFractureHighJTextField;
    private JTextField proppantVolumeNaturalFractureModerateJTextField;
    private JTextField proppantVolumeNaturalFractureLowJTextField;
    private JTextField proppedSurfaceAreaNaturalFractureHighJTextField;
    private JTextField proppedSurfaceAreaNaturalFractureModerateJTextField;
    private JTextField proppedSurfaceAreaNaturalFractureLowJTextField;
    private JTextField perforationClustersNaturalFractureMoreFourJTextField;
    private JTextField perforationClustersNaturalFractureThreeJTextField;
    private JTextField perforationClustersNaturalFracturesTwoJTextField;
    private JTextField fractureGeometryNaturalFractureComplexJTextField;
    private JTextField fractureGeometryNaturalFractureModerateComplexJTextField;
    private JTextField fractureGeometryNaturalFracturePlanarJTextField;
    private JTextField fractureGeometryNaturalFracturePlanarOrShearingJTextField;
    private JTextField propagationResistanceNaturalFractureHigherJTextField;
    private JTextField propagationResistanceNaturalFractureHighJTextField;
    private JTextField propagationResistanceNaturalFractureModerateJTextField;
    private JTextField propagationResistanceNaturalFractureLowJTextField;
    private JTextField fractureHeightNaturalFractureHighJTextField;
    private JTextField fractureHeightNaturalFractureModerateJTextField;
    private JTextField fractureHeightNaturalFractureImpliedJTextField;
    private JTextField fractureLengthNaturalFractureSmallJTextField;
    private JTextField fractureLengthNaturalFractureModerateJTextField;
    private JTextField fractureLengthNaturalFractureLongJTextField;
    private JTextField EURNaturalFractureHighJTextField;
    private JTextField EURNaturalFractureModerateJTextField;
    private JTextField EURNaturalFractureLowJTextField;
    private JComboBox formationPressureComboBox;

    public JTextField getSlickwaterFormationPressureJTextField() {
        return slickwaterFormationPressureJTextField;
    }
    public JTextField getHybridFormationPressureJTextField() {
        return hybridFormationPressureJTextField;
    }
    public JTextField getCrossLinkedFormationPressureJTextField() {
        return crossLinkedFormationPressureJTextField;
    }
    public JTextField getFoamFormationPressureJTextField() {
        return foamFormationPressureJTextField;
    }
    public JTextField getFluidVolumeFormationPressureHighJTextField() {
        return fluidVolumeFormationPressureHighJTextField;
    }
    public JTextField getFluidVolumeFormationPressureModerateJTextField() {
        return fluidVolumeFormationPressureModerateJTextField;
    }
    public JTextField getFluidVolumeFormationPressureLowJTextField() {
        return fluidVolumeFormationPressureLowJTextField;
    }
    public JTextField getFluidLossFormationPressureHighJTextField() {
        return fluidLossFormationPressureHighJTextField;
    }
    public JTextField getFluidLossFormationPressureModerateJTextField() {
        return fluidLossFormationPressureModerateJTextField;
    }
    public JTextField getFluidLossFormationPressureLowJTextField() {
        return fluidLossFormationPressureLowJTextField;
    }
    public JTextField getTreatmentRateFormationPressureLowJTextField() {
        return treatmentRateFormationPressureLowJTextField;
    }
    public JTextField getTreatmentRateFormationPressureModerateJTextField() {
        return treatmentRateFormationPressureModerateJTextField;
    }
    public JTextField getTreatmentRateFormationPressureHighJTextField() {
        return treatmentRateFormationPressureHighJTextField;
    }
    public JTextField getRampUpFormationPressureSlowJTextField() {
        return rampUpFormationPressureSlowJTextField;
    }
    public JTextField getRampUpFormationPressureModerateJTextField() {
        return rampUpFormationPressureModerateJTextField;
    }
    public JTextField getRampUpFormationPressureFastJTextField() {
        return rampUpFormationPressureFastJTextField;
    }
    public JTextField getFracturePressureFormationPressureHighJTextField() {
        return fracturePressureFormationPressureHighJTextField;
    }
    public JTextField getFracturePressureFormationPressureModerateJTextField() {
        return fracturePressureFormationPressureModerateJTextField;
    }
    public JTextField getFracturePressureFormationPressureLowJTextField() {
        return fracturePressureFormationPressureLowJTextField;
    }
    public JTextField getProppantConcentrationFormationPressureHighJTextField() {
        return proppantConcentrationFormationPressureHighJTextField;
    }
    public JTextField getProppantConcentrationFormationPressureModerateJTextField() {
        return proppantConcentrationFormationPressureModerateJTextField;
    }
    public JTextField getProppantConcentrationFormationPressureLowJTextField() {
        return proppantConcentrationFormationPressureLowJTextField;
    }
    public JTextField getProppantSizeFormationPressureHighMeshJTextField() {
        return proppantSizeFormationPressureHighMeshJTextField;
    }
    public JTextField getProppantSizeFormationPressureHybridJTextField() {
        return proppantSizeFormationPressureHybridJTextField;
    }
    public JTextField getProppantSizeFormationPressureLowMeshJTextField() {
        return proppantSizeFormationPressureLowMeshJTextField;
    }
    public JTextField getProppantDensityFormationPressureLowJTextField() {
        return proppantDensityFormationPressureLowJTextField;
    }
    public JTextField getProppantDensityFormationPressureModerateJTextField() {
        return proppantDensityFormationPressureModerateJTextField;
    }
    public JTextField getProppantDensityFormationPressureNormalJTextField() {
        return proppantDensityFormationPressureNormalJTextField;
    }
    public JTextField getProppantVolumeFormationPressureHighJTextField() {
        return proppantVolumeFormationPressureHighJTextField;
    }
    public JTextField getProppantVolumeFormationPressureModerateJTextField() {
        return proppantVolumeFormationPressureModerateJTextField;
    }
    public JTextField getProppantVolumeFormationPressureLowJTextField() {
        return proppantVolumeFormationPressureLowJTextField;
    }
    public JTextField getProppedSurfaceAreaFormationPressureHighJTextField() {
        return proppedSurfaceAreaFormationPressureHighJTextField;
    }
    public JTextField getProppedSurfaceAreaFormationPressureModerateJTextField() {
        return proppedSurfaceAreaFormationPressureModerateJTextField;
    }
    public JTextField getProppedSurfaceAreaFormationPressureLowJTextField() {
        return proppedSurfaceAreaFormationPressureLowJTextField;
    }
    public JTextField getPerforationClustersFormationPressureMoreFourJTextField() {
        return perforationClustersFormationPressureMoreFourJTextField;
    }
    public JTextField getPerforationClustersFormationPressureThreeJTextField() {
        return perforationClustersFormationPressureThreeJTextField;
    }
    public JTextField getPerforationClustersFormationPressureTwoJTextField() {
        return perforationClustersFormationPressureTwoJTextField;
    }
    public JTextField getFractureGeometryFormationPressureComplexJTextField() {
        return fractureGeometryFormationPressureComplexJTextField;
    }
    public JTextField getFractureGeometryFormationPressureModerateComplexJTextField() {
        return fractureGeometryFormationPressureModerateComplexJTextField;
    }
    public JTextField getFractureGeometryFormationPressurePlanarJTextField() {
        return fractureGeometryFormationPressurePlanarJTextField;
    }
    public JTextField getFractureGeometryFormationPressurePlanarOrShearingJTextField() {
        return fractureGeometryFormationPressurePlanarOrShearingJTextField;
    }
    public JTextField getPropagationResistanceFormationPressureHigherJTextField() {
        return propagationResistanceFormationPressureHigherJTextField;
    }
    public JTextField getPropagationResistanceFormationPressureHighJTextField() {
        return propagationResistanceFormationPressureHighJTextField;
    }
    public JTextField getPropagationResistanceFormationPressureModerateJTextField() {
        return propagationResistanceFormationPressureModerateJTextField;
    }
    public JTextField getPropagationResistanceFormationPressureLowJTextField() {
        return propagationResistanceFormationPressureLowJTextField;
    }
    public JTextField getFractureHeightFormationPressureHighJTextField() {
        return fractureHeightFormationPressureHighJTextField;
    }
    public JTextField getFractureHeightFormationPressureModerateJTextField() {
        return fractureHeightFormationPressureModerateJTextField;
    }
    public JTextField getFractureHeightFormationPressureImpliedJTextField() {
        return fractureHeightFormationPressureImpliedJTextField;
    }
    public JTextField getFractureLengthFormationPressureSmallJTextField() {
        return fractureLengthFormationPressureSmallJTextField;
    }
    public JTextField getFractureLengthFormationPressureModerateJTextField() {
        return fractureLengthFormationPressureModerateJTextField;
    }
    public JTextField getFractureLengthFormationPressureLongJTextField() {
        return fractureLengthFormationPressureLongJTextField;
    }
    public JTextField getEURFormationPressureHighJTextField() {
        return EURFormationPressureHighJTextField;
    }
    public JTextField getEURFormationPressureModerateJTextField() {
        return EURFormationPressureModerateJTextField;
    }
    public JTextField getEURFormationPressureLowJTextField() {
        return EURFormationPressureLowJTextField;
    }

    private JTextField slickwaterFormationPressureJTextField;
    private JTextField hybridFormationPressureJTextField;
    private JTextField crossLinkedFormationPressureJTextField;
    private JTextField foamFormationPressureJTextField;
    private JTextField fluidVolumeFormationPressureHighJTextField;
    private JTextField fluidVolumeFormationPressureModerateJTextField;
    private JTextField fluidVolumeFormationPressureLowJTextField;
    private JTextField fluidLossFormationPressureHighJTextField;
    private JTextField fluidLossFormationPressureModerateJTextField;
    private JTextField fluidLossFormationPressureLowJTextField;
    private JTextField treatmentRateFormationPressureLowJTextField;
    private JTextField treatmentRateFormationPressureModerateJTextField;
    private JTextField treatmentRateFormationPressureHighJTextField;
    private JTextField rampUpFormationPressureSlowJTextField;
    private JTextField rampUpFormationPressureModerateJTextField;
    private JTextField rampUpFormationPressureFastJTextField;
    private JTextField fracturePressureFormationPressureHighJTextField;
    private JTextField fracturePressureFormationPressureModerateJTextField;
    private JTextField fracturePressureFormationPressureLowJTextField;
    private JTextField proppantConcentrationFormationPressureHighJTextField;
    private JTextField proppantConcentrationFormationPressureModerateJTextField;
    private JTextField proppantConcentrationFormationPressureLowJTextField;
    private JTextField proppantSizeFormationPressureHighMeshJTextField;
    private JTextField proppantSizeFormationPressureHybridJTextField;
    private JTextField proppantSizeFormationPressureLowMeshJTextField;
    private JTextField proppantDensityFormationPressureLowJTextField;
    private JTextField proppantDensityFormationPressureModerateJTextField;
    private JTextField proppantDensityFormationPressureNormalJTextField;
    private JTextField proppantVolumeFormationPressureHighJTextField;
    private JTextField proppantVolumeFormationPressureModerateJTextField;
    private JTextField proppantVolumeFormationPressureLowJTextField;
    private JTextField proppedSurfaceAreaFormationPressureHighJTextField;
    private JTextField proppedSurfaceAreaFormationPressureModerateJTextField;
    private JTextField proppedSurfaceAreaFormationPressureLowJTextField;
    private JTextField perforationClustersFormationPressureMoreFourJTextField;
    private JTextField perforationClustersFormationPressureThreeJTextField;
    private JTextField perforationClustersFormationPressureTwoJTextField;
    private JTextField fractureGeometryFormationPressureComplexJTextField;
    private JTextField fractureGeometryFormationPressureModerateComplexJTextField;
    private JTextField fractureGeometryFormationPressurePlanarJTextField;
    private JTextField fractureGeometryFormationPressurePlanarOrShearingJTextField;
    private JTextField propagationResistanceFormationPressureHigherJTextField;
    private JTextField propagationResistanceFormationPressureHighJTextField;
    private JTextField propagationResistanceFormationPressureModerateJTextField;
    private JTextField propagationResistanceFormationPressureLowJTextField;
    private JTextField fractureHeightFormationPressureHighJTextField;
    private JTextField fractureHeightFormationPressureModerateJTextField;
    private JTextField fractureHeightFormationPressureImpliedJTextField;
    private JTextField fractureLengthFormationPressureSmallJTextField;
    private JTextField fractureLengthFormationPressureModerateJTextField;
    private JTextField fractureLengthFormationPressureLongJTextField;
    private JTextField EURFormationPressureHighJTextField;
    private JTextField EURFormationPressureModerateJTextField;
    private JTextField EURFormationPressureLowJTextField;


    public JTextField getSlickwaterYoungsTextField() {
        return slickwaterYoungsTextField;
    }
    public JTextField getHybridYoungsTextField() {
        return hybridYoungsTextField;
    }
    public JTextField getCrossLinkedYoungsTextField() {
        return crossLinkedYoungsTextField;
    }
    public JTextField getFoamYoungsTextField() {
        return foamYoungsTextField;
    }

    public JTextField getFluidVolumeYoungsHighJtextField() {
        return fluidVolumeYoungsHighJtextField;
    }

    public JTextField getFluidVolumeYoungsModerateJtextField() {
        return fluidVolumeYoungsModerateJtextField;
    }

    public JTextField getFluidVolumeYoungsLowJtextField() {
        return fluidVolumeYoungsLowJtextField;
    }

    public JTextField getFluidLossYoungsHighJTextField() {
        return fluidLossYoungsHighJTextField;
    }

    public JTextField getFluidLossYoungsModerateJTextField() {
        return fluidLossYoungsModerateJTextField;
    }

    public JTextField getFluidLossYoungsLowJTextField() {
        return fluidLossYoungsLowJTextField;
    }

    public JTextField getTreatmentRateYoungsHighJTextField() {
        return treatmentRateYoungsHighJTextField;
    }

    public JTextField getTreatmentRateYoungsModerateJTextField() {
        return treatmentRateYoungsModerateJTextField;
    }

    public JTextField getTreatmentRateYoungsLowJTextField() {
        return treatmentRateYoungsLowJTextField;
    }

    public JTextField getRampUpYoungsFastJTextField() {
        return rampUpYoungsFastJTextField;
    }

    public JTextField getRampUpYoungsModerateJTextField() {
        return rampUpYoungsModerateJTextField;
    }

    public JTextField getRampUpYoungsSlowJTextField() {
        return rampUpYoungsSlowJTextField;
    }

    public JTextField getFracturePressureYoungsHighJTextField() {
        return fracturePressureYoungsHighJTextField;
    }

    public JTextField getFracturePressureYoungsModerateJTextField() {
        return fracturePressureYoungsModerateJTextField;
    }

    public JTextField getFracturePressureYoungsLowJTextField() {
        return fracturePressureYoungsLowJTextField;
    }

    public JTextField getProppantConcentrationYoungsHighJTextField() {
        return proppantConcentrationYoungsHighJTextField;
    }

    public JTextField getProppantConcentrationYoungsModerateJTextField() {
        return proppantConcentrationYoungsModerateJTextField;
    }

    public JTextField getProppantConcentrationYoungsLowJTextField() {
        return proppantConcentrationYoungsLowJTextField;
    }

    public JTextField getProppantSizeYoungsHighMeshJTextField() {
        return proppantSizeYoungsHighMeshJTextField;
    }

    public JTextField getProppantSizeYoungsHybridJTextField() {
        return proppantSizeYoungsHybridJTextField;
    }

    public JTextField getProppantSizeYoungsLowMeshJTextField() {
        return proppantSizeYoungsLowMeshJTextField;
    }

    public JTextField getProppantDensityYoungsNormalJTextField() {
        return proppantDensityYoungsNormalJTextField;
    }

    public JTextField getProppantDensityYoungsModerateJTextField() {
        return proppantDensityYoungsModerateJTextField;
    }

    public JTextField getProppantDensityYoungsLowJTextField() {
        return proppantDensityYoungsLowJTextField;
    }

    public JTextField getProppantVolumeYoungsHighJTextField() {
        return proppantVolumeYoungsHighJTextField;
    }

    public JTextField getProppantVolumeYoungsModerateJTextField() {
        return proppantVolumeYoungsModerateJTextField;
    }

    public JTextField getProppantVolumeYoungsLowJTextField() {
        return proppantVolumeYoungsLowJTextField;
    }

    public JTextField getProppedSurfaceAreaYoungsHighJTextField() {
        return proppedSurfaceAreaYoungsHighJTextField;
    }

    public JTextField getProppedSurfaceAreaYoungsModerateJTextField() {
        return proppedSurfaceAreaYoungsModerateJTextField;
    }

    public JTextField getProppedSurfaceAreaYoungsLowJTextField() {
        return proppedSurfaceAreaYoungsLowJTextField;
    }

    public JTextField getPerforationClustersYoungsMoreFourJTextField() {
        return perforationClustersYoungsMoreFourJTextField;
    }

    public JTextField getPerforationClustersYoungsThreeJTextField() {
        return perforationClustersYoungsThreeJTextField;
    }

    public JTextField getPerforationClustersYoungsTwoJTextField() {
        return perforationClustersYoungsTwoJTextField;
    }

    public JTextField getFractureGeometryYoungsComplexJTextField() {
        return fractureGeometryYoungsComplexJTextField;
    }

    public JTextField getFractureGeometryYoungsModerateComplexJTextField() {
        return fractureGeometryYoungsModerateComplexJTextField;
    }

    public JTextField getFractureGeometryYoungsPlanarJTextField() {
        return fractureGeometryYoungsPlanarJTextField;
    }

    public JTextField getFractureGeometryYoungsPlanarOrShearingJTextField() {
        return fractureGeometryYoungsPlanarOrShearingJTextField;
    }

    public JTextField getPropagationResistanceYoungsHigherJTextField() {
        return propagationResistanceYoungsHigherJTextField;
    }

    public JTextField getPropagationResistanceYoungsHighJTextField() {
        return propagationResistanceYoungsHighJTextField;
    }

    public JTextField getPropagationResistanceYoungsModerateJTextField() {
        return propagationResistanceYoungsModerateJTextField;
    }

    public JTextField getPropagationResistanceYoungsLowJTextField()
        {return propagationResistanceYoungsLowJTextField;
    }

    public JTextField getFractureHeightYoungsHighJTextField() {
        return fractureHeightYoungsHighJTextField;
    }

    public JTextField getFractureHeightYoungsModerateJTextField() {
        return fractureHeightYoungsModerateJTextField;
    }

    public JTextField getFractureHeightYoungsImpliedJTextField() {
        return fractureHeightYoungsImpliedJTextField;
    }

    public JTextField getFractureLengthYoungsLongJTextField() {
        return fractureLengthYoungsLongJTextField;
    }

    public JTextField getFractureLengthYoungsModerateJTextField() {
        return fractureLengthYoungsModerateJTextField;
    }

    public JTextField getFractureLengthYoungsSmallJTextField() {
        return fractureLengthYoungsSmallJTextField;
    }

    public JTextField getEURYoungsHighJTextField() {
        return EURYoungsHighJTextField;
    }

    public JTextField getEURYoungsModerateJTextField() {
        return EURYoungsModerateJTextField;
    }

    public JTextField getEURYoungsLowJTextField() {
        return EURYoungsLowJTextField;
    }


    public HydraulicFractureAnalysisDialog() {

        //sets EGI image icon
        URL EGIURL = mainWindow.class.getResource("/Images/EGI.png");
        ImageIcon EGIImageIcon = new ImageIcon(EGIURL);
        Image EGIImage = EGIImageIcon.getImage();
        this.setIconImage(EGIImage);

        JTextField[] youngModulusTextFields = {getSlickwaterYoungsTextField(),getHybridYoungsTextField(),getCrossLinkedYoungsTextField(),getFoamYoungsTextField(),getFluidVolumeYoungsHighJtextField()
        ,getFluidVolumeYoungsModerateJtextField(),getFluidVolumeYoungsLowJtextField(),getFluidLossYoungsHighJTextField(),getFluidLossYoungsModerateJTextField(),getFluidLossYoungsLowJTextField(),getTreatmentRateYoungsLowJTextField()
        ,getTreatmentRateYoungsModerateJTextField(),getTreatmentRateYoungsHighJTextField(),getRampUpYoungsSlowJTextField(),getRampUpYoungsModerateJTextField(),getRampUpYoungsFastJTextField(),getFracturePressureYoungsHighJTextField()
        ,getFracturePressureYoungsModerateJTextField(),getFracturePressureYoungsLowJTextField(),getProppantConcentrationYoungsHighJTextField(),getProppantConcentrationYoungsModerateJTextField(),getProppantConcentrationYoungsLowJTextField()
        ,getProppantSizeYoungsHighMeshJTextField(),getProppantSizeYoungsHybridJTextField(),getProppantSizeYoungsLowMeshJTextField(),getProppantDensityYoungsLowJTextField(),getProppantDensityYoungsModerateJTextField()
        ,getProppantDensityYoungsNormalJTextField(),getProppantVolumeYoungsHighJTextField(),getProppantVolumeYoungsModerateJTextField(),getProppantVolumeYoungsLowJTextField(),getProppedSurfaceAreaYoungsHighJTextField()
        ,getProppedSurfaceAreaYoungsModerateJTextField(),getProppedSurfaceAreaYoungsLowJTextField(),getPerforationClustersYoungsMoreFourJTextField(), getPerforationClustersYoungsThreeJTextField(), getPerforationClustersYoungsTwoJTextField()
        ,getFractureGeometryYoungsComplexJTextField(),getFractureGeometryYoungsModerateComplexJTextField(),getFractureGeometryYoungsPlanarJTextField(),getFractureGeometryYoungsPlanarOrShearingJTextField()
        ,getPropagationResistanceYoungsHigherJTextField(),getPropagationResistanceYoungsHighJTextField(),getPropagationResistanceYoungsModerateJTextField(),getPropagationResistanceYoungsLowJTextField()
        ,getFractureHeightYoungsHighJTextField(),getFractureHeightYoungsModerateJTextField(),getFractureHeightYoungsImpliedJTextField(),getFractureLengthYoungsSmallJTextField(),getFractureLengthYoungsModerateJTextField()
        ,getFractureLengthYoungsLongJTextField(),getEURYoungsHighJTextField(),getEURYoungsModerateJTextField(),getEURYoungsLowJTextField()};

        JTextField[] naturalFractureTextFields = {getSlickwaterNaturalFractureJTextField(),getHybridNaturalFractureJTextField(),getCrossLinkedNaturalFractureJTextField(),getFoamNaturalFractureJTextField()
        ,getFluidVolumeNaturalFractureHighJTextField(),getFluidVolumeNaturalFractureModerateJTextField(),getFluidVolumeNaturalFractureLowJTextField()
        ,getFluidLossNaturalFractureHighJTextField(),getFluidLossNaturalFractureModerateJTextField(),getFluidLossNaturalFractureLowJTextField()
        ,getTreatmentRateNaturalFractureLowJTextField(),getTreatmentRateNaturalFractureModerateJTextField(),getTreatmentRateNaturalFractureHighJTextField()
        ,getRampUpNaturalFractureSlowJTextField(),getRampUpNaturalFractureModerateJTextField(),getRampUpNaturalFractureFastJTextField(),getFracturePressureNaturalFractureHighJTextField()
        ,getFracturePressureNaturalFractureModerateJTextField(),getFracturePressureNaturalFractureLowJTextField(),getProppantConcentrationNaturalFractureHighJTextField()
        ,getProppantConcentrationNaturalFractureModerateJTextField(),getProppantConcentrationNaturalFractureLowJTextField(),getProppantSizeNaturalFractureHighMeshJTextField()
        ,getProppantSizeNaturalFractureHybridJTextField(),getProppantSizeNaturalFractureLowMeshJTextField(),getProppantDensityNaturalFractureLowJTextField(),getProppantDensityNaturalFractureModerateJTextField()
        ,getProppantDensityNaturalFractureNormalJTextField(),getProppantVolumeNaturalFractureHighJTextField(),getProppantVolumeNaturalFractureModerateJTextField()
        ,getProppantVolumeNaturalFractureLowJTextField(),getProppedSurfaceAreaNaturalFractureHighJTextField(),getProppedSurfaceAreaNaturalFractureModerateJTextField()
        ,getProppedSurfaceAreaNaturalFractureLowJTextField(),getPerforationClustersNaturalFractureMoreFourJTextField(),getPerforationClustersNaturalFractureThreeJTextField()
        ,getPerforationClustersNaturalFracturesTwoJTextField(),getFractureGeometryNaturalFractureComplexJTextField(),getFractureGeometryNaturalFractureModerateComplexJTextField()
        ,getFractureGeometryNaturalFracturePlanarJTextField(),getFractureGeometryNaturalFracturePlanarOrShearingJTextField(),getPropagationResistanceNaturalFractureHigherJTextField()
        ,getPropagationResistanceNaturalFractureHighJTextField(),getPropagationResistanceNaturalFractureModerateJTextField(),getPropagationResistanceNaturalFractureLowJTextField()
        ,getFractureHeightNaturalFractureHighJTextField(),getFractureHeightNaturalFractureModerateJTextField(),getFractureHeightNaturalFractureImpliedJTextField()
        ,getFractureLengthNaturalFractureSmallJTextField(),getFractureLengthNaturalFractureModerateJTextField(),getFractureLengthNaturalFractureLongJTextField(),getEURNaturalFractureHighJTextField()
        ,getEURNaturalFractureModerateJTextField(),getEURNaturalFractureLowJTextField()};

        JTextField[] formationPressureTextFields = {getSlickwaterFormationPressureJTextField(),getHybridFormationPressureJTextField(),getCrossLinkedFormationPressureJTextField(),getFoamFormationPressureJTextField()
        ,getFluidVolumeFormationPressureHighJTextField(),getFluidVolumeFormationPressureModerateJTextField(),getFluidVolumeFormationPressureLowJTextField()
        ,getFluidLossFormationPressureHighJTextField(),getFluidLossFormationPressureModerateJTextField(),getFluidLossFormationPressureLowJTextField()
        ,getTreatmentRateFormationPressureLowJTextField(),getTreatmentRateFormationPressureModerateJTextField(),getTreatmentRateFormationPressureHighJTextField()
        ,getRampUpFormationPressureSlowJTextField(),getRampUpFormationPressureModerateJTextField(),getRampUpFormationPressureFastJTextField(),getFracturePressureFormationPressureHighJTextField()
        ,getFracturePressureFormationPressureModerateJTextField(),getFracturePressureFormationPressureLowJTextField(),getProppantConcentrationFormationPressureHighJTextField()
        ,getProppantConcentrationFormationPressureModerateJTextField(),getProppantConcentrationFormationPressureLowJTextField(),getProppantSizeFormationPressureHighMeshJTextField()
        ,getProppantSizeFormationPressureHybridJTextField(),getProppantSizeFormationPressureLowMeshJTextField(),getProppantDensityFormationPressureLowJTextField(),getProppantDensityFormationPressureModerateJTextField()
        ,getProppantDensityFormationPressureNormalJTextField(),getProppantVolumeFormationPressureHighJTextField(),getProppantVolumeFormationPressureModerateJTextField()
        ,getProppantVolumeFormationPressureLowJTextField(),getProppedSurfaceAreaFormationPressureHighJTextField(),getProppedSurfaceAreaFormationPressureModerateJTextField()
        ,getProppedSurfaceAreaFormationPressureLowJTextField(),getPerforationClustersFormationPressureMoreFourJTextField(),getPerforationClustersFormationPressureThreeJTextField()
        ,getPerforationClustersFormationPressureTwoJTextField(),getFractureGeometryFormationPressureComplexJTextField(),getFractureGeometryFormationPressureModerateComplexJTextField()
        ,getFractureGeometryFormationPressurePlanarJTextField(),getFractureGeometryFormationPressurePlanarOrShearingJTextField(),getPropagationResistanceFormationPressureHigherJTextField()
        ,getPropagationResistanceFormationPressureHighJTextField(),getPropagationResistanceFormationPressureModerateJTextField(),getPropagationResistanceFormationPressureLowJTextField()
        ,getFractureHeightFormationPressureHighJTextField(),getFractureHeightFormationPressureModerateJTextField(),getFractureHeightFormationPressureImpliedJTextField()
        ,getFractureLengthFormationPressureSmallJTextField(),getFractureLengthFormationPressureModerateJTextField(),getFractureLengthFormationPressureLongJTextField(),getEURFormationPressureHighJTextField()
        ,getEURFormationPressureModerateJTextField(),getEURFormationPressureLowJTextField()};

        DOMXMLParser dParser = new DOMXMLParser();

        ArrayList<String> modulusList = new ArrayList<String>(dParser.getComboItems("modulus","modulusvalue","XMLFiles/young modulus tables.xml"));
        ArrayList<String> naturalFractureList = new ArrayList<String>(dParser.getComboItems("naturalfracturedensity","densityvalue","XMLFiles/Natural Fracture Tables.xml"));
        ArrayList<String> formationPressureList = new ArrayList<String>(dParser.getComboItems("formationpressure","formationpressurevalue","XMLFiles/Formation Pressure Table.xml"));


        for(int i = 0;i< modulusList.size();i++) {

            youngModulusComboBox.addItem(modulusList.get(i));
        }
        for(int i = 0;i< naturalFractureList.size();i++) {

            naturalFractureComboBox.addItem(naturalFractureList.get(i));
        }
        for(int i = 0;i< formationPressureList.size();i++) {

            formationPressureComboBox.addItem(formationPressureList.get(i));
        }

        youngModulusComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String identity = "Young's Modulus";
                String selectedInputModulus = youngModulusComboBox.getSelectedItem().toString();
                DOMXMLParser parsedValuesAssigning = new DOMXMLParser();

                parsedValuesAssigning.populateValuesParser(selectedInputModulus, youngModulusTextFields, identity);

            }
        });
        naturalFractureComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String identity = "Natural Fracture Density";
                String selectedInputFractureDensity = naturalFractureComboBox.getSelectedItem().toString();

                DOMXMLParser parsedValuesAssigning = new DOMXMLParser();

                parsedValuesAssigning.populateValuesParser(selectedInputFractureDensity, naturalFractureTextFields, identity);
            }
        });

        formationPressureComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String identity = "Formation Pressure";
                String selectedInputFormationPressure = formationPressureComboBox.getSelectedItem().toString();

                DOMXMLParser parsedValuesAssigning = new DOMXMLParser();

                parsedValuesAssigning.populateValuesParser(selectedInputFormationPressure, formationPressureTextFields, identity);
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void initialize() {

        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Hydraulic Fracture Analysis");


    }
}
