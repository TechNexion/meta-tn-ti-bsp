# UBOOT_LOCALVERSION can be set to add a tag to the end of the
# U-boot version string.  such as the commit id
UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).replace('AUTOINC+','')[:10]}"

UBOOT_SUFFIX ?= "img"
SPL_BINARY ?= "MLO"

require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

SUMMARY = "u-boot bootloader for TechNexion TI devices"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

BRANCH = "tn-ti-u-boot-2021.01_08_06_00_07"
SRCREV = "2b9ad44900e0af30fe22d497a00212c95f577628"

UBOOT_GIT_URI = "git://github.com/TechNexion/u-boot-tn-ti.git"
UBOOT_GIT_PROTOCOL = "https"
SRC_URI = "${UBOOT_GIT_URI};protocol=${UBOOT_GIT_PROTOCOL};branch=${BRANCH}"

PV_append = "+git${SRCPV}"

# u-boot needs devtree compiler to parse dts files
DEPENDS += "dtc-native bc-native lzop-native flex-native bison-native python3-setuptools-native"

DM_FIRMWARE = "ipc_echo_testb_mcu1_0_release_strip.xer5f"

PACKAGECONFIG[atf] = "ATF=${STAGING_DIR_HOST}/firmware/bl31.bin,,trusted-firmware-a"
PACKAGECONFIG[optee] = "TEE=${STAGING_DIR_HOST}${nonarch_base_libdir}/firmware/bl32.bin,,optee-os"
PACKAGECONFIG[dm] = "DM=${STAGING_DIR_HOST}${nonarch_base_libdir}/firmware/pdk-ipc/${DM_FIRMWARE},,ti-rtos-firmware"

PACKAGECONFIG_append_aarch64 = " atf optee"
PACKAGECONFIG_append_am62xx = " dm"
PACKAGECONFIG_append_am62axx = " dm"

COMPATIBLE_MACHINE = "(ti-soc)"

EXTRA_OEMAKE += "${PACKAGECONFIG_CONFARGS}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

S = "${WORKDIR}/git"

# Support for secure devices - detailed info is in doc/README.ti-secure
TI_SECURE_DEV_PKG ?= ""
export TI_SECURE_DEV_PKG

SYSROOT_DIRS += "/boot"

# SPL (Second Program Loader) to be loaded over UART
SPL_UART_BINARY = "u-boot-spl.bin"
SPL_UART_BINARY_k3r5 = ""

do_compile_append_k3r5 () {
	if ! [ -f ${B}/${UBOOT_BINARY} ]; then
		ln -s spl/${UBOOT_BINARY} ${B}/${UBOOT_BINARY}
	fi
}

TOOLCHAIN = "gcc"
