# raspberrypi-microk8s-java

## Introduction

This is a Spring Boot project intended to be deployed on a Kubernetes cluster.

## Requirements

- Raspberry Pi
- Ubuntu Server for Raspberry Pi
- Microk8s (Kubernetes cluster for Ubuntu Server)
- Java 11
- Maven
- Docker
- Kubectl

## Getting Started

### Deploy Application

1. Build application

    ```shell script
    mvn clean install
    ```

2. Build image

    ```shell script
    docker build -t smartinrub/raspberrypimicrok8sjava .
    ```
    >Only ARM images can run on Raspberry Pi. Java Docker image for Raspberry Pi: https://hub.docker.com/r/arm64v8/openjdk/.

3. Push image to Docker Hub                                                                                                 

    ```shell script
    docker push
    ```
    > You need to `docker login` first.

4. Configure access to Kubernetes cluster

    ```shell script
    vi .kube/config
    ```
   
   >Get password for admin user: `kubectl config view`

5. Create replica sets of the application on Kubernetes

    ```shell script
    kubectl apply -f deployment.yaml 
    ```       
   
6. Create service resource
    ```shell script
    kubectl apply -f service.yaml 
    ```  

6. Create ingress resource

    ```shell script
    kubectl apply -f ingress.yaml 
    ```
   
7. The application is exposed at [https://<node_ip>/uppercase/hello](https://<node_ip>/uppercase/hello)        
   
### Cleaning up

You can delete a Kubernetes resource with:

```shell script
kubectl delete <resource_type> <resource_name>
```                         
or
```shell script
kubectl delete -f resource_file.yaml
```             