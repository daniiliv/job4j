package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *@author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    /**
     * Тест для метода add().
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * Тест для метода replace().
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест для метода delete().
     * Добавили две заявки, удалили одну. Проверяем, что действительно осталась одна заявка в массиве заявок.
     */
    @Test
    public void whenDeleteOneFromTwoThenReturnOne() {
        Tracker result = new Tracker();
        Tracker expected = new Tracker();
        Item anItem = new Item("test", "testDesc", 155L);
        Item deleted = new Item("test3", "testDescription3", 12345L);
        result.add(deleted);
        result.add(anItem);
        result.delete(deleted.getId());

        expected.add(anItem);

        assertThat(result.getAll(), is(expected.getAll()));
    }

    /**
     * Тест для метода delete().
     * Добавили одну заявку, после удалили её же. Проверяем, что заявок нет.
     */
    @Test
    public void whenDeleteThenReturnEmpty() {
        Tracker result = new Tracker();
        Tracker expected = new Tracker();
        Item deleted = new Item("test3", "testDescription3", 12345L);
        result.add(deleted);
        result.delete(deleted.getId());

        assertThat(result.getAll(), is(expected.getAll()));
    }

    /**
     * Тест метода getAll().
     * Добавляем 4 заявки в трекер, 2 из них - null. Метод должен удалить null и вернуть две существующие заявки.
     */
    @Test
    public void whenGetAllFromArrayWhereTwoNullsThenReturnArrayWithoutNulls() {
        Tracker result = new Tracker();
        Item[] items = new Item[4];
        Tracker expected = new Tracker();
        items[0] = new Item("test3", "testDescription3", 12345L);
        items[3] = new Item("test6", "testDescription6", 1237L);

        for (int i = 0; i < 4; i++) {
            result.add(items[i]);
        }

        expected.add(items[0]);
        expected.add(items[3]);

        assertThat(result.getAll(), is(expected.getAll()));
    }

    /**
     * Тест метода findByName().
     * Возвращает две найденные заявки по заданному имени.
     */
    @Test
    public void whenNameIsPetyaThenFoundTwo() {
        Tracker result = new Tracker();
        Tracker expected = new Tracker();
        Item[] items = new Item[6];
        items[0] = new Item("test", "testDescription", 119L);
        items[1] = new Item("test2", "testDescription2", 129L);
        items[2] = new Item("test3", "testDescriptio3", 139L);
        items[3] = new Item("Petya", "testDescription", 241L);
        items[4] = new Item("test4", "testDescription4", 149L);
        items[5] = new Item("Petya", "testDescription2", 242L);
        for (int i = 0; i < 6; i++) {
            result.add(items[i]);
        }
        expected.add(items[3]);
        expected.add(items[5]);
        assertThat(result.findByName("Petya"), is(expected.getAll()));
    }

    /**
     * Тест метода findById().
     */
    @Test
    public void whenGotIdThenFoundNeccessaryItem() {
        Tracker result = new Tracker();
        Item[] items = new Item[6];
        items[0] = new Item("test", "testDescription", 119L);
        items[1] = new Item("test2", "testDescription2", 129L);
        items[2] = new Item("test3", "testDescriptio3", 139L);
        items[3] = new Item("Petya", "testDescription", 241L);
        items[4] = new Item("ourItem", "testDescriptionItem", 149L);
        items[5] = new Item("Petya", "testDescription2", 242L);
        for (int i = 0; i < 6; i++) {
            result.add(items[i]);
        }
        assertThat(result.findById(items[5].getId()), is(items[5]));
    }
}