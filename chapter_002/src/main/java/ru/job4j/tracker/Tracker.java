package ru.job4j.tracker;

import java.util.*;
/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Случайное число. Используется для генерации уникального ключа.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        if (item == null) {
            return item;
        }
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод ищёт заявку по её уникальному ключу в массиве заявок и
     * заменяёт её на новую заявку.
     *
     * @param id   Уникальный ключ заявки.
     * @param item Заявка.
     */
    public boolean replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод удаляет заявку из массива заявок по заданному уникальному ключу.
     * @param id Уникальный ключ.
     */
    public boolean delete(String id) {
        for (int i = 0; i < position; i++) {
            if (position == 0) {
                //System.out.println("Nothing to delete");
                return false;
            } else if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, (i + 1), this.items, i, (position - 1 - i));
                position--;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает копию массива this.items без null элементов;
     * @return Массив заявок.
     */
    public Item[] getAll() {
        int elements = position;
        return Arrays.copyOf(items, elements);
    }

    /**
     * Метод возвращает массив заявок, у которых имя совпадает с заданным именем key.
     * @param key Имя заявки.
     * @return Массив заявок.
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                items[count++] = items[i];
            }
        }
        if (count == 0) {
            return null;
        }
        return Arrays.copyOf(items, count);
    }

    /**
     * Метод возвращает заявку в заданным уникальным ключом. Если заявка не найдена, возвращает null.
     * @param id Уникальный ключ заявки.
     * @return Заявка либо null.
     */
    public Item findById(String id) {
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                return items[i];
            }
        }
        return null;
    }
}