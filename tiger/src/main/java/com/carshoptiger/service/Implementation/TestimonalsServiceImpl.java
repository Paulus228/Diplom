package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Testimonals;
import com.carshoptiger.repository.API.TestimonalsRepository;
import com.carshoptiger.service.API.TestimonalsService;
import com.carshoptiger.util.validators.TestimonalsValidator;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
public class TestimonalsServiceImpl implements TestimonalsService {

    private final TestimonalsRepository testimonalsRepository;

    @Override
    public boolean savetestimonals(Testimonals testimonals) {
        boolean result_save;
        if(TestimonalsValidator.TestimonalsValidation(testimonals)){
            testimonals.setDate_send(new Date(new java.util.Date().getTime()));
            result_save = testimonalsRepository.savetestimonals(testimonals);
        }else{
            result_save=false;
        }
        return result_save;
    }

    @Override
    public boolean deletetestimonals(Long id) {
        boolean result_delete;
        Testimonals testimonalsIsexists = testimonalsRepository.findAllTestimonals().
                stream().filter((o1)->o1.getId().equals(id)).findAny().orElse(null);
        if(testimonalsIsexists!=null){
            result_delete = testimonalsRepository.deletetestimonals(id);
        }else{
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public List<Testimonals> findAllTestimonals() {
        return testimonalsRepository.findAllTestimonals();
    }
}
