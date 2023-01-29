package correspondence.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import department.model.DepartmentType;
import department.model.SubDepartment;
import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table
public class Correspondence {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long QRCode;

    public Long getQRCode() {
        return QRCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Correspondences getCorrespondence() {
        return correspondence;
    }

    public CorType getCorType() {
        return corType;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public SubDepartment getSubDepartment() {
        return subDepartment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Integer getDateReceived() {
        return dateReceived;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Id

    @SequenceGenerator(
            name = "cor_sequence",
            sequenceName = "cor_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cor_sequence"
    )

    private String companyName;
    private Correspondences correspondence;
    private CorType corType;
    private DepartmentType department;

    public void setQRCode(Long QRCode) {
        this.QRCode = QRCode;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCorrespondence(Correspondences correspondence) {
        this.correspondence = correspondence;
    }

    public void setCorType(CorType corType) {
        this.corType = corType;
    }

    public void setDepartment(DepartmentType department) {
        this.department = department;
    }

    public void setSubDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateReceived(Integer dateReceived) {
        this.dateReceived = dateReceived;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    private SubDepartment subDepartment;



    @Override
    public String toString() {

        return "Correspondence{" +
                "id=" + QRCode +
                ", NameOfSender='" + companyName + '\'' +
                ", CorType='" + corType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", correspondence =" + correspondence +
                ", department= " + department +
                ", sub_department=" + subDepartment +
                '}';
    }

    public Correspondence(){}

    private String phoneNumber;
    private String email;
    @Transient
    private Integer dateReceived;


    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate expirationDate;

    public Long getId() {
        return QRCode;
    }

    public void setId(Long id) {
        this.QRCode = id;
    }

    public Correspondence(Long id, String companyName,
                    String subDepartment, String phoneNumber,
                    String email,
                    LocalDate dob) {
        this.QRCode = id;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.expirationDate = dob;
    }

    public Correspondence(String firstName, String subDepartment,
                    String phoneNumber, String email,
                    LocalDate dob) {
        this.companyName = firstName;
        this.subDepartment = SubDepartment.valueOf(subDepartment);
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.expirationDate = dob;
    }


    public Correspondence create(Correspondence correspondence) {
        return correspondence.create(correspondence);
    }

    public Optional<Object> update(Correspondence correspondence) {
        return correspondence.update(correspondence);
    }
}
