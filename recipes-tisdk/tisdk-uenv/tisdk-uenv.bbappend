FILESEXTRAPATHS:prepend := "${THISDIR}/${MACHINE}:"

SRC_URI:append = "\
    file://uEnv-rovy-4vm-display.txt \
"

FILES:${PN} += "/boot/uEnv.txt"

# Install to /boot/uEnv.txt in rootfs
do_install:rovy-4vm() {
    install -d ${D}/boot/
    install -m 0644 ${S}/uEnv-rovy-4vm-display.txt ${D}/boot/uEnv.txt
}

# Install to boot partition
# TODO: Remove after u-boot modifications are made to load uEnv.txt from /boot
#       in rootfs
do_deploy:rovy-4vm() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${S}/uEnv-rovy-4vm-display.txt ${DEPLOYDIR}/uEnv.txt
}

PR:append = "_tn_1"

