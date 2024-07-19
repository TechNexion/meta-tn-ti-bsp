do_install_prepend_axon-am62ax() {
        export TI_SECURE_DEV_PKG=${TI_SECURE_DEV_PKG}
        ( cd ${RTOS_DM_FW_DIR}; \
                mv ${DM_FIRMWARE} ${DM_FIRMWARE}.unsigned; \
                ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh ${DM_FIRMWARE}.unsigned ${DM_FIRMWARE}; \
        )
        ( cd ${RTOS_IPC_FW_DIR}; \
                ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh am62a-mcu-r5f0_0-fw \
                    am62a-mcu-r5f0_0-fw.signed; \
                ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh ipc_echo_test_c7x_1_release_strip.xe71 \
                    ipc_echo_test_c7x_1_release_strip.xe71.signed; \
        )
}
