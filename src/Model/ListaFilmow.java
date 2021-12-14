package Model;

import java.net.SocketOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListaFilmow {

    private List<Film> listaFilmow;
    private int liczbaWypozyczonychFilmow;
    private int liczbaZarezerwowanychFilmow;

    public int getLiczbaWypozyczonychFilmow() {
        return liczbaWypozyczonychFilmow;
    }

    public void setLiczbaWypozyczonychFilmow(int liczbaWypozyczonychFilmow) {
        this.liczbaWypozyczonychFilmow = liczbaWypozyczonychFilmow;
    }

    public int getLiczbaZarezerwowanychFilmow() {
        return liczbaZarezerwowanychFilmow;
    }

    public void setLiczbaZarezerwowanychFilmow(int liczbaZarezerwowanychFilmow) {
        this.liczbaZarezerwowanychFilmow = liczbaZarezerwowanychFilmow;
    }

    public List<Film> getListaFilmow() {
        return listaFilmow;
    }

    public void setListaFilmow(List<Film> listaFilmow) {
        this.listaFilmow = listaFilmow;
    }

    public ListaFilmow() {
        this.listaFilmow = new ArrayList<>();
        this.liczbaWypozyczonychFilmow = 0;
        this.liczbaZarezerwowanychFilmow = 0;
    }

    public ListaFilmow( List<Film> listaFilmow) {
        this.listaFilmow = listaFilmow;
        this.liczbaWypozyczonychFilmow = 0;
        this.liczbaZarezerwowanychFilmow = 0;
    }

    public void wyswietlListeFilmow(){
        for(var film : listaFilmow){
            System.out.println(film.getNazwaFilmu());
        }
    }

    public void dodajFilm(int numerFilmu ,String nazwaFilmu, int rokWydania, int czasTrwania, double cena, String stan, String jezyk){
        listaFilmow.add(new Film(numerFilmu, nazwaFilmu,rokWydania,czasTrwania,cena,stan,jezyk));
    }

    public void usunFilm(int numerFilmu){
        listaFilmow.removeIf(film->film.getNumerFilmu() == 1);
    }

    public Film przekazFilmDoWyp(int id){
        int index = 0;
        for(var film : listaFilmow){
            if (film.getNumerFilmu() == id) {
                liczbaWypozyczonychFilmow++;
                break;
            }
            index++;
        }
        try{
            return listaFilmow.remove(index);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void wrocFilmZWyp(Film film){
        listaFilmow.add(film);
        liczbaWypozyczonychFilmow--;
    }

    public Film przekazFilmDoRez(int id){
        int index = 0;
        for(var film : listaFilmow){
            if (film.getNumerFilmu() == id) {
                liczbaZarezerwowanychFilmow++;
                break;
            }
            index++;
        }
        try{
            return listaFilmow.remove(index);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void wrocFilmZRez(Film film){
        listaFilmow.add(film);
        liczbaZarezerwowanychFilmow--;
    }
}
