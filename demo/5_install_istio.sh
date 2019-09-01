#!/bin/bash -v

export ISTIO_HOME="$(dirname ${ISTIO_PATH})";
kubectl apply -f ${ISTIO_HOME}/install/kubernetes/istio-demo.yaml;
#kubectl label namespace default istio-injection=enabled;
