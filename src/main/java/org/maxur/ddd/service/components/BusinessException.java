/*
 * Copyright (c) 2016 Maxim Yunusov
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.maxur.ddd.service.components;

/**
 * The type Business exception.
 *
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>9/18/2015</pre>
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = -7189064682665335451L;

    /**
     * Instantiates a new Business exception.
     *
     * @param message the message
     */
    BusinessException(final String message) {
        super(message);
    }
}