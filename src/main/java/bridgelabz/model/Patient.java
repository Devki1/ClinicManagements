package bridgelabz.model;

public class Patient {
    private String name;
    private int id;
    private Long mobileNumber;
    private int age;

    Patient() {

    }

    public Patient(String name, int id, Long mobileNumber, int age) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.age = age;

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

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}



