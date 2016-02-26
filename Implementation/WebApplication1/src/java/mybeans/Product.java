/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

/**
 *
 * @author shashi
 */
public class Product {
 
//6    
    private String prodID;
    private String name;
    private String details;
    private String price;
    private String availQuantity;
    private String soldPieces;

    public String getAvailQuantity() {
        return availQuantity;
    }

    public void setAvailQuantity(String availQuantity) {
        this.availQuantity = availQuantity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getSoldPieces() {
        return soldPieces;
    }

    public void setSoldPieces(String soldPieces) {
        this.soldPieces = soldPieces;
    }
}
