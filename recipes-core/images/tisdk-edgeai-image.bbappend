COMPATIBLE_MACHINE_append ="|rovy-4vm"

# Remove the tisdk edgeai uenv
IMAGE_INSTALL_remove = " \
    edgeai-uenv \
"

# Add the TN uenv
IMAGE_INSTALL_append = " \
	tn-edgeai-uenv \
"

# IMAGE_BOOT_FILES_remove_rovy-4vm = "uEnv.txt"

PR_append = ".tn1"