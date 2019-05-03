package com.eld.message;

public class SomeMessage implements Message {
    
    private final Header header;
    private final String somethingSpecific;

    public SomeMessage(final Header header, final String somethingSpecific) {
        this.header = header;
        this.somethingSpecific = somethingSpecific;
    }
    
    @Override
    public Header getHeader() {
        return header;
    }
    
    public String getSomethingSpecific() {
        return somethingSpecific;
    }

}
