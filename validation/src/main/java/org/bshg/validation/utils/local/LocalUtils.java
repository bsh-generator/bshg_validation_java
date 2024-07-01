package org.bshg.validation.utils.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bshg.validation.config.Configure;

import java.io.IOException;
import java.io.InputStream;

public class LocalUtils {
    public static Local local(String local) {
        String path = "/local/" + local + ".json";
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = LocalUtils.class.getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + path);
            }
            return objectMapper.readValue(inputStream, Local.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Local local;

    public static Local local() {
        if (local == null)
            local = LocalUtils.local(Configure.local);
        return local;
    }
}