package com.carshoptiger.repository.API;

import com.carshoptiger.domain.Testimonals;

import java.util.List;

public interface TestimonalsRepository {
    boolean savetestimonals(Testimonals testimonals);
    boolean deletetestimonals(Long id);
    List<Testimonals> findAllTestimonals();
}
