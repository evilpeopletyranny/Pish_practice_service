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

@Comment("Department is subdivision of the institute")
@JmixEntity
@Table(name = "department", indexes = {
        @Index(name = "IDX_DEPARTMENT_INSTITUTE", columnList = "institute_id")
})
@Entity
public class Department {
    @Comment("Department identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "Department name can't be empty.")
    @NotEmpty(message = "Department name can't be empty.")
    @InstanceName
    @Comment("Department full name")
    @Column(name = "name", nullable = false)
    @Lob
    @NotNull
    private String name;

    @NotBlank(message = "Department abbreviation can't be empty.")
    @NotEmpty(message = "Department abbreviation can't be empty.")
    @Comment("Department abbreviation")
    @Column(name = "abbreviation", nullable = false)
    @NotNull
    private String abbreviation;

    @Comment("Foreign key reffering to the Institute")
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "institute_id", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Institute institute;

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
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