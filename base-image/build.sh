#!/bin/bash
#
# build minimal base image
#
pkg=locales,apt-utils,inetutils-ping,iproute2

/usr/share/docker-engine/contrib/mkimage.sh -t debian-base:latest -d . debootstrap --variant=minbase --components=main --include=$pkg jessie http://httpredir.debian.org/debian
