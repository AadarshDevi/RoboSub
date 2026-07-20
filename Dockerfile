
# Creating a Docker Container using Ubuntu 22.04 LTS image
FROM ubuntu:22.04
#--platform=linux/arm64

# Disables the OS from asking user to install stuff like apps. pop ups also do not show up.
ENV DEBIAN_FRONTEND:noninteractive

# download a new list of packages on the ubuntu servers.
# run command
# download
# show no recommended downloads
# download ca-certificates
# download curl
# force delete
# delete list of packages that were downloaded
RUN \
    apt-get update \
    && apt-get install -y \
    --no-install-recommends \
    ca-certificates \
    curl \
    && rm -rf \
    /var/lib/apt/lists/*

# create a permanant env var for jdk
# the filepath to the jdk
ENV JAVA_HOME=opt/java/openjdk

# tells where the java exe is when we need it
ENV PATH="${JAVA_HOME}/bin:${PATH}"