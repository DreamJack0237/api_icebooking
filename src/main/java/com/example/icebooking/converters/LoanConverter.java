package com.example.icebooking.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.icebooking.Dto.LoanRequestDto;
import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Pret;

@Component
public class LoanConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Pret fromCreationDto(LoanRequestDto loanRequestDto) {

        Pret loan = modelMapper.map(loanRequestDto, Pret.class);
        ArrayList<Ouvrage> ouvrages = new ArrayList<Ouvrage>();
        loan.setOuvrages(ouvrages);
        return loan;

    }
}
