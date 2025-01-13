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

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    @PostMapping
    public WasteCategory addWasteCategory(@RequestBody WasteCategory category) {
        return wasteCategoryService.addWasteCategory(category);
    }

    @PostMapping("/{categoryId}/guidelines")
    public DisposalGuideline addDisposalGuideline(@PathVariable Long categoryId,
                                                  @RequestBody DisposalGuideline guideline) {
        return wasteCategoryService.addDisposalGuideline(categoryId, guideline);
    }

    @PostMapping("/{categoryId}/tips")
    public RecyclingTip addRecyclingTip(@PathVariable Long categoryId, @RequestBody RecyclingTip tip) {
        return wasteCategoryService.addRecyclingTip(categoryId, tip);
    }
}
