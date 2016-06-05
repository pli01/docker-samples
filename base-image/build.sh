#!/bin/bash
#
# build minimal base image
#
mkdir CHROOT=debian
debootstrap stable $CHROOT http://httpredir.debian.org/debian
tar -C $CHROOT -c . | docker import - debian/jessie:latest
