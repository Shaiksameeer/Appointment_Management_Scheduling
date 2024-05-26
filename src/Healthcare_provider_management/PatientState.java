package Healthcare_provider_management;public interface PatientState {
    void monitorPatient(RemotePatientMonitoring monitoring, String patientId);
    void updateTreatmentPlan(RemotePatientMonitoring monitoring, String patientId);
}

