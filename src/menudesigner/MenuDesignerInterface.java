package menudesigner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class MenuDesignerInterface extends JFrame {

    private Font menuFont = new Font("Charlemagne Std", Font.BOLD, 48);
    private Font buttonFont = new Font("Charlemagne Std", Font.BOLD, 15);
    private Font ingredientFont = new Font("Charlemagne Std", Font.PLAIN, 10);
    private Color backgroundColor = Color.LIGHT_GRAY;

    private JPanel newMenuDesignerPanel;
    private JPanel mainMenuPanel;
    private JPanel addMenuPanel;
    
    private ArrayList<ItemOnMenu> itemsOnMenuList;
    private ArrayList<Ingredient> ingredientsList;
    
    private JTextField getItemNameField;
    private JTextField getIngredientsField;
    private JTextField getPriceField;
    private JTextField amountField;
    private JTextField nameField;

    public static void main(String[] args) {
        MenuDesignerInterface mdi = new MenuDesignerInterface();
        mdi.initialSetup();
        

    }

    public void initialSetup() {
        //panel = new JPanel();

        setupMainMenu();

        //add(panel);
        setSize(500, 500);
        setVisible(true);
        setTitle("Menu Designer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setupMainMenu() {

        if(itemsOnMenuList == null){
        
            itemsOnMenuList = new ArrayList<>();
        }
        
        mainMenuPanel = new JPanel();
        JLabel titleLabel;
        JLabel emptyLabel;
        JLabel mainPanelEmptyLabel;
        JButton newMenuButton;
        JButton loadMenuButton;
        JButton configureIngredientDataBaseButton;

        JPanel mainPanel = new JPanel();
        titleLabel = new JLabel(" Menu Designer");
        titleLabel.setFont(menuFont);

        emptyLabel = new JLabel("em");
        emptyLabel.setFont(menuFont);
        emptyLabel.setForeground(backgroundColor);

        mainPanelEmptyLabel = new JLabel("e");
        mainPanelEmptyLabel.setFont(new Font("Ariel", Font.BOLD, 100));
        mainPanelEmptyLabel.setForeground(backgroundColor);

        newMenuButton = new JButton("Create New Menu");
        newMenuButton.addActionListener(new NewMenuListener());
        newMenuButton.setFont(buttonFont);

        loadMenuButton = new JButton("Load Saved Menu");
        loadMenuButton.addActionListener(new LoadMenuListener());
        loadMenuButton.setFont(buttonFont);
        
        configureIngredientDataBaseButton = new JButton("Configure Ingredient Database");
        configureIngredientDataBaseButton.addActionListener(new ConfigureIngredientDataBaseListener());
        configureIngredientDataBaseButton.setFont(buttonFont);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(mainPanelEmptyLabel);
        mainPanel.add(newMenuButton);
        mainPanel.add(loadMenuButton);
        mainPanel.add(configureIngredientDataBaseButton);
        mainPanel.setBackground(backgroundColor);

        mainMenuPanel.setLayout(new BorderLayout());
        mainMenuPanel.add(BorderLayout.NORTH, titleLabel);
        mainMenuPanel.add(BorderLayout.WEST, emptyLabel);
        mainMenuPanel.add(BorderLayout.CENTER, mainPanel);
        mainMenuPanel.setBackground(backgroundColor);

        add(mainMenuPanel);
        if(newMenuDesignerPanel != null){
           
            remove(newMenuDesignerPanel);
        }
        
        repaint();
        validate();

    }

    public void setupNewMenuDesigner() {
        newMenuDesignerPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JLabel newMenuLabel = new JLabel("New Menu");
        newMenuLabel.setFont(menuFont);
        
        JButton addButton = new JButton("Add New Item");
        addButton.addActionListener(new AddButtonListener());
        
        JButton saveMenuButton = new JButton("Save Menu");
        saveMenuButton.addActionListener(new SaveMenuListener());
        
        JButton loadMenuButton = new JButton("Load Menu");
        loadMenuButton.addActionListener(new LoadMenuListener());
        
        JButton backToMainMenuButton = new JButton("Back to Main Menu");
        backToMainMenuButton.addActionListener(new BackToMainMenuListener());

        
        for(ItemOnMenu m: itemsOnMenuList){
            
            mainPanel.add(m);
        }
        
        
        
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(addButton);
        southPanel.add(saveMenuButton);
        southPanel.add(loadMenuButton);
        southPanel.add(backToMainMenuButton);
        

        newMenuDesignerPanel.setLayout(new BorderLayout());
        newMenuDesignerPanel.add(BorderLayout.NORTH, newMenuLabel);
        newMenuDesignerPanel.add(BorderLayout.SOUTH, southPanel);
        newMenuDesignerPanel.add(BorderLayout.CENTER, mainPanel);

        add(newMenuDesignerPanel);
        remove(mainMenuPanel);
        if(addMenuPanel != null){
           
            remove(addMenuPanel);
        }
        
        
        
        repaint();
        validate();

    }

    public void addMenuItem() {
        double costOfDish = 0;
        if (ingredientsList == null) {
            
            ingredientsList = new ArrayList<>();
        }
        
        
        addMenuPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setForeground(backgroundColor);
        
        JLabel emptyLabel = new JLabel("empty");
        emptyLabel.setForeground(backgroundColor);
        
        JLabel bigEmptyLabel = new JLabel("empty");
        bigEmptyLabel.setForeground(backgroundColor);
        bigEmptyLabel.setFont(new Font("Ariel", Font.BOLD, 10));
        
        JLabel addItemLabel = new JLabel("Add New Item");
        addItemLabel.setFont(menuFont);
        
        JLabel enterItemNameLabel = new JLabel("Item Name: ");
        enterItemNameLabel.setFont(buttonFont);
        
        JLabel enterIngredientsLabel = new JLabel("Ingredients: ");
        enterIngredientsLabel.setFont(buttonFont);
        
        JLabel ingredientNameLabel = new JLabel("Ingredient");
        ingredientNameLabel.setFont(ingredientFont);
        
        JLabel ingredientAmountLabel = new JLabel("Amount");
        ingredientAmountLabel.setFont(ingredientFont);
        
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setFont(buttonFont);
        
        getItemNameField = new JTextField();
        getIngredientsField = new JTextField();
        getPriceField = new JTextField();
        
        nameField = new JTextField();
        amountField = new JTextField();
        
        JButton addToMenuButton = new JButton("Add to Menu");
        addToMenuButton.addActionListener(new AddToMenuListener());
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelListener());
        
        JButton addIngredientButton = new JButton("Add");
        addIngredientButton.addActionListener(new AddIngredientListener());
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.add(enterItemNameLabel);
        namePanel.add(getItemNameField);
        
        JPanel ingredientNames = new JPanel();
        ingredientNames.setLayout(new BoxLayout(ingredientNames, BoxLayout.Y_AXIS));
        ingredientNames.add(ingredientNameLabel);
        ingredientNames.add(nameField);
        
        JPanel ingredientAmounts = new JPanel();
        ingredientAmounts.setLayout(new BoxLayout(ingredientAmounts, BoxLayout.Y_AXIS));
        ingredientAmounts.add(ingredientAmountLabel);
        ingredientAmounts.add(amountField);
        
        
        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setLayout(new BoxLayout(ingredientsPanel, BoxLayout.X_AXIS));
        ingredientsPanel.add(enterIngredientsLabel);
        ingredientsPanel.add(ingredientNames);
        ingredientsPanel.add(ingredientAmounts);
        ingredientsPanel.add(addIngredientButton);
        
        
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(addToMenuButton);
        buttonsPanel.add(cancelButton);
        
        JPanel addItemPanel = new JPanel();
        addItemPanel.setLayout(new BoxLayout(addItemPanel, BoxLayout.Y_AXIS));
        addItemPanel.add(addItemLabel);
        addItemPanel.add(bigEmptyLabel);
        addItemPanel.setBackground(backgroundColor);
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(namePanel);
        for(Ingredient i: ingredientsList){
            
            mainPanel.add(i);
            costOfDish = costOfDish + i.getPrice();
        }
        String costString = String.format("$%.2f", costOfDish);
        JLabel costOfDishLabel = new JLabel(costString);
        costOfDishLabel.setFont(buttonFont);
        
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout((new BoxLayout(pricePanel, BoxLayout.X_AXIS)));
        pricePanel.add(priceLabel);
        pricePanel.add(costOfDishLabel);
        
        mainPanel.add(ingredientsPanel);
        mainPanel.add(pricePanel);
        //mainPanel.add(bigEmptyLabel);
        
        
        addMenuPanel.setLayout(new BorderLayout());
        addMenuPanel.add(BorderLayout.SOUTH, buttonsPanel);
        addMenuPanel.add(BorderLayout.CENTER, mainPanel);
        addMenuPanel.add(BorderLayout.NORTH, addItemPanel);
        addMenuPanel.add(BorderLayout.WEST, emptyLabel);
        
        addMenuPanel.setBackground(backgroundColor);
        mainPanel.setForeground(backgroundColor);
        
        
        add(addMenuPanel);
        remove(newMenuDesignerPanel);
        
        repaint();
        validate();
        
        
    }
    
    public void removeItem(ItemOnMenu i){
        
        itemsOnMenuList.remove(i);
        setupMainMenu();
        setupNewMenuDesigner();
        
        
    }
    
    public void removeItem(Ingredient i){
        
        ingredientsList.remove(i);
        setupMainMenu();
        setupNewMenuDesigner();
        
        
    }
    
    public class ConfigureIngredientDataBaseListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
        
    }
    
    public class BackToMainMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            setupMainMenu();
        }
        
        
    }
    
    public class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            setupNewMenuDesigner();
        }
            
    
    
    }
    
    public class AddToMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            double price = 0;
            ArrayList<String> ingredients = new ArrayList<>();
            if (!getItemNameField.getText().equals("") && !ingredientsList.isEmpty()) {

                for(Ingredient i: ingredientsList){
                    
                    price = price + i.getPrice();
                    ingredients.add(i.getName());
                }
                itemsOnMenuList.add(new ItemOnMenu(getItemNameField.getText(), ingredients, price, MenuDesignerInterface.this));
                setupNewMenuDesigner();

            } else {
                JOptionPane.showMessageDialog(null, "One or more fields are empty.");
            }

        }
        
    }
    
    public class AddIngredientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            double price = 0;
            String ingredientName = "";
            double amount;
            boolean match = false;
            try {
                amount = Double.parseDouble(amountField.getText());

                if (!nameField.getText().equals("") && !amountField.getText().equals("")) {
                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(new File("src/menudesigner/database/ingredientdatabase")));
                        String message;

                        while ((message = reader.readLine()) != null) {
                            String[] results = message.split(" ");
                            ingredientName = results[0];
                            price = Double.parseDouble(results[1]);
                            if (nameField.getText().equals(ingredientName)) {
                                double totalPrice = price * amount;
                                if(results[2].equals("kg")){
                                    totalPrice /= 100;
                                    
                                }
                                ingredientsList.add(new Ingredient(ingredientName, amount, totalPrice, results[2], MenuDesignerInterface.this));
                                nameField.setText("");
                                amountField.setText("");
                                match = true;
                                setupNewMenuDesigner();
                                addMenuItem();
                                break;
                            }
                            
                        }
                        if(match == false){
                            JOptionPane.showMessageDialog(null, "Ingredient not found.");
                        }
                        
                        

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ingredient not found.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You must enter an ingredient and amount.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid amount!");
            }

        }
        
        
    }

    public class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            addMenuItem();
        }

    }

    public class NewMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            setupNewMenuDesigner();
        }

    }
    
    public class SaveMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Not yet supported");
        }
        
    }

    public class LoadMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Not yet supported");
        }

    }

}
