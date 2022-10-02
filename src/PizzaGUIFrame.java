import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PizzaGUIFrame extends JFrame {
    JPanel mainPanel;


    JPanel radioPanel;

    JRadioButton thinCrustRadio;
    JRadioButton regularCrustRadio;
    JRadioButton deepCrustRadio;
    ButtonGroup radioGroup;

    JPanel comboPanel;
    JComboBox sizeCombo;


    JPanel checkPanel;

    JCheckBox pepperoniCheck;
    JCheckBox pineappleCheck;
    JCheckBox cheeseCheck;
    JCheckBox oliveCheck;
    JCheckBox pepperCheck;
    JCheckBox cocaineCheck;

    JPanel receiptPanel;
    JTextArea receiptTA;
    JScrollPane scroller;

    JPanel controlPanel;
    JButton orderButton;
    JButton clearButton;
    JButton quitButton;

    double baseCost;
    int amountOfToppings;

    String typeOfCrustLine;
    String sizeOfPizzaLine;
    double subtotal;
    double total;

    int input;

    public PizzaGUIFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        createRadioPanel();
        mainPanel.add(radioPanel, BorderLayout.NORTH);

        createComboPanel();
        mainPanel.add(comboPanel, BorderLayout.EAST);

        createCheckPanel();
        mainPanel.add(checkPanel, BorderLayout.WEST);

        createReceiptPanel();
        mainPanel.add(receiptPanel, BorderLayout.CENTER);

        createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void createRadioPanel() {
        radioPanel = new JPanel();
        radioPanel.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));
        thinCrustRadio = new JRadioButton("Thin");
        regularCrustRadio = new JRadioButton("Regular");
        deepCrustRadio = new JRadioButton("Deep-Dish");

        radioGroup = new ButtonGroup();
        radioGroup.add(thinCrustRadio);
        radioGroup.add(regularCrustRadio);
        radioGroup.add(deepCrustRadio);

        radioPanel.add(thinCrustRadio);
        radioPanel.add(regularCrustRadio);
        radioPanel.add(deepCrustRadio);

    }

    public void createComboPanel() {
        comboPanel = new JPanel();
        comboPanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        sizeCombo = new JComboBox();
        sizeCombo.addItem("Small");
        sizeCombo.addItem("Medium");
        sizeCombo.addItem("Large");
        sizeCombo.addItem("Super");

        comboPanel.add(sizeCombo);

    }

    public void createCheckPanel() {
        checkPanel = new JPanel();
        checkPanel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings - ($1/each)"));

        pepperoniCheck = new JCheckBox("Pepperoni");
        pineappleCheck = new JCheckBox("Pineapple");
        pepperCheck = new JCheckBox("Pepper");
        cheeseCheck = new JCheckBox("Cheese");
        oliveCheck = new JCheckBox("Olives");
        cocaineCheck = new JCheckBox("Cocaine");

        checkPanel.add(pepperoniCheck);
        checkPanel.add(pineappleCheck);
        checkPanel.add(pepperCheck);
        checkPanel.add(cheeseCheck);
        checkPanel.add(oliveCheck);
        checkPanel.add(cocaineCheck);


    }

    public void createReceiptPanel() {
        receiptPanel = new JPanel();
        receiptPanel.setBorder(new TitledBorder(new EtchedBorder(), "Receipt"));
        receiptTA = new JTextArea(10, 25);
        scroller = new JScrollPane(receiptTA);
        receiptTA.setEditable(false);
        receiptPanel.add(scroller);
    }

    public void createControlPanel() {
        controlPanel= new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Controls"));
        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        quitButton = new JButton("Quit");

        orderButton.addActionListener((ActionEvent ae) -> {
            if (thinCrustRadio.isSelected()) {
                typeOfCrustLine = "Thin Crust";
            }
            if (regularCrustRadio.isSelected()) {
                typeOfCrustLine = "Regular Crust";
            }

            if (deepCrustRadio.isSelected()) {
                typeOfCrustLine = "Deep Crust";
            }

            if (sizeCombo.getSelectedItem().toString().equals("Small")) {
                sizeOfPizzaLine = "Small";
                baseCost = 8.00;
            }
            if (sizeCombo.getSelectedItem().toString().equals("Medium")) {
                sizeOfPizzaLine = "Medium";
                baseCost = 12.00;
            }
            if (sizeCombo.getSelectedItem().toString().equals("Large")) {
                sizeOfPizzaLine = "Large";
                baseCost = 16.00;
            }
            if (sizeCombo.getSelectedItem().toString().equals("Super")) {
                sizeOfPizzaLine = "Super";
                baseCost = 20.00;
            }

            if (pepperoniCheck.isSelected()) {
                amountOfToppings += 1;
            }
            if (pineappleCheck.isSelected()) {
                amountOfToppings += 1;
            }
            if (cheeseCheck.isSelected()) {
                amountOfToppings += 1;
            }
            if (oliveCheck.isSelected()) {
                amountOfToppings += 1;
            }
            if (pepperCheck.isSelected()) {
                amountOfToppings += 1;
            }
            if (cocaineCheck.isSelected()) {
                amountOfToppings += 1;
            }
            subtotal = baseCost + amountOfToppings;
            total = subtotal + subtotal * .07;
            receiptTA.append("=====================\n\n");
            receiptTA.append("Size: \t " + sizeOfPizzaLine + "\n");
            receiptTA.append("Crust Type: \t " + typeOfCrustLine + "\n");
            receiptTA.append("Sub-total: \t " + subtotal + "\n");
            receiptTA.append("Tax: \t 7%" + "\n");
            receiptTA.append("--------------------------\n");
            receiptTA.append("Total: \t" + total + "\n");
            receiptTA.append("=====================\n\n\n");
        });

        clearButton.addActionListener((ActionEvent ae) ->  {
            radioGroup.clearSelection();
            sizeCombo.setSelectedIndex(0);
            pepperoniCheck.setSelected(false);
            pineappleCheck.setSelected(false);
            pepperCheck.setSelected(false);
            cheeseCheck.setSelected(false);
            oliveCheck.setSelected(false);
            cocaineCheck.setSelected(false);


        });
        quitButton.addActionListener((ActionEvent ae) -> {
            input = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "", JOptionPane.DEFAULT_OPTION);
            if (input == 0) {
                System.exit(0);
            }
        });

        controlPanel.add(orderButton);
        controlPanel.add(clearButton);
        controlPanel.add(quitButton);
    }



}
