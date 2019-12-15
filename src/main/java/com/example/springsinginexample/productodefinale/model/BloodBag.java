package com.example.springsinginexample.productodefinale.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bloodbag")
public class BloodBag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "institution")
    private String institution;

    @Column(name = "madedate")
    private String madedate;

    @Column(name = "expdate")
    private String expdate;

    @Column(name = "bagtype")
    private String bagtype;

    @Column(name = "phenotype")
    private String phenotype;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "abo")
    private String abo;

    @Column(name = "rh")
    private String rh;

    @Column(name = "bagid")
    private String bagid;

    @Column(name = "comment")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getMadedate() {
        return madedate;
    }

    public void setMadedate(String madedate) {
        this.madedate = madedate;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getBagtype() {
        return bagtype;
    }

    public void setBagtype(String bagtype) {
        this.bagtype = bagtype;
    }

    public String getPhenotype() {
        return phenotype;
    }

    public void setPhenotype(String phenotype) {
        this.phenotype = phenotype;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAbo() {
        return abo;
    }

    public void setAbo(String abo) {
        this.abo = abo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getBagid() {
        return bagid;
    }

    public void setBagid(String bagid) {
        this.bagid = bagid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BloodBag() {
        super();
    }

}
