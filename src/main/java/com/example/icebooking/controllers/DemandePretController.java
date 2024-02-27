// package com.example.icebooking.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.icebooking.models.DemandeDePret;
// import com.example.icebooking.services.LoanRequestServiceImpl;

// import lombok.AllArgsConstructor;

// @RestController
// @RequestMapping("/demandeprets")
// @AllArgsConstructor
// public class DemandePretController {
// @Autowired
// private final LoanRequestServiceImpl demandepretService;

// @ResponseStatus(HttpStatus.CREATED)
// @PostMapping("{id}/")
// public void sendDemandePret(@RequestBody DemandeDePret demandePret) {
// this.demandepretService.sendDemandePret(null);
// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @GetMapping("/")
// public List<DemandeDePret> listeDemandePret() {
// return demandepretService.getDemandePrets();

// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @DeleteMapping("/{id}")
// public void cancelOrRejectDemandePret(@PathVariable Integer id) {
// this.demandepretService.cancelOrRejectDemandePret();
// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @PostMapping("/{id}")
// public void acceptDemandePret(@PathVariable Integer id) {
// this.demandepretService.acceptDemandePret(id);
// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @PutMapping("/{id}")
// public void updateDemandePret(@PathVariable Integer id, @RequestBody
// DemandeDePret demandePret) {
// this.demandepretService.updateDemandePret(id, demandePret);
// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @GetMapping("/{id}")
// public DemandeDePret getDemandePret(@PathVariable Integer id) {
// return demandepretService.getDemandePret(id);
// }

// @ResponseStatus(HttpStatus.ACCEPTED)
// @GetMapping("/{id}/lines")
// public DemandeDePret getLoanRequestLine(@PathVariable Integer id) {
// return demandepretService.getDemandePret(id);
// }

// }
