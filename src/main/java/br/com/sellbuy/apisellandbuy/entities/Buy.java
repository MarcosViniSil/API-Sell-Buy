package br.com.sellbuy.apisellandbuy.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_Buy")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="tb_purchaseCode",length = 100,nullable = false)
    private String purchaseCode;
    @Column(name="tb_priceBuy",nullable = false)
    private Double priceBuy;
    @Column(name="tb_dateBuy",nullable = false)
    private Date dateBuy;
    @Column(name="tb_currency",length = 100,nullable = false)
    private String currency;
    @ManyToOne
    private Historic historic;

    public Buy(){}

    public Integer getId() {
        return id;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public Double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
}
