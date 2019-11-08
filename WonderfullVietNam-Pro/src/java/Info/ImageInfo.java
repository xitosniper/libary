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
public class ImageInfo {

    //declare variables
    int Image_id;
    String Image_name;
    int Status;

    /**
     * Create Constructor
     */
    public ImageInfo() {

    }

    /**
     * Create Constructor with full parameter
     *
     * @param Image_id
     * @param Image_name
     * @param Status
     */
    public ImageInfo(int Image_id, String Image_name, int Status) {
        this.Image_id = Image_id;
        this.Image_name = Image_name;
        this.Status = Status;
    }

    /**
     * Create getImage_id
     *
     * @return Image_id
     */
    public int getImage_id() {
        return Image_id;
    }

    /**
     * Create setImage_id
     *
     * @param Image_id
     */
    public void setImage_id(int Image_id) {
        this.Image_id = Image_id;
    }

    /**
     * Create getImage_name
     *
     * @return Image_name
     */
    public String getImage_name() {
        return Image_name;
    }

    /**
     * Create setImage_name
     *
     * @param Image_name
     */
    public void setImage_name(String Image_name) {
        this.Image_name = Image_name;
    }

    /**
     * Create getStatus()
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
     * Create toString()
     *
     * @return all parameter
     */
    @Override
    public String toString() {
        return Image_id + " " + Image_name + " " + Status;
    }
}
