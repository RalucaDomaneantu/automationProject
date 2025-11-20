package tests;

import helpMethods.ElementsMethods;
import helpMethods.FrameMethods;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;
import sharedData.SharedData;

public class Frames extends SharedData {

    ElementsMethods elementsMethods;
    FrameMethods frameMethods;

    @Test

    public void metodaTest() {

        elementsMethods = new ElementsMethods(getDriver());
        frameMethods = new FrameMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        FramesPage frames = new FramesPage(getDriver());
        frames.clickFramesButton();

        frameMethods.switchToSpecificFrame("frame1");

        frameMethods.switchToParent();

        frameMethods.switchToSpecificFrame("frame2");
    }
}