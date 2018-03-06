/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuNational;

/**
 *
 * @author utilisateur
 */
public class Selection {
    private int id;
    private String description;
    private double price;
    private Boolean availability;

    public Selection(int idD, String descriptionD, double priceD, boolean availabilityD) {
        id = idD;
        description = descriptionD;
        price = priceD;
        availability = availabilityD;         
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
    
    
}
