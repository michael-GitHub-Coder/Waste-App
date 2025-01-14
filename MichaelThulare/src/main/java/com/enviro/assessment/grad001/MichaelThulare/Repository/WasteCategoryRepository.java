package com.enviro.assessment.grad001.MichaelThulare.Repository;

import com.enviro.assessment.grad001.MichaelThulare.Models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // Marks this interface as a Spring Data repository that will be automatically implemented by Spring Data JPA
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

}
