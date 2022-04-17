package com.carshoptiger.service.API;

import com.carshoptiger.domain.Testimonals;

import java.util.List;

public interface TestimonalsService {
    boolean savetestimonals(Testimonals testimonals);
    boolean deletetestimonals(Long id);
    List<Testimonals> findAllTestimonals();
}
