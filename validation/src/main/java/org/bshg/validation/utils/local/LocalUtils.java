package org.bshg.validation.utils.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bshg.validation.config.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class LocalUtils {
    private static Local local;

    public static Local local() {
        if (local != null) return local;
        String localString = Configuration.inst().getLocalString();

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = fetchLocalFromResource(localString)
                .orElseThrow(() -> new RuntimeException("No File Provided To Fetch The Messages"));
        try {
            local = objectMapper.readValue(inputStream, Local.class);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return local;
    }

    private static Optional<InputStream> fetchLocalFromResource(String local) {
        Function<String, Optional<InputStream>> localFileByName = Configuration.inst().getLocalFileByName();
        Supplier<Optional<InputStream>> localFile = Configuration.inst().getLocalFile();
        if (localFileByName != null) return localFileByName.apply(local);
        else if (localFile != null) return localFile.get();
        return defaultFetchLocalFromResource(local);
    }

    private static Optional<InputStream> defaultFetchLocalFromResource(String local) {
        String path = "/local/" + local + ".json";
        return Optional.ofNullable(LocalUtils.class.getResourceAsStream(path));
    }
}