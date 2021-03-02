package Src;
/**Represents a custom command used for this framework */
public class Command {
    
    //Attributes
    private String call;
    private String desc;
    private Runnable func;



    //Constructor
    /**Object representing a command that can be called from the CLI
     * 
     * @param call  The input that calls the command
     * @param desc  A brief description of the command
     * @param func  Returns the callable function of the command
     */
    public Command(String call, String desc, Runnable func) {
        this.call = call;
        this.desc = desc;
        this.func = func;
    }



    //Functions/Methods
    /**Returns the input that calls the command
     */
    public String getCall() { return call; }

    /**Returns a brief description of the command
     */
    public String getDescription() { return desc; }

    /**Returns the callable function of the command
     */
    public Runnable getFunction() { return func; }
}
