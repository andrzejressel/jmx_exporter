/*
 * Copyright (C) 2023 The Prometheus jmx_exporter Authors
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

package io.prometheus.jmx.test.support;

import okhttp3.Headers;

/** Interface for a Response */
public interface Response {

    /**
     * Method to get the response code
     *
     * @return the response code
     */
    int code();

    /**
     * Method to get the response Headers
     *
     * @return the response Headers
     */
    Headers headers();

    /**
     * Method to get the response content
     *
     * @return the response content
     */
    String content();

    /**
     * Method to compare whether this Response is equals to another Object
     *
     * @param response response
     * @return this
     */
    Response isSuperset(Response response);

    /**
     * Method to dispatch the response code to a CodeConsumer
     *
     * @param consumer consumer
     * @return this
     */
    Response dispatch(CodeConsumer consumer);

    /**
     * Method to dispatch the response Headers to a HeadersConsumer
     *
     * @param consumer consumer
     * @return this
     */
    Response dispatch(HeadersConsumer consumer);

    /**
     * Method to dispatch the response content to a ContentConsumer
     *
     * @param consumer consumer
     * @return this
     */
    Response dispatch(ContentConsumer consumer);
}
