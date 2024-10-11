package ru.nntu.pish.practice.entity.university;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "INSTITUTE", indexes = {
        @Index(name = "IDX_INSTITUTE_UNIVERSITY", columnList = "university_id")
})
@Entity
public class Institute {
    @Comment("Institute identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "Institute name can't be empty.")
    @NotEmpty(message = "Institute name can't be empty.")
    @InstanceName
    @Comment("Institute full name")
    @Column(name = "name", nullable = false)
    @Lob
    @NotNull
    private String name;

    @NotBlank(message = "Institute abbreviation can't be empty.")
    @NotEmpty(message = "Institute abbreviation can't be empty.")
    @Comment("Institute name abbreviation")
    @Column(name = "abbreviation", nullable = false)
    @NotNull
    private String abbreviation;

    @Comment("Foreign key reffering to the Universaty")
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "university_id", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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