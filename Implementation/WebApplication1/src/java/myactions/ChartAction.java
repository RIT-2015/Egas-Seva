/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mybeans.User;
import mydatabase.ChartDAO;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author shashi
 */
public class ChartAction extends ActionSupport implements SessionAware {

    Map session;

    public ChartAction() {
    }

    public String barchart() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ChartDAO dao = new ChartDAO();
        boolean res = dao.barchart();

        return "success";
    }

    public String piechart() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ChartDAO dao = new ChartDAO();
        boolean res = dao.piechart();

        return "success";
    }
    
    
    
    public String customerCities() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ChartDAO dao = new ChartDAO();
        boolean res = dao.customerCities();

        return "customerCities";
    }
    
    public String regCustomerCities() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ChartDAO dao = new ChartDAO();
        boolean res = dao.regCustomerCities();

        return "regCustomerCities";
    }
    
    public String distributorCities() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        ChartDAO dao = new ChartDAO();
        boolean res = dao.distributorCities();

        return "distributorCities";
    }
    
    
    private String yearing;
    private String valuing;

    public String getValuing() {
        return valuing;
    }

    public void setValuing(String valuing) {
        this.valuing = valuing;
    }

    public String getYearing() {
        return yearing;
    }

    public void setYearing(String yearing) {
        this.yearing = yearing;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
