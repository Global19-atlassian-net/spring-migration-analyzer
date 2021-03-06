/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.migrationanalyzer.render.support.html;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.migrationanalyzer.util.IoUtils;
import org.springframework.stereotype.Component;

@Component
final class FileOutputFactory implements OutputFactory {

    private final Logger logger = LoggerFactory.getLogger(FileOutputFactory.class);

    @Override
    public Writer createWriter(String path, String pathPrefix) {
        try {
            return new FileWriter(createAndPrepareFile(path, pathPrefix));
        } catch (IOException ioe) {
            throw new OutputCreationFailedException("Failed to create writer", ioe);
        }
    }

    @Override
    public OutputStream createOutputStream(String path, String pathPrefix) {
        try {
            return new FileOutputStream(createAndPrepareFile(path, pathPrefix));
        } catch (IOException ioe) {
            throw new OutputCreationFailedException("Failed to create output stream", ioe);
        }
    }

    private File createAndPrepareFile(String path, String pathPrefix) {
        File file = new File(pathPrefix, path);
        try {
            IoUtils.createDirectoryIfNecessary(file.getParentFile());
        } catch (IOException ioe) {
            this.logger.error(String.format("Failed to create directory '%s'. Please check the output path and try again.", file.getParentFile()));
        }
        return file;
    }
}
