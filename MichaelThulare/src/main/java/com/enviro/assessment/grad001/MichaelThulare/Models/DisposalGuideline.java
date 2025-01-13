package com.enviro.assessment.grad001.MichaelThulare.Models;

import jakarta.persistence.*;


@Entity
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String guideline;
//, nullable = false
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory wasteCategory;

    // Getter and Setter for wasteCategory
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
}


