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

import io.patriot_framework.generator.dataFeed.ConstantDataFeed;
import io.patriot_framework.generator.dataFeed.DataFeed;
import io.patriot_framework.generator.dataFeed.NormalDistVariateDataFeed;
import io.patriot_framework.generator.device.active.Active;
import io.patriot_framework.generator.device.active.ActiveDevice;
import io.patriot_framework.generator.device.impl.basicSensors.Thermometer;
import io.patriot_framework.generator.device.passive.sensors.SimpleSensor;

public class ActiveDeviceExample {

    public static void activeDevice(String httpEndpoint) throws InterruptedException {
        DataFeed df = new NormalDistVariateDataFeed(18, 2);
        SimpleSensor temperature = new Thermometer("activeThermometer", df);
        temperature.registerToCoapServer();

        DataFeed tf = new ConstantDataFeed(2000);
        Active activeDevice = new ActiveDevice(temperature, tf);
        activeDevice.start();

        Thread.sleep(11000);
        activeDevice.stop();
    }

}
