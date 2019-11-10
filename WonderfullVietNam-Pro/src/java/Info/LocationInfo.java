/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

/**
 *
 * @author Admin
 */
public class LocationInfo {

    //declare variables
    private int location_id;
    private String location_name;
    private String location_description;
    private int status;

    /**
     * Constructor LocationInfor
     *
     * @param location_id
     * @param location_name
     * @param location_description
     * @param status
     */
    public LocationInfo(int location_id, String location_name, String location_description, int status) {
        this.location_id = location_id;
        this.location_name = location_name;
        this.location_description = location_description;
        this.status = status;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_description() {
        return location_description;
    }

    public void setLocation_description(String location_description) {
        this.location_description = location_description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
