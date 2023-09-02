package bossmonster.view;

public class OutputView {

    private static final String ERROR_MESSAGE_TEMPLATE = "[ERROR] %s%n";

    public void printErrorMessage(final String message) {
        System.out.printf(ERROR_MESSAGE_TEMPLATE, message);
    }
}
