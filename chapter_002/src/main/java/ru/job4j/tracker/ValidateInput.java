package ru.job4j.tracker;

/**
 * Валидатор.
 * Получает данные из системы до тех под пока не введут правильные символы.
 *
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {

    /**
     * Источник данных.
     */
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select correct menu option: ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter correct number: ");
            }
        } while (invalid);
        return value;
    }
}
