package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            logoElement = $("[data-test-id='Main-Header-Main-DesktopLogo']"),
            headerDesktopContainer = $("[data-test-id='Main-Header-Main-Desktop-container']"),
            headerDesktopContainerRight = $("[data-test-id='Main-Header-Main-Desktop-container-right']"),
            bentoBanner = $("[data-test-id='bentoBanner']"),
            fifthCard = $("[data-test-id='fifthCard']"),
            secondCard = $("[data-test-id='secondCard']"),
            thirdCard = $("[data-test-id='thirdCard']"),
            fourthCard = $("[data-test-id='fourthCard']"),
            searchPointer = $(".aOEd7f"),
            searchInput = $("[data-test-id='yandexSearchInput']"),
            searchResult = $("#ya-site-results"),
            videoBackground = $("[data-test-id='video-background-video']");


    public void openPage() {
        open(baseUrl);
    }

    public void checkLogo() {
        $(logoElement)
                .shouldBe(visible)
                .should(exist);
    }

    public void checkLinksAtHeaderContainer(List<String> expectedLinks) {
        headerDesktopContainer.$$("a")
                .filter(visible)
                .shouldHave(texts(expectedLinks));

    }

    public static Stream<Arguments> checkLinksAtHeaderContainer() {
        return Stream.of(
                Arguments.of(
                        List.of("", "ЧАСТНЫМ ЛИЦАМ", "МАЛОМУ БИЗНЕСУ И ИП", "КОРПОРАЦИЯМ", "ФИНАНСОВЫМ ОРГАНИЗАЦИЯМ",
                                "Карты", "Вклады", "Кредиты", "Ипотека", "Инвестиции", "Alfa Only", "Самозанятость",
                                "Alfa Students", "Ещё", "Стать клиентом")
                )
        );
    }

    public void checkHeaderContainerRight() {
        headerDesktopContainerRight.$(".aOEd7f").shouldBe(visible);
        headerDesktopContainerRight.$(".button__label_1yzjy").shouldHave(text("Стать клиентом"));
        headerDesktopContainerRight.$(".button__label_1yzjy.button__stretchText_1yzjy").shouldHave(text("Войти"));
    }

    public void bentoBannerVisible() {
        $(bentoBanner).shouldBe(visible);
    }

    public void bentoBannerVideo() {
        $(videoBackground).shouldHave(attribute("src", "https://alfabank.servicecdn.ru/site-upload/13/41/8216/850x418_0506_dk.mp4"));
    }

    public void bentoBannerSecondCard() {
        $(secondCard)
                .shouldHave(text("Кредит наличными"))
                .shouldHave(attributeMatching("style", "background-image: url\\(\"https://alfabank.servicecdn.ru/site-upload/bc/d6/1449/D_MainBento_412x128_170924-min.jpg\"\\);" +
                        " background-color: rgb\\(168, 240, 0\\);" +
                        " background-position: center center;" +
                        " border: none;" +
                        " width: 412px;" +
                        " height: 128px;"));
    }


    public void bentoBannerThirdCard() {
        $(thirdCard)
                .shouldHave(text("Премиальный \n" +
                        "сервис Alfa Only"))
                .shouldHave(attribute("style", "background-image: url(\"https://alfabank.servicecdn.ru/site-upload/f4/8f/1449/D_MainBento_412x128_071024.png\");" +
                        " background-color: rgb(233, 224, 255);" +
                        " background-position: center center;" +
                        " border: none;" +
                        " width: 412px;" +
                        " height: 128px;"));
    }

    public void bentoBannerFourthCard() {
        $(fourthCard)
                .shouldHave(text("Альфа-Вклад"))
                .shouldHave(attribute("style", "background-image: url(\"https://alfabank.servicecdn.ru/site-upload/be/f2/1449/D_MainBento_267x273_160224.png\");" +
                        " background-color: rgb(162, 103, 255);" +
                        " background-position: center center; border: none;" +
                        " width: 267px;" +
                        " height: 273px;"));
    }

    public void bentoBannerFifthCard() {
        $(fifthCard)
                .shouldHave(text("Кредитная карта"))
                .shouldHave(attribute("style", "background-image: url(\"https://alfabank.servicecdn.ru/site-upload/02/ed/1449/D_MainBento_267x273_230524.png\"); " +
                        "background-color: rgb(82, 151, 255); " +
                        "background-position: center center; " +
                        "border: none; " +
                        "width: 267px; " +
                        "height: 273px;"));
    }

    public void searchWork() {
        $(searchPointer)
                .shouldBe(visible)
                .click();
        $(searchInput)
                .shouldBe(visible)
                .sendKeys("Кредиты");
        $(searchInput).pressEnter();
    }

    public void searchResult() {
        $(searchResult)
                .shouldBe(visible);
        $("a[href='https://AlfaBank.ru/help/articles/credit/chto-takoe-kredit/']")
                .shouldHave(text("Кредит: что это такое, виды и функции кредита - Блог..."));

    }
}
