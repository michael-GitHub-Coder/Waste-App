package com.enviro.assessment.grad001.MichaelThulare.Services;

import com.enviro.assessment.grad001.MichaelThulare.Models.*;
import com.enviro.assessment.grad001.MichaelThulare.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.MichaelThulare.Repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.MichaelThulare.Repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Marks this class as a service component, indicating it's a service layer responsible for business logic.
public class WasteCategoryService {

    @Autowired // Injects the WasteCategoryRepository dependency into the service.
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired // Injects the DisposalGuidelineRepository dependency into the service.
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired // Injects the RecyclingTipRepository dependency into the service.
    private RecyclingTipRepository recyclingTipRepository;


    // Method to add a new WasteCategory
    public WasteCategory addWasteCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category); // Saves the category to the repository.
    }

    // Method to add a new DisposalGuideline to a specific WasteCategory
    public DisposalGuideline addDisposalGuideline(Long categoryId, DisposalGuideline guideline) {
        // Fetches the WasteCategory by its ID, throws exception if not found
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        guideline.setWasteCategory(category); // Sets the category for the guideline.
        return disposalGuidelineRepository.save(guideline); // Saves the guideline to the repository.
    }

    public DisposalGuideline updateDisposalGuideline(Long disposalId, DisposalGuideline updatedGuideline) {
        // Fetch the existing guideline
        DisposalGuideline existingGuideline = disposalGuidelineRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Guideline not found"));

        // Update the fields of the existing guideline with the new values
        if (updatedGuideline.getGuideline() != null) {
            existingGuideline.setGuideline(updatedGuideline.getGuideline());
        }

        // Save and return the updated entity
        return disposalGuidelineRepository.save(existingGuideline);
    }

    // Method to add a new RecyclingTip to a specific WasteCategory
    public RecyclingTip addRecyclingTip(Long categoryId, RecyclingTip tip) {
        // Fetches the WasteCategory by its ID, throws exception if not found
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        tip.setWasteCategory(category); // Sets the category for the recycling tip.
        return recyclingTipRepository.save(tip); // Saves the recycling tip to the repository.
    }

    public void deleteRecyclingTip(Long recyclingId) {
        // Find the existing tip by ID or throw an exception if not found
        RecyclingTip existingRecyclingTip = recyclingTipRepository.findById(recyclingId)
                .orElseThrow(() -> new RuntimeException("Tip not found"));

        // Delete the existing tip
        recyclingTipRepository.delete(existingRecyclingTip);
    }

    public void deleteWasteCategory(Long categoryId) {
        // Find the WasteCategory by ID or throw an exception if not found
        WasteCategory existingWasteCategory = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));

        // Delete the WasteCategory; related RecyclingTips will be deleted automatically
        wasteCategoryRepository.delete(existingWasteCategory);
    }

    public void deleteGuideline(Long guidelineId){
        DisposalGuideline existingDisposalguideline = disposalGuidelineRepository.findById(guidelineId)
                .orElseThrow(() -> new RuntimeException("Dispoasl Guideline not found"));

        disposalGuidelineRepository.delete(existingDisposalguideline);
    }

    public RecyclingTip updateRecyclingTip(Long recylcingId, RecyclingTip updateTip){

        RecyclingTip existingRecyclingTip = recyclingTipRepository.findById(recylcingId)
                .orElseThrow(() -> new RuntimeException(("Tip not found")));

        if(updateTip.getTip() != null){
            existingRecyclingTip.setTip(updateTip.getTip());
        }

        return recyclingTipRepository.save(existingRecyclingTip);
    }
    // Method to get all WasteCategories with their associated guidelines and tips
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll(); // Retrieves all WasteCategories from the repository.
    }
}
