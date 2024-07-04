package org.bshg.validation.config;

import java.io.InputStream;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Configure {
    public static String local = "en";
    public static Supplier<Optional<InputStream>> getLocalFile;
    public static Function<String, Optional<InputStream>> getLocalFileByName;
}