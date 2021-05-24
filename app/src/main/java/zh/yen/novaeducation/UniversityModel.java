package zh.yen.novaeducation;

public class UniversityModel {
    String photo;
    String name;
    String location;

    public
    UniversityModel(String photo , String name , String location) {
        this.photo = photo;
        this.name = name;
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
