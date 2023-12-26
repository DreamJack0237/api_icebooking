package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.icebooking.models.Notification;
import com.example.icebooking.services.NotificationServiceImpl;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
       private final NotificationServiceImpl notificationService;


    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("/")
    public void creerNotification(@RequestBody Notification notification){
        this.notificationService.createNotification(notification);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/")
    public List<Notification> listeNotification(){
       return notificationService.getNotifications();
  
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/{id}")
    public void deleteNotification(@PathVariable Integer id){
        this.notificationService.deleteNotification(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updateNotification(@PathVariable Integer id, @RequestBody Notification notification){
        this.notificationService.updateNotification(id,notification);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Integer id){
        return notificationService.getNotification(id);
    }
 
}
