package br.com.sellbuy.apisellandbuy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "tb_Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="tb_saleCode",nullable = false)
    private String saleCode;
    @Column(name="tb_dateSale",nullable = false)
    private Date dateSale;
    @Column(name="tb_currency",length = 100,nullable = false)
    private String currency;
    @Column(name="tb_priceSale",nullable = false)
    private String priceSale;
    @ManyToOne
    @JsonBackReference
    private Historic historic;

    public Sale(){}

    public Sale(String saleCode, Date dateSale, String currency, String priceSale) {
        this.saleCode = saleCode;
        this.dateSale = dateSale;
        this.currency = currency;
        this.priceSale = priceSale;
    }

    public Integer getId() {
        return id;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return priceSale;
    }

    public void setPrice(String price) {
        this.priceSale = price;
    }

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
}
