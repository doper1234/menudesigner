/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menudesigner;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;



public class ItemOnMenu extends JPanel{
    
    private JLabel itemNameLabel;
    private JLabel ingredientsLabel;
    private JLabel priceOfItemLabel;
    private JButton removeItemButton;
    
    private String itemName;
    private String[] ingredients;
    private double price;
    
    private Font itemFont = new Font("Ariel", Font.BOLD, 16);
    private Font ingredientsFont = new Font("Ariel", Font.PLAIN, 12);
    
    private MenuDesignerInterface menuDesignerInterface;
    
    
    
    public ItemOnMenu(String name, ArrayList<String> ingredients, double price, MenuDesignerInterface mdi){
        
        menuDesignerInterface = mdi;
        String ingredientsList = "<html>";
        for(int i = 0; i < ingredients.size(); i++){
            if(i == ingredients.size() -1){
                ingredientsList = ingredientsList + " & " + ingredients.get(i) + "<html>";
            }
            
            else if(i == 4 && ingredients.size() > 4){
                ingredientsList = ingredientsList + "<br>" + ingredients.get(i);
            }
            else{
                ingredientsList = ingredientsList + " " + ingredients.get(i) + ",";
            }
            
        }
        String formattedPrice = String.format("$%.2f", price);
        
        
        itemNameLabel = new JLabel(name + " ");
        itemNameLabel.setFont(itemFont);
        
        ingredientsLabel = new JLabel(ingredientsList + " ");
        ingredientsLabel.setFont(ingredientsFont);
        
        priceOfItemLabel = new JLabel(formattedPrice);
        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(new RemoveListener());
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        add(itemNameLabel);
        add(ingredientsLabel);
        add(priceOfItemLabel);
        add(removeItemButton);
        
        
        
        
    }
    
    public class RemoveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            menuDesignerInterface.removeItem(ItemOnMenu.this);
            //System.out.println("removing" + ItemOnMenu.this.itemNameLabel.getText());
            
        }
        
    }
    
    
}
