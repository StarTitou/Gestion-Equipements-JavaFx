package models;

public class Document {
    private Integer documentID;
    private Integer numDocument;
    private Integer Type;

    public Document(Integer numDocument, Integer type) {
        this.numDocument = numDocument;
        Type = type;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public Integer getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(Integer numDocument) {
        this.numDocument = numDocument;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }
}
