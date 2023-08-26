require ${METATIBASE}/recipes-bsp/u-boot/u-boot-ti.inc

SUMMARY = "u-boot bootloader for TechNexion TI devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

PR = "r0"

BRANCH = "tn-ti-u-boot-2021.01_08_06_00_06-next"

UBOOT_GIT_URI = "git://github.com/johnweber/u-boot-ti.git"

SRC_URI[sha256sum] = "99b601ba77f53b3c254964d694fc3c3898e951339b0228075e75beec787a3c30"

SRCREV = "0d2d0839bbdc0c0cf084fcf6d3934d0849087ec4"


COMPATIBLE_MACHINE = "^("
COMPATIBLE_MACHINE .= "rovy-4vm"
COMPATIBLE_MACHINE .= "|rovy-4vm-k3r5"
COMPATIBLE_MACHINE .= ")$"
