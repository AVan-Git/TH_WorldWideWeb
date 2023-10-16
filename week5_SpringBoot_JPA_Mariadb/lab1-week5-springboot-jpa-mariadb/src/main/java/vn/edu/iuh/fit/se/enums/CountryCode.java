package vn.edu.iuh.fit.se.enums;

public enum CountryCode {
    VN(84),
    LAO(856),
    THA(66);

    private final int countryCode;

    CountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getCountryCode() {
        return countryCode;
    }
}
