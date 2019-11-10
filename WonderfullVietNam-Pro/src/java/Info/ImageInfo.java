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
    private int image_id;
    private String image_name;
    private int status;
    private int place_id;
    /**
     * Constructor image
     * @param image_id
     * @param image_name
     * @param status
     * @param place_id 
     */
    public ImageInfo(int image_id, String image_name, int status, int place_id) {
        this.image_id = image_id;
        this.image_name = image_name;
        this.status = status;
        this.place_id = place_id;
    }

    /**
     * Create getimage_id
     *
     * @return image_id
     */
    public int getImage_id() {
        return image_id;
    }

    /**
     * Create setImage_id
     *
     * @param image_id
     */
    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    /**
     * Create getImage_name
     *
     * @return image_name
     */
    public String getImage_name() {
        return image_name;
    }

    /**
     * Create setImage_name
     *
     * @param image_name
     */
    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    /**
     * Create getStatus()
     *
     * @return Status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Create setStatus
     *
     * @param Status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

}
