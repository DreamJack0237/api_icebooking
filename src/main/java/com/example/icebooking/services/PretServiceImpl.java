package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Pret;

public class PretServiceImpl implements PretService{

    private final PretRepository pretRepository;
        @Override
    public Pret createProduct(Pret pret) {
        return productrepository.save(pret);
    }

    @Override
    public pret updateProduct(Pret pret,long id) {
        // TODO Auto-generated method stub
        return  productrepository.findById(id).map(p->
        {
           return  productrepository.save(p);
        }).orElseThrow();
    }

    @Override
    public List<pret> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }


    @Override
    public pret getProduct(long id) {
        // TODO Auto-generated method stub
        return productrepository.findById(id).orElseThrow();
    }

    @Override
    public String deleteProduct(long id) {
        // TODO Auto-generated method stub
        productrepository.deleteById(id);
        return "ok";
    }
}
