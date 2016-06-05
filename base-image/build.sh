#!/bin/bash
#
# build minimal base image
#
/usr/share/docker-engine/contrib/mkimage.sh -t debian/jessie:latest debootstrap jessie
