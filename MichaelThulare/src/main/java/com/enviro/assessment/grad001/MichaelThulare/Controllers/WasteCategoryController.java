package com.enviro.assessment.grad001.MichaelThulare.Controllers;

import com.enviro.assessment.grad001.MichaelThulare.Models.DisposalGuideline;
import com.enviro.assessment.grad001.MichaelThulare.Models.RecyclingTip;
import com.enviro.assessment.grad001.MichaelThulare.Models.WasteCategory;
import com.enviro.assessment.grad001.MichaelThulare.Services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    // Get all categories
    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    // Add a new WasteCategory
    @PostMapping
    public ResponseEntity<WasteCategory> addWasteCategory(@RequestBody WasteCategory category) {
        WasteCategory createdCategory = wasteCategoryService.addWasteCategory(category);
        return ResponseEntity.ok(createdCategory); // Return created category in response
    }

    // Add Disposal Guideline to a specific category
    @PostMapping("/{categoryId}/guidelines")
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@PathVariable Long categoryId, @RequestBody DisposalGuideline guideline) {
        try {
            DisposalGuideline addedGuideline = wasteCategoryService.addDisposalGuideline(categoryId, guideline);
            return ResponseEntity.ok(addedGuideline);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null); // If category not found, return 404 status
        }
    }

    // Add Recycling Tip to a specific category
    @PostMapping("/{categoryId}/tips")
    public ResponseEntity<RecyclingTip> addRecyclingTip(@PathVariable Long categoryId, @RequestBody RecyclingTip tip) {
        try {
            RecyclingTip addedTip = wasteCategoryService.addRecyclingTip(categoryId, tip);
            return ResponseEntity.ok(addedTip);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null); // If category not found, return 404 status
        }
    }
}
