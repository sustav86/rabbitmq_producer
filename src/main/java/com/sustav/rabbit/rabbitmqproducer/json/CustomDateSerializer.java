package com.sustav.rabbit.rabbitmqproducer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializer extends StdSerializer<LocalDate> {

    private DateTimeFormatter gg = DateTimeFormatter.ofPattern("dd-MMM-yy");
    private SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(gg.format(value));
    }

    public CustomDateSerializer(Class<LocalDate> t) {
        super(t);
    }

    public CustomDateSerializer() {
        this(null);
    }


}
