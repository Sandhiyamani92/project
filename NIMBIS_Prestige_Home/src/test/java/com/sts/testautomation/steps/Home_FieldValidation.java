package com.sts.testautomation.steps;


import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.NIMBIS_Login;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Client;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Home;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Home_FieldValidation extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private ExcelHandler EH;
    private String Sheet;



    @Parameters({"URL", "Device","NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device, String datasheet) {
        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = datasheet ;

            //Loop runs through all the Nodes in the Grid and performs the tests on them
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
    public void Login(String URL) throws Exception {
        url = URL;

        nimbisLogin = new NIMBIS_Login(testB,Device);

        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        EH = new ExcelHandler(Sheet, "LoginDetails", 0, 0);
        nimbisLogin.enterUsername(EH.getCellValueSpecific(1,"Username"));
        nimbisLogin.clickContinueBtn();
        nimbisLogin.enterPassword(EH.getCellValueSpecific(1,"Password"));
        nimbisLogin.clickSignInBtn();
        Thread.sleep(6000);

    }

    @Parameters({"URL"})
    @Test(priority = 1, description = "Add Home Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;

        EH = new ExcelHandler(Sheet, "Home Test Cases", 0, 0);

        nimbisLogin = new NIMBIS_Login(testB,Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB,Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB,Device);
        elementFunctionality = new ElementFunctionality(testB,Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB,Device);

        for(int i = 1 ; i < 2 ; i ++){
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
           JavascriptExecutor js = (JavascriptExecutor) testB;
            //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            nimbisUserNavigation.clickNextBtn();
            nimbisUserNavigation.clickOpenQuote();
            Thread.sleep(2000);
            nimbisUserNavigation.clickCoverBtn();
            nimbisUserNavigation.clickHomeCover();
            Thread.sleep(2000);
            nimbisUserNavigation.clickAddNewItemBtn();

            Thread.sleep(6000);
            nimbisUserNavigation.changeFocus2();
            nimbisPrestigeHome.enterHomeSumInsured(EH.getCellValueSpecific(i,"Sum insured"));
            nimbisPrestigeHome.clickCoverTypeDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of Cover"));

            nimbisPrestigeHome.clickTypeOfHomeDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of Home"));

            if(EH.getCellValueSpecific(i,"Type of Cover").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickDaysUnoccupied90Days();
            }

            nimbisPrestigeHome.clickTypeOfWallConstructionDropDown();
            Thread.sleep(1000);
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of wall construction"));

            nimbisPrestigeHome.clickTypeOfRoofConstructionDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of roof construction"));

            if(EH.getCellValueSpecific(i,"Lightning Conductor (SABS)").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickLightningConductorSABS();
            }
            if(EH.getCellValueSpecific(i,"Fire retardant (SABS)").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickFireRetardantSABS();
            }
            if(EH.getCellValueSpecific(i,"Surge Protection (SANS)").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickSurgeProtectionSANS();
            }


            nimbisPrestigeHome.clickResidenceTypeDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Residence Type"));

            nimbisPrestigeHome.clickUseOfPremisesDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Use of premises"));
            // elementFunctionality.scrollToElementBrowser(testB.findElement(By.xpath("")));
            captureTestCaseScreenshotCoverDetail( i);

            Thread.sleep(1000);
            nimbisPrestigeHome.enterNoOfElectricGeyser(EH.getCellValueSpecific(i,"No. of electric geysers"));
            Thread.sleep(1000);
            nimbisPrestigeHome.enterNoOfGasGeysers(EH.getCellValueSpecific(i,"No. of heat pump geysers"));
            Thread.sleep(1000);
            nimbisPrestigeHome.enterNoOfHeatPumpGeysers(EH.getCellValueSpecific(i,"No. of gas geysers"));
            Thread.sleep(1000);
            nimbisPrestigeHome.enterNoOfSolarGeysers(EH.getCellValueSpecific(i,"No. of solar geysers"));

            // elementFunctionality.scrollToElementBrowser(testB.findElement(By.xpath("//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7224']")));
            // elementFunctionality.scrollByPercentage(30.0, "DOWN");
            Thread.sleep(3000);

            if(EH.getCellValueSpecific(i,"Thatch or non-standard structure more than 15% of main building ").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickThatch15OfMainBuilding();
            }

            //nimbisPrestigeHome.clickIsFinanced();

            nimbisPrestigeHome.clickNCB_DropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"NCB"));

            if(EH.getCellValueSpecific(i,"Renewable energy equipment").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickRenewableEnergyEquipment();
            }


            Thread.sleep(1000);
            nimbisPrestigeHome.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(i,"Years of previous uninterrupted buildings insurance cover"));

            if(EH.getCellValueSpecific(i,"Increased risk business type").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickIncreasedRiskBusinessType();
            }
            if(EH.getCellValueSpecific(i,"Plot, smallholding or farm").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickPlotSmallHoldingOrFarm();
            }
            if(EH.getCellValueSpecific(i,"Commune)").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickCommune();
            }
            if(EH.getCellValueSpecific(i,"Within 100m of a water body").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickWithin100mOfaWaterBody();
            }
            captureTestCaseScreenshotDisclosures(i);





            if(EH.getCellValueSpecific(i,"Burglar bars on all opening windows").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickBurglarBarsOpeningWindows();
            }
            if(EH.getCellValueSpecific(i,"Alarm linked to armed response").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickAlarmLinkedToArmedResponse();
            }


            Thread.sleep(1000);
            nimbisPrestigeHome.clickElectricFence_DropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Electric Fence"));
            Thread.sleep(1000);
            if(EH.getCellValueSpecific(i,"24 hour security guard").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickTwentyFourHourSecurityGuard();
            }
            if(EH.getCellValueSpecific(i,"Access controlled area").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickAccessControlledArea();
            }
            if(EH.getCellValueSpecific(i,"All doors protected by security gates").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickAllDoorsProtectedBySecurityGates();
            }

            Thread.sleep(1000);
            nimbisPrestigeHome.clickPerimeterProtection_DropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Perimeter protection"));
            Thread.sleep(1000);
            if(EH.getCellValueSpecific(i,"High-security estate/complex").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickHighSecurityEstateComplex();
            }
            if(EH.getCellValueSpecific(i,"CCTV camera").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickCCTVCamera();
            }
            if(EH.getCellValueSpecific(i,"Laser beams in garden").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickLaserBeamsInGarden();
            }
            captureTestCaseScreenshotSecurity(i);
            Thread.sleep(1000);


            js.executeScript("window.scrollTo(20, document.body.scrollHeight);");
            Thread.sleep(3000);
            nimbisPrestigeHome.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i,"Number of Building claims in the last 12 months, excluding geyser damage"));
            nimbisPrestigeHome.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i,"Number of Buildings claims in the last 25 to 36 months, excluding geyser damage"));
            nimbisPrestigeHome.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i,"Number of Building claims in the last 13 to 24 months, excluding geyser damage"));

            nimbisPrestigeHome.enterAdditionalExcess_Txt("0");

            nimbisPrestigeHome.clickBasicExcessDropDown();
            Thread.sleep(1000);
            nimbisUserNavigation.selectOptionExcess(EH.getCellValueSpecific(i,"Basic Excess"));

            captureTestCaseScreenshotExcess(i,"Basic Excess", "Basic Excess");

            if(EH.getCellValueSpecific(i,"Power surge").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickPowerSurge();
                nimbisPrestigeHome.clickPowerSurgeSumInsuredDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Power surge Sum Insured"));
            }
            if(EH.getCellValueSpecific(i,"Power surge").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickPowerSurgeMainCoverSumInsured();
            }
            captureTestCaseScreenshotPowerSurge(i, "Power surge", "Power surge Sum Insured");
            if(EH.getCellValueSpecific(i,"Garden and landscaping - extended cover").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickGardenAndLandscapingExtendedCover();
                nimbisPrestigeHome.clickGardenAndLandscapingSumInsuredDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Garden and landscaping - extended cover Sum Insured"));
            }
            Thread.sleep(1000);
            captureTestCaseScreenshotLandScaping(i, "Garden and landscaping - extended cover", "Garden and landscaping - extended cover Sum Insured");
            Thread.sleep(1000);
            if(EH.getCellValueSpecific(i,"Subsidence, landslip or ground heave - extended cover").equalsIgnoreCase("Yes")){
                nimbisPrestigeHome.clickSubsidenceLandslipOrGroundHeaveExtendedCove();
            }

            nimbisUserNavigation.clickCalculatePremiumBtn();
            Thread.sleep(7000);
           // nimbisUserNavigation.changeFocusToAlert();
            nimbisUserNavigation.clickPopUpOkRateBtn();
            Thread.sleep(1000);
           // nimbisUserNavigation.changeFocus2();
            Thread.sleep(1000);
            nimbisUserNavigation.clickSaveBtn();

            nimbisUserNavigation.changeFocusToBrowser();
            Thread.sleep(3000);
        }















        }

    public void captureTestCaseScreenshotCoverDetail(int i) {
        String[] RatingInfoFields = new String[]{"Type of Home", "Unoccupied for more than 90 days", "Type of roof construction", "Fire retardant (SABS)", "Residence Type", "Type of wall construction", "Lightning Conductor (SABS)", "Surge Protection (SANS)", "Use of premises","No. of electric geysers","No. of heat pump geysers","No. of gas geysers","No. of solar geysers"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotDisclosures(int i) {
        String[] RatingInfoFields = new String[]{"Thatch or non-standard structure more than 15% of main building ", "NCB", "Plot, smallholding or farm", "Commune", "Renewable energy equipment", "Increased risk business type", "Within 100m of a water body"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotSecurity(int i) {
        String[] RatingInfoFields = new String[]{"Burglar bars on all opening windows", "Electric fence", "Access controlled area", "Perimeter protection", "CCTV camera", "Alarm linked to armed response", "24 hour security guard","All doors protected by security gates","High-security estate/complex","Laser beams in garden"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotDetails(int i) {
        String[] RatingInfoFields = new String[]{"Number of Building claims in the last 12 months,  geyser damage", "Number of Buildings claims in the last 25 to 36 months, excluding geyser damage", "Number of Building claims in the last 13 to 24 months, excluding geyser damage", "Subsidence, landslip or ground heave - extended cover"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }

    }
    public void captureTestCaseScreenshotExcess(int i, String cover, String sumInsured) {
        String[] RatingInfoFields = new String[]{"Basic Excess"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + cover + " " + ", Selected option : " + EH.getCellValue(Integer.toString(i),sumInsured));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotLandScaping(int i, String cover, String sumInsured) {
        String[] RatingInfoFields = new String[]{"Garden and landscaping - extended cover"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + cover + " " + ", Selected option : " + EH.getCellValue(Integer.toString(i),sumInsured));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotPowerSurge(int i, String cover, String sumInsured) {
        String[] RatingInfoFields = new String[]{"Power surge"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + cover + " " + ", Selected option : " + EH.getCellValue(Integer.toString(i),sumInsured));
                break;
            }
        }
    }

    }

