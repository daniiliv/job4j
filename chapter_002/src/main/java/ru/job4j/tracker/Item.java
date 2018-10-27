package ru.job4j.tracker;
/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    /**
     * Уникальный ключ заявки.
     */
    private String id;
    /**
     * Имя заявки.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String description;
    /**
     * Время создания заявки.
     */
    private long created;

    /**
     * Конструктор с параметрами.
     * @param name Имя заявки.
     * @param description Описание заявки.
     * @param created Время создания заявки.
     */
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }
    /**
     * Геттер имени заявки.
     * @return Имя заявки.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Геттер описания заявки.
     * @return Описание заявки.
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Геттер времени создания заявки.
     * @return Время создания заявки.
     */
    public long getCreated() {
        return this.created;
    }
    /**
     * Геттер уникального ключа заявки.
     * @return Уникальный ключ заявки.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Сеттер имени заявки.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Сеттер описания заявки.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Сеттер времени создания заявки.
     */
    public void setCreated(long created) {
        this.created = created;
    }
    /**
     * Сеттер уникального ключа заявки.
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Description: " + this.description + " ID: " + this.id;
    }
}
