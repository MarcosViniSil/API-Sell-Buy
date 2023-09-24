package br.com.sellbuy.apisellandbuy.entities;

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
    private Double priceSale;
    @ManyToOne
    private Historic historic;

    public Sale(){}

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

    public Double getPrice() {
        return priceSale;
    }

    public void setPrice(Double price) {
        this.priceSale = price;
    }

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
}
