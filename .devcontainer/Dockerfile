
# Docker image that will be used as a base
FROM ros:lyrical-ros-base

# Author
LABEL authors="AadarshDevi"

# Check Robosub.md
RUN apt-get update \
    && apt-get install -y ros-lyrical-mavros

# Bash runs the following cmd
RUN echo "source /opt/ros/lyrical/setup.bash" >> ~/.bashrc