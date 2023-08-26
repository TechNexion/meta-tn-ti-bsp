FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${MACHINE}:"

COMPATIBLE_MACHINE_append = "|rovy-4vm"
PLAT_SOC_rovy-4vm = "j721e"

do_install_append() {
	install -d ${D}/boot
 	install -m 0644 -m 0644 ${S}/uEnv_edgeai-apps.txt ${D}/boot/uEnv.txt
}

PR_append = ".tn1"

FILES_${PN} += "boot/*"

do_deploy_append() {
    install -d ${DEPLOYDIR}/boot/
    install -m 0644 ${S}/uEnv_edgeai-apps.txt ${DEPLOYDIR}/boot/uEnv.txt
}
