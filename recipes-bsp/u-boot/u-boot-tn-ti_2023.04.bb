require ${METATIBASE}/recipes-bsp/u-boot/u-boot-ti.inc

SUMMARY = "u-boot bootloader for TechNexion TI devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

PR = "r0"

BRANCH = "tn-ti-u-boot-2023.04_09_00_01_03-next"

UBOOT_GIT_URI = "git://github.com/TechNexion/u-boot-tn-ti.git"

SRC_URI[sha256sum] = "99b601ba77f53b3c254964d694fc3c3898e951339b0228075e75beec787a3c30"

SRCREV = "17adc3e689682977dffd67e7d3d869a34f8e7076"


COMPATIBLE_MACHINE = "^("
COMPATIBLE_MACHINE .= "rovy-4vm"
COMPATIBLE_MACHINE .= "|rovy-4vm-k3r5"
COMPATIBLE_MACHINE .= ")$"
