package setup;

/**
 * Holds list of required constants.
 */
public enum Constants {

    /** The host name to connect to. */
    HOST("host"),
    /** The protocol port to connect to. */
    PORT("port"),
    /** Desired duration of the waiting for an element presence.*/
    TIMEOUT("5"),
    /** site under testing */
    SUT("sut"),
    SUT_TITLE("title");

    public String myConstant;

    Constants(String constant) {
        myConstant = constant;
    }

    public String get() {
        return myConstant;
    }

    public int getInt() {
        return Integer.parseInt(myConstant);
    }
}
