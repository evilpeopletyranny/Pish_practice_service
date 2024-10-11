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

@Comment("Dictionary table for all universities in system.")
@JmixEntity
@Table(name = "university")
@Entity
public class University {
    @Comment("University identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "University name can't be empty.")
    @NotEmpty(message = "University name can't be empty.")
    @InstanceName
    @Comment("University full name")
    @Column(name = "name", nullable = false)
    @Lob
    @NotNull
    private String name;

    @NotBlank(message = "Universaty name abbreviation can't be empty.")
    @NotEmpty(message = "Universaty name abbreviation can't be empty.")
    @NotNull
    @Column(name = "abbreviation", nullable = false)
    @Comment("Abbreviation of university name")
    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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