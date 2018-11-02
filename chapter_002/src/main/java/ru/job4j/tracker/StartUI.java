package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private Input input;
    /**
     * Хранилище заявок.
     */
    private Tracker tracker;

    /**
     * Конструктор класса.
     * @param input Сущность класса, реализующего интерфейс Input.
     * @param tracker Объект трекер - хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("select:")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Метод, выводящий пункты меню.
     */
    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add a new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit an item");
        System.out.println("3. Delete an item");
        System.out.println("4. Find an item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
