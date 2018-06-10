package posmanager.restdomain;

/**
 * Created by shitul on 4/25/17.
 */
public class ImageUploadResponseMessage {

    private Integer Staus;
    private String  messege;
    private String imageFileName;

    public Integer getStaus() {
        return Staus;
    }

    public void setStaus(Integer staus) {
        Staus = staus;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
