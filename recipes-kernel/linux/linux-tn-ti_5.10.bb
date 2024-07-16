SECTION = "kernel"
SUMMARY = "Linux kernel for TechNexion AXON-AM62XX device"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel

DEFCONFIG_BUILDER = "${S}/ti_config_fragments/defconfig_builder.sh"
require recipes-kernel/linux/setup-defconfig.inc
require recipes-kernel/linux/ti-uio.inc
require recipes-kernel/linux/bundle-devicetree.inc
require recipes-kernel/linux/kernel-rdepends.inc
require recipes-kernel/linux/ti-kernel.inc

DEPENDS += "gmp-native libmpc-native"

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-5.10:"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT} \
		      ${EXTRA_DTC_ARGS}"

S = "${WORKDIR}/git"

BRANCH = "tn-ti_5.10.168_08.06.00.07"

SRCREV = "01bab9b5dbbbd9c90f1b9d28ef51f8251bd8224b"
PV = "5.10.168+git${SRCPV}"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "b"
PR = "${MACHINE_KERNEL_PR}"

KERNEL_GIT_URI = "git://github.com/TechNexion/linux-tn-ti.git"
KERNEL_GIT_PROTOCOL = "https"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            "

FILES_${KERNEL_PACKAGE_NAME}-devicetree += "/${KERNEL_IMAGEDEST}/*.itb"

# Special configuration for remoteproc/rpmsg IPC modules
module_conf_rpmsg_client_sample = "blacklist rpmsg_client_sample"
module_conf_ti_k3_r5_remoteproc = "softdep ti_k3_r5_remoteproc pre: virtio_rpmsg_bus"
module_conf_ti_k3_dsp_remoteproc = "softdep ti_k3_dsp_remoteproc pre: virtio_rpmsg_bus"
KERNEL_MODULE_PROBECONF += "rpmsg_client_sample ti_k3_r5_remoteproc ti_k3_dsp_remoteproc"
KERNEL_MODULE_AUTOLOAD_append_j7 = " rpmsg_kdrv_switch"

KERNEL_CONFIG_AARCH64 = "tn_ti_defconfig"
KBUILD_DEFCONFIG ?= ""
KBUILD_DEFCONFIG_am62xx= "${KERNEL_CONFIG_AARCH64}"

addtask copy_defconfig after do_unpack before do_configure
do_copy_defconfig () {
    install -d ${B}
    mkdir -p ${B}
    cp ${S}/arch/arm64/configs/${KERNEL_CONFIG_AARCH64} ${WORKDIR}/defconfig
}
