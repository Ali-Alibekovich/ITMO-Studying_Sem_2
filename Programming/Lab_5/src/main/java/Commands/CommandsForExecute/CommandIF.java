package Commands.CommandsForExecute;

public interface CommandIF {
    /**
     * Interface for Commands
     * @param args take all commandline
     */
    void execute(String[] args);

    /**
     *
     * @return возращает информацию о команде
     */
    String infoCommand();
}
