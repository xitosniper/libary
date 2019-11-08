/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class PlaceInfo {
    //Declare variable
    private int place_id;
    private String place_name;
    private String place_description;
    private int status;
    private int location_id;
    /**
     * Constructor
     * @param place_id
     * @param place_name
     * @param place_description
     * @param status
     * @param location_id 
     */
    public PlaceInfo(int place_id, String place_name, String place_description, int status, int location_id) {
        this.place_id = place_id;
        this.place_name = place_name;
        this.place_description = place_description;
        this.status = status;
        this.location_id = location_id;
    }
    /**
     * Get place_id
     * @return 
     */
    public int getPlace_id() {
        return place_id;
    }
    /**
     * Set place_id
     * @param place_id 
     */
    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }
    /**
     * Get place_name
     * @return 
     */
    public String getPlace_name() {
        return place_name;
    }
    /**
     * Set place_name
     * @param place_name 
     */
    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }
    /**
     * Get place_description
     * @return 
     */
    public String getPlace_description() {
        return place_description;
    }
    /**
     * Set place_description
     * @param place_description 
     */
    public void setPlace_description(String place_description) {
        this.place_description = place_description;
    }
    /**
     * Get status
     * @return 
     */
    public int getStatus() {
        return status;
    }
    /**
     * Set status
     * @param status 
     */
    public void setStatus(int status) {
        this.status = status;
    }
    /**
     * Get location_id
     * @return 
     */
    public int getLocation_id() {
        return location_id;
    }
    /**
     * Set location_id
     * @param location_id 
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    
}
