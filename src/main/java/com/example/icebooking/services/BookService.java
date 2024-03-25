package com.example.icebooking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.icebooking.models.Notation;
import com.example.icebooking.models.Ouvrage;

public interface BookService {

    // create book
    public void createOuvrage(Ouvrage ouvrage, MultipartFile file, MultipartFile image);

    public ResponseEntity<?> downloadBook(String id);

    // delete book
    public void deleteOuvrage(String id);

    // get book notations
    public List<Notation> getBookNotations(String id);

    // get book lectors
    public List<Notation> getBookLectors(String id);

    // get book downloader
    public List<Notation> getBookDownloader(String id);

    // add a category to book
    public void addBookCategory(String bookId, Integer categoryId);

    // delete specified book categories
    public void deleteBookCategory(String bookId, Integer categoryId);

    // get a book
    public Ouvrage getOuvrage(String id);

    // get all book
    public List<Ouvrage> getOuvrages();

    // update all book
    public void updateOuvrage(String id, Ouvrage ouvrage, MultipartFile file, MultipartFile image);

}
