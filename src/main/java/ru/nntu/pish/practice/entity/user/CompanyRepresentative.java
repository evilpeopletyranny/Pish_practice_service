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
import ru.nntu.pish.practice.entity.university.Company;

import java.util.UUID;

@Comment("Company representative specific data")
@JmixEntity
@Table(name = "company_representative", indexes = {
        @Index(name = "IDX_COMPANY_REPRESENTATIVE_COMPANY", columnList = "company_id"),
        @Index(name = "IDX_COMPANY_REPRESENTATIVE_USER_DETAIL", columnList = "user_detail_id")
})
@Entity
public class CompanyRepresentative {
    @Comment("Company representative specific identifier")
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

    @Comment("Foreign key reffering to the Company")
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "company_id", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Company company;

    @NotBlank(message = "Position can't be empty.")
    @NotEmpty(message = "Position can't be empty.")
    @Comment("Company representative position")
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}