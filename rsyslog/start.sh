#!/bin/bash

service rsyslog start
tail -f /var/log/syslog &
wait
