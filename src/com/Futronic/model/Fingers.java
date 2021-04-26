package Futronic.model;

import javax.persistence.*;

@Entity
@Table(name="fingers")
public class Fingers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private byte[] data;

    public Fingers() {
    }

    public Fingers(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
