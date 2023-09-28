package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    TERMINATE(-1),
    IN_ACTIVE(0),
    ACTIVE(1);
    private int value;

    ProductStatus() {
    }

    public int getValue() {
        return value;
    }

    ProductStatus(int value) {
        this.value = value;
    }
}
