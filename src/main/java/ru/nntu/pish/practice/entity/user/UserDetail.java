package ru.nntu.pish.practice.entity.user;

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

import java.time.LocalDate;
import java.util.UUID;

@Comment("Additional table with user data")
@JmixEntity
@Table(name = "user_detail", indexes = {
        @Index(name = "IDX_USER_DETAIL_USER", columnList = "user_id")
})
@Entity
public class UserDetail {
    @Comment("User additional data identifier")
    @JmixGeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    private UUID id;

    @Comment("Foreign key reffering to User_")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @NotBlank(message = "User first name can't be empty.")
    @NotEmpty(message = "User first name can't be empty.")
    @InstanceName
    @Comment("User first name")
    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @NotBlank(message = "User last name can't be empty.")
    @NotEmpty(message = "User last name can't be empty.")
    @Comment("User last name")
    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;

    @NotBlank(message = "User patronymic can't be empty.")
    @NotEmpty(message = "User patronymic can't be empty.")
    @Comment("User patronymic")
    @Column(name = "patronymic", nullable = false)
    @NotNull
    private String patronymic;

    @NotNull
    @Comment("User birth date")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}