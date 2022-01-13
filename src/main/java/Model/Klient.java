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

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setAdres(String adres) {
        this.adres = adres;
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

    public int countWyp(){
        int counter = 0;
        for(var wyp : listaWypozyczen)
            counter++;
        return counter;
    }

    public int countRez(){
        int counter = 0;
        for(var rez : listaRezerwacje)
            counter++;
        return counter;
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
