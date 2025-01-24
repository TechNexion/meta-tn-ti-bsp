SECTION = "kernel"
SUMMARY = "Linux kernel for TechNexion AXON-AM62XX device"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit ti-secdev
inherit kernel

include ${@ 'recipes-kernel/linux/ti-kernel-devicetree-prefix.inc' if d.getVar('KERNEL_DEVICETREE_PREFIX') else ''}
include ${@ 'recipes-kernel/linux/ti-extras.inc' if d.getVar('TI_EXTRAS') else ''}

DEPENDS += "gmp-native libmpc-native"

# Look in the generic major.minor directory for files
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-6.6:"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT} \
		      ${EXTRA_DTC_ARGS}"

S = "${WORKDIR}/git"

BRANCH ?= "tn-ti_6.6.58_10.01.10"

SRCREV ?= "5b40a9d5870c4a067b95884626d0a67d6d9ea3dc"
PV = "6.6.58+git"

# Special configuration for remoteproc/rpmsg IPC modules
module_conf_rpmsg_client_sample = "blacklist rpmsg_client_sample"
module_conf_ti_k3_r5_remoteproc = "softdep ti_k3_r5_remoteproc pre: virtio_rpmsg_bus"
module_conf_ti_k3_dsp_remoteproc = "softdep ti_k3_dsp_remoteproc pre: virtio_rpmsg_bus"
KERNEL_MODULE_PROBECONF += "rpmsg_client_sample ti_k3_r5_remoteproc ti_k3_dsp_remoteproc"

KBUILD_DEFCONFIG ?= "tn_ti_defconfig"

# Add DTC FLAGS -@ when KERNEL_DTB_OVERLAY_SUPPORT is enabled

def get_extra_dtc_args(d):
    if d.getVar('KERNEL_DTB_OVERLAY_SUPPORT') == "1":
        return "DTC_FLAGS=-@"
    else:
        return ""

EXTRA_DTC_ARGS += "${@get_extra_dtc_args(d)}"

# Tell the kernel class to install the DTBs in the same directory structure as
# the kernel.
KERNEL_DTBDEST = "${KERNEL_IMAGEDEST}/dtb"
KERNEL_DTBVENDORED = "1"

KERNEL_GIT_URI ?= "git://github.com/TechNexion/linux-tn-ti.git"
KERNEL_GIT_PROTOCOL ?= "https"
KERNEL_GIT_BRANCH ?= "branch=${BRANCH}"

SRC_URI = " \
    ${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};${KERNEL_GIT_BRANCH} \
"
