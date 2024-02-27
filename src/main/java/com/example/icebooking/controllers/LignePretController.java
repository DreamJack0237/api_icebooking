// package com.example.icebooking.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.icebooking.models.Ouvrage;

// @RequestMapping("/loanrequestlines")
// @RestController
// public class LignePretController {

// @Autowired
// private final LignePretController LigneDePretService;

// @ResponseStatus(HttpStatus.ACCEPTED)
// @DeleteMapping("/{id}")
// public void deleteLoanRequestLine(@PathVariable Integer id) {
// this.LigneDePretService.deleteLoanRequestLine(id);
// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @PutMapping("/{id}")
// public void updateLoanRequestLine(@PathVariable Integer id, @RequestBody
// Ouvrage ouvrage) {
// this.LigneDePretService.updateLoanRequestLine(id, ouvrage);
// }

// }
