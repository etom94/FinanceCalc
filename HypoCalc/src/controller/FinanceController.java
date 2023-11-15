package controller;

import model.*;
import view.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class FinanceController {
    private Map<FinanceTypeEnum, List<FinancialObject>> financialObjectLists;

    public FinanceController() {
        // Initialisiere die Listen für jeden FinanceTypeEnum
        financialObjectLists = new EnumMap<>(FinanceTypeEnum.class);
        for (FinanceTypeEnum type : FinanceTypeEnum.values()) {
            financialObjectLists.put(type, new ArrayList<>());
        }
    }

    public void createFinancialObject(String name, FinanceTypeEnum typeEnum, double medianValue, double monthlyValue, boolean yearly) {
        List<FinancialObject> currentList = financialObjectLists.get(typeEnum);

        FinancialObject financialObject = new FinancialObject(typeEnum, name, medianValue, monthlyValue, yearly);
        currentList.add(financialObject);
    }
    public List<FinancialObject> getDebtObjects() {
        return financialObjectLists.get(FinanceTypeEnum.debt);
    }

    // Getter-Methode für Objekte des Typs "income"
    public List<FinancialObject> getIncomeObjects() {
        return financialObjectLists.get(FinanceTypeEnum.income);
    }

    // Getter-Methode für Objekte des Typs "savings"
    public List<FinancialObject> getSavingsObjects() {
        return financialObjectLists.get(FinanceTypeEnum.savings);
    }

    // Getter-Methode für Objekte des Typs "expenses"
    public List<FinancialObject> getExpensesObjects() {
        return financialObjectLists.get(FinanceTypeEnum.expenses);
    }
    public void editFinancialObject(FinancialObject selectedObject, String newName, double newMedianValue, double newMonthlyValue, boolean newYearly) {
        selectedObject.setName(newName);
        selectedObject.setMedianValue(newMedianValue);
        selectedObject.setMonthlyValue(newMonthlyValue);
        selectedObject.setYearly(newYearly);

    }
}
