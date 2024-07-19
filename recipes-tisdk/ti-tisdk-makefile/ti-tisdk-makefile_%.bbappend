FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_axon-am62xx = " file://Makefile_u-boot-spl_am62"
SRC_URI_append_axon-am62ax = " file://Makefile_u-boot-spl_am62"

MAKEFILES_append_axon-am62xx = " u-boot-spl_am62"
MAKEFILES_append_axon-am62ax = " u-boot-spl_am62"

K3_UBOOT_MACHINE_R5_axon-am62xx = "axon-am62xx_r5_config"
K3_UBOOT_MACHINE_R5_axon-am62ax = "axon-am62ax_r5_config"
