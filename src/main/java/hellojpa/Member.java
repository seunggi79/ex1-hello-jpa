package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;


    @Embedded
    private Period workPeriod;
    @Embedded
    private Adress homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name="street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name="zipcode", column = @Column(name = "WORK_ZIPCODE"))
    })
    private Adress workAddress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
