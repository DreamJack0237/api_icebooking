package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Pret;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.repositories.PretRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PretServiceImpl implements PretService {

    @Autowired
    private final PretRepository pretRepository;

    @Override
    public List<Pret> getPrets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public Pret getPret(Integer id) {
        // TODO Auto-generated method stub
        return pretRepository.findById(id).orElseThrow();
    }

    @Override
    public String backPret(Integer id) {
        // TODO Auto-generated method stub
        return "k";
    }

}
