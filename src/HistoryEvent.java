public class HistoryEvent {
    private String eventType;
    private String description;

    public HistoryEvent(String eventType, String description) {
        this.eventType = eventType;
        this.description = description;
    }

    // Getters for eventType and description
    public String getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }
}
