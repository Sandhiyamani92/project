package com.sts.testautomation.steps;


import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.server.handler.interactions.touch.Down;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

import java.util.concurrent.TimeUnit;

public class Contents extends BaseTest{

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;



    @Parameters({"URL", "Device"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device) {
        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;

    for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
        if (currentNode.getKey().equals(Device)) {
            //Android
            if (currentNode.getValue() instanceof AndroidNode) {
                try {

                    //Focus here

                } catch (Exception e) {
                    Assert.fail();
                    e.printStackTrace();

                }

            }

            //iOS
            else if (currentNode.getValue() instanceof IOSNode) {
                try {

                }    //Here

                catch (Exception e) {
                    e.printStackTrace();
                    Assert.fail();


                }


            }

            //Browsers
            else if (currentNode.getValue() instanceof BrowserNode) {
                try {
                    BrowserNode bNode = ((BrowserNode) currentNode.getValue());
                    System.out.println("Tial Test started on " + currentNode.getKey());




                    WebDriverManager.edgedriver().setup();
                    testB = new EdgeDriver();
                    testB.get(URL);
                    testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    testB.manage().window().maximize();


                } catch (Exception e) {
                    Assert.fail();
                    e.printStackTrace();

                }

            }

        }
    }


} catch (Exception e) {
        Assert.fail();
            e.printStackTrace();

        }

                }

@Parameters({"URL"})
@Test(priority = 0, description = "Logging in to NIMBIS")
public void Login(String URL) throws InterruptedException {
    url = URL;

    nimbisLogin = new NIMBIS_Login(testB,Device);

    //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    nimbisLogin.enterUsername("nathaniel.smith");
    nimbisLogin.clickContinueBtn();
    nimbisLogin.enterPassword("9c)i[3m#080LsPA");
    nimbisLogin.clickSignInBtn();
    Thread.sleep(6000);
}


    @Parameters({"URL"})
    @Test(priority = 1, description = "Create Client")
    public void CreateClient(String URL) throws Exception {
        url = URL;


        nimbisLogin = new NIMBIS_Login(testB,Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB,Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB,Device);
        elementFunctionality = new ElementFunctionality(testB,Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB,Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB,Device);

        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
       // JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        nimbisUserNavigation.clickCoverBtn();
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();

        nimbisPrestigeContents.enterContentsSumInsured("10000");

        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption("Full Cover");

        nimbisPrestigeContents.clickTypeOfHomeDropDown();
        nimbisUserNavigation.selectOption("Flat Above Ground");

        nimbisPrestigeContents.clickDaysUnoccupied90Days();

        nimbisPrestigeContents.clickTypeOfRoofConstructionDropDown();
        nimbisUserNavigation.selectOption("Standard");

        nimbisPrestigeContents.clickTypeOfWallConstructionDropDown();
        nimbisUserNavigation.selectOption("Standard");

        nimbisPrestigeContents.clickLightningConductorSABS();

        nimbisPrestigeContents.clickFireRetardantSABS();

        nimbisPrestigeContents.clickSurgeProtectionSANS();

        nimbisPrestigeContents.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption("Main Residence");

        nimbisPrestigeContents.clickUseOfPremisesDropDown();
        nimbisUserNavigation.selectOption("Residential only");


        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption("0");

        nimbisPrestigeContents.clickIncreasedRiskBusinessType();

        nimbisPrestigeContents.clickThatch15OfMainBuilding();

        nimbisPrestigeContents.clickRenewableEnergyEquipment();

      //  nimbisPrestigeContents.enter

        nimbisPrestigeContents.clickPlotSmallHoldingOrFarm();

        nimbisPrestigeContents.clickWithin100mOfaWaterBody();

        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption("None");

        nimbisPrestigeContents.clickBurglarBarsOpeningWindows();

        nimbisPrestigeContents.clickAlarmLinkedToArmedResponse();

        nimbisPrestigeContents.clickTwentyFourHourSecurityGuard();

        nimbisPrestigeContents.clickAccessControlledArea();

        nimbisPrestigeContents.clickAllDoorsProtectedBySecurityGates();

        nimbisPrestigeContents.clickPerimeterProtection_DropDown();
        nimbisUserNavigation.selectOption("Wire fence");

        nimbisPrestigeContents.clickHighSecurityEstateComplex();

        nimbisPrestigeContents.clickCCTVCamera();

        nimbisPrestigeContents.clickLaserBeamsInGarden();

        nimbisPrestigeContents.enterNumberOfClaimsLast12month("0");

        nimbisPrestigeContents.enterNumberOfClaimsLast24month("0");

        nimbisPrestigeContents.enterNumberOfClaimsLast36month("0");

      //  nimbisPrestigeContents.clickBasicExcessDropDown();
        //nimbisUserNavigation.selectOption("1 000");

        nimbisPrestigeContents.clickBedAndBreakfast();
        nimbisPrestigeContents.clickBusinessContentsExtendedCover();
        nimbisPrestigeContents.clickMarqueeHire();
        nimbisPrestigeContents.clickGardenAndOutdoorItemsExtendedCover();

    }



}
