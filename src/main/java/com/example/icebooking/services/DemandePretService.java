package com.example.icebooking.services;

import com.example.icebooking.models.DemandeDePret;

import java.util.List;

public interface DemandePretService {
    public void createDemandePret(DemandeDePret demandePret);
    public  void deleteDemandePret(Integer id);
    public DemandeDePret getDemandePret(Integer id);
    public List<DemandeDePret> getDemandePrets();

    public  void updateDemandePret(Integer id,DemandeDePret demandePret);
}
