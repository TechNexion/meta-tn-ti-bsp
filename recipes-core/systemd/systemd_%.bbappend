FILESEXTRAPATHS:prepend := "${THISDIR}/${MACHINE}:${THISDIR}/${PN}:"

SRC_URI:append:rovy-4vm = " \
    file://can.rules \
"

PR:append:rovy-4vm = ".tn1"

do_install:append() {
    install -m 0644 ${WORKDIR}/can.rules ${D}${sysconfdir}/udev/rules.d/11-can.rules
}
