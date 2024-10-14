package model.Entity;

public class Bill {
    private int billId;
    private int paymentId;
    private int productId;
    private String dateOfCreate; // Sử dụng LocalDate nếu cần

    // Constructor không tham số
    public Bill() {}

    // Constructor có tham số
    public Bill(int billId, int paymentId, int productId, String dateOfCreate) {
        this.billId = billId;
        this.paymentId = paymentId;
        this.productId = productId;
        this.dateOfCreate = dateOfCreate;
    }

    // Getter và Setter
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    // Phương thức để hiển thị thông tin đối tượng Bill
    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", paymentId=" + paymentId +
                ", productId=" + productId +
                ", dateOfCreate='" + dateOfCreate + '\'' +
                '}';
    }
}
