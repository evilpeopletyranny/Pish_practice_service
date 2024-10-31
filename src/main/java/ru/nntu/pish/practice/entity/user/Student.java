package ru.nntu.pish.practice.entity.user;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import ru.nntu.pish.practice.entity.university.Department;
import ru.nntu.pish.practice.entity.university.StudyDirection;

import java.util.UUID;

@Comment("Student-specific data")
@JmixEntity
@Table(name = "student", indexes = {
        @Index(name = "IDX_STUDENT_USER_DETAIL", columnList = "user_detail_id"),
        @Index(name = "IDX_STUDENT_DEPARTMENT", columnList = "department_id"),
        @Index(name = "IDX_STUDENT_STUDY_DIRECTION", columnList = "study_direction_id")
})
@Entity
public class Student {
    @Comment("Student-specific data identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @Comment("Foreign key reffering to the UserDetail")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "user_detail_id", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private UserDetail userDetail;

    @Comment("Foreign key reffering to the Department")
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "department_id", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Department department;

    @Comment("Foreign key reffering to the StudyDirection")
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "study_direction_id", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StudyDirection studyDirection;

    @DecimalMax(message = "Grade can't be more than 5.", value = "5.00")
    @DecimalMin(message = "Grade can't be less than 2.", value = "2.00")
    @Comment("Average student grade")
    @NumberFormat(pattern = "0,##", decimalSeparator = ",", groupingSeparator = " ")
    @Column(name = "avg_grade", nullable = false, columnDefinition = "NUMERIC(3,2)")
    @NotNull
    private Float avgGrade;

    public StudyDirection getStudyDirection() {
        return studyDirection;
    }

    public void setStudyDirection(StudyDirection studyDirection) {
        this.studyDirection = studyDirection;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Float avgGrade) {
        this.avgGrade = avgGrade;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}