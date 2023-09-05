FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

include recipes-bsp/tn-machine-add/tn-machine-add.inc

SRC_URI_append = " \
    file://0001-src-ldc-Add-support-for-1to1-remap.patch \
"
