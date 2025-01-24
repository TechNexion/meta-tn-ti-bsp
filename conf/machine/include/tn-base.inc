
############################################################################
##
## Copyright (C) 2024 TechNexion.
## Contact: https://www.technexion.com/
##
## This file is part of the TechNexion bitbake/yocto meta-layer
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
############################################################################

OVERRIDES:append = ":tn"
OVERRIDES:append = "${@'' if (d.getVar('RF_FIRMWARES', True) is None or len(d.getVar('RF_FIRMWARES', True)) == 0) else ':%s' % ':'.join([fw.lower() for fw in d.getVar('RF_FIRMWARES', True).split(' ') if fw])}"

#
# Release Info
#
DISTRO_NAME:tn = "TechNexion Release Distro"
RELEASE_NAME := "${@'Q%s' % (lambda dt: (dt.datetime.now().month+2)//3)(__import__('datetime')) if (d.getVar('PREVIEW', True) is None) else 'Preview'}"
INHERIT += "image-buildinfo"
IMAGE_BUILDINFO_VARS:append = " RELEASE_NAME"

#
# Kernel Specifics
#
PREFERRED_PROVIDER_kernel:tn = "linux-tn-ti"
PREFERRED_PROVIDER_virtual/kernel:tn = "linux-tn-ti"

#
# Bootloader Specifics
#
PREFERRED_PROVIDER_virtual/bootloader:tn = "u-boot-tn-ti"
PREFERRED_PROVIDER_u-boot:tn = "u-boot-tn-ti"
IMAGE_BOOT_FILES:remove = "ti_logo_414x97_32bpp.bmp.gz"

# Extra NXP Wi-Fi and Bluetooth driver firmware and driver
MACHINE_FIRMWARE:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'nxpiw416-sdio', 'firmware-nxp-wifi-nxpiw416-sdio', '', d)}"
MACHINE_EXTRA_RRECOMMENDS:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'nxpiw416-sdio', 'kernel-module-nxp-wlan', '', d)}"
PREFERRED_RPROVIDER_linux-firmware-nxpiw416-sdio = "firmware-nxp-wifi"

MACHINE_FIRMWARE:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'nxpiw612-sdio', 'firmware-nxp-wifi-nxpiw612-sdio', '', d)}"
MACHINE_EXTRA_RRECOMMENDS:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'nxpiw612-sdio', 'kernel-module-nxp-wlan', '', d)}"
PREFERRED_RPROVIDER_linux-firmware-nxpiw612-sdio = "firmware-nxp-wifi"

LICENSE_FLAGS_ACCEPTED:append = " commercial_qca commercial_tn"
