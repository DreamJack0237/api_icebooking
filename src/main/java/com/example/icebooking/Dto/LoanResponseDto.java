package com.example.icebooking.Dto;

import java.util.Date;

import com.example.icebooking.models.Utilisateur;

import lombok.Data;

@Data
public class LoanResponseDto

{
    private long id;
    private Utilisateur creator;
    private String author;
    private long itemCount;
    private Date limitDate;
    private Date returnDate;
}
