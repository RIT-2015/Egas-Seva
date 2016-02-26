<%-- 
    Document   : homebody
    Created on : Feb 25, 2012, 5:47:50 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
 <s:if test="#session.user!=null">
         <s:if test="#session.user.logintype=='distributor'">
             <META HTTP-EQUIV="Refresh" CONTENT="0;URL=/egas/distributor/dishome.jsp"/>
         </s:if>
</s:if>
             
             <fieldset>
<div id="BannerRotatorFXDiv">
			<a href="http://www.adobe.com/go/getflashplayer">
				<img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" />
			</a>
		</div>
             </fieldset>