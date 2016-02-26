/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mybeans;

/**
 *
 * @author Shirish
 */
public class Transfer {


    String c_id;
    String d_id;
    String newaddr;
    String newcity;
    String newstate;
    

    public void setC_id(String c_id)
    {this.c_id=c_id;}

    public void setD_id(String d_id)
    {this.d_id=d_id;}

    public void setNewaddr(String newaddr)
    {this.newaddr=newaddr;}

    public void setNewcity(String newcity)
    {this.newcity=newcity;}

    public void setNewstate(String newstate)
    {this.newstate=newstate;}


    public String getC_id()
    {return c_id;}

    public String getNewcity()
    {return newcity;}

    public String getD_id()
    {System.out.println("getdid "+d_id);return d_id;}

    public String getNewaddr()
    {return newaddr;}

    public String getNewstate()
    {return newstate;}


}
