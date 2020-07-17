/*
 * Copyright 2020 Patriot project
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.patriot_framework.examples;

import io.patriot_framework.beans.RunnableBean;
import io.patriot_framework.builders.DeviceJsonBuilder;

import java.io.IOException;

/**
 * The definition of StateMachines via yml builder is not supported
 */
public class YAMLBuilderExample {

    public static final String DEFAULT_PATH = "device.yml";

    public static void deviceBuilder(String path, String httpEndpoint) throws InterruptedException {
        RunnableBean runnableBean = new RunnableBean();

        path = path.isEmpty() ? DEFAULT_PATH : path;

        DeviceJsonBuilder builder = new DeviceJsonBuilder(runnableBean, path);

        try {
            builder.loadDevices();
        } catch (IOException e) {
            e.printStackTrace();
        }

        builder.getRunnableBean().getActiveDeviceBean().startSimulationAll();
        builder.getRunnableBean().registerAllDevices();
        Thread.sleep(10000);

    }

}
