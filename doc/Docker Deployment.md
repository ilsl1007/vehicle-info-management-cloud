## Docker方式部署脚本备份
```shell script
register-center
    register-center1    8761
        docker volume create register-center1
        docker run -it -d --name register-center1 -v register-center1:/home/soft --net=host java

gateway-service
    gateway-service1    9030
        docker volume create gateway-service1
        docker run -it -d --name gateway-service1 -v gateway-service1:/home/soft --net=host java
    gateway-service2    9031
        docker volume create gateway-service2
        docker run -it -d --name gateway-service2 -v gateway-service2:/home/soft --net=host java

user-service
    user-service1       9000
        docker volume create user-service1
        docker run -it -d --name user-service1 -v user-service1:/home/soft --net=host java
    user-service2       9001
        docker volume create user-service2
        docker run -it -d --name user-service2 -v user-service2:/home/soft --net=host java

vehicle-management-service
    vehicle-management-service1    9010
        docker volume create vehicle-management-service1
        docker run -it -d --name vehicle-management-service1 -v vehicle-management-service1:/home/soft --net=host java
    vehicle-management-service2    9011
        docker volume create vehicle-management-service2
        docker run -it -d --name vehicle-management-service2 -v vehicle-management-service2:/home/soft --net=host java

notification-service
    notification-service1    9020
        docker volume create notification-service1
        docker run -it -d --name notification-service1 -v notification-service1:/home/soft --net=host java
    notification-service2    9021
        docker volume create notification-service2
        docker run -it -d --name notification-service2 -v notification-service2:/home/soft --net=host java
```