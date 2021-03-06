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

import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;
import java.util.Scanner;

import static io.patriot_framework.examples.ActiveDeviceExample.activeDevice;
import static io.patriot_framework.examples.ActuatorExample.actuator;
import static io.patriot_framework.examples.SensorExample.sensor;
import static io.patriot_framework.examples.SimpleSensorExample.simpleSensor;
import static io.patriot_framework.examples.JsonBuilderExample.deviceBuilder;

public class DeviceExample {

    public static void main(String... args) throws ConnectorException, InterruptedException, IOException {

        String help = "On few simple examples, this project will \n"
                + "1 Sensor examples \n"
                + "2 SimpleSensor examples \n"
                + "3 Actuator examples \n"
                + "4 ActiveDevice examples \n"
                + "5 import from yml file examples \n"
                + "9 to configure DTM with new http endpoint or yml file for deserialization\n"
                + "0 to exit \n"
                + "type 1, 2, 3, 4 or 5 to run examples \n";


        /*
         * Default values for yml file for deserialization and http endpoint
         */
        String jsonFile = "device.json";

        /*
         * Example HTTP endpoint is on public requestbin:
         * https://requestbin.com/r/enisg4fvfqevq/1efyNiKoKNYlP7Sk9C53OQrEwTM
         *
         * Feel free to change this.
         */
        String httpEndpoint = "https://enisg4fvfqevq.x.pipedream.net/";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(help);
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    sensor(httpEndpoint);
                    break;
                case 2:
                    simpleSensor(httpEndpoint);
                    break;
                case 3:
                    actuator(httpEndpoint);
                    break;
                case 4:
                    activeDevice(httpEndpoint);
                    break;
                case 5:
                    deviceBuilder(jsonFile);
                    break;
                case 9:
                    System.out.println("New http endpoint: ");
                    httpEndpoint = scanner.next();

                    System.out.println("New yml file for device ");
                    jsonFile = scanner.next();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Unsupported argument. Try numbers (1 .. 5)");

            }
        }

    }

}
