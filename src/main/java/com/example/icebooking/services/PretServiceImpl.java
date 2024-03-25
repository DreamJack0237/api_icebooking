package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.icebooking.Dto.LoanRequestDto;
import com.example.icebooking.converters.LoanConverter;
import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Pret;
import com.example.icebooking.repositories.LoanRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PretServiceImpl implements PretService {

    private LoanConverter loanConverter;

    private final LoanRepository pretRepository;

    private final BookServiceImpl bookService;

    //
    @Override
    public List<Pret> getPrets() {
        return pretRepository.findAll();

    }

    // get specific information about a loan
    @Override
    public Pret getPret(Integer id) {
        return pretRepository.findById(id).orElseThrow();
    }

    // this method is for back a loan
    @Override
    public void backPret(Integer id) {
        Pret loan = pretRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Product not found with id: " + id));
        ;
        loan.setBackDate(new Date());
        pretRepository.save(loan);
    }

    @Override
    public Pret createPret(LoanRequestDto loanDto) {
        Pret loan = loanConverter.fromCreationDto(loanDto);
        loanDto.getBooks()
                .stream()
                .map(bookId -> bookService.getOuvrage(bookId))
                .forEach(loan::addBook);
        return pretRepository.save(loan);
    }

    @Override
    public void updateLimitDate(Integer id, Date date) {
        Pret loan = pretRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Product not found with id: " + id));
        loan.setLimitBackDate(date);
        pretRepository.save(loan);

    }

}
