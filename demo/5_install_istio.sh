#!/bin/bash -v

export ISTIO_HOME="$(dirname ${ISTIO_PATH})";
kubectl apply -f ${ISTIO_HOME}/install/kubernetes/istio-demo.yaml;
# kubectl label namespace default istio-injection=enabled;
# kubectl -n istio-system get svc istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}'
