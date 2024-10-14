package ru.nntu.pish.practice.entity.university;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Comment("Company information")
@JmixEntity
@Table(name = "company")
@Entity
public class Company {
    @Comment("Company identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "Company name can't be empty.")
    @NotEmpty(message = "Company name can't be empty.")
    @InstanceName
    @Comment("Company name")
    @Column(name = "name", nullable = false)
    @Lob
    @NotNull
    private String name;

    @NotBlank(message = "Company legal name can't be empty.")
    @NotEmpty(message = "Company legal name can't be empty.")
    @Comment("Company full legal name")
    @Column(name = "legal_name", nullable = false)
    @Lob
    @NotNull
    private String legalName;

    @Comment("Company description")
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    @Lob
    @NotNull
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}