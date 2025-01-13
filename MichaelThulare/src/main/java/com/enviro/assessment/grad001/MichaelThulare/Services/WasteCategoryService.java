package com.enviro.assessment.grad001.MichaelThulare.Services;

import com.enviro.assessment.grad001.MichaelThulare.Models.DisposalGuideline;
import com.enviro.assessment.grad001.MichaelThulare.Models.RecyclingTip;
import com.enviro.assessment.grad001.MichaelThulare.Models.WasteCategory;
import com.enviro.assessment.grad001.MichaelThulare.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.MichaelThulare.Repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.MichaelThulare.Repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    // Add a new WasteCategory
    public WasteCategory addWasteCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }

    // Add a new DisposalGuideline to a category
    public DisposalGuideline addDisposalGuideline(Long categoryId, DisposalGuideline guideline) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        guideline.setWasteCategory(category);
        return disposalGuidelineRepository.save(guideline);
    }

    // Add a new RecyclingTip to a category
    public RecyclingTip addRecyclingTip(Long categoryId, RecyclingTip tip) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        tip.setWasteCategory(category);
        return recyclingTipRepository.save(tip);
    }

    // Get all categories with related guidelines and tips
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }
}
