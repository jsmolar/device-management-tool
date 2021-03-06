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

package io.patriot_framework.builders;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.patriot_framework.beans.ActiveDeviceBean;
import io.patriot_framework.beans.ActuatorBean;
import io.patriot_framework.beans.RunnableBean;
import io.patriot_framework.beans.SensorBean;

import java.io.File;
import java.io.IOException;

public class DeviceJsonBuilder {

    private RunnableBean runnableBean;

    private String fileName;

    public DeviceJsonBuilder(RunnableBean runnableBean, String fileName) {
        this.runnableBean = runnableBean;
        this.fileName = fileName;
    }

    public void loadDevices() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File file = new File(fileName);

        runnableBean.setActiveDeviceBean(
                mapper.readValue(file, ActiveDeviceBean.class));

        runnableBean.setSensorBean(
                mapper.readValue(file, SensorBean.class));

        runnableBean.setActuatorBean(
                mapper.readValue(file, ActuatorBean.class));
    }

    public RunnableBean getRunnableBean() {
        return runnableBean;
    }
}
