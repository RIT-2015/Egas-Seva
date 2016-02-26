/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

import java.awt.*;
import java.sql.*;
import java.io.*;
import java.sql.Connection;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;

/**
 *
 * @author shashi
 */
public class ChartDAO extends BaseDAO {

    public boolean piechart() {

        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();

            int value[] = new int[10];
            ResultSet rs1 = st.executeQuery("select * from crce.report");
            for (int i = 0; rs1.next(); i++) {
                value[i] = Integer.parseInt(rs1.getString("value"));
            }

            final DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("2006\n"+value[6], new Double(value[6]));
            data.setValue("2007\n"+value[7], new Double(value[7]));
            data.setValue("2008\n"+value[8], new Double(value[8]));
            data.setValue("2009\n"+value[9], new Double(value[9]));
            data.setValue("2010\n"+value[10], new Double(value[10]));
            data.setValue("2011\n"+value[11], new Double(value[11]));

            JFreeChart chart = ChartFactory.createPieChart("Cylinders sold (last 5 years)", data, true, true, false);


            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/resources/images/charts/piechart.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return true;
    }
   

         
     
    
  public boolean barchart() {

   Connection con = null;
   try {
            con = getConnection();
            Statement st = con.createStatement();

            int value[] = new int[10];
            ResultSet rs1 = st.executeQuery("select * from crce.report");
            for (int i = 0; rs1.next(); i++) 
            {
                value[i] = Integer.parseInt(rs1.getString("value"));
            }
        final double[][] data = new double[][]
        {
            {
               value[0], value[1], value[2], value[3], value[4], value[5], value[6], value[7], value[8], value[9]
            }
            //  {210, 300, 320, 265, 299},
            //  {200, 304, 201, 201, 340}
        };

        final CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Cylinders sold", "", data);

        JFreeChart chart = null;
        BarRenderer renderer = null;
        CategoryPlot plot = null;


        final CategoryAxis categoryAxis = new CategoryAxis("Years (in 2000)");
        final ValueAxis valueAxis = new NumberAxis("No. of cylinders sold)");
        renderer = new BarRenderer();

        plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
        plot.setOrientation(PlotOrientation.VERTICAL);
        chart = new JFreeChart("cylinders sold(last 10 years)", JFreeChart.DEFAULT_TITLE_FONT, plot, true);

        chart.setBackgroundPaint(new Color(249, 231, 236));

        Paint p1 = new GradientPaint(0.0f, 0.0f, new Color(16, 89, 172), 0.0f, 0.0f, new Color(201, 201, 244));

        renderer.setSeriesPaint(1, p1);

        //Paint p2 = new GradientPaint(0.0f, 0.0f, new Color(255, 35, 35), 0.0f, 0.0f, new Color(255, 180, 180));
        //renderer.setSeriesPaint(2, p2);

         plot.setRenderer(renderer);


        final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        final File file1 = new File("C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/resources/images/charts/barchart.png");
        ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);


     } catch (Exception e) {
            System.out.println("error aaya:" + e);
      }
   closeConnection();
   return true;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
     public boolean customerCities() {

        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();

            int value[] = new int[10];
            System.out.println("");
            ResultSet rs1 = st.executeQuery("select count(c_id)AS count from crce.customer where city='mumbai' and username <> 'na'");
            rs1.next();
            value[0] = rs1.getInt("count");
            System.out.println("1");
            rs1.close();

            ResultSet rs2 = st.executeQuery("select count(*)AS count from crce.customer where city='chennai' and username <> 'na'");
            rs2.next();
            value[1] = rs2.getInt("count");
            System.out.println("2");
            rs2.close();

            ResultSet rs3 = st.executeQuery("select count(*)as count from crce.customer where city='delhi' and username <> 'na'");
            rs3.next();
            value[2] = rs3.getInt("count");
            System.out.println("3");
            rs3.close();

            ResultSet rs4 = st.executeQuery("select count(*)as count from crce.customer where city='kolkata' and username <> 'na'");
            rs4.next();
            value[3] = rs4.getInt("count");
            System.out.println("4");
            rs4.close();
                              

            final DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Mumbai\n"+value[0], new Double(value[0]));
            data.setValue("Chennai\n"+value[1], new Double(value[1]));
            data.setValue("Delhi\n"+value[2], new Double(value[2]));
            data.setValue("Kolkata\n"+value[3], new Double(value[3]));

            
            JFreeChart chart = ChartFactory.createPieChart("Customers from Metro Cities", data, true, true, false);


            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/resources/images/charts/customerCities.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return true;
    }
     
     
     
