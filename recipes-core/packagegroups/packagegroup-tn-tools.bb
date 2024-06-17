# Copyright (C) 2022-2024 Technexion Ltd.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Software packages used for TechNexion internal test"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup


RDEPENDS:${PN} = " \
    alsa-utils \
    alsa-tools \
    bash \
    bc \
    coreutils \
    dnsmasq \
    dtc \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    evtest \
    ethtool \
    fbset \
    fb-test \
    fio \
    glmark2 \
    haveged \
    hdparm \
    hostapd \
    i2c-tools \
    iozone3 \
    iptables \
    iproute2 \
    iperf3 \
    libgpiod-tools \
    lmbench \
    memtester \
    mmc-utils \
    net-tools \
    openssh-sftp-server \
    picocom \
    read-edid \
    rsync \
    spidev-test \
    stress-ng \
    stressapptest \
    sysbench \
    v4l-utils \
    udev \
    trace-cmd \
"