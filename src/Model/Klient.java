package Model;

import java.util.ArrayList;
import java.util.List;

public class Klient {

    private int id;
    private String imie;
    private String nazwisko;
    private int wiek;
    private String adres;
    private int telefon;
    private List<Wypozyczenie> listaWypozyczen;
    private List<Rezerwacja> listaRezerwacje;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public List<Wypozyczenie> getListaWypozyczen() {
        return listaWypozyczen;
    }

    public void setListaWypozyczen(List<Wypozyczenie> listaWypozyczen) {
        this.listaWypozyczen = listaWypozyczen;
    }

    public List<Rezerwacja> getListaRezerwacje() {
        return listaRezerwacje;
    }

    public void setListaRezerwacje(List<Rezerwacja> listaRezerwacje) {
        this.listaRezerwacje = listaRezerwacje;
    }

    public Klient(int id,String imie, String nazwisko, int wiek, String adres, int telefon) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.adres = adres;
        this.telefon = telefon;
        this.listaRezerwacje = new ArrayList<>();
        this.listaWypozyczen = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id='" + id + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", adres='" + adres + '\'' +
                ", telefon=" + telefon +
                ", listaWypozyczen=" + listaWypozyczen.toString() +
                ", listaRezerwacje=" + listaRezerwacje +
                '}';
    }
}
