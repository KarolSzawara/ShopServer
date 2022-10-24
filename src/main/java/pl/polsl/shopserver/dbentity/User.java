package pl.polsl.shopserver.dbentity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "phon_number", length = 45)
    private String phonNumber;

    @Column(name = "company_or_person", length = 1)
    private String companyOrPerson;

    @Column(name = "company_name", length = 45)
    private String companyName;

    @Column(name = "nip", length = 45)
    private String nip;

    @Column(name = "street", length = 45)
    private String street;

    @Column(name = "street_number", length = 45)
    private String streetNumber;

    @Column(name = "post_code", length = 45)
    private String postCode;

    @Column(name = "post_town", length = 45)
    private String postTown;

    @Column(name = "flat_number", length = 45)
    private String flatNumber;

    @Column(name = "phone_number", length = 45)
    private String phoneNumber;


    @OneToMany(mappedBy = "idUser")
    private Set<Order> orders = new LinkedHashSet<>();

    @Column(name = "refresh_token", length = 45)
    private String refreshToken;

    @Column(name = "enable", length = 1)
    private String enable;

    @Column(name = "verfication_token", length = 45)
    private String verficationToken;

}