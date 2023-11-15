package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.FinanceTypeEnum;
import model.FinancialObject;
import model.GridBagBuilder;
import model.MyFrame;
import controller.FinanceController;

public class MainView {
    private static int frameWidth = 2000;
    private static int frameHeight = 1300;
    private static FinanceController financeController = new FinanceController();

    public static void main(String[] args) {
        //#region Helpers
        // create constraints
        GridBagBuilder builder = new GridBagBuilder();
        builder.setDefaultValues()
            .fill(GridBagConstraints.BOTH)
            .anchor(GridBagConstraints.CENTER)
            .gridx(0)
            .gridy(0)
            .gridwidth(1)
            .gridheight(1)
            .weightx(1)
            .weighty(1)
            .insets(new Insets(0, 0, 0, 0))
            .build();
        //#endregion
        //#region Frame
        // create window
        MyFrame myFrame = new MyFrame(frameWidth, frameHeight);
        myFrame.setLayout(new GridBagLayout());
        //#endregion
        //#region Panel for BaseLayout
        // create and add Panel
        JPanel 
        mainpanel =             new JPanel(new GridBagLayout()),
        titelPanel =            new JPanel(new GridBagLayout()),
        upperBodyPanel =        new JPanel(new GridBagLayout()),
        combinedValuesPanel =   new JPanel(new GridBagLayout()),
        lowerBodyPanel =        new JPanel(new GridBagLayout()),
        footerPanel =           new JPanel(new GridBagLayout());
 
        myFrame.add(mainpanel,              builder.resetValues().build());
        mainpanel.add(titelPanel,           builder.gridy(0).weighty(0.02).build());
        mainpanel.add(upperBodyPanel,       builder.gridy(1).weighty(0.2).build());
        mainpanel.add(combinedValuesPanel,  builder.gridy(2).weighty(0.1).build());
        mainpanel.add(lowerBodyPanel,       builder.gridy(3).weighty(0.4).build());
        mainpanel.add(footerPanel,          builder.gridy(4).weighty(0.05).build());
        //#endregion
        //#region titleLabel
        JLabel titleLabel = new JLabel("Finanz Berechnung");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titelPanel.add(titleLabel, builder.resetValues().fill(GridBagConstraints.NONE).anchor(GridBagConstraints.CENTER).build());
        //#endregion
        //#region User iput
        JPanel 
        fillerPanel1 = new JPanel(),
        fillerPanel2 = new JPanel(),
        inputpanel = new JPanel(new GridBagLayout());
        JLabel 
        nameLabel = new JLabel("Benennung:"),
        valueLabel = new JLabel("Wert:");
        JTextField 
        nameField = new JTextField(),
        valueTextField = new JTextField();
        JCheckBox 
        yearlyCheckBox = new JCheckBox("Jährlich");
        JComboBox<FinanceTypeEnum> 
        typeComboBox = new JComboBox<>(FinanceTypeEnum.values());
        JButton 
        createButton = new JButton("Objekt erstellen");

        upperBodyPanel.add(inputpanel,  builder.resetValues().gridy(0).weightx(1).weighty(0.001).fill(GridBagConstraints.BOTH).build());

        inputpanel.add(fillerPanel1,    builder.gridx(0).weightx(0.3).insets(new Insets(5,5,5,5)).build());
        inputpanel.add(nameLabel,       builder.gridx(1).weightx(0)  .build());
        inputpanel.add(nameField,       builder.gridx(2).weightx(0.2).build());
        inputpanel.add(typeComboBox,    builder.gridx(3).weightx(0.05).build());
        inputpanel.add(valueLabel,      builder.gridx(4).weightx(0)  .build());
        inputpanel.add(valueTextField,  builder.gridx(5).weightx(0.2).build());
        inputpanel.add(yearlyCheckBox,  builder.gridx(6).weightx(0).build());
        inputpanel.add(fillerPanel2,    builder.gridx(7).weightx(0.3).build());
        inputpanel.add(createButton,    builder.gridx(0).gridy(1).weightx(0).weighty(0).gridwidth(8).fill(GridBagConstraints.NONE).anchor(GridBagConstraints.SOUTH).build());

        //#region actionListener
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                FinanceTypeEnum typeEnum = (FinanceTypeEnum) typeComboBox.getSelectedItem();
                boolean yearly = yearlyCheckBox.isSelected();
                double medianValue = 0;
                double monthlyValue = 0;
                if(!yearly){
                monthlyValue = Double.parseDouble(valueTextField.getText());
                }
                else {
                medianValue = Double.parseDouble(valueTextField.getText());
                }
                financeController.createFinancialObject(name, typeEnum, medianValue, monthlyValue, yearly);
                }
        });
        
        //#endregion

        //#endregion
        //#region Output Elements
        JPanel 
        outputPanel = new JPanel(new GridBagLayout()),
        incomePanel = new JPanel(new GridBagLayout()),
        savingsPanel = new JPanel(new GridBagLayout()),
        expensesPanel = new JPanel(new GridBagLayout()),
        debtPanel = new JPanel(new GridBagLayout());

        JLabel
        incomeLabel = new JLabel("Einnahmen"),
        savingsLabel = new JLabel("Vermögen"),
        expensesLabel = new JLabel("Ausgaben"),
        debtLabel = new JLabel("Schulden");

        incomePanel.add(incomeLabel,        builder.resetValues().gridx(0).gridy(0).weightx(0).weighty(0).fill(GridBagConstraints.NONE).anchor(GridBagConstraints.NORTH).build());
        savingsPanel.add(savingsLabel,      builder.gridy(0).build());
        expensesPanel.add(expensesLabel,    builder.gridy(0).build());
        debtPanel.add(debtLabel,            builder.gridy(0).build());


        upperBodyPanel.add(outputPanel,   builder.resetValues().gridx(0).gridy(1).weighty(0.999).anchor(GridBagConstraints.NORTH).build());
        outputPanel.add(incomePanel,      builder.gridx(0).weightx(0.33).gridy(0).build());
        outputPanel.add(savingsPanel,     builder.gridx(1).weightx(0.33).build());
        outputPanel.add(expensesPanel,    builder.gridx(2).weightx(0.33).build());
        outputPanel.add(debtPanel,        builder.gridx(3).weightx(0.33).build());        

        //#region table and scrollpane creation
        DefaultTableModel 
        incomeTable = new DefaultTableModel(),
        savingsTable = new DefaultTableModel(),
        expensesTable = new DefaultTableModel(),
        debtTable = new DefaultTableModel();

        JTable 
        incomeJTable = new JTable(incomeTable),
        savingsJTable = new JTable(savingsTable),
        expensesJTable = new JTable(expensesTable),
        debtJTable = new JTable(debtTable);

        JScrollPane
        incomeScrollPane = new JScrollPane(incomeJTable),
        savingsScrollPane = new JScrollPane(savingsJTable),
        expensesScrollPane = new JScrollPane(expensesJTable),
        debtScrollPane = new JScrollPane(debtJTable);
        

        incomeTable.addColumn("Benennung");
        incomeTable.addColumn("Jahres Wert");
        incomeTable.addColumn("Monat Wert");

        savingsTable.addColumn("Benennung");
        savingsTable.addColumn("Jahres Wert");
        savingsTable.addColumn("Monat Wert");

        expensesTable.addColumn("Benennung");
        expensesTable.addColumn("Jahres Wert");
        expensesTable.addColumn("Monat Wert");

        debtTable.addColumn("Benennung");
        debtTable.addColumn("Jahres Wert");
        debtTable.addColumn("Monat Wert");
        //#endregion
        incomePanel.add(incomeScrollPane,       builder.resetValues().gridx(0).gridy(1).gridwidth(1).weightx(1).weighty(1).anchor(GridBagConstraints.NORTH).fill(GridBagConstraints.BOTH).build());        
        savingsPanel.add(savingsScrollPane,     builder.build());
        expensesPanel.add(expensesScrollPane,   builder.build());
        debtPanel.add(debtScrollPane,           builder.build());

        //#endregion

        //#region borders
        titelPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
        incomePanel.setBorder(BorderFactory.createMatteBorder(1,0,1,1, Color.BLACK));
        savingsPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,1, Color.BLACK));
        expensesPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,1, Color.BLACK));
        debtPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0, Color.BLACK));
        //#endregion
        myFrame.repaint();
        myFrame.validate();
    }
        
}
