package mrs.riverjach.console.mesclasses.interop;

public class User {
    private String name;
    private int age;

    private Adresse adresse;

    public User() {
        // interop Kotlin vers Java
        adresse = new Adresse("Nantes", "France");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
