package vn.edu.iuh.fit.enums;

public enum EmployeeStatus {
    TERMINATE(-1),
    IN_ACTIVE(0),
    ACTIVE(1);
    private int status;

    public int getStatus() {
        return status;
    }

    EmployeeStatus() {
    }

    EmployeeStatus(int status) {
        this.status = status;
    }
}
