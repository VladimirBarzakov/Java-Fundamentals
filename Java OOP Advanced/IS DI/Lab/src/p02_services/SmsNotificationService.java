package p02_services;

public class SmsNotificationService implements NotificationService{
    private boolean isActive;

    public SmsNotificationService(Boolean isActive) {
        this.isActive=isActive;
    }

    public void sendNotification() {
        System.out.println("SMS notification");
    }

    public boolean isActive() {
        return this.isActive;
    }
}
