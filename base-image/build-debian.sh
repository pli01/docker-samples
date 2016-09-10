#!/bin/bash
#
# build minimal base image
#
# export http_proxy

export distrib=debian
export version=jessie
export arch=amd64
export url=http://httpredir.debian.org/debian

# export FAKECHROOT="fakechroot fakeroot"
# export DEBOOTSTRAP="fakechroot fakeroot debootstrap"

pkg="locales,apt-utils,inetutils-ping,iproute2,sysvinit-core,apt,bash"

/usr/share/docker-engine/contrib/mkimage.sh -t $distrib-base:latest -d . debootstrap \
  --arch=$arch --variant=minbase --components=main --include=$pkg $version $url
