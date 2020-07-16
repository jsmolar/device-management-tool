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

package io.patriot_framework.example;

import io.patriot_framework.generator.controll.client.CoapControlClient;
import io.patriot_framework.generator.device.impl.basicActuators.RotaryActuator;
import io.patriot_framework.generator.device.passive.actuators.Actuator;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;

public class ExampleActuator {

    public static void actuator(String httpEndpoint) throws ConnectorException, IOException, InterruptedException {

        Actuator actuator = new RotaryActuator("rotator", 3000);
        actuator.registerToCoapServer();

        CoapControlClient client = new CoapControlClient("coap://127.0.0.1:5683");

        for (int i = 0; i < 3; i++) {
            client.post("/rotator", "rotate");
            Thread.sleep(3500);
        }

    }

}
