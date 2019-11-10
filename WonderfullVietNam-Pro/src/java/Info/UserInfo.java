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
public class UserInfo {

    //Declared variables
    private int user_id;
    private String user_name;
    private int user_gender;
    private String user_img;
    private String user_phone;
    private String user_address;
    private String user_username;
    private String user_password;
    private int status;
    private int role_id;

    /**
     * Constructor of "user" table with variables
     *
     * @param user_id
     * @param user_name
     * @param user_gender
     * @param user_img
     * @param user_phone
     * @param user_address
     * @param user_username
     * @param user_password
     * @param status
     * @param role_id
     */
    public UserInfo(int user_id, String user_name, int user_gender, String user_img, String user_phone, String user_address, String user_username, String user_password, int status, int role_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_img = user_img;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_username = user_username;
        this.user_password = user_password;
        this.status = status;
        this.role_id = role_id;
    }

    /**
     * Constructor of "user" table with variables without id
     *
     * @param user_name
     * @param user_gender
     * @param user_img
     * @param user_phone
     * @param user_address
     * @param user_username
     * @param user_password
     * @param status
     * @param role_id
     */
    public UserInfo(String user_name, int user_gender, String user_img, String user_phone, String user_address, String user_username, String user_password, int status, int role_id) {
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_img = user_img;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_username = user_username;
        this.user_password = user_password;
        this.status = status;
        this.role_id = role_id;
    }

    /**
     * Constructor of "user" table with variables without password
     *
     * @param user_id
     * @param user_name
     * @param user_gender
     * @param user_img
     * @param user_phone
     * @param user_address
     * @param user_username
     * @param status
     * @param role_id
     */
    public UserInfo(int user_id, String user_name, int user_gender, String user_img, String user_phone, String user_address, String user_username, int status, int role_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_img = user_img;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_username = user_username;
        this.status = status;
        this.role_id = role_id;
    }

    /**
     * Constructor of "user" table
     */
    public UserInfo() {
    }

    /**
     * get user id
     *
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * set user id
     *
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * get user name
     *
     * @return
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * set user name
     *
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * get user gender
     *
     * @return
     */
    public int getUser_gender() {
        return user_gender;
    }

    /**
     * set user gender
     *
     * @param user_gender
     */
    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    /**
     * get user image
     *
     * @return
     */
    public String getUser_img() {
        return user_img;
    }

    /**
     * set user image
     *
     * @param user_img
     */
    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    /**
     * get user phone
     *
     * @return
     */
    public String getUser_phone() {
        return user_phone;
    }

    /**
     * set user phone
     *
     * @param user_phone
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    /**
     * get user address
     *
     * @return
     */
    public String getUser_address() {
        return user_address;
    }

    /**
     * set user address
     *
     * @param user_address
     */
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    /**
     * get username of user
     *
     * @return
     */
    public String getUser_username() {
        return user_username;
    }

    /**
     * set username of user
     *
     * @param user_username
     */
    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    /**
     * get password of user
     *
     * @return
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * set password of user
     *
     * @param user_password
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * get status
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get id of role
     *
     * @return
     */
    public int getRole_id() {
        return role_id;
    }

    /**
     * set id of role
     *
     * @param role_id
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

}
