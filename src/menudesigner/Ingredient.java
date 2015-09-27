/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menudesigner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Chris
 */
public class Ingredient extends JPanel{
    
    private double price;
    private double amount;
    private String name;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel amountLabel;
    MenuDesignerInterface menuDesignerInterface;
    private String unit;
    
    public Ingredient(String name, double amount, double price, String unit, MenuDesignerInterface mdi){
        
        menuDesignerInterface = mdi;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.unit = unit;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        String costString = String.format("$%.2f", price);
        
        nameLabel = new JLabel(name);
        amountLabel = new JLabel(amount + " " + unit);
        priceLabel = new JLabel(costString);
        
        JButton removeButton = new JButton("remove");
        
        add(nameLabel);
        add(amountLabel);
        add(priceLabel);
        add(removeButton);
    }
    
    public double getPrice(){
        
        return price;
    }
    
    public String getName(){
        
        return name;
    }
    
    public class RemoveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuDesignerInterface.removeItem(Ingredient.this);
            //System.out.println("removing" + ItemOnMenu.this.itemNameLabel.getText());
            
        }
        
    }
    
}
