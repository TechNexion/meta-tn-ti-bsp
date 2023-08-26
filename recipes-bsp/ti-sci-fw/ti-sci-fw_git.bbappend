SYSFW_PREFIX_rovy-4vm-k3r5 = "fs"

# The Makefile for ti-sci-fw adds an 'SBL=' argument which will cause an error when
# building for j721e, so remove this argument.
EXTRA_OEMAKE_remove_rovy-4vm-k3r5 = " SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""