      public boolean regCustomerCities() {

        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();

            int value[] = new int[10];
            System.out.println("");
            ResultSet rs1 = st.executeQuery("select count(*)AS count from crce.customer where city='mumbai' and status='approved'");
            rs1.next();
            value[0] = rs1.getInt("count");
            System.out.println("1");
            rs1.close();

            ResultSet rs2 = st.executeQuery("select count(*)AS count from crce.customer where city='chennai' and status='approved'");
            rs2.next();
            value[1] = rs2.getInt("count");
            System.out.println("2");
            rs2.close();

            ResultSet rs3 = st.executeQuery("select count(*)as count from crce.customer where city='delhi' and status='approved'");
            rs3.next();
            value[2] = rs3.getInt("count");
            System.out.println("3");
            rs3.close();

            ResultSet rs4 = st.executeQuery("select count(*)as count from crce.customer where city='kolkata' and status='approved'");
            rs4.next();
            value[3] = rs4.getInt("count");
            System.out.println("4");
            rs4.close();
                              

            final DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Mumbai\n"+value[0], new Double(value[0]));
            data.setValue("Chennai\n"+value[1], new Double(value[1]));
            data.setValue("Delhi\n"+value[2], new Double(value[2]));
            data.setValue("Kolkata\n"+value[3], new Double(value[3]));

            
            JFreeChart chart = ChartFactory.createPieChart("Registered Customers from Metro Cities", data, true, true, false);


            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/resources/images/charts/regCustomerCities.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return true;
    }
     
     
    
       public boolean distributorCities() {

        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();

            int value[] = new int[10];
            System.out.println("");
            ResultSet rs1 = st.executeQuery("select count(*)AS count from crce.distributor where city_service='mumbai' and verified='true'");
            rs1.next();
            value[0] = rs1.getInt("count");
            System.out.println("1");
            rs1.close();

            ResultSet rs2 = st.executeQuery("select count(*)AS count from crce.distributor where city_service='chennai' and verified='true'");
            rs2.next();
            value[1] = rs2.getInt("count");
            System.out.println("2");
            rs2.close();

            ResultSet rs3 = st.executeQuery("select count(*)as count from crce.distributor where city_service='delhi' and verified='true'");
            rs3.next();
            value[2] = rs3.getInt("count");
            System.out.println("3");
            rs3.close();

            ResultSet rs4 = st.executeQuery("select count(*)as count from crce.distributor where city_service='kolkata' and verified='true'");
            rs4.next();
            value[3] = rs4.getInt("count");
            System.out.println("4");
            rs4.close();
                              

            final DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Mumbai\n"+value[0], new Double(value[0]));
            data.setValue("Chennai\n"+value[1], new Double(value[1]));
            data.setValue("Delhi\n"+value[2], new Double(value[2]));
            data.setValue("Kolkata\n"+value[3], new Double(value[3]));

            
            JFreeChart chart = ChartFactory.createPieChart("Distributors in Metro Cities", data, true, true, false);


            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File file1 = new File("C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/resources/images/charts/distributorCities.png");
        //   final File file1 = new File("E:/CreatingProjects/Project/Implementation/WebApplication1/web/resources/images/charts/distributorCities.png");
            
            
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return true;
    }
     
     
     
     
     
     
     
     
     
     
     
     
     

  
  
    
    
    
    
  
 
  
  public static void main(String sss[])throws Exception{
      
      ChartDAO dao=new ChartDAO();
     // dao.ChartMetroCities();
  }
  
}
