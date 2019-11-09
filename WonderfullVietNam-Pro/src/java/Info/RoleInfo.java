/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

/**
 *
 * @author DELL
 */
public class RoleInfo {
    //Declared variables
    private int role_id;
    private String role_name;
    private String role_description;
    private int status;

    /**
     * Constructor of "role" table
     */
    public RoleInfo() {
    }

    /**
     * Constructor with variables of "role" table without id
     * @param role_name
     * @param role_description
     * @param status 
     */
    public RoleInfo(String role_name, String role_description, int status) {
        this.role_name = role_name;
        this.role_description = role_description;
        this.status = status;
    }

    
    /**
     * Constructor with variables of "role" table
     * @param role_id
     * @param role_name
     * @param role_description
     * @param status 
     */
    public RoleInfo(int role_id, String role_name, String role_description, int status) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_description = role_description;
        this.status = status;
    }

    /**
     * get id of role
     * @return 
     */
    public int getRole_id() {
        return role_id;
    }

    /**
     * set id of role
     * @param role_id 
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    /**
     * get name of role
     * @return 
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * set name of role
     * @param role_name 
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * get description of role
     * @return 
     */
    public String getRole_description() {
        return role_description;
    }

    /**
     * set description of role
     * @param role_description 
     */
    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    /**
     * get status
     * @return 
     */
    public int getStatus() {
        return status;
    }

    /**
     * set status
     * @param status 
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
