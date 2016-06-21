#!/bin/bash
#
# build minimal base image
#
pkg=locales,apt-utils,inetutils-ping,iproute2
url=http://httpredir.debian.org/debian
# export http_proxy

/usr/share/docker-engine/contrib/mkimage.sh -t debian-base:latest -d . debootstrap --variant=minbase --components=main --include=$pkg jessie $url
