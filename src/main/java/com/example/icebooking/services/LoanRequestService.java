package com.example.icebooking.services;

import com.example.icebooking.models.DemandeDePret;

import java.util.List;

public interface LoanRequestService {
    // accept a loan request
    public void acceptDemandePret(Integer id);

    public void rejectDemandePret(Integer id);

    public void cancelDemandePret(Integer id);

    // send a loan request
    public void sendDemandePret(Integer id);

    // get information about ea specific loan request
    public DemandeDePret getDemandePret(Integer id);

    // get all loan request
    public List<DemandeDePret> getDemandePrets();

    // update information about a specific loan request
    public void updateDemandePret(Integer id, DemandeDePret demandePret);
}
