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
public class EditorInfo {
    //declare variables

    int Editor_id;
    String Editor_time;
    int Status;

    /**
     * Create Constructor
     */
    public EditorInfo() {
    }

    /**
     * Create Constructor with full parameter
     *
     * @param Editor_id
     * @param Editor_time
     * @param Status
     */
    public EditorInfo(int Editor_id, String Editor_time, int Status) {
        this.Editor_id = Editor_id;
        this.Editor_time = Editor_time;
        this.Status = Status;
    }

    /**
     * Create getEditor_id
     * @return Editor_id
     */
    public int getEditor_id() {
        return Editor_id;
    }

    /**
     * Create setEditor_id
     * @param Editor_id
     */
    public void setEditor_id(int Editor_id) {
        this.Editor_id = Editor_id;
    }

    /**
     * Create getEditor_time
     * @return
     */
    public String getEditor_time() {
        return Editor_time;
    }

    /**
     * Create setEditor_time
     * @param Editor_time
     */
    public void setEditor_time(String Editor_time) {
        this.Editor_time = Editor_time;
    }

    /**
     * Create getStatus
     * @return
     */
    public int getStatus() {
        return Status;
    }

    /**
     * Create setStatus
     * @param Status
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * Create toString
     * @return all parameter
     */
    @Override
    public String toString() {
        return Editor_id + " " + Editor_time + " " + Status;
    }

}
