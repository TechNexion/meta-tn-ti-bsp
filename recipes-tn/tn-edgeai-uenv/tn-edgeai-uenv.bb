DESCRIPTION = "Package that will install a uEnv_edgeai-apps.txt file to /boot/uEnv.txt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "rovy-4vm"

SRC_URI = "\
    file://uEnv_edgeai-apps.txt \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"

PR = "r1"
PV = "1.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/boot/
    install -m 0644 ${S}/uEnv_edgeai-apps.txt ${D}/boot/uEnv.txt
}

FILES_${PN} += "/boot/uEnv.txt"

