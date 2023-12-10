package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_korisnika")
    private Long idKorisnika;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "email")
    private String email;

    @Column(name = "lozinka")
    private String lozinka;

    @OneToMany(mappedBy = "autor")
    private Set<Anketa> ankete;

    @OneToMany(mappedBy = "korisnik")
    private Set<Odgovor> odgovori;

    public Korisnik() {

    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Set<Anketa> getAnkete() {
        return ankete;
    }

    public void setAnkete(Set<Anketa> ankete) {
        this.ankete = ankete;
    }

    public Set<Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(Set<Odgovor> odgovori) {
        this.odgovori = odgovori;
    }
}
