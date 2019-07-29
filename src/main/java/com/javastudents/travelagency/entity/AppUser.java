package com.javastudents.travelagency.entity;

import javax.persistence.*;
import javax.persistence.Entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor @Builder
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "travel_agent_id")
    private TravelAgent travelAgent;

    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;

    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @ElementCollection(targetClass = AppRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.ORDINAL)
    private List<AppRole> authorities;

    public AppUser(String name, String surname, String email, String login,
                   String password, TravelAgent travelAgent, boolean accountNonExpired,
                   boolean accountNonLocked, boolean credentialsNonExpired,
                   boolean enabled, List<AppRole> authorities) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.travelAgent = travelAgent;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
