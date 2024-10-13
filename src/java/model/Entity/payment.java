package model.Entity;

public class payment {
    private int paymentId;
    private String typePayment;

    // Constructor không tham số
    public payment() {}

    // Constructor có tham số
    public payment(int paymentId, String typePayment) {
        this.paymentId = paymentId;
        this.typePayment = typePayment;
    }

    // Getter và Setter
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    // Phương thức để hiển thị thông tin đối tượng Payment
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", typePayment='" + typePayment + '\'' +
                '}';
    }
}
