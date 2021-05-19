package Futronic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="level2")
public class Level2 {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private int x;
    private int y;
    private int type;
    private float angle;
    private int quality;
    private int img_height;
    private int img_width;

    public Level2(){}


    public Level2(int x, int y, int type, float angle, int quality, int img_height, int img_width) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.angle = angle;
        this.quality = quality;
        this.img_height = img_height;
        this.img_width = img_width;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getImg_height() {
        return img_height;
    }

    public void setImg_height(int img_height) {
        this.img_height = img_height;
    }

    public int getImg_width() {
        return img_width;
    }

    public void setImg_width(int img_width) {
        this.img_width = img_width;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Float getAngle() {
        return this.angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
