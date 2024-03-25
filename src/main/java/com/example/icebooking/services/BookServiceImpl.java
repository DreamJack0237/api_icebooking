package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.icebooking.models.Notation;
import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.repositories.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository ouvrageRepository;
    @Autowired
    private final FileStorageService fileStorageService;

    @Override
    public void createOuvrage(Ouvrage ouvrage, MultipartFile file, MultipartFile image) {
        ouvrage.setImagePath(fileStorageService.saveFile("images", image));
        ouvrage.setFilePath(fileStorageService.saveFile("files", file));

        this.ouvrageRepository.save(ouvrage);
    }

    @Override
    public void deleteOuvrage(String id) {
        this.ouvrageRepository.deleteById(id);
    }

    @Override
    public void updateOuvrage(String id, Ouvrage ouvrage, MultipartFile file, MultipartFile image) {
        Ouvrage existingProduct = ouvrageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setAutheur(ouvrage.getAutheur());
        existingProduct.setNom(ouvrage.getNom());
        existingProduct.setDescription(ouvrage.getDescription());
        existingProduct.setQuantite(ouvrage.getQuantite());

        this.ouvrageRepository.save(existingProduct);
    }

    @Override
    public Ouvrage getOuvrage(String id) {

        return ouvrageRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        List<Ouvrage> ouvrages = new ArrayList<>();
        ouvrageRepository.findAll().forEach(ouvrage -> {
            ouvrages.add(ouvrage);

        });

        return ouvrages;
    }

    @Override
    public List<Notation> getBookNotations(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookNotations'");
    }

    @Override
    public List<Notation> getBookLectors(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getBookLectors'");
    }

    @Override
    public List<Notation> getBookDownloader(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getBookDOwnloader'");
    }

    // add category to a book
    @Override
    public void addBookCategory(String id, Integer categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'addBookCategory'");
    }

    // remove a categroy from book
    @Override
    public void deleteBookCategory(String id, Integer categoryId) {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method'deleteBookCategory'");
    }

    @Override
    public ResponseEntity<?> downloadBook(String id) {
        Ouvrage o = ouvrageRepository.getReferenceById(id);
        return fileStorageService.load(o.getFilePath());
    }

}
