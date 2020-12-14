package Futronic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="docs")
public class Doc {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//poziadavka
	private String request;
	private String docName;
	private String docType;

	@Lob
	private byte[] data;

	private Long size;
	
	public Doc() {}

	public Doc(String docName,String request, String docType, byte[] data, Long size) {
		super();
		this.size = size;
		this.request=request;
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}

	public String getRequest() { return request; }

	public void setRequest(String sender) { this.request = sender; }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
