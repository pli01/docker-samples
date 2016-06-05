#!/bin/bash
#
# build minimal base image
#
/usr/share/docker-engine/contrib/mkimage.sh -t debian:latest -d . debootstrap --variant=minbase --components=main --include=inetutils-ping,iproute2 jessie http://httpredir.debian.org/debian
