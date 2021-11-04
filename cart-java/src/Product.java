public class Product {

    private String ime;
    private String kategorija;
    private float cena;


    public Product(String ime, String kategorija, float cena) {
        this.ime = ime;
        this.kategorija = kategorija;
        this.cena = cena;
    }

    public Product() {
        this.ime = ime;
        this.kategorija = kategorija;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Product (" + "ime: " + ime + ", kategorija: " + kategorija + ", cena: " + cena + ')';
    }
}
