package model;

public class FinancialObject {
    private String name;
    private FinanceTypeEnum typeEnum;
    private double medianValue;
    private double monthlyValue;
    private boolean yearly;

    public FinancialObject(FinanceTypeEnum typeEnum, String name, double medianValue,double monthlyValue, boolean yearly) {
        this.name = name;
        this.typeEnum = typeEnum;
        this.medianValue = medianValue;
        this.monthlyValue = monthlyValue;
        this.yearly = yearly;
    }

    public String getName() {
        return name;
    }
    public void setName(String inputName) {
        name = inputName;
    }
    public FinanceTypeEnum getTypeEnum() {
        return typeEnum;
    }
    
    public void setTypeEnum(FinanceTypeEnum inputTypeEnum) {
        typeEnum = inputTypeEnum;
    }    
    public double getMedianValue() {
        return medianValue;
    }
    public void setMedianValue(double inputMedianValue) {
        medianValue = inputMedianValue;
    }
    public double getMonthlyValue() {
        return monthlyValue;
    }
    public void setMonthlyValue(double inputMonthlyValue) {
        monthlyValue = inputMonthlyValue;
    }
    public boolean getYearly() {
        return yearly;
    }
    public void setYearly(boolean inputYearly) {
        yearly = inputYearly;
    }

    public void calculateMissingValue() {
        if (!yearly) {
            medianValue = monthlyValue * 12;
            yearly = true;
        } else {
            monthlyValue = medianValue / 12;
        }
    }
}
