/*
 * Copyright 2019 Patriot project
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

package io.patriot_framework;

import io.patriot_framework.beans.RunnableBean;
import io.patriot_framework.builders.DeviceYamlBuilder;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        RunnableBean runnableBean = new RunnableBean();

        if (args.length > 0) {
            String jsonPath = args[0];
            DeviceYamlBuilder builder = new DeviceYamlBuilder(runnableBean, jsonPath);

            try {
                builder.loadDevices();
            } catch (IOException e) {
                e.printStackTrace();
            }

            builder.getRunnableBean().getActiveDeviceBean().startSimulationAll();
        }


        System.out.println("aaa");
    }

}
