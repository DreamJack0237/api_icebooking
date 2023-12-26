package com.example.icebooking.services;

import com.example.icebooking.models.Notification;
import com.example.icebooking.models.Notification;

import java.util.List;

public interface NotificationService {
    public void createNotification(Notification notification);
    public  void deleteNotification(Integer id);
    public Notification getNotification(Integer id);
    public List<Notification> getNotifications();

    public  void updateNotification(Integer id,Notification notification);
}
