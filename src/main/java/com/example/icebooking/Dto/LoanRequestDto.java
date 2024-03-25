package com.example.icebooking.Dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class LoanRequestDto {

    // private Date limitBackDate;
    private List<String> books;
}
