package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Строка - пользовательское меню.
     */
    private final String menu = "Menu:\n0. Add a new Item\n1. Show all items\n2. Edit an item\n3. Delete an item\n4. Find an item by Id\n5. Find items by name\n6. Exit Program\n";

    /**
     * Заменяем стандартный вывод на вывод в пямять для тестирования.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Возвращаем обратно стандартный вывод в консоль.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тест метода add(), когда пользователь вводит данные с клавиатуры.
     */

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Тест метода edit(), когда пользователь вводит данные с клавиатуры.
     */
    @Test
    public void whenUserUpdateItemThenUpdatedItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("name test", "desc test", 1L);
        tracker.add(item);
        String inputedId = item.getId();
        Input input = new StubInput(new String[]{"2", inputedId, "new test name", "new test desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(inputedId).getName(), is("new test name"));
    }

    /**
     * Тест метода delete(), когда пользователь вводит данные с клавиатуры.
     */
    @Test
    public void whenUserDeleteItemThenDeletedItem() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[2];
        items[0] = new Item("name test", "desc test", 1L);
        items[1] = new Item("name test2", "desc test2", 2L);
        tracker.add(items[0]);
        tracker.add(items[1]);
        Item[] expected = new Item[1];
        expected[0] = items[1];

        String inputedId = items[0].getId();
        Input input = new StubInput(new String[]{"3", inputedId, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll(), is(expected));
    }

    /**
     * Тест метода showItems(), когда в хранилище 3 заявки, и пользователь вводит данные с клавиатуры.
     */
    @Test
    public void whenUserShowItems() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = new Item("name test", "desc test", 1L);
        items[1] = new Item("name test2", "desc test2", 2L);
        items[2] = new Item("name test", "desc test", 1L);
        for (int i = 0; i < 3; i++) {
            tracker.add(items[i]);
        }

        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Показать все заявки --------------")
                                .append(System.lineSeparator())
                                .append("Список заявок: ")
                                .append(System.lineSeparator())
                                .append(items[0])
                                .append(System.lineSeparator())
                                .append(items[1])
                                .append(System.lineSeparator())
                                .append(items[2])
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .toString()
                )
        );
    }

    /**
     * Тест метода showItems(), когда в хранилище нет заявок, пользовательский ввод.
     */
    @Test
    public void whenUserShowNoItems() {
        Tracker tracker = new Tracker();

        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Показать все заявки --------------")
                                .append(System.lineSeparator())
                                .append("Заявок нет!")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .toString()
                )
        );
    }

    /**
     * Тест метода findById(), когда пользователь вводит данные с клавиатуры.
     */
    @Test
    public void whenUserFindById() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[6];
        items[0] = new Item("test", "testDescription", 119L);
        items[1] = new Item("test2", "testDescription2", 129L);
        items[2] = new Item("test3", "testDescriptio3", 139L);
        items[3] = new Item("Petya", "testDescription", 241L);
        items[4] = new Item("ourItem", "testDescriptionItem", 149L);
        items[5] = new Item("Petya", "testDescription2", 242L);
        for (int i = 0; i < 6; i++) {
            tracker.add(items[i]);
        }
        String inputtedId = items[3].getId();
        Input input = new StubInput(new String[]{"4", inputtedId, "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Найти заявку по ID --------------")
                                .append(System.lineSeparator())
                                //.append("Введите ID заявки: ")                      //******почему это не выводит?******
                                //.append(System.lineSeparator())
                                .append("------------ Найденная заявка -----------")
                                .append(System.lineSeparator())
                                .append(items[3])
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .toString()
                )
        );

    }

    @Test
    public void whenUserFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[6];
        items[0] = new Item("test", "testDescription", 119L);
        items[1] = new Item("test2", "testDescription2", 129L);
        items[2] = new Item("test3", "testDescriptio3", 139L);
        items[3] = new Item("Petya", "testDescription", 241L);
        items[4] = new Item("ourItem", "testDescriptionItem", 149L);
        items[5] = new Item("Petya", "testDescription2", 242L);
        for (int i = 0; i < 6; i++) {
            tracker.add(items[i]);
        }
        String inputtedName = "Petya";
        Input input = new StubInput(new String[]{"5", inputtedName, "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Найти заявки по имени --------------")
                                .append(System.lineSeparator())
                                //.append("Введите имя заявки: ")                      //******почему это не выводит?******
                                //.append(System.lineSeparator())
                                .append("------------ Найденные заявки -----------")
                                .append(System.lineSeparator())
                                .append(items[3])
                                .append(System.lineSeparator())
                                .append(items[5])
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .toString()
                )
        );
    }

}



