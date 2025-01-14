package com.enviro.assessment.grad001.MichaelThulare.DTO;

import java.util.List;

public class WasteCategoryDTO {

    private Long id;
    private String name;
    private String description;
    private List<DisposalGuidelineDTO> disposalGuidelines;
    private List<RecyclingTipDTO> recyclingTips;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DisposalGuidelineDTO> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(List<DisposalGuidelineDTO> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }

    public List<RecyclingTipDTO> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTipDTO> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}
