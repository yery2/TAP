package ex1;

public class Mountain {
    private String name;
    private int height;
    private String country;
    private String continent;

    public Mountain(String name, int height, String country, String continent) {
        this.name = name;
        this.height = height;
        this.country = country;
        this.continent = continent;
    }

    public String getName() { return name; }
    public int getHeight() { return height; }
    public String getCountry() { return country; }
    public String getContinent() { return continent; }

    @Override
    public String toString() {
        return "Mountain"+ name +" | Height="+ height +" | Country="+ country +" | Continent=" + continent;
    }
}