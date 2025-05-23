package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Prestige_Contents {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Contents(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    //COVER DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_BuildingValue']")
    private WebElement contentsSumInsured_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7245_Input']")
    private WebElement  coverType_DD ;

    //RISK DETAILS
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_PropertyType_Input']")
    private WebElement  typeOfHome_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7244']")
    private WebElement daysUnoccupied90Days ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_WallType']")
    private WebElement  typeOfWallConstruction_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_Input']")
    private WebElement  typeOfRoofConstruction_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_HasLightningRod']")
    private WebElement lightningConductorSABS ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7248']")
    private WebElement fireRetardantSABS ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7247]")
    private WebElement surgeProtectionSANS ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10554_Input']")
    private WebElement residenceType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10554_Input']")
    private WebElement useOfPremises_DD ;



    // DISCLOOSURES


    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10557']")
    private WebElement thatch15OfMainBuilding ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NCB_Input']")
    private WebElement ncb_DD ;


    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10558']")
    private WebElement renewableEnergyEquipment ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10560']")
    private WebElement previousUninterruptedBuildingsInsurance_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10561']")
    private WebElement plotSmallHoldingOrFarm ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10556']")
    private WebElement increasedRiskBusinessType ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10562']")
    private WebElement commune ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10563_Input']")
    private WebElement useOfAdjoiningLand_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10577']")
    private WebElement within100mOfaWaterBody ;

    //SECURITY

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7249']")
    private WebElement burglarBarsOpeningWindows ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7250']")
    private WebElement alarmLinkedToArmedResponse ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7243_Input']")
    private WebElement electricFence_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10569']")
    private WebElement twentyFourHourSecurityGuard ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10570']")
    private WebElement accessControlledArea ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10571']")
    private WebElement allDoorsProtectedBySecurityGates  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10572_Input']")
    private WebElement perimeterProtection_DD  ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10573']")
    private WebElement highSecurityEstateComplex ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10574']")
    private WebElement cctvCamera ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10575']")
    private WebElement laserBeamsInGarden ;

    //CLAIMS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10566']")
    private WebElement numberOfClaimsLast12month_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10567']")
    private WebElement numberOfClaimsLast24month_Txt  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10568']")
    private WebElement numberOfClaimsLast36month_Txt ;

    //EXCESS OPTIONS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VoluntaryExcess']")
    private WebElement additionalExcess_Txt  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7240_Input']")
    private WebElement basicExcess_DD ;

    //EXTENSIONS

    @FindBy(xpath = "//button[@id='chkExtension3183']")
    private WebElement itemsOutAndAbout;

    @FindBy(xpath = "//button[@id='chkExtension3190']")
    private WebElement bedAndBreakfast ;

    @FindBy(xpath = "//button[@id='chkExtension3184']")
    private WebElement businessContentsExtendedCover ;

    @FindBy(xpath = "//button[@id='chkExtension3212']")
    private WebElement marqueeHire ;

    @FindBy(xpath = "//button[@id='chkExtension5664']")
    private WebElement gardenAndOutdoorItemsExtendedCover;

    //COVER DETAILS METHODS

    public void  enterContentsSumInsured( String amount) {
        if (verifyElement.verifyBrowserElementValue(contentsSumInsured_Txt, "Home Sum Insured") == 0) {
            verifyElement.sendKeys(contentsSumInsured_Txt,"Home Sum Insured",amount);
        }
    }

    public void clickCoverTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(coverType_DD, "Cover Type") == 0){
            verifyElement.clickElement(coverType_DD,"Cover Type");
        }
    }

    //RISK DETAILS METHODS

    public void clickTypeOfHomeDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfHome_DD, "Type Of Home") == 0){
            verifyElement.clickElement(typeOfHome_DD,"Type Of Home");
        }
    }

    public void clickDaysUnoccupied90Days(){
        if (verifyElement.verifyBrowserElementValue(daysUnoccupied90Days, "Unoccupied for more than 90 days") == 0){
            verifyElement.clickElement(daysUnoccupied90Days,"Unoccupied for more than 90 days");
        }
    }

    public void clickTypeOfRoofConstructionDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfRoofConstruction_DD, "Type of roof construction") == 0){
            verifyElement.clickElement(typeOfRoofConstruction_DD,"Type of roof construction");
        }
    }

    public void clickTypeOfWallConstructionDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfWallConstruction_DD, "Type of wall construction") == 0){
            verifyElement.clickElement(typeOfWallConstruction_DD,"Type of wall construction");
        }
    }

    public void clickLightningConductorSABS(){
        if (verifyElement.verifyBrowserElementValue(lightningConductorSABS, "Lightning Conductor SABS") == 0){
            verifyElement.clickElement(lightningConductorSABS,"Lightning Conductor SABS");
        }
    }

    public void clickFireRetardantSABS(){
        if (verifyElement.verifyBrowserElementValue(fireRetardantSABS, "Fire Retardant SABS") == 0){
            verifyElement.clickElement(fireRetardantSABS,"Fire Retardant SABS");
        }
    }

    public void clickSurgeProtectionSANS(){
        if (verifyElement.verifyBrowserElementValue(surgeProtectionSANS, "Surge Protection SANS") == 0){
            verifyElement.clickElement(surgeProtectionSANS,"Surge Protection SANS");
        }
    }

    public void clickResidenceTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(residenceType_DD, "Residence Type") == 0){
            verifyElement.clickElement(residenceType_DD,"Residence Type");
        }
    }

    public void clickUseOfPremisesDropDown(){
        if (verifyElement.verifyBrowserElementValue(useOfPremises_DD, "Use Of Premises") == 0){
            verifyElement.clickElement(useOfPremises_DD,"Use Of Premises");
        }
    }


    //DISCLOOSURES METHODS



    public void clickThatch15OfMainBuilding(){
        if (verifyElement.verifyBrowserElementValue(thatch15OfMainBuilding, "thatch15OfMainBuilding") == 0){
            verifyElement.clickElement(thatch15OfMainBuilding,"thatch15OfMainBuilding");
        }
    }

    public void clickNCB_DropDown(){
        if (verifyElement.verifyBrowserElementValue(ncb_DD, "NCB") == 0){
            verifyElement.clickElement(ncb_DD,"NCB");
        }
    }

    public void clickRenewableEnergyEquipment(){
        if (verifyElement.verifyBrowserElementValue(renewableEnergyEquipment, "Renewable Energy Equipment") == 0){
            verifyElement.clickElement(renewableEnergyEquipment,"Renewable Energy Equipment");
        }
    }

    public void clickPreviousUninterruptedBuildingsInsurance(String years){
        if (verifyElement.verifyBrowserElementValue(previousUninterruptedBuildingsInsurance_Txt, "Years of previous uninterrupted buildings insurance cover") == 0){
            verifyElement.sendKeys(previousUninterruptedBuildingsInsurance_Txt,"Years of previous uninterrupted buildings insurance cover",years);
        }
    }

    public void clickPlotSmallHoldingOrFarm(){
        if (verifyElement.verifyBrowserElementValue(plotSmallHoldingOrFarm, "Plot Small Holding Or Farm") == 0){
            verifyElement.clickElement(plotSmallHoldingOrFarm,"Plot Small Holding Or Farm");
        }
    }

    public void clickIncreasedRiskBusinessType(){
        if (verifyElement.verifyBrowserElementValue(increasedRiskBusinessType, "Increased Risk Business Type") == 0){
            verifyElement.clickElement(increasedRiskBusinessType,"Increased Risk Business Type");
        }
    }

    public void clickCommune(){
        if (verifyElement.verifyBrowserElementValue(commune, "Increased Risk Business Type") == 0){
            verifyElement.clickElement(commune,"Increased Risk Business Type");
        }
    }

    public void clickUseOfAdjoiningLandDropDown(){
        if (verifyElement.verifyBrowserElementValue(useOfAdjoiningLand_DD, "Use Of Adjoining Land") == 0){
            verifyElement.clickElement(useOfAdjoiningLand_DD,"Use Of Adjoining Land");
        }
    }

    public void clickWithin100mOfaWaterBody(){
        if (verifyElement.verifyBrowserElementValue(within100mOfaWaterBody, "Within 100m Of a Water Body") == 0){
            verifyElement.clickElement(within100mOfaWaterBody,"Within 100m Of a Water Body");
        }
    }

    //SECURITY METHODS

    public void clickBurglarBarsOpeningWindows(){
        if (verifyElement.verifyBrowserElementValue(burglarBarsOpeningWindows, "Burglar Bars Opening Windows") == 0){
            verifyElement.clickElement(burglarBarsOpeningWindows,"Burglar Bars Opening Windows");
        }
    }

    public void clickAlarmLinkedToArmedResponse(){
        if (verifyElement.verifyBrowserElementValue(alarmLinkedToArmedResponse, "Alarm Linked To Armed Response") == 0){
            verifyElement.clickElement(alarmLinkedToArmedResponse,"Alarm Linked To Armed Response");
        }
    }

    public void clickElectricFence_DropDown(){
        if (verifyElement.verifyBrowserElementValue(electricFence_DD, "Alarm Linked To Armed Response") == 0){
            verifyElement.clickElement(electricFence_DD,"Alarm Linked To Armed Response");
        }
    }

    public void clickTwentyFourHourSecurityGuard(){
        if (verifyElement.verifyBrowserElementValue(twentyFourHourSecurityGuard, "24 hour security guard") == 0){
            verifyElement.clickElement(twentyFourHourSecurityGuard,"24 hour security guard");
        }
    }

    public void clickAccessControlledArea(){
        if (verifyElement.verifyBrowserElementValue(accessControlledArea, "Access Controlled Area") == 0){
            verifyElement.clickElement(accessControlledArea,"Access Controlled Area");
        }
    }

    public void clickAllDoorsProtectedBySecurityGates(){
        if (verifyElement.verifyBrowserElementValue(allDoorsProtectedBySecurityGates, "All Doors Protected By Security Gates") == 0){
            verifyElement.clickElement(allDoorsProtectedBySecurityGates,"All Doors Protected By Security Gates");
        }
    }

    public void clickPerimeterProtection_DropDown(){
        if (verifyElement.verifyBrowserElementValue(perimeterProtection_DD, "Perimeter Protection") == 0){
            verifyElement.clickElement(perimeterProtection_DD,"Perimeter Protection");
        }
    }

    public void clickHighSecurityEstateComplex(){
        if (verifyElement.verifyBrowserElementValue(highSecurityEstateComplex, "High Security Estate Complex") == 0){
            verifyElement.clickElement(highSecurityEstateComplex,"High Security Estate Complex");
        }
    }

    public void clickCCTVCamera(){
        if (verifyElement.verifyBrowserElementValue(cctvCamera, "CCTV Camera") == 0){
            verifyElement.clickElement(cctvCamera,"CCTV Camera");
        }
    }

    public void clickLaserBeamsInGarden(){
        if (verifyElement.verifyBrowserElementValue(laserBeamsInGarden, "Laser Beams In Garden") == 0){
            verifyElement.clickElement(laserBeamsInGarden,"Laser Beams In Garden");
        }
    }

    //CLAIMS METHODS

    public void enterNumberOfClaimsLast12month(String claims){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast12month_Txt, "Number of Building claims in the last 12 months, excluding geyser damage") == 0){
            verifyElement.sendKeys(numberOfClaimsLast12month_Txt,"Number of Building claims in the last 12 months, excluding geyser damage",claims);
        }
    }

    public void enterNumberOfClaimsLast24month(String claims){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast24month_Txt, "Number of Building claims in the last 13 to 24 months, excluding geyser damage") == 0){
            verifyElement.sendKeys(numberOfClaimsLast24month_Txt,"Number of Building claims in the last 13 to 24 months, excluding geyser damage",claims);
        }
    }

    public void enterNumberOfClaimsLast36month(String claims){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast36month_Txt, "Number of Buildings claims in the last 25 to 36 months, excluding geyser damage") == 0){
            verifyElement.sendKeys(numberOfClaimsLast36month_Txt,"Number of Buildings claims in the last 25 to 36 months, excluding geyser damage",claims);
        }
    }

    //EXCESS METHODS

    public void enterAdditionalExcess_Txt(String amount){
        if (verifyElement.verifyBrowserElementValue(additionalExcess_Txt , "Additional Excess") == 0){
            verifyElement.sendKeys(additionalExcess_Txt ,"Additional Excess",amount);
        }
    }

    public void clickBasicExcessDropDown(){
        if (verifyElement.verifyBrowserElementValue(basicExcess_DD, "Basic Excess") == 0){
            verifyElement.clickElement(basicExcess_DD,"Basic Excess");
        }
    }

    //EXTENSIONS METHODS

    public void clickItemsOutAndAbout(){
        if (verifyElement.verifyBrowserElementValue(itemsOutAndAbout, "Items Out And About") == 0){
            verifyElement.clickElement(itemsOutAndAbout,"Items Out And About");
        }
    }

    public void clickBedAndBreakfast(){
        if (verifyElement.verifyBrowserElementValue(bedAndBreakfast, "Bed And Breakfast") == 0){
            verifyElement.clickElement(bedAndBreakfast,"Bed And Breakfast");
        }
    }

    public void clickBusinessContentsExtendedCover(){
        if (verifyElement.verifyBrowserElementValue(businessContentsExtendedCover , "Business Contents Extended Cover") == 0){
            verifyElement.clickElement(businessContentsExtendedCover ,"Business Contents Extended Cover");
        }
    }

    public void clickMarqueeHire(){
        if (verifyElement.verifyBrowserElementValue(marqueeHire, "Marquee Hire") == 0){
            verifyElement.clickElement(marqueeHire,"Marquee Hire");
        }
    }

    public void clickGardenAndOutdoorItemsExtendedCover(){
        if (verifyElement.verifyBrowserElementValue(gardenAndOutdoorItemsExtendedCover, "Garden And Outdoor Items Extended Cover") == 0){
            verifyElement.clickElement(gardenAndOutdoorItemsExtendedCover,"Garden And Outdoor Items Extended Cover");
        }
    }




}
