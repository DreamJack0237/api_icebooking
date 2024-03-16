package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Pret;
import com.example.icebooking.repositories.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PretServiceImpl implements PretService {

    @Autowired
    private final LoanRepository pretRepository;

    //
    @Override
    public List<Pret> getPrets() {
        throw new UnsupportedOperationException("Unimplemented method'getAllProducts'");
    }

    // get specific information about a loan
    @Override
    public Pret getPret(Integer id) {
        return pretRepository.findById(id).orElseThrow();
    }

    // this method is for back a loan
    @Override
    public String backPret(Integer id) {
        return "k";
    }

    @Override
    public Pret createPret(Pret pret) {
        throw new UnsupportedOperationException("Unimplemented method 'createPret'");
    }

}
