// package com.example.icebooking.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.*;

// import com.example.icebooking.models.Notification;
// import com.example.icebooking.services.NotificationServiceImpl;

// import lombok.AllArgsConstructor;

// @RestController
// @RequestMapping("/notifications")
// @AllArgsConstructor
// public class NotificationController {

//     @Autowired
//     private final NotificationServiceImpl notificationService;

//     @ResponseStatus(HttpStatus.CREATED)
//     @PostMapping("/")
//     public void creerNotification(@RequestBody Notification notification) {
//         this.notificationService.createNotification(notification);
//     }

//     @ResponseStatus(HttpStatus.ACCEPTED)
//     @DeleteMapping("/{id}")
//     public void deleteNotification(@PathVariable Integer id) {
//         this.notificationService.deleteNotification(id);
//     }

//     @ResponseStatus(HttpStatus.ACCEPTED)
//     @GetMapping("/{id}")
//     public Notification getNotification(@PathVariable Integer id) {
//         return notificationService.getNotification(id);
//     }

// }
