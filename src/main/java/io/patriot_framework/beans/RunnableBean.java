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

package io.patriot_framework.beans;

public class RunnableBean {

    ActiveDeviceBean activeDeviceBean = new ActiveDeviceBean();

    SensorBean sensorBean = new SensorBean();

    ActuatorBean actuatorBean = new ActuatorBean();

    public ActiveDeviceBean getActiveDeviceBean() {
        return activeDeviceBean;
    }

    public void setActiveDeviceBean(ActiveDeviceBean activeDeviceBean) {
        this.activeDeviceBean = activeDeviceBean;
    }

    public SensorBean getSensorBean() {
        return sensorBean;
    }

    public void setSensorBean(SensorBean sensorBean) {
        this.sensorBean = sensorBean;
    }

    public ActuatorBean getActuatorBean() {
        return actuatorBean;
    }

    public void setActuatorBean(ActuatorBean actuatorBean) {
        this.actuatorBean = actuatorBean;
    }
}
