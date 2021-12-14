package Model;

import java.time.LocalDateTime;

public class Wypozyczenie {
    private Film wypozyczonyFilm;
    private LocalDateTime dataWypozyczenia;
    private LocalDateTime dataUplynieciaWypozyczenia;

    public Wypozyczenie(Film wypozyczonyFilm) {
        this.wypozyczonyFilm = wypozyczonyFilm;
        dataWypozyczenia = LocalDateTime.now();
        dataUplynieciaWypozyczenia = dataWypozyczenia.plusDays(14);
    }

    public Film getWypozyczonyFilm() {
        return wypozyczonyFilm;
    }

    public void setWypozyczonyFilm(Film wypozyczonyFilm) {
        this.wypozyczonyFilm = wypozyczonyFilm;
    }

    public LocalDateTime getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(LocalDateTime dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public LocalDateTime getDataUplynieciaWypozyczenia() {
        return dataUplynieciaWypozyczenia;
    }

    public void setDataUplynieciaWypozyczenia(LocalDateTime dataUplynieciaWypozyczenia) {
        this.dataUplynieciaWypozyczenia = dataUplynieciaWypozyczenia;
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" +
                "wypozyczonyFilm=" + wypozyczonyFilm.toString() +
                ", dataWypozyczenia=" + dataWypozyczenia +
                ", dataUplynieciaWypozyczenia=" + dataUplynieciaWypozyczenia +
                '}';
    }
}
