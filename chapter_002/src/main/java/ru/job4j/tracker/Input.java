package ru.job4j.tracker;
/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    public String ask(String question);
    public int ask(String question, int[] range);
}
