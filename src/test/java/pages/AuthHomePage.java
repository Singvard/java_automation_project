package pages;

import elements.AuthShopMenu;

public class AuthHomePage extends HomePage {
    private final AuthShopMenu shopMenu;

    public AuthHomePage() {
        this.shopMenu = new AuthShopMenu();
    }

    public AuthHomePage verifyPageIsLoaded() {
        super.verifyPageLoad();
        shopMenu.verifyVisibility();
        return this;
    }

    public AuthHomePage verifyLogin(String login) {
        shopMenu.verifyLoggedText(login);
        return this;
    }

    public DeletedAccountPage deleteAccount() {
        shopMenu.clickDeleteAccount();
        return new DeletedAccountPage();
    }
}
