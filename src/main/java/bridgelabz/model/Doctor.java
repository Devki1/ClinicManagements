package bridgelabz.model;

public class Doctor {
    private String name;
    private int id;
    private String specialization;
    private String avl;

    Doctor() {
    }

    public Doctor(String name, Integer id, String spl, String avl) {
        this.setName(name);
        this.setId(id);
        this.setSpecialization(spl);
        this.setAvl(avl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvl() {
        return avl;
    }

    public void setAvl(String avl) {
        this.avl = avl;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", specialization='" + specialization + '\'' +
                ", avl='" + avl + '\'' + '}';
    }
}

