#!/bin/bash

echo "vizionpanel init: Start..."

BUS=$(dmesg | grep 'omap_i2c 2010000'  | sed -E 's/.*bus ([0-9]+).*/\1/')

SER=0x0c
DES=0x2c
SER_DEC=${SER#0x}

sleep 3

if ! i2cdetect -y -r $BUS | grep -q "$SER_DEC"; then
    echo "vizionpanel init: Device not found at address $SER. Exiting..."
    exit 1
fi

echo "vizionpanel init: Device found at i2c $BUS addr $SER. Initializing..."

i2cset -y ${BUS} ${SER} 0x01 0x0f
sleep 1
i2cset -y ${BUS} ${SER} 0x03 0xBA
#Add the following three lines to enable PWR_SW_CTL_EN
i2cset -y ${BUS} ${SER} 0x5B 0x20
i2cset -y ${BUS} ${SER} 0x1E 0x02
i2cset -y ${BUS} ${SER} 0x0F 0x09
i2cset -y ${BUS} ${SER} 0x1E 0x01
i2cset -y ${BUS} ${SER} 0x5B 0x21
i2cset -y ${BUS} ${SER} 0x4F 0x8C
i2cset -y ${BUS} ${SER} 0x40 0x04
i2cset -y ${BUS} ${SER} 0x41 0x05
i2cset -y ${BUS} ${SER} 0x42 0x14
i2cset -y ${BUS} ${SER} 0x0e 0x33
i2cset -y ${BUS} ${SER} 0x0d 0x33
i2cset -y ${BUS} ${SER} 0x01 0x00

sleep 1

i2cset -y ${BUS} ${DES} 0x01 0x01
i2cset -y ${BUS} ${DES} 0x49 0x62
i2cset -y ${BUS} ${DES} 0x34 0x01
i2cset -y ${BUS} ${DES} 0x1D 0x1d
i2cset -y ${BUS} ${DES} 0x1E 0xdd

echo "vizionpanel init: Complete."
sleep 1