package enilibrary.EniLibrary.entities;

import enilibrary.EniLibrary.Enum.DocumentCategory;
import jakarta.persistence.*;


@Entity
@Table(name="docs")
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String docName;
    private String docType;

    @Enumerated(EnumType.STRING)
    private DocumentCategory documentCategory;

    @Lob
    private byte[] data;

    public Doc() {}

    public Doc(String docName, String docType, DocumentCategory documentCategory, byte[] data) { // Modification du constructeur
        this.docName = docName;
        this.docType = docType;
        this.documentCategory = documentCategory;
        this.data = data;
    }


    public DocumentCategory getDocumentCategory(){
        return this.documentCategory;
    }

    public void setDocumentCategory(DocumentCategory documentCategory) {
        this.documentCategory=documentCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id= id;
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

}
