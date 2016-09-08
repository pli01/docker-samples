#!/bin/bash
#
# build minimal base image
#
# export http_proxy

export distrib=centos
export version=6
export arch=6
export url=http://mirror.centos.org/centos/6/os/x86_64/Packages

/usr/share/docker-engine/contrib/mkimage.sh -t $distrib$version-base:latest -d . rinse \
  --distribution $distrib-$version --arch amd64   --verbose --mirror $url

