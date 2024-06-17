# Copyright (C) 2024 Richard Hu <richard.hu@technexion.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "SystemD service to initialize Vizionpanel SERDES chip"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit systemd allarch

SRC_URI = "file://vizionpanel.service \
	file://vizionpanel.sh \
	"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/vizionpanel.service ${D}${systemd_unitdir}/system/vizionpanel.service
    install -d ${D}${sbindir}
    install -m 0755 ${S}/vizionpanel.sh ${D}${sbindir}
    install -m 0755 ${S}/vizionpanel.sh ${D}${sbindir}
}

SYSTEMD_SERVICE:${PN} = "vizionpanel.service"
RDEPENDS:${PN} = "bash i2c-tools"
