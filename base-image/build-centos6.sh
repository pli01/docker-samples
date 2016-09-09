#!/bin/bash
#
# build minimal base image
#
# export http_proxy

export distrib=centos
export version=6
export arch=amd64
export url=http://mirror.centos.org/centos/6/os/x86_64/Packages

/home/b/mkimage/contrib/mkimage.sh -t $distrib$version-base:latest -d . rinse \
  --distribution $distrib-$version --arch $arch   --verbose --mirror $url

