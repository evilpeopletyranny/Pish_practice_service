package ru.nntu.pish.practice.entity.user;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ru.nntu.pish.practice.entity.university.Department;

import java.util.UUID;

@Comment("University representative specifit data")
@JmixEntity
@Table(name = "university_representative", indexes = {
        @Index(name = "IDX_UNIVERSITY_REPRESENTATIVE_DEPARTMENT", columnList = "department_id"),
        @Index(name = "IDX_UNIVERSITY_REPRESENTATIVE_USER_DETAILL", columnList = "user_detailL_id")
})
@Entity
public class UniversityRepresentative {
    @Comment("University representative specific data identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @Comment("Foreign key reffering to the UserDetail")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "user_detailL_id", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private UserDetail userDetail;

    @Comment("Foreign key reffering to the Department")
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "department_id", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Department department;

    @NotBlank(message = "Position can't be empty.")
    @NotEmpty(message = "Position can't be empty.")
    @Comment("University representative position")
    @Column(name = "position", nullable = false)
    @Lob
    @NotNull
    private String position;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}