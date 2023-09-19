package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    SELL(1),//dang kinh doanh
    PAUSE(0),//tạm ngưng
    UNSELL(-1);//không kinh doanh
    private int status;

    public int getStatus() {
        return status;
    }

    ProductStatus(int status) {
        this.status = status;
    }
}
