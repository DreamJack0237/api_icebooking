package com.example.icebooking.services;

import java.util.Date;
import java.util.List;

import com.example.icebooking.Dto.LoanRequestDto;
import com.example.icebooking.models.Pret;

public interface PretService {

    List<Pret> getPrets();

    Pret getPret(Integer id);

    void backPret(Integer id);

    void updateLimitDate(Integer id, Date date);

    Pret createPret(LoanRequestDto loanDto);
}