# Robosub

1. ROS2: Lyrical
2. Companion Computer: NVIDIA Jetson Orin Nano
3. Python: 3.14

## Project

1. Run ROS2 Lyrical Docker Image (It will download if it doesn't exist in device)
    ```
    docker run -it ros:lyrical-ros-base
    ```
2. We are inside container's shell
3. Update
    ```
    apt-get update
    ```
4. Installing MavROS in container
    ```
    apt-get install -y ros-lyrical-mavros
    ```
5. List all packages in the container
    ```
    ros2 pkg list
    ```

6. In Project root, create folder: ".devcontainer". Tells IDE to use the container as a "virtual" environment.

## Docker

1. Building Docker Image
    ```
    docker buildx build . -t <image_name>
    ```

2. Open/Run Docker Image
    ```
    docker run -it <image_name>
    ```

## ROS2

1. ROS2 Package
  ```
  ros2 pkg create --build-type ament_python <package_name>
  ```

2. 

## Homework

1. how to create ros2 package (used to organise code)
