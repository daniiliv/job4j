package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
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
        Tracker expected = new Tracker();
        Item[] items = new Item[2];
        items[0] = new Item("name test", "desc test", 1L);
        items[1] = new Item("name test2", "desc test2", 2L);
        tracker.add(items[0]);
        tracker.add(items[1]);

        expected.add(items[1]);
        String inputedId = items[0].getId();
        Input input = new StubInput(new String[]{"3", inputedId, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll(), is(expected.getAll()));
    }
/*
    @Test
    public void whenUserFindByidThenItemFound() {
        Tracker tracker = new Tracker();
        Item items[] = new Item[3];
        items[0] = new Item("name test", "desc test", 1L);
        items[1] = new Item("name test2", "desc test2", 2L);
        items[2] = new Item("name test3", "desc test3", 3L);
        for (int i = 0; i < 3; i ++) {
            tracker.add(items[i]);
        }
        String inputedId = items[1].getId();
        Input input = new StubInput(new String[]{"4", inputedId, "6"});

        new StartUI(input, tracker);
        assertThat(tracker.findById());
    }
    */
}


