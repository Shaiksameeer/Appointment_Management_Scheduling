package Healthcare_provider_management;

import Healthcare_provider_management.RemotePatientMonitoring.PatientData;

public class StableState implements PatientState {

    @Override
    public void monitorPatient(RemotePatientMonitoring monitoring, String patientId) {
        PatientData patientData = monitoring.getPatientDataMap().get(patientId);
        if (patientData == null) {
            patientData = new PatientData(patientId);
            monitoring.getPatientDataMap().put(patientId, patientData);
        }
        patientData.setHeartRate(72 + (int) (Math.random() * 10));
        patientData.setBloodPressure("120/80");

        System.out.println("Monitoring patient ID " + patientId + " in stable state.");
        System.out.println("Heart Rate: " + patientData.getHeartRate() + " bpm");
        System.out.println("Blood Pressure: " + patientData.getBloodPressure());
    }

    @Override
    public void updateTreatmentPlan(RemotePatientMonitoring monitoring, String patientId) {
        PatientData patientData = monitoring.getPatientDataMap().get(patientId);
        if (patientData == null) {
            System.out.println("No data available for patient ID " + patientId + ". Cannot update treatment plan.");
            return;
        }

        String treatmentPlan = "Maintain current medication and monitor daily.";
        patientData.setTreatmentPlan(treatmentPlan);
        System.out.println("Updating treatment plan for patient ID " + patientId + " in stable state.");
        System.out.println("New Treatment Plan: " + patientData.getTreatmentPlan());
    }
}

