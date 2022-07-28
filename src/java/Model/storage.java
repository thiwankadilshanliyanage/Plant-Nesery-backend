/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author Thiwanka
 */
public class storage {
    private String Temperature;
    private String Humidity;
    private String Moisture;
    private String Light;
    private String Time;

    public storage(String Temperature, String Humidity, String Moisture, String Light) {
        this.Temperature = Temperature;
        this.Humidity = Humidity;
        this.Moisture = Moisture;
        this.Light = Light;
        this.Time = new Timestamp(System.currentTimeMillis()).toString();
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String Temperature) {
        this.Temperature = Temperature;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String Humidity) {
        this.Humidity = Humidity;
    }

    public String getMoisture() {
        return Moisture;
    }

    public void setMoisture(String Moisture) {
        this.Moisture = Moisture;
    }

    public String getLight() {
        return Light;
    }

    public void setLight(String Light) {
        this.Light = Light;
    }
    
}
