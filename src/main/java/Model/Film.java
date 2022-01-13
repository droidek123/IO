package Model;

public class Film {
    private int numerFilmu;
    private String nazwaFilmu;
    private int rokWydania;
    private int czasTrwania;
    private double cena;
    private String stan;
    private String jezyk;

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getNumerFilmu() {
        return numerFilmu;
    }

    public String getNazwaFilmu() {
        return nazwaFilmu;
    }

    public void setNazwaFilmu(String nazwaFilmu) {
        this.nazwaFilmu = nazwaFilmu;
    }

    public int getDataWydania() {
        return rokWydania;
    }

    public void setDataWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public double getCena() {
        return cena;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getJezyk() {
        return jezyk;
    }

    public void setJezyk(String jezyk) {
        this.jezyk = jezyk;
    }

    public Film(int numerFilmu,String nazwaFilmu, int rokWydania, int czasTrwania, double cena, String stan, String jezyk) {
        this.numerFilmu =numerFilmu;
        this.nazwaFilmu = nazwaFilmu;
        this.rokWydania = rokWydania;
        this.czasTrwania = czasTrwania;
        this.cena = cena;
        this.stan = stan;
        this.jezyk = jezyk;
    }

    @Override
    public String toString() {
        return "Film{" +
                "numerFilmu=" + numerFilmu +
                ", nazwaFilmu='" + nazwaFilmu + '\'' +
                ", rokWydania=" + rokWydania +
                ", czasTrwania=" + czasTrwania +
                ", cena=" + cena +
                ", stan='" + stan + '\'' +
                ", jezyk='" + jezyk + '\'' +
                '}';
    }
}
