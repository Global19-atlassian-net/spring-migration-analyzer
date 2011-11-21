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

package org.springframework.migrationanalyzer.contributions.spring;

import org.springframework.migrationanalyzer.analyze.fs.FileSystemEntry;

final class SpringConfiguration {

    private final FileSystemEntry location;

    private final String name;

    SpringConfiguration(FileSystemEntry location, String name) {
        this.location = location;
        this.name = name;
    }

    FileSystemEntry getLocation() {
        return this.location;
    }

    String getName() {
        return this.name;
    }
}
