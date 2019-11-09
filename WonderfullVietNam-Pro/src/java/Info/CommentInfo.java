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
public class CommentInfo {
    //Declare variables
    private int comment_id;
    private String comment_email;
    private Date comment_time;
    private String comment_description;
    private int status;
    private int user_id;
    private int post_id;

    //-------------CONSTRUCTOR-------------------
    /**
     * Create Constructor has not any parameter
     */
    public CommentInfo() {
    }

    /**
     * Create Constructor has only comment_id is the parameter
     * @param comment_id 
     */
    public CommentInfo(int comment_id) {
        this.comment_id = comment_id;
    }

    
    /**
     * Create Constructor has full parameters
     * @param comment_id
     * @param comment_email
     * @param comment_time
     * @param comment_description
     * @param status
     * @param user_id
     * @param post_id 
     */
    public CommentInfo(int comment_id, String comment_email, Date comment_time, String comment_description, int status, int user_id, int post_id) {
        this.comment_id = comment_id;
        this.comment_email = comment_email;
        this.comment_time = comment_time;
        this.comment_description = comment_description;
        this.status = status;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    /**
     * Create constructor do not have comment_id
     * @param comment_email
     * @param comment_time
     * @param comment_description
     * @param status
     * @param user_id
     * @param post_id 
     */
    public CommentInfo(String comment_email, Date comment_time, String comment_description, int status, int user_id, int post_id) {
        this.comment_email = comment_email;
        this.comment_time = comment_time;
        this.comment_description = comment_description;
        this.status = status;
        this.user_id = user_id;
        this.post_id = post_id;
    }
    
    
    //-------------END CONSTRUCTOR-------------------
    
    //------------------GETTER-----------------------
    /**
     * Create getComment_id
     * @return 
     */
    public int getComment_id() {
        return comment_id;
    }

    /**
     * Create getComment_email
     * @return 
     */
    public String getComment_email() {
        return comment_email;
    }

    /**
     * Create getComment_time
     * @return 
     */
    public Date getComment_time() {
        return comment_time;
    }

    /**
     * Create getComment_description
     * @return 
     */
    public String getComment_description() {
        return comment_description;
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
     * Create getPost_id
     * @return 
     */
    public int getPost_id() {
        return post_id;
    }
    //------------------END GETTER-----------------------
    
    //------------------SETTER-----------------------
    /**
     * Create setComment_id
     * @param comment_id 
     */
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    /**
     * Create setComment_email
     * @param comment_email 
     */
    public void setComment_email(String comment_email) {
        this.comment_email = comment_email;
    }

    /**
     * Create setComment_time
     * @param comment_time 
     */
    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    /**
     * Create setComment_description
     * @param comment_description 
     */
    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
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
     * Create setPost_id
     * @param post_id 
     */
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    
    //------------------END SETTER-----------------------
    
}
