package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    @Step("Навести на пункт меню {menuItem}, дождаться появления {subMenu} и кликнуть по нему.")
    public void selectMainMenuItem(String menuItem, String subMenu){
        new MainPage().selectMainMenuItem(menuItem, subMenu);
    }
    /*@Step("Дождаться появления {subMenuItem} и кликнуть по нему")
    public void selectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }

     */

}
