package postmain;

import java.io.Serializable;

public class photopost extends post implements Serializable {

    public String textpost;
    public String felling;
    public String username;
    public String photoname;
    public String data;
    public String time;

    @Override
    public void settextpost(String textpost) {
        this.textpost = textpost;
    }

    @Override
    public String gettextpost() {
        return textpost;
    }

    @Override
    public void setfelling(String felling) {
        this.felling = felling;
    }

    @Override
    public String getfelling() {
        return felling;
    }

    @Override
    public void setusername(String username) {
        this.username = username;
    }

    @Override
    public String getusername() {
        return username;
    }

    @Override
    public void setphoto(String photoname) {
        this.photoname = photoname;
    }

    @Override
    public String getphoto() {
        return photoname;
    }

    @Override
    public void setdate(String date) {
        this.data = date;
    }

    @Override
    public String getdata() {
        return data;
    }

    @Override
    public void settime(String time) {
        this.time = time;
    }

    @Override
    public String gettime() {
        return time;
    }

    @Override
    public void setvideo(String video) {
    }

    @Override
    public String getvideo() {
        return null;
    }

} // end class photopost 