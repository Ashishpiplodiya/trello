package com.trello.android.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.trello.android.baseutil.BaseTest;
import com.trello.android.baseutil.InitializePages;
import com.trello.android.dataprovider.DataProviderFactory;
import com.trello.android.dataprovider.DataProviderFileRowFilter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

/**
 * 
 * Name:Trello_007
 * Description: Verify that whether user is able to move the List to the different position in the Same Board.
 * 
 * @author Ashish Piplodiya , Gaurav S.
 *
 */
public class Trello_007 extends BaseTest
{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from TrelloData where SlNo ='7'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Description:Verify that whether user is able to move the List to the different position in the Same Board")
	public void tc_Trello_007(String SlNo , String	boardName , String	listName , String	listName2 , String	listName3	, String card1	 , String card2	 , String itemName	 , String updatedBoardName	, String updatedListName	, String updatedcardName , String copyListName , String position) throws InterruptedException
	{
InitializePages pages = new InitializePages(androidDriver, ETO, actionUtil);
		

/* Login to The Application */
pages.login_Page.loginToApplication();

   /* Click on Plus Icon */
   pages.home_Page.clkPlusIcon();

   /* Click on Board Icon */
   pages.home_Page.clkBoardsIcon();

   /* Set Board Name */
   pages.home_Page.setBoardName(boardName);

   /* Click on Add List Button */
   pages.boardDashboard_page.clkAddlistBtn();

   /* Set list Name */
   pages.boardDashboard_page.setListNameTa(listName);

   /* Click Add Card Button */
   pages.boardDashboard_page.clkAddCardBtn(listName);

   /* Set Card Name */
   pages.boardDashboard_page.setCardNameTa(listName, card1);
   
   /* Set Card Name */ 
   pages.boardDashboard_page.setCardNameTa(listName, card2);

   /* Click on Add List button */
   pages.boardDashboard_page.clkAddlistBtn();

   /* Set List Name */
   pages.boardDashboard_page.setListNameTa(listName2);

   /* Click List Action */
   pages.boardDashboard_page.clkListAction(listName);

   /* Click on Move List Under List Action */
   pages.boardDashboard_page.clkMoveListLinkUnderListActions();

   /* Click on Boards Option Under Copy List */
   pages.boardDashboard_page.sltBoardsOptUnderCopyList(boardName);

   /* Click on Position Under Copy list */
   pages.boardDashboard_page.sltPositionOptUnderCopyList(position);

   /* Click on Confirm Tick Mark */
   pages.boardDashboard_page.clkConfirmTickMark();

   /* Validate position Of List */
   pages.boardDashboard_page.validateThePositionOfList(2, listName, listName2);

   /* Click List Action Under Boards */
   pages.boardDashboard_page.clkListActionsBoards();

   /* Click on Boards Setting */
   pages.boardDashboard_page.clkBoardSetting();

   /* Click on Close Boards */
   pages.boardDashboard_page.clkCloseBoards(boardName);
		
   /* Click on Back button */
	pages.boardDashboard_page.clkBackButton();
	
	/* Logout From The Application */
	pages.home_Page.logoutFromTheApplication();
	}

}
