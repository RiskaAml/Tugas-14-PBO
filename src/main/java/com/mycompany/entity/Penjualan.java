package com.mycompany.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "penjualan")
@NamedQueries({
    @NamedQuery(name = "Penjualan.findAll", query = "SELECT p FROM Penjualan p"),
    @NamedQuery(name = "Penjualan.findById", query = "SELECT p FROM Penjualan p WHERE p.id = :id"),
    @NamedQuery(name = "Penjualan.findByTanggal", query = "SELECT p FROM Penjualan p WHERE p.tanggal = :tanggal"),
    @NamedQuery(name = "Penjualan.findByTotalHarga", query = "SELECT p FROM Penjualan p WHERE p.totalHarga = :totalHarga")})
public class Penjualan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @Column(name = "total_harga")
    private BigInteger totalHarga;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    @ManyToOne
    private Mobil mobilId;

    public Penjualan() {
    }

    public Penjualan(Integer id) {
        this.id = id;
    }

    public Penjualan(Integer id, Date tanggal, BigInteger totalHarga) {
        this.id = id;
        this.tanggal = tanggal;
        this.totalHarga = totalHarga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigInteger getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigInteger totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Mobil getMobilId() {
        return mobilId;
    }

    public void setMobilId(Mobil mobilId) {
        this.mobilId = mobilId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penjualan)) {
            return false;
        }
        Penjualan other = (Penjualan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Penjualan[ id=" + id + " ]";
    }
    
}
