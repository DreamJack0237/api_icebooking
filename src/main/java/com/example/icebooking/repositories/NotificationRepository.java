package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
