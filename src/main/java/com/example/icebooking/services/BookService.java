package com.example.icebooking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.icebooking.models.Notation;
import com.example.icebooking.models.Ouvrage;

public interface BookService {

    // create book
    public void createOuvrage(Ouvrage ouvrage, MultipartFile file, MultipartFile image);

    public ResponseEntity<?> downloadBook(Integer id);

    // delete book
    public void deleteOuvrage(Integer id);

    // get book notations
    public List<Notation> getBookNotations(Integer id);

    // get book lectors
    public List<Notation> getBookLectors(Integer id);

    // get book downloader
    public List<Notation> getBookDownloader(Integer id);

    // add a category to book
    public void addBookCategory(Integer bookId, Integer categoryId);

    // delete specified book categories
    public void deleteBookCategory(Integer bookId, Integer categoryId);

    // get a book
    public Ouvrage getOuvrage(Integer id);

    // get all book
    public List<Ouvrage> getOuvrages();

    // update all book
    public void updateOuvrage(Integer id, Ouvrage ouvrage);

}
