package br.com.sellbuy.apisellandbuy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String priceBuy;
    @Column(name="tb_dateBuy",nullable = false)
    private Date dateBuy;
    @Column(name="tb_currency",length = 100,nullable = false)
    private String currency;
    @ManyToOne
    @JsonBackReference
    private Historic historic;

    public Buy(){}

    public Buy(String purchaseCode,Date dateBuy, String priceBuy,  String currency) {
        this.purchaseCode = purchaseCode;
        this.priceBuy = priceBuy;
        this.dateBuy = dateBuy;
        this.currency = currency;

    }

    public Integer getId() {
        return id;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public String getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(String priceBuy) {
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
