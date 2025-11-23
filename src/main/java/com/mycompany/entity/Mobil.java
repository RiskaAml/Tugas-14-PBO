package com.mycompany.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mobil")
@NamedQueries({
    @NamedQuery(name = "Mobil.findAll", query = "SELECT m FROM Mobil m"),
    @NamedQuery(name = "Mobil.findById", query = "SELECT m FROM Mobil m WHERE m.id = :id"),
    @NamedQuery(name = "Mobil.findByMerk", query = "SELECT m FROM Mobil m WHERE m.merk = :merk"),
    @NamedQuery(name = "Mobil.findByModel", query = "SELECT m FROM Mobil m WHERE m.model = :model"),
    @NamedQuery(name = "Mobil.findByTahun", query = "SELECT m FROM Mobil m WHERE m.tahun = :tahun"),
    @NamedQuery(name = "Mobil.findByHarga", query = "SELECT m FROM Mobil m WHERE m.harga = :harga")
})
public class Mobil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "merk")
    private String merk;

    @Column(name = "model")
    private String model;

    @Column(name = "tahun")
    private Integer tahun;

    @Column(name = "harga")
    private BigInteger harga;

    // ===== RELASI ONE TO MANY (BENAR) =====
    @OneToMany(mappedBy = "mobilId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Penjualan> penjualanList;

    public Mobil() {}

    public Mobil(Integer id) {
        this.id = id;
    }

    // ===== GETTER & SETTER =====

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getTahun() { return tahun; }
    public void setTahun(Integer tahun) { this.tahun = tahun; }

    public BigInteger getHarga() { return harga; }
    public void setHarga(BigInteger harga) { this.harga = harga; }

    public List<Penjualan> getPenjualanList() { return penjualanList; }
    public void setPenjualanList(List<Penjualan> penjualanList) { this.penjualanList = penjualanList; }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mobil)) {
            return false;
        }
        Mobil other = (Mobil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + merk + " " + model;
    }
}
