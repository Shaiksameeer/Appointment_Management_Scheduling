package Healthcare_provider_management;


import java.util.HashMap;
import java.util.Map;

public class RemotePatientMonitoring {
    private Map<String, PatientData> patientDataMap;
    private PatientState state;

    public RemotePatientMonitoring() {
        patientDataMap = new HashMap<>();
        state = new StableState();
    }

    public void setState(PatientState state) {
        this.state = state;
    }

    public Map<String, PatientData> getPatientDataMap() {
        return patientDataMap;
    }

    public void monitorPatient(String patientId) {
        state.monitorPatient(this, patientId);
    }

    public void updateTreatmentPlan(String patientId) {
        state.updateTreatmentPlan(this, patientId);
    }

    // Nested class to store patient data
    public static class PatientData {
        private String patientId;
        private int heartRate;
        private String bloodPressure;
        private String treatmentPlan;

        public PatientData(String patientId) {
            this.patientId = patientId;
        }

        public String getPatientId() {
            return patientId;
        }

        public int getHeartRate() {
            return heartRate;
        }

        public void setHeartRate(int heartRate) {
            this.heartRate = heartRate;
        }

        public String getBloodPressure() {
            return bloodPressure;
        }

        public void setBloodPressure(String bloodPressure) {
            this.bloodPressure = bloodPressure;
        }

        public String getTreatmentPlan() {
            return treatmentPlan;
        }

        public void setTreatmentPlan(String treatmentPlan) {
            this.treatmentPlan = treatmentPlan;
        }
    }
}
