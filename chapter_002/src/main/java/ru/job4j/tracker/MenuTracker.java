package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
/**
 * Классы разнесены в учебных целях.
 */

/**
 * Внешний класс поиска заявки по заданному ID.
 */
class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Найти заявку по ID --------------");
        String temp = input.ask("Введите ID заявки: ");
        Item item = tracker.findById(temp);
        if (item == null) {
            System.out.println("------------ Заявка не найдена -----------");
        } else {
            System.out.println("------------ Найденная заявка -----------");
            System.out.println(item);
        }
    }

}

/**
 * Внешний класс поиска заявок по заданному имени.
 */
class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Найти заявки по имени --------------");
        String name = input.ask("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("------------ Заявки не найдены -----------");
        } else {
            System.out.println("------------ Найденные заявки -----------");
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        }
    }
}

public class MenuTracker {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";

    /**
     * Получение данных от пользователя.
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */

    private Tracker tracker;

    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     * @param input   объект типа Input.
     * @param tracker объект типа Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return Длина массива.
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add a new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit an item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete an item"));
        this.actions.add(new FindItemById(4, "Find an item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний нестатический класс добавления заявки в хранилище.
     */
    class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item newItem = new Item(name, desc, 1L);
            tracker.add(newItem);
            System.out.println("------------ Новая заявка -----------");
            System.out.println(newItem);
        }
    }


    /**
     * Внутренний нестатический класс вывода всех заявок хранилища.
     */
    public class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.getAll();
            System.out.println("------------ Показать все заявки --------------");
            if (items == null) {
                System.out.println("Заявок нет!");
            } else if (items != null) {
                System.out.println("Список заявок: ");
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }
            }
        }
    }

    /**
     * Внутренний статический класс редактирования заявки по заданному ID.
     */
    public static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактировать заявку --------------");
            String temp = input.ask("Введите ID заявки:");
            Item oldItem = tracker.findById(temp);
            // если введен несуществующий ID
            if (oldItem == null) {
                System.out.println("------------ Заявка не найдена -----------");
            } else {
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание заявки :");
                Item newItem = new Item(name, desc, 1L);
                String oldId = oldItem.getId();
                newItem.setId(oldId);
                if (tracker.replace(oldId, newItem)) {
                    System.out.println("Команда выполнена успешно!");
                    System.out.println("------------ Отредактированная заявка -----------");
                    System.out.println(newItem);
                }
            }
        }

    }

    /**
     * Внутренний статический класс удаления заявки по заданному ID.
     */
    public static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удалить заявку --------------");
            String deletedId = input.ask("Введите ID заявки: ");
            Item deletedItem = tracker.findById(deletedId);
            if (deletedItem == null) {
                System.out.println("------------ Заявка не найдена -----------");
            } else {
                if (tracker.delete(deletedId)) {
                    System.out.println("Команда выполнена успешно!");
                    System.out.println("------------ Удаленная заявка -----------");
                    System.out.println(deletedItem);
                }
            }
        }
    }
}
