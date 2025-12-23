package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
    name = "vendor",
    uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String contactEmail;
    private String contactPhone;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    /* ================= CONSTRUCTORS ================= */

    // Default constructor (required by JPA)
    public Vendor() {
        this.active = true;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    // Parameterized constructor
    public Vendor(String name, String contactEmail, String contactPhone) {
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.active = true;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    /* ================= GETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public Boolean getActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    /* ================= SETTERS ================= */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
