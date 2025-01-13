package com.enviro.assessment.grad001.MichaelThulare.Models;

import jakarta.persistence.*;

@Entity
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String guideline;

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

}


