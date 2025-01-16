package com.enviro.assessment.grad001.MichaelThulare.Repository;

import com.enviro.assessment.grad001.MichaelThulare.Models.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByWasteCategoryId(Long categoryId);
}
