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

@Comment("Study direction abbreviation")
@JmixEntity
@Table(name = "study_direction")
@Entity
public class StudyDirection {
    @Comment("Study direction identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "Study direction name can't be empty.")
    @NotEmpty(message = "Study direction name can't be empty.")
    @Comment("Sutdy direction full name")
    @InstanceName
    @Column(name = "name", nullable = false)
    @Lob
    @NotNull
    private String name;

    @Comment("Study direction abbreviation")
    @NotBlank(message = "Institute abbreviation can't be empty.")
    @NotEmpty(message = "Institute abbreviation can't be empty.")
    @Column(name = "abbreviation", nullable = false)
    @NotNull
    private String abbreviation;

    @NotBlank(message = "Study direction can't be empty.")
    @NotEmpty(message = "Study direction can't be empty.")
    @Comment("Study direction code")
    @Column(name = "code", nullable = false)
    @NotNull
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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