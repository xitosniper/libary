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
public class Type_of_placeInfo {
    //Declare variable
    private int type_of_place_id;
    private int type_id;
    private int place_id;
    /**
     * Constructor
     * @param type_of_place_id
     * @param type_id
     * @param place_id 
     */
    public Type_of_placeInfo(int type_of_place_id, int type_id, int place_id) {
        this.type_of_place_id = type_of_place_id;
        this.type_id = type_id;
        this.place_id = place_id;
    }
    /**
     * Get type_of_place_id
     * @return 
     */
    public int getType_of_place_id() {
        return type_of_place_id;
    }
    /**
     * Set type_of_place_id
     * @param type_of_place_id 
     */
    public void setType_of_place_id(int type_of_place_id) {
        this.type_of_place_id = type_of_place_id;
    }
    /**
     * Get type_id
     * @return 
     */
    public int getType_id() {
        return type_id;
    }
    /**
     * Set type_id
     * @param type_id 
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
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
}
