package org.bshg.validation.config;

import java.io.InputStream;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Configuration {

    private static Configuration configuration;

    public static Configuration inst() {
        if (configuration == null) {
            configuration = new Configuration();
            configuration.local = Configure.local;
            configuration.localFileByName = Configure.getLocalFileByName;
            configuration.localFile = Configure.getLocalFile;
        }
        return configuration;
    }

    private String local;
    private Function<String, Optional<InputStream>> localFileByName;
    private Supplier<Optional<InputStream>> localFile;

    public String getLocalString() {
        return local;
    }

    public Function<String, Optional<InputStream>> getLocalFileByName() {
        return this.localFileByName;
    }

    public Supplier<Optional<InputStream>> getLocalFile() {
        return this.localFile;
    }
}