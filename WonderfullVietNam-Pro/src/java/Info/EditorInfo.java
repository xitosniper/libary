/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class EditorInfo {
    //declare variables

    private int editor_id;
    private Date editor_time;
    private int status;
    private int user_id;

    /**
     * Constructor editorInfo
     * @param editor_id
     * @param editor_time
     * @param status
     * @param user_id 
     */
    public EditorInfo(int editor_id, Date editor_time, int status, int user_id) {
        this.editor_id = editor_id;
        this.editor_time = editor_time;
        this.status = status;
        this.user_id = user_id;
    }


    

    /**
     * Create getEditor_id
     * @return Editor_id
     */
    public int getEditor_id() {
        return editor_id;
    }

    /**
     * Create setEditor_id
     * @param Editor_id
     */
    public void setEditor_id(int Editor_id) {
        this.editor_id = Editor_id;
    }

    /**
     * Create getEditor_time
     * @return
     */
    public Date getEditor_time() {
        return editor_time;
    }

    /**
     * Create setEditor_time
     * @param Editor_time
     */
    public void setEditor_time(Date editor_time) {
        this.editor_time = editor_time;
    }

    /**
     * Create getStatus
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Create setStatus
     * @param Status
     */
    public void setStatus(int Status) {
        this.status = Status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
