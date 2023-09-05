FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

include recipes-bsp/tn-machine-add/tn-machine-add.inc

SRC_URI_append = " \
    file://0001-ext-ldc-Add-support-for-colorconversion-UYVY-NV12.patch \
"