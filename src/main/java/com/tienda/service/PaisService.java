
package com.tienda.service;

import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaisService implements IPaisService {
    
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> listContry() {
        return (List<Pais>) paisRepository.findAll();
    }
}
