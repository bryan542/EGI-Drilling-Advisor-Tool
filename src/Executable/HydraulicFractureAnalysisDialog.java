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

        final JTextField[] youngModulusTextFields = {getSlickwaterYoungsTextField(),getHybridYoungsTextField(),getCrossLinkedYoungsTextField(),getFoamYoungsTextField(),getFluidVolumeYoungsHighJtextField()
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

        final JTextField[] naturalFractureTextFields = {getSlickwaterNaturalFractureJTextField(),getHybridNaturalFractureJTextField(),getCrossLinkedNaturalFractureJTextField(),getFoamNaturalFractureJTextField()
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

        final JTextField[] formationPressureTextFields = {getSlickwaterFormationPressureJTextField(),getHybridFormationPressureJTextField(),getCrossLinkedFormationPressureJTextField(),getFoamFormationPressureJTextField()
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

        // These are used to find the child elements of the main element in the xml files that are then fed into the combobox for user selection
        ArrayList<String> modulusList = new ArrayList<String>(dParser.getComboItems("modulus","modulusvalue","XMLFiles/young modulus tables.xml"));
        ArrayList<String> naturalFractureList = new ArrayList<String>(dParser.getComboItems("naturalfracturedensity","densityvalue","XMLFiles/Natural Fracture Tables.xml"));
        ArrayList<String> formationPressureList = new ArrayList<String>(dParser.getComboItems("formationpressure","formationpressurevalue","XMLFiles/Formation Pressure Table.xml"));

        //Used when we find the sum/averages of the values across the tabs
        final  ArrayList<JTextField[]> totalJTextFieldCollections = new ArrayList<JTextField[]>();
        totalJTextFieldCollections.add(youngModulusTextFields);
        totalJTextFieldCollections.add(naturalFractureTextFields);
        totalJTextFieldCollections.add(formationPressureTextFields);


        for(int i = 0;i< modulusList.size();i++) {

            youngModulusComboBox.addItem(modulusList.get(i));
        }
        for(int i = 0;i< naturalFractureList.size();i++) {

            naturalFractureComboBox.addItem(naturalFractureList.get(i));
        }
        for(int i = 0;i< formationPressureList.size();i++) {

            formationPressureComboBox.addItem(formationPressureList.get(i));
        }

        // When the user chooses the combobox value for any of the teabs, the value is fed into the parser
        // to populate the tables with the correct xml file values
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
                double[] averagesArray = finalHydraulicFractureSumAverages(totalJTextFieldCollections); //sums and averages all the tabbed values
                String[] summationNames = populateReportTextField(averagesArray); // takes the sums and finds the highest value
                FinalHydraulicReportDialog FHRD = new FinalHydraulicReportDialog(summationNames);
                FHRD.setModal(true);// Passes the named value into the class to settext the jtextfields
                FHRD.initialize(); //builds the dialog window
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

    //This method finds the averages of each value across all of the hydraulic fracture tabs and returns them as an array
    public double[] finalHydraulicFractureSumAverages(ArrayList<JTextField[]> totalTextFieldCollections){

        int size = totalTextFieldCollections.size(); // used to find the length of subsection in the arrays so that it
                                                    //dynamically divides and sorts by the right amount
        double sumHolder = 0;
        double[] averagesArray = new double[54];

        for(int i = 0;i<totalTextFieldCollections.get(0).length;i++){

            for (int j = 0;j<size;j++){

                sumHolder = sumHolder+Double.parseDouble(totalTextFieldCollections.get(j)[i].getText());
            }
            averagesArray[i] = sumHolder/size;
            sumHolder = 0;
        }
        return averagesArray;
    }

    //This method sets the textboxes for the suggested element types based on the highest reported value of the set
    //of average values in the subgroups. (look at xml file groupings for reference)
    //This is tedious and cumbersome. May wnat to come back and think of a smarter/more efficient approach
    public String[] populateReportTextField(double[] sumAveragesArray){

        String[] reportOutputs = new String[17];

        String[] fluidNames = {"Slickwater","Hybrid","Cross-Linked","Foam","High","Moderate","Low","High","Moderate","Low","Low","Moderate","High"
               , "Slow","Moderate","Fast","High","Moderate","Low","High","Moderate","Low","100, 40/70, 20/40 Tail-in","Hybrid","20/40",
                "Low","Moderate","Normal","High","Moderate","Low","High","Moderate","Low","Four or More","Three","Two","Complex","Moderate to Complex","Planar","Planar or Shearing"
        ,"Higher","High","Moderate","Small","High","Moderate","Implied","Short","Moderate","Long","High","Moderate","Low"};
        

        double fluidSystemFinalValue = 0;
        double fluidVolumeFinalValue = 0;
        double fluidlossFinalValue =0;
        double treatmentRateFinalValue = 0;
        double rampUpFinalValue = 0;
        double fracturePressureFinalValue = 0;
        double proppantConcentrationFinalValue = 0;
        double proppantSizeFinalValue = 0;
        double proppantDensityFinalValue = 0;
        double proppantVolumeFinalValue = 0;
        double proppedSurfaceAreaFinalValue = 0;
        double perforationClusterFinalValue = 0;
        double fractureGeometryFinalValue = 0;
        double propagationResistanceFinalValue = 0;
        double fractureHeightFinalValue = 0;
        double fractureLengthFinalValue = 0;
        double EURFinalValue = 0;

        String fluidSystemFinalName = null;
        String fluidVolumeFinalName = null;
        String fluidlossFinalName =null;
        String treatmentRateFinalName = null;
        String rampUpFinalName = null;
        String fracturePressureFinalName = null;
        String proppantConcentrationFinalName = null;
        String proppantSizeFinalName = null;
        String proppantDensityFinalName = null;
        String proppantVolumeFinalName = null;
        String proppedSurfaceAreaFinalName = null;
        String perforationClusterFinalName = null;
        String fractureGeometryFinalName = null;
        String propagationResistanceFinalName = null;
        String fractureHeightFinalName = null;
        String fractureLengthFinalName = null;
        String EURFinalName = null;


        //set all of the int ranges based on the known sizes of the arrays. There has to be a smarter way
        //by accessing the sizes of the child nodes....
        for (int i = 0;i<4;i++){
            if(sumAveragesArray[i]>fluidSystemFinalValue){

                fluidSystemFinalValue = sumAveragesArray[i];
                fluidSystemFinalName = fluidNames[i];
            }

        }
        for(int i = 4;i<7;i++){

            if(sumAveragesArray[i]>fluidlossFinalValue){

                fluidlossFinalValue = sumAveragesArray[i];
                fluidlossFinalName = fluidNames[i];
            }
        }
        for(int i = 4;i<7;i++){

            if(sumAveragesArray[i]>fluidVolumeFinalValue){

                fluidVolumeFinalValue = sumAveragesArray[i];
                fluidVolumeFinalName = fluidNames[i];
            }
        }
        for(int i = 7;i<10;i++){

            if(sumAveragesArray[i]>fluidlossFinalValue){

                fluidlossFinalValue = sumAveragesArray[i];
                fluidlossFinalName = fluidNames[i];
            }
        }
        
        for(int i = 10;i<13;i++){

            if(sumAveragesArray[i]>treatmentRateFinalValue){

                treatmentRateFinalValue = sumAveragesArray[i];
                treatmentRateFinalName = fluidNames[i];
            }
        }

        for(int i = 13;i<16;i++){

            if(sumAveragesArray[i]>rampUpFinalValue){

                rampUpFinalValue = sumAveragesArray[i];
                rampUpFinalName = fluidNames[i];
            }
        }
        for(int i = 16;i<19;i++){

            if(sumAveragesArray[i]>fracturePressureFinalValue){

                fracturePressureFinalValue = sumAveragesArray[i];
                fracturePressureFinalName = fluidNames[i];
            }
        }
        for(int i = 19;i<22;i++){

            if(sumAveragesArray[i]>proppantConcentrationFinalValue){

                proppantConcentrationFinalValue = sumAveragesArray[i];
                proppantConcentrationFinalName = fluidNames[i];
            }
        }
        for(int i = 22;i<25;i++){

            if(sumAveragesArray[i]>proppantSizeFinalValue){

                proppantSizeFinalValue = sumAveragesArray[i];
                proppantSizeFinalName = fluidNames[i];
            }
        }
        for(int i = 25;i<28;i++){

            if(sumAveragesArray[i]>proppantDensityFinalValue){

                proppantDensityFinalValue = sumAveragesArray[i];
                proppantDensityFinalName = fluidNames[i];
            }
        }
        for(int i = 25;i<28;i++){

            if(sumAveragesArray[i]>proppantDensityFinalValue){

                proppantDensityFinalValue = sumAveragesArray[i];
                proppantDensityFinalName = fluidNames[i];
            }
        }
        for(int i = 28;i<31;i++){

            if(sumAveragesArray[i]>proppantVolumeFinalValue){

                proppantVolumeFinalValue = sumAveragesArray[i];
                proppantVolumeFinalName = fluidNames[i];
            }
        }
        for(int i = 31;i<34;i++){

            if(sumAveragesArray[i]>proppedSurfaceAreaFinalValue){

                proppedSurfaceAreaFinalValue = sumAveragesArray[i];
                proppedSurfaceAreaFinalName = fluidNames[i];
            }
        }
        for(int i = 34;i<37;i++){

            if(sumAveragesArray[i]>perforationClusterFinalValue){

                perforationClusterFinalValue = sumAveragesArray[i];
                perforationClusterFinalName = fluidNames[i];
            }
        }
        for(int i = 37;i<41;i++){

            if(sumAveragesArray[i]>fractureGeometryFinalValue){

                fractureGeometryFinalValue = sumAveragesArray[i];
                fractureGeometryFinalName = fluidNames[i];
            }
        }
        for(int i = 41;i<45;i++){

            if(sumAveragesArray[i]>propagationResistanceFinalValue){

                propagationResistanceFinalValue = sumAveragesArray[i];
                propagationResistanceFinalName = fluidNames[i];
            }
        }
        for(int i = 45;i<48;i++){

            if(sumAveragesArray[i]>fractureHeightFinalValue){

                fractureHeightFinalValue = sumAveragesArray[i];
                fractureHeightFinalName = fluidNames[i];
            }
        }
        for(int i = 48;i<51;i++){

            if(sumAveragesArray[i]>fractureLengthFinalValue){

                fractureLengthFinalValue = sumAveragesArray[i];
                fractureLengthFinalName = fluidNames[i];
            }
        }

        for(int i = 51;i<54;i++){

            if(sumAveragesArray[i]>EURFinalValue){

                EURFinalValue = sumAveragesArray[i];
                EURFinalName = fluidNames[i];
            }
        }

        //selects the highest rated value from each loop and puts it in the array that will be passed to the
        //FinalHydraulicReportDialog class for final analysis/JTextField settings.
        reportOutputs[0] = fluidSystemFinalName;
        reportOutputs[1] = fluidVolumeFinalName;
        reportOutputs[2] = fluidlossFinalName;
        reportOutputs[3] = treatmentRateFinalName;
        reportOutputs[4] = rampUpFinalName;
        reportOutputs[5] = fracturePressureFinalName;
        reportOutputs[6] = proppantConcentrationFinalName;
        reportOutputs[7] = proppantSizeFinalName;
        reportOutputs[8] = proppantDensityFinalName;
        reportOutputs[9] = proppantVolumeFinalName;
        reportOutputs[10] = proppedSurfaceAreaFinalName;
        reportOutputs[11] = perforationClusterFinalName;
        reportOutputs[12] = fractureGeometryFinalName;
        reportOutputs[13] = propagationResistanceFinalName;
        reportOutputs[14] = fractureHeightFinalName;
        reportOutputs[15] = fractureLengthFinalName;
        reportOutputs[16] = EURFinalName;
        
        return reportOutputs;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void initialize() {

        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Hydraulic Fracture Analysis");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);



    }
}
