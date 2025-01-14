package com.enviro.assessment.grad001.MichaelThulare.Controllers;

import com.enviro.assessment.grad001.MichaelThulare.Models.DisposalGuideline;
import com.enviro.assessment.grad001.MichaelThulare.Models.RecyclingTip;
import com.enviro.assessment.grad001.MichaelThulare.Models.WasteCategory;
import com.enviro.assessment.grad001.MichaelThulare.Services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")  // Base URL for all API requests in this controller
public class WasteCategoryController {

    @Autowired //dependency injection
    private WasteCategoryService wasteCategoryService;  // Injecting the WasteCategoryService to handle business logic

    // Get all categories
    @GetMapping  // This method will be triggered for GET requests to "/api/categories"
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllCategories();  // Returns a list of all WasteCategory objects
    }

    // Add a new WasteCategory
    @PostMapping  // This method will be triggered for POST requests
    public ResponseEntity<WasteCategory> addWasteCategory(@RequestBody WasteCategory category) {
        WasteCategory createdCategory = wasteCategoryService.addWasteCategory(category);  // Adds the category to the system
        return ResponseEntity.ok(createdCategory);  // Returns the created category in the response with an HTTP 200 status
    }

    // Add Disposal Guideline to a specific category
    @PostMapping("/{categoryId}/guidelines")  // This method will be triggered for POST requests
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@PathVariable Long categoryId, @RequestBody DisposalGuideline guideline) {
        try {
            DisposalGuideline addedGuideline = wasteCategoryService.addDisposalGuideline(categoryId, guideline);  // Adds a disposal guideline to the specified category
            return ResponseEntity.ok(addedGuideline);  // Returns the added disposal guideline with an HTTP 200 status
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);  // If category is not found, returns an HTTP 404 status with a null response body
        }
    }

    @PutMapping("/{disposalId}/guidelines")
    public ResponseEntity<DisposalGuideline> updateDisposal(@PathVariable Long disposalId, @RequestBody DisposalGuideline guideline){
        try{
            DisposalGuideline updatedGuideline = wasteCategoryService.updateDisposalGuideline(disposalId,guideline);
            return ResponseEntity.ok(updatedGuideline);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Add Recycling Tip to a specific category
    @PostMapping("/{categoryId}/tips")  // This method will be triggered for POST requests
    public ResponseEntity<RecyclingTip> addRecyclingTip(@PathVariable Long categoryId, @RequestBody RecyclingTip tip) {
        try {
            RecyclingTip addedTip = wasteCategoryService.addRecyclingTip(categoryId, tip);  // Adds a recycling tip to the specified category
            return ResponseEntity.ok(addedTip);  // Returns the added recycling tip with an HTTP 200 status
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);  // If category is not found, returns an HTTP 404 status with a null response body
        }
    }

    @PutMapping("/{tipId}/tips")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long tipId,@RequestBody RecyclingTip tip){
        try{
            RecyclingTip updateTip = wasteCategoryService.updateRecyclingTip(tipId,tip);
            return ResponseEntity.ok(updateTip);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }


    @DeleteMapping("/delete/{tipId}")
    public ResponseEntity<String> deleteById(@PathVariable Long tipId){
        wasteCategoryService.deleteRecyclingTip(tipId);
        return new ResponseEntity<>(" was successfully deleted! ", HttpStatus.OK);
    }

}
