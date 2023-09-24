package br.com.sellbuy.apisellandbuy.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="tb_name",length = 100,nullable = false)
    private String name;
    @Column(name="tb_country",length = 100,nullable = false)
    private String country;
    @OneToOne
    @JoinColumn(name="historic_id")
    private Historic historic;

    public User(){}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
}
