package br.com.sellbuy.apisellandbuy.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tb_Historic")
public class Historic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="tb_historicCode",nullable = false)
    private String historicCode;
    @Column(name="tb_dateAccess",nullable = false)
    private Date dateAccess;
    @OneToMany(mappedBy = "historic")
    private List<Sale> sales;
    @OneToMany(mappedBy = "historic")
    private List<Buy> buy;
    @OneToOne(mappedBy = "historic")
    private User user;

    public Historic(){}

    public Integer getId() {
        return id;
    }

    public String getHistoricCode() {
        return historicCode;
    }

    public Date getDateAccess() {
        return dateAccess;
    }

    public void setDateAccess(Date dateAccess) {
        this.dateAccess = dateAccess;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Buy> getBuy() {
        return buy;
    }

    public void setBuy(List<Buy> buy) {
        this.buy = buy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
