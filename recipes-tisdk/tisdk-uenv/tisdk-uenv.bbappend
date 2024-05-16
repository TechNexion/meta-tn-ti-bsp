FILESEXTRAPATHS:prepend := "${THISDIR}/${MACHINE}:"

SRC_URI:rovy-4vm = "\
    file://uEnv-rovy-4vm.txt \
"

# Install to /boot/uEnv.txt in rootfs
do_install:rovy-4vm() {
    install -d ${D}/boot/
    install -m 0644 ${S}/uEnv-rovy-4vm.txt ${D}/boot/uEnv.txt
}

FILES:${PN} += "boot/*"

# Install to boot partition
do_deploy:rovy-4vm() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${S}/uEnv-rovy-4vm.txt ${DEPLOYDIR}/uEnv.txt
}

PR:append = "_tn_1"

