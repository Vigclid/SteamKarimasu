package model.Entity;

public class TypeProduct {
    private int typeId;
    private String typeName;

    // Constructor không tham số
    public TypeProduct() {}

    // Constructor có tham số
    public TypeProduct(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    // Getter và Setter
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    // Phương thức để hiển thị thông tin đối tượng TypeProduct
    @Override
    public String toString() {
        return "TypeProduct{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
