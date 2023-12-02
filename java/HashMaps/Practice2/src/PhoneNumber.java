public class Phonebook {
    private int countryCode;
    private String areaCode;
    private String centralOfficeCode;
    private String lineNumber;

    /**
     * @param areaCode the first three digits
     * @param centralOfficeCode the middle three digits
     * @param lineNumber the last four digits
     */
    public PhoneNumber(String areaCode, String centralOfficeCode, String lineNumber) {
        this.areaCode = areaCode;
        this.centralOfficeCode = centralOfficeCode;
        this.lineNumber = lineNumber;
    }

    /**
     * @param countryCode       the country code
     * @param areaCode          the first three digits
     * @param centralOfficeCode the middle three digits
     * @param lineNumber        the last four digits
     */
    public Phonebook(int countryCode, String areaCode, String centralOfficeCode, String lineNumber) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.centralOfficeCode = centralOfficeCode;
        this.lineNumber = lineNumber;
    }

    /**
     * @return a phone number in XXX-XXX-XXXX format
     */
    public String toString() {
        return areaCode + "-"  + centralOfficeCode + "-"  + lineNumber;
    }
}