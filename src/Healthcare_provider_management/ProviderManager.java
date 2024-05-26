package Healthcare_provider_management;

import java.util.HashMap;
import java.util.Map;

public class ProviderManager {
    private static ProviderManager instance;
    Map<String, HealthcareProvider> providers;

    private ProviderManager() {
        providers = new HashMap<>();
    }

    public static ProviderManager getInstance() {
        if (instance == null) {
            instance = new ProviderManager();
        }
        return instance;
    }

    public void registerProvider(HealthcareProvider provider) {
        if (provider == null) {
            throw new IllegalArgumentException("Provider cannot be null");
        }
        providers.put(provider.getProviderId(), provider);
        System.out.println("Provider " + provider.getName() + " registered.");
    }

    public void scheduleAppointment(String providerId, Appointment appointment) {
        HealthcareProvider provider = providers.get(providerId);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid provider ID");
        }
        provider.addAppointment(appointment);
        System.out.println("Appointment scheduled with Dr. " + provider.getName());
    }

    public void cancelAppointment(String providerId, Appointment appointment) {
        HealthcareProvider provider = providers.get(providerId);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid provider ID");
        }
        provider.removeAppointment(appointment);
        System.out.println("Appointment cancelled for Dr. " + provider.getName());
    }

    public void conductTelemedicineAppointment(String providerId, TelemedicineAppointment appointment) {
        HealthcareProvider provider = providers.get(providerId);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid provider ID");
        }
        provider.addAppointment(appointment);
        System.out.println("Telemedicine appointment conducted with Dr. " + provider.getName());
    }

    public void viewProviderSchedule(String providerId) {
        HealthcareProvider provider = providers.get(providerId);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid provider ID");
        }
        System.out.println("Schedule for Dr. " + provider.getName() + ":");
        for (Appointment appointment : provider.getAppointments()) {
            System.out.println("Appointment ID: " + appointment.getAppointmentId() + ", Date: " + appointment.getDate() + ", Details: " + appointment.getDetails());
        }
    }

    public void sendProviderReminders() {
        for (HealthcareProvider provider : providers.values()) {
            System.out.println("Reminder for Dr. " + provider.getName() + ": Check your appointment schedule.");
        }
    }

    public void integrateWithEMR() {
        System.out.println("Integrating with Electronic Medical Records (EMR) systems.");
    }
}
