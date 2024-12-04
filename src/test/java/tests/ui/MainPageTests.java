package tests.ui;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static io.qameta.allure.Allure.step;


@Owner("Andrei Drazdouski")
@Feature("Main page tests")
@Tags({@Tag("ui"), @Tag("mainpage")})
public class MainPageTests extends TestBase {

    @ParameterizedTest(name = "The header contains the following sections {0} ")
    @MethodSource("pages.MainPage#checkLinksAtHeaderContainer")
    @DisplayName("Check for the logo and links in the header")
    void contentHeaderTest(List<String> expectedLinks) {
        step("Open main page", () -> mainPage.openPage());
        step("Check logo", () -> mainPage.checkLogo());
        step("Check links at header", () -> mainPage.checkLinksAtHeaderContainer(expectedLinks));
        step("Check that the right header container contains", () -> mainPage.checkHeaderContainerRight());
    }

    @Test
    @DisplayName("Check the visibility of the bentoBanner")
    void bentoBannerTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Check bentoBanner", () -> mainPage.bentoBannerVisible());
    }

    @Test
    @DisplayName("Check video-background at bentoBanner")
    void videoBackgroundAtBentoBannerTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Check video at bentoBanner", () -> mainPage.bentoBannerVideo());
    }

    @Test
    @DisplayName("Check secondCard text and image style")
    void secondCardAtBentoBannerTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Check secondCard at bentoBanner", () -> mainPage.bentoBannerSecondCard());
    }

    @Test
    @DisplayName("Check thirdCard text and image style")
    void thirdCardAtBentoBannerTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Check thirdCard at bentoBanner", () -> mainPage.bentoBannerThirdCard());
    }

    @Test
    @DisplayName("Check fourthCard text and image style")
    void fourthCardAtBentoBannerTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Check fourthCard at bentoBanner", () -> mainPage.bentoBannerFourthCard());
    }

    @Test
    @DisplayName("Check fifthCard text and image style")
    void fifthCardAtBentoBannerTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Check fifthCard at bentoBanner", () -> mainPage.bentoBannerFifthCard());
    }

    @Test
    @DisplayName("Check if the search input works")
    void searchInputWorks() {
        step("Open main page", () -> mainPage.openPage());
        step("Click to searchInput", () -> mainPage.searchWork());
    }

    @Test
    @DisplayName("Check result of searching")
    void searchResultOfSearching() {
        step("Open main page", () -> mainPage.openPage());
        step("Click to searchInput", () -> mainPage.searchWork());
        step("Check search result", () -> mainPage.searchResult());
    }
}
