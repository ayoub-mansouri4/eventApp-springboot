package springboot_auth.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="locations")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_location;
    private String location_name;
    private float latitude;
    private  float longitude;

    public Location(String location_name ,float latitude, float longitude) {
        this.location_name=location_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public  Location(){}

    public Long getId_location() {
        return id_location;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public void setId_location(Long id_location) {
        this.id_location = id_location;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
