package Healthcare_provider_management;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class RemotePatientMonitoringTest {

    private RemotePatientMonitoring monitoring;
    private final String patientId = "P1";

    @Before
    public void setUp() {
        monitoring = new RemotePatientMonitoring();
    }

    @After
    public void tearDown() {
        monitoring = null;
    }

    @Test
    public void testMonitorPatientStableState() {
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);
        
        assertNotNull("Patient data should not be null", data);
        assertTrue("Heart rate should be within stable range", data.getHeartRate() >= 72 && data.getHeartRate() <= 82);
        assertEquals("Blood pressure should be 120/80", "120/80", data.getBloodPressure());
    }

    @Test
    public void testUpdateTreatmentPlanStableState() {
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        monitoring.updateTreatmentPlan(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);

        assertNotNull("Patient data should not be null", data);
        assertEquals("Treatment plan should be for stable state", "Maintain current medication and monitor daily.", data.getTreatmentPlan());
    }

    @Test
    public void testMonitorPatientCriticalState() {
        monitoring.setState(new CriticalState());
        monitoring.monitorPatient(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);

        assertNotNull("Patient data should not be null", data);
        assertTrue("Heart rate should be within critical range", data.getHeartRate() >= 90 && data.getHeartRate() <= 100);
        assertEquals("Blood pressure should be 140/90", "140/90", data.getBloodPressure());
    }

    @Test
    public void testUpdateTreatmentPlanCriticalState() {
        monitoring.setState(new CriticalState());
        monitoring.monitorPatient(patientId);
        monitoring.updateTreatmentPlan(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);

        assertNotNull("Patient data should not be null", data);
        assertEquals("Treatment plan should be for critical state", "Review medication dosage. Schedule follow-up appointment.", data.getTreatmentPlan());
    }

    @Test
    public void testNoDataUpdateTreatmentPlan() {
        monitoring.setState(new StableState());
        monitoring.updateTreatmentPlan(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);

        assertNull("Patient data should be null", data);
    }

    @Test
    public void testStateTransition() {
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);
        
        assertNotNull("Patient data should not be null", data);
        assertEquals("Blood pressure should be 120/80", "120/80", data.getBloodPressure());

        monitoring.setState(new CriticalState());
        monitoring.monitorPatient(patientId);
        
        assertEquals("Blood pressure should be 140/90", "140/90", data.getBloodPressure());
    }
    
    @Test
    public void testPatientDataInitialization() {
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        RemotePatientMonitoring.PatientData data = monitoring.getPatientDataMap().get(patientId);
        
        assertNotNull("Patient data should be initialized", data);
        assertEquals("Patient ID should be set correctly", patientId, data.getPatientId());
    }
    
    @Test
    public void testMonitorMultiplePatients() {
        String patientId2 = "P2";
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        monitoring.monitorPatient(patientId2);
        
        assertEquals("Two patients should be monitored", 2, monitoring.getPatientDataMap().size());
    }
    
    @Test
    public void testUpdateTreatmentPlanWithoutMonitoring() {
        monitoring.setState(new StableState());
        monitoring.updateTreatmentPlan(patientId);
        
        assertNull("Patient data should be null before monitoring", monitoring.getPatientDataMap().get(patientId));
    }


    @Test
    public void testPatientDataNotOverwritten() {
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        RemotePatientMonitoring.PatientData data1 = monitoring.getPatientDataMap().get(patientId);
        
        monitoring.monitorPatient(patientId);
        RemotePatientMonitoring.PatientData data2 = monitoring.getPatientDataMap().get(patientId);
        
        assertSame("Patient data should not be overwritten", data1, data2);
    }

    @Test
    public void testPatientDataDifferentPatients() {
        String patientId2 = "P2";
        monitoring.setState(new StableState());
        monitoring.monitorPatient(patientId);
        monitoring.monitorPatient(patientId2);
        
        RemotePatientMonitoring.PatientData data1 = monitoring.getPatientDataMap().get(patientId);
        RemotePatientMonitoring.PatientData data2 = monitoring.getPatientDataMap().get(patientId2);
        
        assertNotSame("Patient data for different patients should not be same", data1, data2);
    }
}
