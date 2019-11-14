/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class PostInfo {
    //declare variables
    private int post_id;
    private int place_id;
    private String post_text;
    private Date post_time;
    private int status;
    private int user_id;
    private int editor_id;

    //-------------CONSTRUCTOR-------------------
    /**
     * Create Constructor has not any parameter
     */
    public PostInfo() {
    }

    /**
     * Create Constructor has full parameters
     * @param post_id
     * @param place_id
     * @param post_text
     * @param post_time
     * @param status
     * @param user_id
     * @param editor_id 
     */
    public PostInfo(int post_id, int place_id, String post_text, Date post_time, int status, int user_id, int editor_id) {
        this.post_id = post_id;
        this.place_id = place_id;
        this.post_text = post_text;
        this.post_time = post_time;
        this.status = status;
        this.user_id = user_id;
        this.editor_id = editor_id;
    }

//    /**
//     * Constructor do not have post_id
//     * @param post_id
//     * @param post_text
//     * @param post_time
//     * @param status
//     * @param user_id
//     * @param editor_id 
//     */
//    public PostInfo(int place_id, String post_text, Date post_time, int status, int user_id, int editor_id) {
//        this.place_id = place_id;
//        this.post_text = post_text;
//        this.post_time = post_time;
//        this.status = status;
//        this.user_id = user_id;
//        this.editor_id = editor_id;
//    }

    /**
     * Create constructor have only post_id
     * @param post_id 
     */
    public PostInfo(int post_id) {
        this.post_id = post_id;
    }
    
    
    //-------------END CONSTRUCTOR-------------------

    //------------------------GETTER-----------------
    /**
     * Create getPost_id
     * @return 
     */
    public int getPost_id() {
        return post_id;
    }

    /**
     * Create getPlace_id
     * @return 
     */
    public int getPlace_id() {
        return place_id;
    }

    /**
     * Create getPost_text
     * @return 
     */
    public String getPost_text() {
        return post_text;
    }

    /**
     * Create getPost_time
     * @return 
     */
    public Date getPost_time() {
        return post_time;
    }

    /**
     * Create getStatus
     * @return 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Create getUser_id
     * @return 
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Create getEditor_id
     * @return 
     */
    public int getEditor_id() {
        return editor_id;
    }

    //---------------END GETTER-----------------
    
    //---------------SETTER-----------------
    
    /**
     * Create setPost_id
     * @param post_id 
     */
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    /**
     * Create setPlace_id
     * @param place_id 
     */
    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    /**
     * Create setPost_text
     * @param post_text 
     */
    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    /**
     * Create setPost_time
     * @param post_time 
     */
    public void setPost_time(Date post_time) {
        this.post_time = post_time;
    }

    /**
     * Create setStatus
     * @param status 
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Create setUser_id
     * @param user_id 
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Create setEditor_id
     * @param editor_id 
     */
    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }
    
    //---------------END SETTER-----------------
    
}
