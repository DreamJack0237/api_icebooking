package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Download;

public interface DownloadRepository extends JpaRepository<Download, Integer> {

}
