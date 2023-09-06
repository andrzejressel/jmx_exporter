#!/bin/bash

java \
  -Xmx128M \
  -jar jmx_example_application.jar &
APP_PID=$!

sleep 1

sed -e "s/PID/${APP_PID}/g" exporter.yaml.tmpl > exporter.yaml

java \
  -Xmx128M \
  -Djavax.net.ssl.keyStore=localhost.jks \
  -Djavax.net.ssl.keyStorePassword=changeit \
  -jar jmx_prometheus_httpserver.jar 8888 exporter.yaml

sleep 100000