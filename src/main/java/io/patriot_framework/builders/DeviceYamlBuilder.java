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
import io.patriot_framework.beans.RunnableBean;
import io.patriot_framework.beans.SensorBean;

import java.io.FileReader;
import java.io.IOException;

public class DeviceYamlBuilder {

    private RunnableBean runnableBean;

    private String fileName;

    public DeviceYamlBuilder(RunnableBean runnableBean, String fileName) {
        this.runnableBean = runnableBean;
        this.fileName = fileName;
    }

    public DeviceYamlBuilder loadDevices() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try(FileReader fr = new FileReader(fileName)) {
            runnableBean.setActiveDeviceBean(
                    mapper.readValue(fr, ActiveDeviceBean.class));

//            runnableBean.setSensorBean(
//                    mapper.readValue(fr, SensorBean.class));
        }

        return this;
    }

    public RunnableBean getRunnableBean() {
        return runnableBean;
    }
}

//   TypeReference<ActiveDeviceBean>(){}
//        SimpleModule module = new SimpleModule("CustomModel", Version.unknownVersion());
//        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
//        resolver.addMapping(ActiveDevice.class, AbstractActiveDevice.class);
//        module.setAbstractTypes(resolver);
//        mapper.registerModule(module);


//        YAMLFactory yamlFactory = new YAMLFactory();
//        yamlFactory.disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID);