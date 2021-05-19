package Futronic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="fingers")
public class Finger {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private byte[] data;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "finger_id",referencedColumnName = "id")
    List<Level2> levels = new ArrayList<>();

    public Finger() {
    }

    public Finger(byte[] data) {
        this.data = data;
    }

    public List<Level2> getLevels() {
        return levels;
    }

    public void setLevels(List<Level2> levels) {
        this.levels = levels;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
