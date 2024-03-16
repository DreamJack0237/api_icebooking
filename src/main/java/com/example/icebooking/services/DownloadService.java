package com.example.icebooking.services;

import com.example.icebooking.models.Download;

import java.util.List;

public interface DownloadService {

    // get information about a specific download
    public Download getDownload(Integer id);

    // list all download
    public List<Download> getDownloads();
}
