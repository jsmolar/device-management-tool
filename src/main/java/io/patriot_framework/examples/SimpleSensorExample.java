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

import io.patriot_framework.generator.dataFeed.DataFeed;
import io.patriot_framework.generator.dataFeed.NormalDistVariateDataFeed;
import io.patriot_framework.generator.device.impl.basicSensors.Thermometer;
import io.patriot_framework.generator.device.passive.sensors.SimpleSensor;
import io.patriot_framework.generator.network.NetworkAdapter;
import io.patriot_framework.generator.network.Rest;
import io.patriot_framework.generator.network.wrappers.JSONWrapper;

public class SimpleSensorExample {

    public static void simpleSensor(String httpEndpoint) throws InterruptedException {
        DataFeed df = new NormalDistVariateDataFeed(18, 2);
        NetworkAdapter na = new Rest(httpEndpoint, new JSONWrapper());
        SimpleSensor sensor = new Thermometer("simpleThermometer", df);
        sensor.setNetworkAdapter(na);

        for (int i = 0; i < 5; i++) {
            sensor.requestData();
            Thread.sleep(1500);
        }
    }

}
