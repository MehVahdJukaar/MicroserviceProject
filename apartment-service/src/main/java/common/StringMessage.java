package common;

public record StringMessage(String text) implements Message{
    @Override
    public String getEventType() {
        return "String";
    }

}
