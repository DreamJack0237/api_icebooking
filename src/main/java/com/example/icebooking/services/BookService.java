package com.example.icebooking.services;

import com.example.icebooking.models.Avis;
import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.repositories.OuvrageRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public interface BookService {

//create book
public void createOuvrage(Ouvrage ouvrage);

//delete  book
public  void deleteOuvrage(Integer id);

//get book notations
public List<Avis> getBookNotations(Integer id);
//get book lectors
public List<Avis> getBookLectors(Integer id);
//get book downloader
public List<Avis> getBookDOwnloader(Integer id);

//add a category to book
public void addOuvrageCategories();

//delete specified book categories
public void deleteOuvrageCategories();

// get a book
public Ouvrage getOuvrage(Integer id);

//get all book
public List<Ouvrage> getOuvrages();

//update all book
public  void updateOuvrage(Integer id,Ouvrage ouvrage);

}
