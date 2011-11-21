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

package org.springframework.migrationanalyzer.render;

import java.util.Map;

/**
 * The model and view parts of the MVC pattern
 * <p />
 * 
 * <strong>Concurrent Semantics</strong><br />
 * 
 * Thread-safe
 */
public final class ModelAndView {

    private final Map<String, Object> model;

    private final String viewName;

    /**
     * Creates a new instance by specifying both a model and a view name
     * 
     * @param model The model
     * @param viewName The view name
     */
    public ModelAndView(Map<String, Object> model, String viewName) {
        this.model = model;
        this.viewName = viewName;
    }

    /**
     * Returns the model
     * 
     * @return the model
     */
    public Map<String, Object> getModel() {
        return this.model;
    }

    /**
     * Returns the view name
     * 
     * @return the view name
     */
    public String getViewName() {
        return this.viewName;
    }
}
