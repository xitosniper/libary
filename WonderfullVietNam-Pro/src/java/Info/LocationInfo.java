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
    int Location_id;
    String Location_name;
    String Location_description;
    int Status;

    /**
     * Create Constructor with full parameter
     *
     * @param Location_id
     * @param Location_name
     * @param Location_description
     * @param Status
     */
    public LocationInfo(int Location_id, String Location_name, String Location_description, int Status) {
        this.Location_id = Location_id;
        this.Location_name = Location_name;
        this.Location_description = Location_description;
        this.Status = Status;
    }

    /**
     * Create getLocation_id
     *
     * @return Location_id
     */
    public int getLocation_id() {
        return Location_id;
    }

    /**
     * Create setLocation_id
     *
     * @param Location_id
     */
    public void setLocation_id(int Location_id) {
        this.Location_id = Location_id;
    }

    /**
     * Create getLocation_name
     *
     * @return Location_name
     */
    public String getLocation_name() {
        return Location_name;
    }

    /**
     * Create setLocation_name
     *
     * @param Location_name
     */
    public void setLocation_name(String Location_name) {
        this.Location_name = Location_name;
    }

    /**
     * Create getLocation_description
     *
     * @return Location_description
     */
    public String getLocation_description() {
        return Location_description;
    }

    /**
     * Create setLocation_description
     *
     * @param Location_description
     */
    public void setLocation_description(String Location_description) {
        this.Location_description = Location_description;
    }

    /**
     * Create getStatus
     *
     * @return Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * Create setStatus
     *
     * @param Status
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * Create toString return all parameter
     */
    @Override
    public String toString() {
        return Location_id + " " + Location_name + " " + Location_description + " " + Status;
    }

}
