package ru.job4j.tracker;

/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
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
     * Константа меню для поиска заявки по ID.
     */
    private static final String IDFIND = "4";
    /**
     * Константа меню для поиска заявок по имени.
     */
    private static final String NAMEFIND = "5";
    /**
     * Константа меню для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DEL:
                    this.deleteItem();
                    break;
                case IDFIND:
                    this.findById();
                    break;
                case NAMEFIND:
                    this.findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("An invalid choice");
            }
        }
    }

    /**
     * Метод добавления заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item newItem = new Item(name, desc, 1L);
        this.tracker.add(newItem);
        System.out.println("------------ Новая заявка -----------");
        System.out.println("ID: " + newItem.getId());
        System.out.println("Name: " + newItem.getName());
        System.out.println("Description: " + newItem.getDescription());
    }

    /**
     * Метод вывода всех заявок хранилища.
     */
    private void showItems() {
        String name;
        String id;
        String desc;
        System.out.println("------------ Показать все заявки --------------");
        if (this.tracker.getAll() == null) {
            System.out.println("Заявок нет!");
        } else {
            System.out.println("Список заявок: ");
            for (int i = 0; i < this.tracker.getAll().length; i++) {
                name = this.tracker.getAll()[i].getName();
                id = this.tracker.getAll()[i].getId();
                desc = this.tracker.getAll()[i].getDescription();
                System.out.println("Name: " + name + " Description: " + desc + " ID: " + id);
            }
        }
    }

    /**
     * Метод редактирования заявки по заданному ID.
     */
    private void editItem() {
        System.out.println("------------ Редактировать заявку --------------");
        String temp = this.input.ask("Введите ID заявки:");
        if (this.tracker.findById(temp) == null) {
            System.out.println("------------ Заявка не найдена -----------");
        } else {
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите новое описание заявки :");
            Item newItem = new Item(name, desc, 1L);
            String oldId = this.tracker.findById(temp).getId();
            newItem.setId(oldId);
            if (tracker.replace(oldId, newItem)) {
                System.out.println("Команда выполнена успешно!");
            }
            System.out.println("------------ Отредактированная заявка -----------");
            System.out.println("ID: " + newItem.getId());
            System.out.println("Name: " + newItem.getName());
            System.out.println("Description: " + newItem.getDescription());
        }
    }

    /**
     * Метод удаления заявки по заданному ID.
     */
    public void deleteItem() {
        System.out.println("------------ Удалить заявку --------------");
        String temp = this.input.ask("Введите ID заявки: ");
        if (this.tracker.findById(temp) == null) {
            System.out.println("------------ Заявка не найдена -----------");
        } else {
            String id = this.tracker.findById(temp).getId();
            String name = this.tracker.findById(temp).getName();
            String desc = this.tracker.findById(temp).getDescription();
            if (tracker.delete(temp)) {
                System.out.println("Команда выполнена успешно!");
            }
            System.out.println("------------ Удаленная заявка -----------");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Description: " + desc);

        }
    }

    /**
     * Метод поиска заявки по заданному ID.
     */
    public void findById() {
        System.out.println("------------ Найти заявку по ID --------------");
        String temp = this.input.ask("Введите ID заявки: ");
        if (this.tracker.findById(temp) == null) {
            System.out.println("------------ Заявка не найдена -----------");
        } else {
            System.out.println("------------ Найденная заявка -----------");
            System.out.println("ID: " + this.tracker.findById(temp).getId());
            System.out.println("Name: " + this.tracker.findById(temp).getName());
            System.out.println("Description: " + this.tracker.findById(temp).getDescription());
        }
    }

    /**
     * Метод поиска заявок по заданному имени.
     */
    public void findByName() {
        System.out.println("------------ Найти заявки по имени --------------");
        String temp = this.input.ask("Введите имя заявки: ");
        if (this.tracker.findByName(temp) == null) {
            System.out.println("------------ Заявки не найдены -----------");
        } else {
            System.out.println("------------ Найденные заявки -----------");
            int amount = this.tracker.findByName(temp).length;
            for (int i = 0; i < amount; i++) {
                System.out.println("ID: " + this.tracker.findByName(temp)[i].getId());
                System.out.println("Name: " + this.tracker.findByName(temp)[i].getName());
                System.out.println("Description: " + this.tracker.findByName(temp)[i].getDescription());
            }
        }
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
