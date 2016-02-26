/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

/**
 *
 * @author shashi
 */
import java.sql.*;

public class CreateTableDB2 extends BaseDAO {

    public static void main(String sss[]) throws SQLException, ClassNotFoundException {


        BaseDAO b = new BaseDAO();
        Connection con = b.getConnection();

        Statement st = con.createStatement();
/*
// 10 TABLES
//18      
        String admin = "create table crce.admin("
                + "a_id varchar(7)  NOT NULL PRIMARY KEY ,"
                + "f_name varchar(30) not null,"
                + "m_name varchar(30) not null,"
                + "l_name varchar(30)not null,"
                + "date_of_birth varchar(30)not null,"
                + "age varchar(3)not null,"
                + "gender varchar(10)not null,"
                + "address varchar(100)not null,"
                + "landmark varchar(50)not null,"
                + "pin_code integer not null,"
                + "city varchar(50)not null,"
                + "state varchar(50)not null,"
                + "mobile_no integer not null,"
                + "landline_no varchar(20),"
                + "email varchar(50)not null,"
                + "username varchar(50) not null,"
                + "password varchar(50)not null,"
                + "reg_date varchar(20)not null   )";

        boolean a = st.execute(admin);
        System.out.println("admin : " + a);


// 24
        String dist = " CREATE TABLE crce.distributor("
                + "d_id INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE )PRIMARY KEY,"
                + "f_name VARCHAR(30) NOT NULL,"
                + "m_name varchar(30) not null,"
                + "l_name varchar(30) not null,"
                + "date_of_birth VARCHAR(20) NOT NULL,"
                + "age integer NOT NULL,"
                + "gender varchar(10) not null,"
                + "address VARCHAR(100) NOT NULL,"
                + "landmark VARCHAR(50) NOT NULL,"
                + "pin_code integer not null,"
                + "city VARCHAR(50) NOT NULL,"
                + "state VARCHAR(20) NOT NULL,"
                + "mobile_no integer NOT NULL,"
                + "landline_no VARCHAR(15),"
                + "email VARCHAR(50) NOT NULL,"
                + "id1 varchar(100) not null,"
                + "id2 varchar(100) not null,"
                + "id3 varchar(100) not null,"
                + "city_service varchar(50) not null,"
                + "verified varchar(10),"
                + "agency_name varchar(50),"
                + "username varchar(50), "
                + "password varchar(30),"
                + "reg_date varchar(30) not null )";
        //	+"DATA CAPTURE NONE ;";
        boolean d = st.execute(dist);
        System.out.println("distributor : " + d);

        
       
        
//17
        String cust = "CREATE TABLE CRCE.CUSTOMER ( C_ID INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE ) , D_ID INTEGER  NOT NULL , F_NAME VARCHAR (30)  NOT NULL , M_NAME VARCHAR (30)  NOT NULL , L_NAME VARCHAR (30)  NOT NULL , DATE_OF_BIRTH VARCHAR (15)  NOT NULL , AGE INTEGER  NOT NULL , ADDRESS VARCHAR (100)  NOT NULL , LANDMARK VARCHAR (50)  NOT NULL , CITY VARCHAR (30)  NOT NULL , CONTACT_NO1 VARCHAR (20)  NOT NULL , CONTACT_NO2 VARCHAR (20) , MOBILE_NO VARCHAR (20)  NOT NULL , EMAIL VARCHAR (50)  NOT NULL , NO_OF_CYLINDERS INTEGER  NOT NULL , CUSTOMER_TYPE VARCHAR (30)  NOT NULL  , STATUS VARCHAR (20) , CONSTRAINT CC1329730665794 PRIMARY KEY ( C_ID) , CONSTRAINT CC1329730674376 FOREIGN KEY (D_ID) REFERENCES CRCE.DISTRIBUTOR (D_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION )";
        boolean c = st.execute(cust);
        System.out.println("customer : " + c);
         
 
// 6
        String proof = "CREATE TABLE CRCE.PROOF ( P_ID INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE ), C_ID INTEGER ,D_ID INTEGER , PROOF_DETAILS1 VARCHAR (100)  NOT NULL , PROOF_DETAILS2 VARCHAR (100) , PROOF_DETAILS3 VARCHAR (100)  , CONSTRAINT CC1329731682466 PRIMARY KEY (P_ID) , CONSTRAINT CC1329731695454 FOREIGN KEY (D_ID) REFERENCES CRCE.DISTRIBUTOR (D_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION , CONSTRAINT CC1329731707782 FOREIGN KEY (C_ID) REFERENCES CRCE.CUSTOMER (C_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION )";
	boolean pr=st.execute(proof);
	System.out.println ("proof: "+pr);
//7
        String register = "CREATE TABLE CRCE.USERTABLE ( USERNAME VARCHAR (50)  NOT NULL , PASSWORD VARCHAR (30)  NOT NULL , C_ID INTEGER  NOT NULL , DATE_OF_REG VARCHAR (15)  NOT NULL , MOBILE_NO VARCHAR (15)  NOT NULL  ,M_VERIFY VARCHAR (10), email varchar(50)not null, CONSTRAINT CC1329733734747 PRIMARY KEY ( USERNAME) , CONSTRAINT CC1329733739403 FOREIGN KEY (C_ID) REFERENCES CRCE.CUSTOMER (C_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION )";
        boolean reg = st.execute(register);
        System.out.println("register : " + reg);

// 8
        String order = "CREATE TABLE CRCE.ORDERTABLE ( O_ID INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE ) , C_ID INTEGER , D_ID INTEGER , O_DATE VARCHAR (15)  NOT NULL , NO_OF_CYLINDERS INTEGER  NOT NULL , DELIVER_DATE VARCHAR (15) , CANCEL_DATE VARCHAR (15)  , STATUS VARCHAR (30) NOT NULL, CONSTRAINT CC1329732036365 PRIMARY KEY ( O_ID) , CONSTRAINT CC1329732040731 FOREIGN KEY (D_ID) REFERENCES CRCE.DISTRIBUTOR (D_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION , CONSTRAINT CC1329732060379 FOREIGN KEY (C_ID) REFERENCES CRCE.CUSTOMER (C_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION )";
        boolean o = st.execute(order);
        System.out.println("order : " + o);
	
        String transfer="CREATE TABLE CRCE.TRANSFER ( T_ID INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1, NO CACHE ) , C_ID INTEGER  NOT NULL , D_ID INTEGER  NOT NULL , NEWADDRESS VARCHAR (200)  NOT NULL , NEWCITY VARCHAR (50)  NOT NULL , NEWSTATE VARCHAR (50)  NOT NULL , NEWLANDMARK VARCHAR (100), VERIFIED VARCHAR (10)  NOT NULL, CONSTRAINT CC1332255818570 PRIMARY KEY ( T_ID) ) ";
        boolean t = st.execute(transfer);
        System.out.println("transfer : " + t);         
  */                 
        String orderProduct="CREATE TABLE CRCE.ORDERPRODUCT(  OP_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH +11  INCREMENT BY +1  MINVALUE +11  MAXVALUE +2147483647 NO CYCLE NO CACHE NO ORDER ) , C_ID INTEGER NOT NULL , D_ID INTEGER NOT NULL , P_ID INTEGER NOT NULL , ORDER_DATE VARCHAR(50) NOT NULL , DELIVERY_DATE VARCHAR(50) NOT NULL , CANCEL_DATE VARCHAR(50) NOT NULL , STATUS VARCHAR(15) NOT NULL , QUANTITY VARCHAR(15) NOT NULL , PRICE INTEGER NOT NULL, CONSTRAINT CC1334994708498 PRIMARY KEY (OP_ID), CONSTRAINT CC1334994714409 FOREIGN KEY (C_ID) REFERENCES CRCE.CUSTOMER (C_ID) ON DELETE NO ACTION ON UPDATE NO ACTION ENFORCED ENABLE QUERY OPTIMIZATION, CONSTRAINT CC1334994739861 FOREIGN KEY (D_ID) REFERENCES CRCE.DISTRIBUTOR (D_ID) ON DELETE NO ACTION ON UPDATE NO ACTION ENFORCED ENABLE QUERY OPTIMIZATION, CONSTRAINT CC1334994751305 FOREIGN KEY (P_ID) REFERENCES CRCE.PRODUCT(P_ID) ON DELETE NO ACTION ON UPDATE NO ACTION ENFORCED ENABLE QUERY OPTIMIZATION )";   
        boolean op = st.execute(orderProduct);
        System.out.println("orderProduct : " + op);
/*
//6
        String product = "create table crce.product("
                + "p_id INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE )PRIMARY KEY,"
                + "name varchar(50) not null,"
                + "details varchar(100),"
                + "price varchar(10) not null,"
                + "quantity integer,"
                + "sold_pieces integer )";
        boolean prod = st.execute(product);
        System.out.println("product : " + prod);

// 3
        String faq="create table crce.faq("
                +"faq_id INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE )PRIMARY KEY,"
                +"question varchar(500) not null,"
                +"answer varchar(1000)  )";
        boolean fq = st.execute(faq);
        System.out.println("faq : " + fq);
    
// 2        
        String report = "create table crce.report("
                + "year varchar(10),"
                + "value varchar(10) )";
        boolean rep = st.execute(report);
        System.out.println("report : " + rep);



     
     

 

// 9
        String fb = "CREATE TABLE CRCE.FEEDBACK ( F_ID INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE ) , TYPE VARCHAR (30)  NOT NULL , CATEGORY VARCHAR (30)  NOT NULL , DESCRIPTION VARCHAR (1000)  NOT NULL , EMAIL VARCHAR (50)  NOT NULL , C_ID INTEGER  NOT NULL , D_ID INTEGER  NOT NULL , REFERENCE_NO VARCHAR (25) , REPLY VARCHAR (1000)  , CONSTRAINT CC1333360227862 PRIMARY KEY ( F_ID) , CONSTRAINT CC1333360238963 FOREIGN KEY (C_ID) REFERENCES CRCE.CUSTOMER (C_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION  )" ;

        boolean f = st.execute(fb);
        System.out.println("feedback : " + f);
   
//4       
        String geo="CREATE TABLE CRCE.GEOLOCATION ( ID BIGINT  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1, NO CACHE ) , D_ID BIGINT  NOT NULL , LATTITUDE VARCHAR (30)  NOT NULL , LONGITUDE VARCHAR (30)  NOT NULL  , CONSTRAINT CC1333356689079 PRIMARY KEY ( ID) , CONSTRAINT CC1333356695629 FOREIGN KEY (D_ID) REFERENCES CRCE.DISTRIBUTOR (D_ID)  ON DELETE CASCADE ON UPDATE NO ACTION ENFORCED  ENABLE QUERY OPTIMIZATION  )";
        boolean g = st.execute(geo);
        System.out.println("geolocation : " + g);
        
  */    
        
 /*       
         
// schema : message        
        
           
        MessageBaseDAO m = new MessageBaseDAO();
        Connection mcon = m.getConnection();

        Statement stmt = mcon.createStatement();
        


        String msgIn="create table message.messagein("
                +"id INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE )PRIMARY KEY,"
                +"sender varchar(20),"
                +"receivetime varchar(100),"
                +"message varchar(160)   )";
        boolean min=stmt.execute(msgIn);
         System.out.println("msgin : " + min);
        
        String msgOut="create table message.messageout("
                +"id INTEGER  NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 11, INCREMENT BY 1, NO CACHE )PRIMARY KEY,"
                +"receiver varchar(20),"
                +"sendtime varchar(20),"
                +"message varchar(160) not null,"
                +"status varchar(30)   )";
        boolean mout=stmt.execute(msgOut);
         System.out.println("msgout : " + mout);
    
  */
        
        b.closeConnection();
    }
}
