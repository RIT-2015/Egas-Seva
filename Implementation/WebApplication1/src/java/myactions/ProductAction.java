/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import com.opensymphony.xwork2.ActionSupport;
import mydatabase.ProductDAO;
import java.util.Collection;
import java.util.Map;
import mybeans.Product;
import mybeans.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author shashi
 */
public class ProductAction extends ActionSupport implements SessionAware {

    private Product product;
    Collection prodColln;
    Map session;
    String msg;

    public ProductAction() {
    }

    public String getProducts() {

        ProductDAO dao = new ProductDAO();
        prodColln = dao.getProducts();

        setProdColln(prodColln);
        return "success";
    }

    public String addProduct() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ProductDAO dao = new ProductDAO();
        boolean rs = dao.addProduct(product);

        prodColln = dao.getProducts();
        setProdColln(prodColln);

        setMsg("Product added successfully.....");
        return "success";
    }

    public String deleteProduct() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ProductDAO dao = new ProductDAO();
        boolean res = dao.deleteProduct(product.getProdID());

        prodColln = dao.getProducts();
        setProdColln(prodColln);

        setMsg("Product deleted successfully.....");
        return "success";
    }

    
    
    
    
    
    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }  
    
    public Collection getProdColln() {
        return prodColln;
    }

    public void setProdColln(Collection prodColln) {
        this.prodColln = prodColln;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
   
    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
