package p02_services;

import java.util.List;

public class OnlineStoreOrder {

    private NotificationService[] notificationServices;

    public OnlineStoreOrder(List<NotificationService> notificationServices) {
        this.notificationServices= notificationServices.stream().toArray(NotificationService[]::new);
    }

    public void process() {
        for (NotificationService notificationService:this.notificationServices) {
            if (notificationService.isActive()){
                notificationService.sendNotification();
            }
        }
    }
}
