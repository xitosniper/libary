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
public class TypeInfo {
    //Declare variable
    private int type_id;
    private String type_name;
    private int status;
    /**
     * Constructor
     * @param type_id
     * @param type_name
     * @param status 
     */
    public TypeInfo(int type_id, String type_name, int status) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.status = status;
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
     * Get type_name
     * @return 
     */
    public String getType_name() {
        return type_name;
    }
    /**
     * Set type_name
     * @param type_name 
     */
    public void setType_name(String type_name) {
        this.type_name = type_name;
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
}
