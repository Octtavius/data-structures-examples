package ie.home.queues.blockingqueues;

public class JobMessage {

	private String logMessage;
	
    public JobMessage(String string) {
        this.logMessage = string;
    }
    
    public String getMsg() {
        return logMessage;
    }
}
