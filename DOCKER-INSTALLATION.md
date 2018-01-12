# Downloading and Installing Docker on Linux

# Section 1: Downloading and installing tools

This section describes, in 11 steps, the procedure to download and install docker.

## 1. Downloading the docker installation script 

In your browser, open this [link](https://get.docker.com/) and inside the webpage, look for the line bellow, then copy and paste on terminal:

`curl -fsSL get.docker.com -o get-docker.sh`

Also look for the line bellow and copy and paste on terminal:

`sh get-docker.sh`

## 2. Add your user to the "docker" group type

To add your user to the "docker" group type, open the terminal and add the command below. Reboot your operating system after execute this command to be sure that it’s will work as expected.

`sudo usermod -aG YOUR_USER`

## 3. Test if docker is running correctly

To test if docker is running correctly type in terminal the following commands and you should see the Client and Server version:

`sudo docker version`
`docker version`

## 4. Installing Docker Machine

To install docker-machine go to [https://github.com/docker/machine/releases](https://github.com/docker/machine/releases), find the Linux command and execute it in terminal.

You can also find the same instructions at [https://docs.docker.com/machine/install-machine/](https://docs.docker.com/machine/install-machine/).

To test if Docker Machine was installed type this command in terminal:

`docker-machine version`


