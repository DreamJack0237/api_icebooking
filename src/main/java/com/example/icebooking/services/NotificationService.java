package com.example.icebooking.services;

import com.example.icebooking.models.Notification;
//import com.example.icebooking.models.Notification;
//import org.springframework.mail.javamail.javaMailSender;

import java.util.List;

public interface NotificationService {
//    javaMailSender
    public void createNotification(Notification notification);
    public  void deleteNotification(Integer id);
    public Notification getNotification(Integer id);
    public List<Notification> getNotifications();

}
