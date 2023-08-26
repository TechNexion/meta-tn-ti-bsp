FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:${THISDIR}/${PN}:"

COMPATIBLE_MACHINE_append = "|rovy-4vm"

SRC_URI_append = " \
    file://can.rules \
"

PR_append_rovy-4vm = ".tn1"

do_install_append() {
    install -m 0644 ${WORKDIR}/can.rules ${D}${sysconfdir}/udev/rules.d/11-can.rules
}
