package Commands.CommandsForExecute.JsonLoader;

/**
 * Interface for ObjectReader json
 */
public interface Fields {
    int getInt(String s);
    boolean getBoolean(String s);
    float getFloat(String s);
    String getString(String s);
    long getLong(String s);
}
