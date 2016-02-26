<%-- 
    Document   : topmenu
    Created on : Feb 24, 2012, 10:25:24 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
<link rel="stylesheet" href="../resources/css/smartmenu.css" type="text/css"/>
<script type="text/javascript" src="../resources/js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="../resources/js/smartmenu.js"></script> 
<script type="text/javascript">
    jQuery(window).ready(function(){
        jQuery("#navigation").Smartmenu({animationDuration: 350});
    });
</script>

        <!-- jQuery validation -->

<link rel="stylesheet" href="../resources/css/validationEngine.jquery.css" type="text/css"/>
<link rel="stylesheet" href="../resources/css/template.css" type="text/css"/>
<script src="../resources/js/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8"></script>
<script src="../resources/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
        
        <script>
    jQuery(document).ready(function(){
        // binds form submission and fields to the validation engine
        jQuery("#formID").validationEngine({autoHidePrompt:true});
    });

    /**
     *
     * @param {jqObject} the field where the validation applies
     * @param {Array[String]} validation rules for this field
     * @param {int} rule index
     * @param {Map} form options
     * @return an error string if validation failed
     */
    function checkHELLO(field, rules, i, options){
        if (field.val() != "HELLO") {
            // this allows to use i18 for the error msgs
            return options.allrules.validate2fields.alertText;
        }
    }
</script>

    </head>
<body>
<!-- MENU STARTS HERE -->
<div id="navigation" class="smartmenu">
    <ul>
        <li>
            <s:if test="#session.user==null">
                <a href="<s:url action="HomePage" namespace="/others"/>">Home</a>
            </s:if>
            <s:if test="#session.user!=null">
                <s:if test="#session.user.logintype=='distributor'">
                    <a href="<s:url action="DisHomePage" namespace="/distributor"/>">Home</a>
                </s:if>
                <s:if test="#session.user.logintype=='admin'">
                    <a href="<s:url action="AdminHome" namespace="/admin"/>">Home</a>
                </s:if>
                <s:if test="#session.user.logintype=='user'">
                    <a href="<s:url action="CusHome" namespace="/customer"/>">Home</a>
                </s:if>
            </s:if>
        </li>
        <li>
            <a href="">About Us</a>
            <ul>
                <li>
                    <a href="<s:url action="OverviewPage" namespace="/static"/>">Overview</a>
                </li>
                <li>
                    <a href="<s:url action="MissionPage" namespace="/static"/>">Mission and Vision</a>
                </li>
                <li>
                    <a href="<s:url action="AwardsPage" namespace="/static"/>">Awards and Acolades</a>
                </li>
                
            </ul>
        </li>
        <li>
            <a href="">Products</a>
            <ul>
                <li>
                    <a href="<s:url action="IndusPage" namespace="/static"/>">Industrial LPG</a>
                </li>
                <li>
                    <a href="<s:url action="PipedPage" namespace="/static"/>">Piped LPG</a>
                </li>
                <li>
                    <a href="<s:url action="AutoPage" namespace="/static"/>">Auto LPG</a>
                </li>
                <li>
                    <a href="<s:url action="MetalPage" namespace="/static"/>">Metal Cutting Gas</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="">Customer Care</a>
            <ul>
                
                <li>
                    <a href="<s:url action="CusrelPage" namespace="/static"/>">Customer Relation Centers</a>
                </li>
                <li>
                    <a href="<s:url action="EmerPage" namespace="/static"/>">Emergency Service Cell</a>
                </li>
                <li>
                    <a href="<s:url action="DisLocatorPage" namespace="/static"/>">Distributor Locator</a>
                </li>
            </ul>
        </li>
        
        <li>
            <a href="<s:url action="faq" namespace="/general"/>">FAQs</a>
        </li>
        <li>
            <a href="">Contact Us</a>
        </li>
        <s:if test="#session.user==null">
            <li>
                <a href="<s:url action="DisLoginPage" namespace="/others"/>">Distributors Login</a>
            </li>
        </s:if>
    </ul>
</div>
</body>
</html>