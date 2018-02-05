# Install Git

This documentation will help you to install and configure Git in your computer

## Getting Started

First of all, open your terminal and execute the following command:

`sudo apt-get update`

### Installing

Execute the commands below in your terminal and you will have Git downloaded, installed and configured in your computer.

`sudo apt-get install git`

## Configuring Git in your computer

Open your terminal and type the following commands.

`git config --global user.name "Your Name"`

`git config --global user.email "youremail@domain.com"`

## Install and configure SSH Key to GitHub/GitLab/Bitbucket

To make your commits easily you need to create and configure SSH Key in your computer.

### Verifiy if the SSH key exists

Explain what these tests test and why

Firts you need to check if there is a SSH Key in your computer. So, open your terminal and type the command below to verifiy if you have ssh hidden directory in your machine:

`ls -al ~/.ssh`

**If the result of the command above return somethig like _id_rsa.pub_, it means that you have a SSH Key in your computer. So, skip the next step.**

### Creating SSH Key

Open the terminal and type:

`ssh-keygen -t rsa -C "your_email@something.com"`

### Adding SSH key to GitLab

Follow this [link](https://docs.gitlab.com/ee/gitlab-basics/create-your-ssh-keys.html)

### Adding SSH key to GitHub

Follow this [link](https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/)

### Adding SSH key to Bitbucket

Follow this [link](https://confluence.atlassian.com/bitbucket/set-up-an-ssh-key-728138079.html)